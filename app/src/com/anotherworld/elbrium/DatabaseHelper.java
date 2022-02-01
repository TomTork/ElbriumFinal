package com.anotherworld.elbrium;

import android.util.Log;

import androidx.annotation.NonNull;

import com.badlogic.gdx.Gdx;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

//import pl.mk5.gdx.fireapp.GdxFIRDatabase;
//import pl.mk5.gdx.fireapp.functional.Consumer;

public class DatabaseHelper {
    private final Gson gson;
    String s;
    GetterANDSetterFileC getter_setter;
    private String valueOf_online = "NONE";
    public boolean bool_tnp_read_online=false;

    public DatabaseHelper() {
        gson = new Gson();
        getter_setter = new GetterANDSetterFileC();
    }

    public void sendToFirebase(String heading, String msg) {
        FirebaseDatabase.getInstance().getReference("LibGDX").child(heading).setValue(msg);
        //GdxFIRDatabase.instance().inReference(heading).setValue(msg);                               //Отправляет значение msg. Не понятно зачем
    }

    public void readString(int case_) {

        // 0 - отправляет никнейм в reference online
        // 1 - удалить из поля online, закрыть приложение
        // 2 - прочитать поле online. требуется вызов метода getvalueOf_online

        switch (case_) {
            case 0:
                FirebaseDatabase.getInstance().getReference("LibGDX").child("online").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        tmp_online(String.valueOf(task.getResult().getValue(String.class)));
                        bool_tnp_read_online=true;
                    }
                });
                //-------------------------
//                GdxFIRDatabase.instance().inReference("online").readValue(String.class).then(new Consumer<String>() {       //Меняет online -> показывает подключенных пользователей?
//                    @Override
//                    public void accept(String s) {
//                        tmp_online(s);
//                        bool_tnp_read_online=true;
//                    }
//                });
                break;

            case 1:
                FirebaseDatabase.getInstance().getReference("LibGDX").child("online").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        tmp_delete_from_online(String.valueOf(task.getResult().getValue(String.class)));
                    }
                });
                //-------------------------------
//                GdxFIRDatabase.instance().inReference("online").readValue(String.class).then(new Consumer<String>() {       //Удаляет из online?
//                    @Override
//                    public void accept(String s) {
//                        tmp_delete_from_online(s);
//                    }
//                });
                break;

            case 2:
                FirebaseDatabase.getInstance().getReference("LibGDX").child("online").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        tmp_read_online(String.valueOf(task.getResult().getValue(String.class)));
                    }
                });
                //------------------------------------
//                GdxFIRDatabase.instance().inReference("online").readValue(String.class).then(new Consumer<String>() {       //Возвращает всех пользователей из online?
//                    @Override
//                    public void accept(String s) {
//                        tmp_read_online(s);
//                    }
//                });
                break;
        }

    }

    private void tmp_read_online(String s) {
        valueOf_online = s;
        bool_tnp_read_online=true;

    }

    public String getValueOf_online() {
        return valueOf_online;
    }

    private void tmp_online(String s) {
        if (s == null) sendToFirebase("online", getter_setter.get_Nickname() + ";");
        else if (!s.contains(getter_setter.get_Nickname()))
            sendToFirebase("online", s + getter_setter.get_Nickname() + ";");
    }

    private void tmp_delete_from_online(String s) {
        if (s != null && s.contains(getter_setter.get_Nickname()))
            sendToFirebase("online", s.replace(getter_setter.get_Nickname() + ";", ""));
        Gdx.app.exit();
    }

    public void setMetadata(String s) {
        this.s = s;
    }

    public void logOut() {
        readString(1);
    }
}


