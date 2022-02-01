package com.anotherworld.elbrium;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

public class THEME_ONE extends Quest{
    public int ra1=0;
    GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
    public String q1 = "Люди недовольны большим количеством предприятий, загрязняющих атмосферу. Не могли бы вы провести референдум?";
    public String q2 = "*Вы узнаёте, что на вашей базе появилась оппозиционная организация, желающая дискредитировать вас. Ваши действия: *";
    public String q3 = "Наши амбары с запасами зерна сгорели, пожалуйста, выделите нам (от 50 до 300 монет), чтобы мы могли пережить зиму. ";
    public String q4_1 = "На нашей базе появилась банда преступников!";
    public String q4_12_c = "Благодарим вас, мы это не забудем.";
    public String q4_2 = "Я - главарь банды, прошу не уничтожайте нас, мы заплатим за собственное спасение.";
    public String q5_1 = "@" + getterANDSetterFile.get_Nickname() + ",не могли бы вы посмотреть на ангар, который мы отремонтировали?";
    public String q5_2 = "*Заходя внутрь, вы замечаете, как какой-то мальчишка в ангаре по неосторожности роняет коробку с инструментами. Вы подзываете его к себе: *";
    public String q5_3 = "Не ругайте его, он мой сын!";
    public String q6 = "К нам в город прибыл священник из Марсианской церкви!";
    public String q6_c = "Церковь этого не забудет.";
    public String q7 = "Жители изголодались по зрелищу! Давайте проведём цирковое выступление.";
    public String q8 = "Школ! Детям не хватает школ!";
    public String q8_c = "Ну ладно…";
    public String q9 = "Нам негде гулять! Постройте больше парков!";
    public String q9_c = "Извините, ошибся… ";
    public String q10_1 = "Спеть вам песенку?";
    public String q10_2 = "«Жил-был в древности космический король" + "\n" + "Жил-был, как вдруг появился дракон…» *вы жестом останавливаете его и говорите: *";

