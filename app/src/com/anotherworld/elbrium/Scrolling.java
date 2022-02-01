package com.anotherworld.elbrium;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.icu.text.AlphabeticIndex;
import android.os.Build;
import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

public class Scrolling extends AppCompatActivity{
    double money,plus_health,plus_attack,real_money;
    int real_level,experience,level,real_xp,seconds;
    CountDownTimer countDownTimer,count;
    GetterANDSetterFile getterANDSetterFile;
    FrameLayout frameLayout;
    TextView nick;
    Online online;
    int sec=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                //TODO
            }
        });
        new CreatorFiles().create();
        getterANDSetterFile = new GetterANDSetterFile();
        if(Multiplayer.condition_spawnerOnDisconnect())for(int i=0;i<15;i++)FirebaseDatabase.getInstance().getReference("ore"+i).onDisconnect().removeValue();
        else for(int i=0;i<15;i++)FirebaseDatabase.getInstance().getReference("ore"+i).onDisconnect();

        // //
        if(getterANDSetterFile.get_Sign()==0)startActivity(new Intent(Scrolling.this, EmailPasswordActivity.class)); // Проверка регистрации
        if(getterANDSetterFile.get_Sign()==0){
            try {
                Thread.sleep(300);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        setContentView(R.layout.activity_scrolling);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPerms();
        }
        frameLayout = findViewById(R.id.gg);
        nick = findViewById(R.id.nick);
        //player_data=new Message(getterANDSetterFile.getTexture(),0,0,getterANDSetterFile.geta);
        //FirebaseDatabase.getInstance().getReference("LONGDATA").push().setValue(player_data.toString());
        online=new Online();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = findViewById(R.id.toolbar_layout);
        TextView info_level = findViewById(R.id.level);
        TextView info_money = findViewById(R.id.money);
        FloatingActionButton room1  = findViewById(R.id.room_one_button);
        seconds = 60;
        experience = 0;
        money = 0;
        level = 0;
        real_money = getterANDSetterFile.get_Guardian_Money();
        real_xp = getterANDSetterFile.get_Guardian_Exp();
        real_level = getterANDSetterFile.get_Guardian_Level();
        experience = real_xp;
        money = real_money;
        level = real_level;
        info_money.setText(getterANDSetterFile.get_Guardian_Money() + "");
        info_level.setText(getterANDSetterFile.get_Guardian_Level()+"");
        count = new CountDownTimer(sec*10,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sec--;
                if(getterANDSetterFile.get_StartChat()==1){
                    getterANDSetterFile.set_StartChat(0);
                    if(getterANDSetterFile.get_StartChat()==0)startActivity(new Intent(getApplicationContext(),MainA.class)); // Открытие чата из LibGDX
                }
            }

            @Override
            public void onFinish() {
                if (count != null){ // Перезапуск таймера
                    sec = 1;
                    count.start();
                }
            }
        };
        if (count != null){ // Перезапуск таймера
            sec = 1;
            count.start();
        }
        countDownTimer = new CountDownTimer(seconds * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                seconds--;
                info_money.setText(getterANDSetterFile.get_Guardian_Money() + ""); // Обновление данных
                info_level.setText(getterANDSetterFile.get_Guardian_Level()+"");
                nick.setText(getterANDSetterFile.get_Nickname()+"");
                //toolBarLayout.setTitle(getterANDSetterFile.get_Nickname());
            }
            @Override
            public void onFinish() {
                toolBarLayout.setTitle(getterANDSetterFile.get_Nickname());
                experience = experience + 1;
                money = getterANDSetterFile.get_Guardian_Money() + 1;
                info_money.setText(money + "");
                if (experience % 50 == 0) { // За новых lvl даётся подарок
                    level = level + 1;
                    info_level.setText(level+"");
                    plus_health = getterANDSetterFile.get_Health();
                    plus_health = plus_health + 4;
                    getterANDSetterFile.set_Health(plus_health);
                    plus_attack = getterANDSetterFile.get_Attack();
                    plus_attack = plus_attack + 0.5;
                    getterANDSetterFile.set_Attack(plus_attack);
                }
                getterANDSetterFile.set_Guardian_Money(money);
                getterANDSetterFile.set_Guardian_Exp(experience);
                getterANDSetterFile.set_Guardian_Level(level);
                if (countDownTimer != null){
                    seconds = 60;
                    countDownTimer.start();
                }
            }
        };
        if (countDownTimer!=null){
            seconds = 60;
            countDownTimer.start();
        }
        room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Scrolling.this,AndroidLauncher.class)); // Запуск LibGDX
            }
        });
    }
    private static final int PERMISSION_REQUEST_CODE = 794;
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestPerms() {
        int permissionStatus = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET},
                    PERMISSION_REQUEST_CODE);
        }
        int permissionStatus2 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionStatus2 != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE + 1);
        }
        int permissionStatus3 = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            permissionStatus3 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NOTIFICATION_POLICY);
        }
        if (permissionStatus3 != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_NOTIFICATION_POLICY},
                    PERMISSION_REQUEST_CODE + 2);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        int positionOfMenuItem = 0;

        MenuItem item = menu.getItem(positionOfMenuItem);
        SpannableString s = new SpannableString("Настройки");
        s.setSpan(new ForegroundColorSpan(Color.RED), 0, s.length(), 0);
        item.setTitle(s);

        MenuItem item2 = menu.getItem(1);
        SpannableString s1 = new SpannableString("Магазин");
        s1.setSpan(new ForegroundColorSpan(Color.RED), 0, s1.length(), 0);
        item2.setTitle(s1);

        MenuItem item4 = menu.getItem(2);
        SpannableString s3 = new SpannableString("О приложении");
        s3.setSpan(new ForegroundColorSpan(Color.RED), 0, s3.length(), 0);
        item4.setTitle(s3);

        MenuItem item5 = menu.getItem(3);
        SpannableString s5 = new SpannableString("База");
        s5.setSpan(new ForegroundColorSpan(Color.RED), 0, s5.length(), 0);
        item5.setTitle(s5);

        MenuItem item3 = menu.getItem(4);
        SpannableString s2 = new SpannableString("Выход");
        s2.setSpan(new ForegroundColorSpan(Color.RED), 0, s2.length(), 0);
        item3.setTitle(s2);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_person){
            startActivity(new Intent(this,PersonActivity.class));
            return true;
        }
        if(id == R.id.shop){
            startActivity(new Intent(Scrolling.this,ShopActivity.class));
            return true;
        }
        if(id == R.id.about_us_menu){
            startActivity(new Intent(Scrolling.this,About_us.class));
            return true;
        }
        if (id == R.id.base){
            startActivity(new Intent(Scrolling.this,UserBase.class));
            return true;
        }
        if (id == R.id.exit) {
            GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
            getterANDSetterFile.set_Guardian_Money(0.0);
            getterANDSetterFile.set_Guardian_Exp(0);
            getterANDSetterFile.set_Guardian_Level(0);
            getterANDSetterFile.set_Sign(0);
            getterANDSetterFile.set_Ore_Elbrium(0.0);
            getterANDSetterFile.set_Coefficient_Attack(0);
            getterANDSetterFile.set_Coefficient_Protection(0);
            getterANDSetterFile.set_Coefficient_Speed(0);
            getterANDSetterFile.set_Health(10.0);
            getterANDSetterFile.set_Attack(3.0);
            getterANDSetterFile.set_Protection(3.0);
            getterANDSetterFile.set_Speed(3.0);
            getterANDSetterFile.set_Message("");
            getterANDSetterFile.set_BaseLevel(0);
            getterANDSetterFile.set_House(0);
            getterANDSetterFile.set_Happiness(25);
            getterANDSetterFile.set_Villagers(3);
            getterANDSetterFile.set_Kitchen(0);
            getterANDSetterFile.set_WorkShop(0);
            getterANDSetterFile.set_TownHall(1);
            getterANDSetterFile.set_Factory(0);
            getterANDSetterFile.set_NameBase("");
            getterANDSetterFile.set_School(0);
            getterANDSetterFile.set_Tower(0);
            getterANDSetterFile.set_Park(0);
            getterANDSetterFile.set_Mill(0);
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this,Scrolling.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}