package com.anotherworld.elbrium;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

public class THEME_TWO extends Quest {  // Класс для Миссий
    int ra2=0;
    int s2=1;
    CountDownTimer countDownTimer2;
    public String m1 = "Меня ограбили! Сделайте же что-нибудь!";
    public String m1_c_1 = "*Стража не находит следов ограбления*";
    public String m1_c_2 = "Не знаю, но это точно произошло!";
    public String m2 = "Банк! Людям нужен банк! Можете ли вы выделить мне деньги на его постройку?";
    public String m2_c = "Кажется, он скрылся с деньгами и не будет ничего делать";
    public String m3 = "Банковское дело! Вот, что я хочу построить, на ваши деньги, конечно же, но поверьте мне: я в долгу не останусь.";
    public String m3_c = "Следующей ночью кто-то оставляет у вас под дверью чемодан с деньгами";
    public String m4 = "Здравствуйте, я занимаюсь продажей матрасов, не желаете ли приобрести 1? Это будет стоить 1000 монет, но уверяю вы не пожалеете.";
    public String m4_c_1 = "Внутри оказалось 1200 монет";
    public String m4_c_2 = "Сколько бы вы не рвали матрас, но кажется, внутрь ничего не положили…";
    public String m5 = "Здравствуйте, буду честен я – вожак банды у меня к вам дело. Не желаете ли вы заняться продажей матрасов? Не лично вы, конечно, просто выделите нам точку в центре, в долгу не останемся.";
    public String m5_c = "Пока вы задавались этим не хитрым вопросом от говорящего уже след простыл";
    public String m6 = "На нас летит большой метеорит! Сделайте же что-нибудь или кто-то точно умрёт!";
    public String m7 = "Срочно! Мне нужны деньги! Позже объясню зачем.";
    public String m7_c_1 = "Вы просто не знаете, что теряете!";
    public String m7_c_2 = "Я хотел купить жвачку, спасибо вам.";
    public String m7_c_3 = "Так хотелось выпить, спасибо!";
    public String m7_c_4 = "Да за такую сумму я, наконец, оплачу задолженность по квартплате, спасибо вам большое!";
    public String m7_c_5 = "Я не могу взять так много, простите…";
    public String m7_c_6 = "Diabolus responderit quo vocas.";
    public String m8 = "Мне кажется, нашу казну грабят!";
    public String m8_c_1 = "*Казну не грабят, однако, когда вы вошли внутрь тяжелая дверь с грохотом закрылась. Кто-то решил подшутить над вами, но он не учёл, что вам было не до смеха, выйдя через 3 часа, вы выгнали этого шутника со своей базы*";
    public String m8_c_2 = "*Оказывается вас действительно грабили, вы теряете 50 монет*";
    public String m9 = "\nНе желаете ли купить этот портрет? *Портрет выглядел не законченным, однако глаза на нём выглядели как-то особенно пугающе*\n";
    public String m9_c_1 = "*Ночью вам снится кошмар, человек из портрета, выходя из рамы, подходит к вам и начинает душить. Однако, проснувшись, вы замечаете, как из картины падает свёрток монет, пересчитав их, вы понимаете, что их ровно 100, но выглядят они не как обычные, успокоив себя, вы прячете их и возвращаетесь в ратушу*";
    public String m9_c_2 = "Ладно, продам её какому-нибудь бедному художнику";
    public String m10 = "Алчность.";
    public String m10_c_1 = "*Вы чувствуйте лёгкий холодок, так будто бы в комнате с вами находится кто-то ещё*";
    public String m10_c_2 = "Ложь, – доносится до вас";

