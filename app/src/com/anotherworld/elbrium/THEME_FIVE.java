package com.anotherworld.elbrium;

import android.os.CountDownTimer;
import android.view.View;

public class THEME_FIVE extends Quest{ // Класс для Миссий
    int ra5=0;
    int s5=1;
    CountDownTimer countDownTimer5;
    public String r1 = "Пора платить по счетам. *Все ваши монеты куда-то исчезают, внутри себя чуть выше желудка вы чувствуете пустоту*";
    public String r1_c = "Он тебе не поможет, потому что тоже в моей власти";
    public String r2 = "Тебе не хватает рабочей силы? Я выделю тебе немного.";
    public String r2_c = "Как хочешь, - *доносится до вас*";
    public String r3 = "Продай мне часть своей души. В загробный мир я тебе обеспечу, а здесь и сейчас дам за неё деньги.";
    public String r3_c = "Ладно-ладно успеешь ещё передумать, - *звучит в вашей голове*";
    public String r4 = "Отдай мне ключ от подземелья, я за него заплачу.";
    public String r4_c = "Зря… - *слышите вы*";
    public String r5_1 = "У меня есть для тебя сделка: я дам тебе деньги, а ты взамен будешь носить мою метку в своём имени, но поменять его увы будет нельзя? Что, скажешь, 500 монет?";
    public String r5_2 = "Уверен? 1000 монет.";

    public void five(){
        vip++;
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_FIVE theme_five = new THEME_FIVE();
        if (getterANDSetterFile.get_Devil()!=0){
            img.setImageResource(R.mipmap.devil);
            pro_result=51;
            npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_five.r1);
            second.setText("Отдать долг");
            third.setText("Священник!");
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getterANDSetterFile.set_Guardian_Money(0.0);
                    getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-1000);
                    Q1();
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+100);
                    getterANDSetterFile.set_Guardian_Money(0.0);
                    description.setText(description.getText().toString() + "\n\n" +theme_five.r1_c);
                    Q1();
                }
            });
        }
        else {
            THEME_SIX theme_six = new THEME_SIX();
            theme_six.six();
        }
    }
    public void Q1(){
        o_button();
        o_input();
        THEME_FIVE theme_five = new THEME_FIVE();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        if (getterANDSetterFile.get_Villagers()<=3){
            img.setImageResource(R.mipmap.devil);
            npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_five.r2);
            second.setText("Взять");
            third.setText("Отказаться");
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()+3);
                    getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-1000);
                    Q2();
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+100);
                    description.setText(description.getText().toString() + "\n\n" +theme_five.r2_c);
                    Q2();
                }
            });
        }
        else{
            Q2();
        }
    }
    public void Q2(){
        o_button();
        o_input();
        THEME_FIVE theme_five = new THEME_FIVE();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        img.setImageResource(R.mipmap.devil);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_five.r3);
        second.setText("Забирай");
        third.setText("Нет, только не моя душа!");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+250.0);
                Q3();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description.setText(description.getText().toString() + "\n\n" +theme_five.r3_c);
                Q3();
            }
        });
    }
    public void Q3(){
        o_button();
        o_input();
        THEME_FIVE theme_five = new THEME_FIVE();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        if (getterANDSetterFile.get_Dungeon()==1){
            img.setImageResource(R.mipmap.devil);
            npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_five.r4);
            second.setText("Отдать");
            third.setText("Оставить себе");
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    description.setText(description.getText().toString() + "\n\n" +theme_five.r4);
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+250.0);
                    getterANDSetterFile.set_Dungeon(0);
                    Q4();
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    description.setText(description.getText().toString() + "\n\n" + theme_five.r4_c);
                    Q4();
                }
            });
        }
        else{
            Q4();
        }
    }
    public void Q4(){
        o_button();
        o_input();
        THEME_FIVE theme_five = new THEME_FIVE();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        if (getterANDSetterFile.get_Block()!=1){
            img.setImageResource(R.mipmap.devil);
            npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_five.r5_1);
            second.setText("Согласиться");
            third.setText("Отказаться");
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getterANDSetterFile.set_Block(1);
                    getterANDSetterFile.set_Nickname(getterANDSetterFile.get_Nickname()+"_Marked_of_curse");
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+500.0);
                    random();
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_five.r5_2);
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getterANDSetterFile.set_Block(1);
                            getterANDSetterFile.set_Nickname(getterANDSetterFile.get_Nickname()+"_Marked_of_curse");
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+1000.0);
                            random();
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            random();
                        }
                    });
                }
            });
        }
        else{
            random();
        }
    }
}