package com.anotherworld.elbrium;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class THEME_SIX extends Quest{  // Класс для Миссий
    int ra6=0;
    public String w1_1 = "Не желаете ли вы сыграть в 21?";
    public String w1_2 = "Желаете поставить монеты или elbrium?";
    public String w1_3 = "Хорошо, делайте свою первоначальную ставку.";
    public String w1_4 = "*Крупье даёт вам 2 карты с числами, на них: ";
    public String w2_1 = "Хотите ли вы сыграть в кости?";
    public String w2_2 = "Сколько желаете поставить? Учтите максимальная ставка - 10 монет.";
    CountDownTimer countDownTimer6;
    int sec6=60;
    int par=0;
    int money6;
    double m=0,y=0;
    int pl1=0,pl2=0,pl=0;
    public void six(){
        vip++;
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_SIX theme_six = new THEME_SIX();
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_six.w2_1);
            second.setText("Да");
            third.setText("Нет");
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {pr();
                    npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_six.w2_2);
                    d_input();
                    second.setText("Ввод");
                    third.setText("Я передумал");
                                second.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {pr();
                                        try {
                                            if (Integer.parseInt(input.getText().toString())<=0){
                                                Toast.makeText(getApplicationContext(),"Вы же всерьёз не думаете, что можете ставить отрицательные числа",Toast.LENGTH_SHORT).show();
                                                THEME_ONE theme_one = new THEME_ONE();
                                                theme_one.one();
                                            }
                                            if (Integer.parseInt(input.getText().toString())>0 && Integer.parseInt(input.getText().toString())<=10){
                                                money6 = Integer.parseInt(input.getText().toString());
                                                pl = g_random();
                                                pl1 = h_random();
                                                pl2 = g_random();
                                                if (pl<pl1 && pl<pl2){
                                                    description.setText(description.getText().toString() + "\n\n" + "Вы проиграли: " + Integer.parseInt(input.getText().toString()) + "");
                                                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() - (double)(Integer.parseInt(input.getText().toString())));
                                                    random();
                                                }
                                                else{
                                                    m = (Math.random());
                                                    String res = "";
                                                    res = String.format("%.1f",m);
                                                    y = Double.parseDouble(res.replace(',','.'));
                                                    description.setText(description.getText().toString() + "\n\n" + "Вы выиграли: " + (money6 + money6*y) + "");
                                                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() + (double)(money6 + money6*y));
                                                    random();
                                                }
                                            }
                                            else Toast.makeText(getApplicationContext(),"Вы даёте слишком много!",Toast.LENGTH_SHORT).show();
                                        }catch (Exception e){
                                            e.printStackTrace();
                                        }
                                    }
                                });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {pr();
                            random();
                        }
                    });
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {pr();
                    random();
                }
            });
    }
    public int h_random(){
        int h = 3;
        h = 1 + (int)(Math.random()*15);
        if (h<3 || h>15)h_random();
        return h;
    }
    public int g_random(){
        int f=3;
        f = 1 + (int)(Math.random()*18);
        if (f<3 || f>18)g_random();
        return f;
    }
}
