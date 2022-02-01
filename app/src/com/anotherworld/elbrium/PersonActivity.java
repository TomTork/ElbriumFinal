package com.anotherworld.elbrium;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class PersonActivity extends AppCompatActivity { // Класс настроек
    EditText name_person;
    Button confirm;
    String s;
    GetterANDSetterFile getterANDSetterFile;
    Spinner appearance;
    ImageView imageView;
    CountDownTimer countDownTimer;
    int seconds=1;
    @Override
    protected void onStart(){
        super.onStart();
    }
    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        getSupportActionBar().hide();
        name_person = findViewById(R.id.name_person);
        s = name_person.getText().toString();
        confirm = findViewById(R.id.confirm);
        imageView = findViewById(R.id.appearance_imageView);
        getterANDSetterFile = new GetterANDSetterFile();
        if(getterANDSetterFile.get_Nickname()!=name_person.getText().toString()){
            confirm.setVisibility(View.VISIBLE);
            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { // Подтверждение ника
                    s = name_person.getText().toString();
                    if(!s.equals("")){
                        if(!s.contains(" ")){
                            if(getterANDSetterFile.get_Block()!=1)getterANDSetterFile.set_Nickname(s);
                            else Toast.makeText(getApplicationContext(),"Вы отмечены меткой дьявола, её не смыть",Toast.LENGTH_SHORT).show();
                        }
                        else Toast.makeText(getApplicationContext(),"Никнейм не может содержать пробел",Toast.LENGTH_SHORT).show();
                    }
                    else Toast.makeText(getApplicationContext(),"Никнейм не может быть пустым",Toast.LENGTH_SHORT).show();
                }
            });
        }
        else confirm.setVisibility(View.INVISIBLE);
        if(!s.equals("")){
            if(!s.contains(" ")){
                if(getterANDSetterFile.get_Block()!=1)getterANDSetterFile.set_Nickname(s);
                else Toast.makeText(getApplicationContext(),"Вы отмечены меткой дьявола, её не смыть",Toast.LENGTH_SHORT).show();
            }
            else Toast.makeText(getApplicationContext(),"Никнейм не может содержать пробел",Toast.LENGTH_SHORT).show();
        }
        //else Toast.makeText(getApplicationContext(),"Никнейм не может быть пустым",Toast.LENGTH_SHORT).show();
        countDownTimer = new CountDownTimer(seconds*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                seconds--;
                // Применение внешнего вида
                if(getterANDSetterFile.get_Appearance()==1)imageView.setImageResource(R.mipmap.original);
                if(getterANDSetterFile.get_Appearance()==2)imageView.setImageResource(R.mipmap.original2);
                if(getterANDSetterFile.get_Appearance()==3)imageView.setImageResource(R.mipmap.original3);
                if(getterANDSetterFile.get_Appearance()==4)imageView.setImageResource(R.mipmap.original4);
                if(getterANDSetterFile.get_Appearance()==5)imageView.setImageResource(R.mipmap.original5);
            }
            @Override
            public void onFinish() {
                if (countDownTimer!=null){
                    seconds = 1;
                    countDownTimer.start();
                }
            }
        };
        if (countDownTimer!=null){
            seconds = 1;
            countDownTimer.start();
        }
        appearance = findViewById(R.id.appearance_spinner);
        final String[] s2 = {""};

        appearance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // Выбор внешнего вида
            public void onItemSelected(AdapterView<?> parent,View itemSelected, int selectedItemPosition, long selectedId) {
                s2[0] = String.valueOf(appearance.getSelectedItem());
                if(appearance.getSelectedItemId()==1)getterANDSetterFile.set_Appearance(1);
                if(appearance.getSelectedItemId()==2)getterANDSetterFile.set_Appearance(2);
                if(appearance.getSelectedItemId()==3)getterANDSetterFile.set_Appearance(3);
                if(appearance.getSelectedItemId()==4)getterANDSetterFile.set_Appearance(4);
                if(appearance.getSelectedItemId()==5)getterANDSetterFile.set_Appearance(5);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}