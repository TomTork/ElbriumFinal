package com.anotherworld.elbrium;

import android.os.CountDownTimer;
import android.view.View;

public class THEME_EIGHT extends Quest{ // Класс для Миссий
    int ra8=0,s8=1;
    CountDownTimer countDownTimer8;
    public String e1 = "К нам прилетели пришельцы!";
    public String e1_c_1 = "*Вы бежите смотреть «пришельцев», но это оказываются обычные грузчики с другой планеты. Вы здороваетесь с ними и делаете вид, что шли не к ним. Сделав большой крюк, вы вернулись*";
    public String e1_c_2 = "Да, что я пришельцев не видел? – *говорите вы уверенно. А ведь и правда не видел, - думаете вы*";
    public String e2 = "Мы бы хотели получить разрешение на организацию бала.";
    public String e3 = "Здравствуйте, МАиЖ (министерство архитектуры и живописи) хотело бы сделать оранжерею на вашей базе. Что скажите?";
    public String e4 = "Здравствуйте, МАиЖ-у не нравится, как выглядят коридоры. Хотите, чтобы мы их улучшили?";

    public void eight(){
        vip++;
        //ID2();
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_EIGHT theme_eight = new THEME_EIGHT();
        img.setImageResource(R.mipmap.base_avatar_1);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" +  theme_eight.e1);
        second.setText("Посмотреть");
        third.setText("Игнорировать");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description.setText(description.getText().toString() + "\n\n" + theme_eight.e1_c_1);
                D1();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description.setText(description.getText().toString() +"\n\n"+ theme_eight.e1_c_2);
                D1();
            }
        });
    }
    public void D1(){
        o_button();
        o_input();
        THEME_EIGHT theme_eight = new THEME_EIGHT();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        img.setImageResource(R.mipmap.base_avatar_1);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_eight.e2);
        second.setText("Проводите");
        third.setText("Нет");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                D2();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                D2();
            }
        });
    }
    public void D2(){
        o_button();
        o_input();
        THEME_EIGHT theme_eight = new THEME_EIGHT();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        img.setImageResource(R.mipmap.base_avatar_1);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_eight.e3);
        second.setText("Стройте");
        third.setText("Нет");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                D3();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                D3();
            }
        });
    }
    public void D3(){
        o_button();
        o_input();
        THEME_EIGHT theme_eight = new THEME_EIGHT();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        img.setImageResource(R.mipmap.base_avatar_1);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_eight.e4);
        second.setText("Да");
        third.setText("Нет");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-25.0);
                getterANDSetterFile.set_HealthBase(getterANDSetterFile.get_HealthBase()+1);
                random();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-2);
                random();
            }
        });
    }
}