    public void two() {
        vip++;
        //ID2();
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_TWO theme_two = new THEME_TWO();
        pro_result = 11;
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_two.m1);
        img.setImageResource(R.mipmap.base_avatar_1);
        d_button();
        first.setText("Дать ограбленные деньги");
        second.setText("Заставить стражу расследовать это дело");
        third.setText("Что например?");
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() - 5);
                o_button();
                F2();
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                description.setText(description.getText().toString() + "\n\n" + theme_two.m1_c_1 + "\n" + theme_two.m1_c_2);
                o_button();
                F2();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pr();
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness() - 1);
                o_button();
                F2();
            }
        });
    }
    public void F2(){
        o_button();
        o_input();
        THEME_TWO theme_two = new THEME_TWO();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_two.m2);
        img.setImageResource(R.mipmap.base_avatar_1);
        second.setText("Конечно!");
        third.setText("Проваливай");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pr();
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-150.0);
                description.setText(description.getText().toString() + "\n\n" +theme_two.m2_c);
                F3();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pr();
                F3();
            }
        });
    }
    public void F3(){
        o_button();
        o_input();
        THEME_TWO theme_two = new THEME_TWO();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_two.m3);
        img.setImageResource(R.mipmap.base_avatar_1);
        second.setText("Хорошо");
        third.setText("Проваливай");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pr();
                description.setText(description.getText().toString() + "\n\n" +theme_two.m3_c);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+150.0);
                F4();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pr();
                F4();
            }
        });
    }
    public void F4(){
        o_button();
        o_input();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_TWO theme_two = new THEME_TWO();
        if (getterANDSetterFile.get_Band()==1){
            npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_two.m4);
            img.setImageResource(R.mipmap.bandit);
            second.setText("Купить");
            third.setText("Отказаться");
            int ran = 1 + (int)(Math.random()*10);
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {pr();
                    if(ran<5) {
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() + 200.0);
                        description.setText(description.getText().toString() + "\n\n" +theme_two.m4_c_1);
                        F5();
                    }
                    else{
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-1000.0);
                        description.setText(description.getText().toString() + "\n\n" +theme_two.m4_c_2);
                        F5();
                    }
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {pr();
                    F5();
                }
            });
        }
        else F5();
    }
    public void F5(){
        o_button();
        o_input();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_TWO theme_two = new THEME_TWO();
        if (getterANDSetterFile.get_Band()!=1){
            img.setImageResource(R.mipmap.bandit);
            npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_two.m5);
            second.setText("Хорошо");
            third.setText("Кто его впустил?");
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {pr();
                    getterANDSetterFile.set_Band(1);
                    F6();
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {pr();
                    description.setText(description.getText().toString() + "\n\n" +theme_two.m5_c);
                    F6();
                }
            });
        }
        else F6();
    }
    public void F6(){
        o_button();
        o_input();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_TWO theme_two = new THEME_TWO();
        if (getterANDSetterFile.get_Villagers()>0){
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_two.m6);
            second.setText("Постройте вышку");
            third.setText("Ничего страшного, с нами марсианский бог, выживем");
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {pr();
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-(double)(getterANDSetterFile.get_Tower()*75+75));
                    getterANDSetterFile.set_Tower(getterANDSetterFile.get_Tower()+1);
                    F7();
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {pr();
                    int ran = 1 + (int)(Math.random()*10);
                    if (ran<5){
                        getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()-1);
                        getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-2);
                    }
                    getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+1);
                    F7();
                }
            });
        }
        else F7();
    }
    public void F7(){
        o_button();
        o_input();
        d_input();
        THEME_TWO theme_two = new THEME_TWO();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        img.setImageResource(R.mipmap.base_avatar_1);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_two.m7);
        second.setText("Хорошо");
        third.setText("Звучит сомнительно, нет");
        input.setText("0");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pr();
                try {
                    if (Integer.parseInt(input.getText().toString())>=0){
                        if (Integer.parseInt(input.getText().toString())==0)description.setText(description.getText().toString() + "\n\n" +"Но вы же ничего мне не дали!");
                        else if (Integer.parseInt(input.getText().toString())<=10 && Integer.parseInt(input.getText().toString())>0){
                            description.setText(description.getText().toString() + "\n\n" +theme_two.m7_c_2);
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)Integer.parseInt(input.getText().toString())));
                            F8();
                        }
                        else if (Integer.parseInt(input.getText().toString())>10 && Integer.parseInt(input.getText().toString())<=50){
                            description.setText(description.getText().toString() + "\n\n" +theme_two.m7_c_3);
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+2);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)Integer.parseInt(input.getText().toString())));
                            F8();
                        }
                        else if (Integer.parseInt(input.getText().toString())>50 && Integer.parseInt(input.getText().toString())<=200){
                            description.setText(description.getText().toString() + "\n\n" + theme_two.m7_c_4);
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+3);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)Integer.parseInt(input.getText().toString())));
                            F8();
                        }
                        else if (Integer.parseInt(input.getText().toString())>200 && Integer.parseInt(input.getText().toString())!=666){
                            description.setText(description.getText().toString() + "\n\n" +theme_two.m7_c_5);
                            F8();
                        }
                        else if (Integer.parseInt(input.getText().toString())==666){
                            description.setText(description.getText().toString() + "\n\n" +theme_two.m7_c_6);
                            getterANDSetterFile.set_Devil(1);
                            getterANDSetterFile.set_Church(-666);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)Integer.parseInt(input.getText().toString())));
                            F8();
                        }
                        else F8();
                    }
                    else F8();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pr();
                description.setText(description.getText().toString() + "\n\n" +theme_two.m7_c_1);
                F8();
            }
        });
    }
    public void F8(){
        o_button();
        o_input();
        THEME_TWO theme_two = new THEME_TWO();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        if (getterANDSetterFile.get_Villagers()>0){
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_two.m8);
            second.setText("Проверить");
            third.setText("Нет, она надежно защищена");
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {pr();
                    description.setText(description.getText().toString() + "\n\n" +theme_two.m8_c_1);
                    getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()-1);
                    F9();
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {pr();
                    description.setText(description.getText().toString() + "\n\n" +theme_two.m8_c_2);
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-50.0);
                    F9();
                }
            });
        }
        else F9();
    }
    public void F9(){
        o_button();
        o_input();
        THEME_TWO theme_two = new THEME_TWO();
        img.setImageResource(R.mipmap.base_avatar_1);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_two.m9);
        second.setText("Купить");
        third.setText("Отказаться");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pr();
                description.setText(description.getText().toString() + "\n\n" +theme_two.m9_c_1);
                F10();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pr();
                description.setText(description.getText().toString() + "\n\n" +theme_two.m9_c_2);
                F10();
            }
        });
    }
    public void F10(){
        o_button();
        o_input();
        THEME_TWO theme_two = new THEME_TWO();
        img.setImageResource(R.mipmap.devil);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_two.m10);
        second.setText("Согласиться");
        third.setText("Отказаться");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pr();
                description.setText(description.getText().toString() + "\n\n" +theme_two.m10_c_1);
                random();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pr();
                description.setText(description.getText().toString() + "\n\n" +theme_two.m10_c_2);
                random();
            }
        });
    }
}