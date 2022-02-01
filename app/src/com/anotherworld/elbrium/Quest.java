package com.anotherworld.elbrium;

import static io.reactivex.internal.functions.Functions.emptyConsumer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.logging.Level;

import io.reactivex.plugins.RxJavaPlugins;


public class Quest extends AppCompatActivity{
    public int kolvo_symbols = 0,v22=0,st=0,n=0,c=1,player1=0,player2=0,z=0,money=0,k1,k2;
    public CountDownTimer countDownTimer;
    public boolean parametr=true;
    public int pro_result=0;
    public static TextView npc_tv,description,crossbar;
    public static Button first,second,third;
    public static EditText input;
    public static ImageView img;
    public int t=0;
    public static NestedScrollView nestedScrollView_npc,nestedScrollView_des;
    public float vip=2;
    public int y=1;
    String b="",s="";
    UserBase userBase;
    @Override
    protected void onStart(){
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        super.onStart();
    }
    @Override
    protected void onPause(){
        exit(false);
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        if(!parametr){ // Наказание за выход из миссий
            if(pro_result==1)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
            if(pro_result==2)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
            if(pro_result==3)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
            if(pro_result==6){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-4);
                getterANDSetterFile.set_Church(-1);
            }
            if(pro_result==7)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
            if(pro_result==8)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
            if(pro_result==9)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
            if(pro_result==10)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
            if(pro_result==11)getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-5);
            if(pro_result==32)getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-3);
            if(pro_result==41)getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-2);
            if(pro_result==42)getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-4);
            if(pro_result==46){
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-7);
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
            }
            if(pro_result==47)getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-3);
            if(pro_result==51)getterANDSetterFile.set_Guardian_Money(0.0);
        }
        super.onPause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxJavaPlugins.setErrorHandler(emptyConsumer());
        setContentView(R.layout.activity_quest);
        getSupportActionBar().hide();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        vip++;
        nestedScrollView_npc = findViewById(R.id.nes_npc_tv);
        nestedScrollView_des = findViewById(R.id.nes_des);
        npc_tv = findViewById(R.id.nps_tv);
        description = findViewById(R.id.description);
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        input = findViewById(R.id.input);
        img = findViewById(R.id.nps_img);
        crossbar = findViewById(R.id.crossbar);
        start();
        exit(true);
        npc_tv.setTextColor(Color.GRAY);
        description.setTextColor(Color.GRAY);
        userBase = new UserBase();
        countDownTimer = new CountDownTimer(c*100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                c--;
                crossbar.setText("Монеты: " + getterANDSetterFile.get_Guardian_Money() + " " + "Руда: " + getterANDSetterFile.get_Ore_Elbrium() + " " + "Счастье: " + getterANDSetterFile.get_Happiness());
                comments(npc_tv);
                comments(description);
                s = npc_tv.getText().toString();
                if (!b.contains(s)){ // Скроллинг вниз при обновлении сообщений
                    b = s;
                    nestedScrollView_npc.smoothScrollTo(0,2100000000);
                    nestedScrollView_des.smoothScrollTo(0,2100000000);
                }
                ins(); // Проверка на счастье
            }
            @Override
            public void onFinish() {
                if (countDownTimer != null){ // Перезапуск таймера
                    c = 1;
                    countDownTimer.start();
                }
            }
        };
        if (countDownTimer != null){ // Перезапуск таймера
            c = 1;
            countDownTimer.start();
        }
        random();
    }

    public void exit(boolean tf){
        parametr = tf;
    }

    public void random(){ // Случайный выбор тематики
        int random  = 1 + (int)(Math.random()*8);
        if (random == 1){
            THEME_ONE theme_one = new THEME_ONE();
            theme_one.one();
        }
        else if (random ==2){
            THEME_TWO theme_two = new THEME_TWO();
            theme_two.two();
        }
        else if (random == 3){
            THEME_THREE  theme_three = new THEME_THREE();
            theme_three.three();
        }
        else if (random == 4){
            THEME_FOUR theme_four = new THEME_FOUR();
            theme_four.four();
        }
        else if (random ==5){
            THEME_FIVE theme_five = new THEME_FIVE();
            theme_five.five();
        }
        else if (random == 6){
            THEME_SIX theme_six = new THEME_SIX();
            theme_six.six();
        }
        else if (random == 7){
            THEME_SEVEN theme_seven = new THEME_SEVEN();
            theme_seven.seven();
        }
        else if (random == 8){
            THEME_EIGHT theme_eight = new THEME_EIGHT();
            theme_eight.eight();
        }
        else{
            THEME_ONE theme_one = new THEME_ONE();
            theme_one.one();
        }
    }
    public void start(){
        npc_tv.setVisibility(View.VISIBLE);
        description.setVisibility(View.VISIBLE);
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.VISIBLE);
        third.setVisibility(View.VISIBLE);
        input.setVisibility(View.INVISIBLE);
        img.setVisibility(View.VISIBLE);
    }
    public void d_button(){ // Добавление кнопки
        first.setVisibility(View.VISIBLE);
    }
    public void d_input(){ // Добавление ввода
        input.setVisibility(View.VISIBLE);
    }
    public void o_button(){ // Скрыть кнопку
        first.setVisibility(View.INVISIBLE);
    }
    public void o_input(){ // Скрыть ввод
        input.setVisibility(View.INVISIBLE);
        input.setText("");
    }

    public void comments(TextView textMessage){ // Комментирование
        String s = textMessage.getText().toString();
        String comment = textMessage.getText().toString();
        if(s.contains("*") && textMessage.getText().toString().contains("*")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '*' && s.contains("*")) {
                    kolvo_symbols++;
                    if (kolvo_symbols == 2 && s.contains("*")) {
                        k1 = (comment.indexOf("*"));
                        k2 = (comment.lastIndexOf("*"));
                        SpannableStringBuilder builder = new SpannableStringBuilder();
                        SpannableString colorSpannable= new SpannableString(s);
                        colorSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.comment)),k1,k1+1,0);
                        colorSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.comment)),k2,k2+1,0);
                        builder.append(colorSpannable);
                        textMessage.setText(builder, TextView.BufferType.SPANNABLE);
                        kolvo_symbols = 0;
                        s = "";
                    }
                    else textMessage.setTextColor(Color.GRAY);
                }
            }
        }
    }
    public void pr(){
        nestedScrollView_npc.smoothScrollTo(0,2100000000);
        nestedScrollView_des.smoothScrollTo(0,2100000000);
    }
    public void ins(){ // Проверка на счастье
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        if(getterANDSetterFile.get_Happiness()<10)ruin();
        if(getterANDSetterFile.get_Happiness()>55)ruin();
    }
    public void ruin(){ // Смотрим метод ins()
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        npc_tv.setVisibility(View.INVISIBLE);
        description.setVisibility(View.VISIBLE);
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.INVISIBLE);
        third.setVisibility(View.INVISIBLE);
        input.setVisibility(View.INVISIBLE);
        img.setVisibility(View.INVISIBLE);
        description.setText("Уровень счастья слишком низкий. Люди восстали против вашей диктатуры. Вы теряете всё!");
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
    }
}