    public void one(){
        pr();
        vip++;
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_ONE theme_one = new THEME_ONE();
        pro_result = 1;
        img.setImageResource(R.mipmap.base_avatar_1);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q1);
        pr();
        second.setText("Да");
        third.setText("Нет");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness() + 1);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() - 50.0);
                RA2();
                pr();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness() - 3);
                RA2();
                pr();
            }
        });
        exit(true);
    }
    public void RA2(){
        o_button();
        o_input();
        pr();
        THEME_ONE theme_one = new THEME_ONE();
        pro_result=2;
        img.setImageResource(R.mipmap.base_avatar_1);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q2);
        pr();
        second.setText("Оставить всё как есть");
        third.setText("Уничтожить");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-100.0);
                RA3();
                pr();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
                RA3();
                pr();
            }
        });
        exit(true);
    }
    public void RA3(){
        o_button();
        o_input();
        pr();
        THEME_ONE theme_one = new THEME_ONE();
        pro_result=3;
        img.setImageResource(R.mipmap.base_avatar_1);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q3);
        pr();
        second.setText("Выдать");
        third.setText("Отказать");
        d_input();
        input.setText("0");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                try {
                    if(Integer.parseInt(input.getText().toString())<50 || Integer.parseInt(input.getText().toString())>300)npc_tv.setText(npc_tv.getText().toString() + "\n\n" + "Но я не просил столько!");
                    else if(Integer.parseInt(input.getText().toString())>50 || Integer.parseInt(input.getText().toString())<300){
                        getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-Integer.parseInt(input.getText().toString()));
                        input.setText("");
                        o_input();
                        pr();
                        RA4();
                        pr();
                    }
                    else {
                        RA4();
                        pr();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
                input.setText("");
                o_input();
                RA4();
                pr();
            }
        });
        exit(true);
    }
    public void RA4(){
        o_button();
        o_input();
        pr();
        THEME_ONE theme_one = new THEME_ONE();
        if (getterANDSetterFile.get_Band()!=1){
            o_input();
            pro_result=4;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q4_1);
            pr();
            second.setText("Уничтожить");
            third.setText("Оставить");
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pr();
                    img.setImageResource(R.mipmap.bandit);
                    npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q4_2);
                    second.setText("Оставить");
                    third.setText("Убирайтесь");
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            pr();
                            int a = 1 + (int) (Math.random() * 100);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+((double)a));
                            description.setText(description.getText().toString() + "\n\n" + theme_one.q4_12_c);
                            pr();
                            getterANDSetterFile.set_Band(1);
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
                            RA5();
                            pr();
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            pr();
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+3);
                            RA5();
                            pr();
                        }
                    });
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pr();
                    int a = 1 + (int) (Math.random() * 100);
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+((double)a));
                    description.setText(description.getText().toString() + "\n\n" +theme_one.q4_12_c);
                    pr();
                    getterANDSetterFile.set_Band(1);
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
                    RA5();
                    pr();
                }
            });
        }
        else RA5();
    }
    public void RA5(){
        o_button();
        o_input();
        pr();
        THEME_ONE theme_one = new THEME_ONE();
        pro_result=5;
        img.setImageResource(R.mipmap.base_avatar_1);
        second.setText("Да");
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q5_1);
        pr();
        third.setText("Нет");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                d_button();
                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q5_2);
                pr();
                first.setText("Отругать");
                second.setText("Будь осторожнее *дать 5 монет*");
                third.setText("Забудь");
                first.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pr();
                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q5_3);
                        pr();
                        o_button();
                        second.setText("Промолчать");
                        third.setText("Накричать");
                        second.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pr();
                                RA6();
                                pr();
                            }
                        });
                        third.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pr();
                                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                                RA6();
                                pr();
                            }
                        });
                    }
                });
                second.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pr();
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-5.0);
                        RA6();
                        pr();
                    }
                });
                third.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pr();
                        RA6();
                        pr();
                    }
                });
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                RA6();
                pr();
            }
        });
    }
    public void RA6(){
        o_button();
        o_input();
        pr();
        THEME_ONE theme_one = new THEME_ONE();
        if (getterANDSetterFile.get_Church()==0){
            pro_result=6;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q6);
            pr();
            second.setText("Прогнать");
            third.setText("Радушно встретить");
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pr();
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-4);
                    getterANDSetterFile.set_Church(-1);
                    description.setText(description.getText().toString() + "\n\n" +theme_one.q6_c);
                    pr();
                    RA7();
                    pr();
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pr();
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+4);
                    getterANDSetterFile.set_Church(1);
                    description.setText(description.getText().toString() + "\n\n" +theme_one.q6_c);
                    pr();
                    RA7();
                    pr();
                }
            });
        }
        else RA7();
    }
    public void RA7(){
        o_button();
        o_input();
        pr();
        THEME_ONE theme_one = new THEME_ONE();
        pro_result=7;
        img.setImageResource(R.mipmap.base_avatar_1);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q7);
        pr();
        second.setText("Можно");
        third.setText("Нет");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+3);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-50.0);
                RA8();
                pr();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
                RA8();
                pr();
            }
        });
    }
    public void RA8(){
        o_button();
        o_input();
        pr();
        THEME_ONE theme_one = new THEME_ONE();
        pro_result=8;
        img.setImageResource(R.mipmap.base_avatar_1);
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q8);
        pr();
        d_button();
        first.setText("Вообще-то их достаточно");
        second.setText("Нет");
        third.setText("Так постройте больше школ!");
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                if(getterANDSetterFile.get_Villagers()<getterANDSetterFile.get_School())description.setText(description.getText().toString() + "\n\n" +theme_one.q8_c);
                else getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                pr();
                RA9();
                pr();
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                RA9();
                pr();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)(getterANDSetterFile.get_School()*75+75)));
                getterANDSetterFile.set_School(getterANDSetterFile.get_School()+1);
                RA9();
                pr();
            }
        });
    }
    public void RA9(){
        o_button();
        o_input();
        pr();
        THEME_ONE theme_one = new THEME_ONE();
        pro_result=9;
        img.setImageResource(R.mipmap.base_avatar_1);
        d_button();
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q9);
        pr();
        first.setText("Но я только в прошлом месяце построил новый!");
        second.setText("Нет");
        third.setText("Так постройте больше парков!");
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                if (getterANDSetterFile.get_Park()>getterANDSetterFile.get_Villagers()){
                    description.setText(description.getText().toString() + "\n\n" + theme_one.q9_c);
                    pr();
                    o_button();
                    RA10();
                }
                else {
                    pr();
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                    o_button();
                    RA10();
                }
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                o_button();
                RA10();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)(getterANDSetterFile.get_Park()*75+75)));
                getterANDSetterFile.set_Park(getterANDSetterFile.get_Park()+1);
                o_button();
                RA10();
            }
        });
    }
    public void RA10(){
        o_button();
        o_input();
        pr();
        o_button();
        THEME_ONE theme_one = new THEME_ONE();
        pro_result=10;
        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q10_1);
        pr();
        img.setImageResource(R.mipmap.base_avatar_1);
        second.setText("Давай");
        third.setText("Нет");
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_one.q10_2);
                pr();
                second.setText("Шедевр, можешь не продолжать");
                third.setText("Ты что пьян?");
                second.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pr();
                        getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                        random();
                    }
                });
                third.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pr();
                        getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                        random();
                    }
                });
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pr();
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                random();
            }
        });
    }
}