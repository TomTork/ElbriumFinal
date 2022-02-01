package com.anotherworld.elbrium;

import android.os.CountDownTimer;
import android.view.View;

public class THEME_SEVEN extends Quest{ // Класс для Миссий
    GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
    public String s1 = "*В один из дней вы вспоминаете про ключ, который был передан священником. Покопавшись в груде вещей, вы находите заветную вещь и радостный спускаетесь по ступенькам вниз, веля охране не следовать за собой. Через некоторое время, спускаясь всё глубже и глубже, вы натыкаетесь на старую дубовую дверь, в руках у вас лежит ключ от неё, а в голове мысль: открыть или всё же…*";
    public String s1_c = "*Или всё же… уйти? Именно это решение приходит вам в голову и недолго думая, вы, развернувшись на каблуках уходите обратно в свою комнату, а через время снова забываете про ключ*";
    public String s2 = "*Нет. Только вперёд, раз выдалась такая возможность. Открыв ключом скрипучую дверь, вы входите внутрь, за вами тут же захлопывается дверь. Как и ожидалось внутри было темно, хоть глаз выколи. Вернувшись обратно, вы захватили с собой подожжённый факел и начали спуск вниз. По мере продвижения воздух становился всё тяжелее и тяжелее, а лестница вниз, казалось, не имела ни начала, ни конца. В конце концов вы начали слышать какой-то приглушённый шум* ";
    public String s3 = "*Прислушавшись, вы вдруг различили чьи-то голоса. Они говорили о вас, за вашей спиной. Удивившись подобной наглости и предвкушая, как они будут оправдываться, увидев вас, вы ускорили шаг и напряглись так, чтобы услышать что-то большее, чем просто своё имя. Наконец, чужие голоса стали хоть сколько-нибудь различимыми, вот, что они говорили: Правление " + getterANDSetterFile.get_Nickname() + " очень скоро закончится. Другой голос той же тональности вторил: Да, это абсолютная правда, но что же нам сделать, чтобы ускорить этот процесс? Первый ответил: Давай просто убьём " + getterANDSetterFile.get_Nickname() + " никто нам и слова не скажет, все наоборот будут нам благодарны…*";
    public String s4 = "*Чтобы кто не говорил, но вам было всё равно, наверное, поэтому через некоторое время голоса стихли, как будто-то бы их никогда и не было. Внезапно вы услышали запах мертвеца, да до такой степени, словно он находился прямо перед вашими ногами. Остановившись, как вкопанный вы решили: * ";
    public String s5 = "*Услышав столь неприемлемые слова вы ускорили шаг, желая наказать мерзавцев, однако споткнувшись упали. Голоса тут же стихли. Тот час же прямо за поворотом громко и чётко послышалось: кто здесь? Немедленно представься или мы убьем тебя!* ";
    public String s6 = "*Подумав, что это вероятно какая-нибудь крыса вы продолжили спуск вниз. Однако, запах продолжал преследовать вас, усиливаясь и набирая обороты, такие, что вы уже не могли дышать. Задыхаясь, вы решили: * ";
    public String s7 = "*Отчаянно, но благородно, вы решил подняться наверх и вызвать стражу. Странным образом поднявшись на два пролета вверх вы оказались перед дверью. Открыв её, вы столкнулись со стражником, который хотел открыть эту дверь. Вы с яростью посмотрели на него и начали кричать, звать остальных. Когда пришли другие стражники, вы объяснили им ситуацию, те пришли в недоумение. Один из них сказал: но там всего лишь склад с продуктами, если вы там видели кого-то значит сейчас мы застанем их врасплох. Остальные согласились и открыв дверь, стали спускаться вниз, вы за ними. Однако через 3 пролёта все оказались в погребе с бесчисленном количеством вина, хлеба и прочих продуктов, присутствием кого-то ещё даже не пахло. Обыскав весь погреб, вы ничего не нашли и раздосадованный вернулись к себе*";
    public String s8 = "*В вашу голову не пришло ничего лучше, кроме как спросить: здесь, что кто-то умер? Ваш глупый вопрос оглушительно, отражаясь от бесчисленного количества стен, пронзил тишину. Внезапно, перед вами появился живой труп. Его куски плоти и мяса свисали с тела, глаз не было, а рот был открыт. Да, это я умер, - ответил мертвец, и видя ваш ужас на лице продолжил, - давным-давно мне дали ключ от склада продуктов, недолго думая я стал спускаться вниз, желая хорошенько подкрепиться, желание моё было настолько велико, что меня не остановил бесконечный спуск вниз и в конце концов я свалился без сил и умер. Мне кажется, что прошло достаточно много времени с того момента, как я спустился, как вы считаете? Какой сейчас год? * ";
    public String s8_c = "*Мертвец кричал вам, что не стоит этого делать, но вы его не слушали…*";
    public String s9 = "Я – " + getterANDSetterFile.get_Nickname() + ", а кто вы? – *спрашиваете вы, в надежде, что вас сейчас же не убьют. На ваше несчастье, заговорщики переглянулись и достали кинжалы из-за пазухи. Ситуация принимала отчаянный оборот, в попытке защититься вы достали ключ от двери наверху и на удивление это сработало. Убийцы отступили и пошептавшись предложили: вы нам ключ, мы вам – жизнь*";
    public String s10 = "*Решив, что игра не стоит свеч, вы, развернувшись ушли, поднявшись через 3 пролёта к двери. Открыв её, вы забыли ключ в скважине и, поднявшись к себе, через некоторое время забыли про подземелье*";
    public String s11 = "Я – священник Марсианской Церкви, - *соврали вы. Перед вами появились двое заговорщиков, на ваше удивление они не узнали вас, видимо свет факела мешал им это сделать. Святой отец, - сказал один из них. – Мы хотим сделать одно дело, но для этого нам нужно подняться наверх, благословите наш подъём*. ";
    public String s12 = "*Решив, что лучшим решением будет продолжить путь, вы начали спускаться всё ниже и ниже, однако как бы вы не старались, но достигнуть заветного низа у вас не получалось. Пройдя бесчисленное количество поворотов, ваш факел начал мигать и в конце концов потух. Испугавшись, вы решили: *";
    public String s13 = "Я – главарь банды, - *уверенно сказали вы. Говорившие поднялись и недоумённо посмотрели на вас и спросили: И как в таком случае вас зовут? А, ведь действительно, как зовут главаря банды? Подумав некоторое время, вы ответили: * ";
    public String s14 = "*Запах оказался настолько не выносимым, что вы повернули назад, в надежде, что он прекратится. Так и произошло, через 4 поворота вы оказались у двери и недолго думая открыли её, потеряв ключ где-то по пути. Вернувшись в комнату, вы забыли, что были в подземелье*";
    public String s15 = "*С перепугу вы отдали им ключ, однако, вместо того чтобы сдержать слово и сохранить вам жизнь, убийцы пошли на вас, тыкая кинжалами воздух. На ваше счастье тот, кто принял из ваших рук ключ, внезапно вскрикнул повалившись на ступени, его сообщник обернулся назад и это дало вам шанс: * ";
    public String s16 = "2021? Я спустился в 1041 году. Как же много времени прошло! Давайте же подниматься наверх, я уверен, что с вами у меня получиться! *То ли от омерзения, то ли ещё из-за чего, но вы вместе со своим спутником стали подниматься наверх. Однако мертвец постоянно отставал от вас, складывалось ощущение, что он просто не мог выбраться отсюда. В какой-то момент вы не заметили, как мертвец куда-то пропал и очутились перед дверью. Выждав некоторое время, вы, утомившись, открыли дверь и, оставив ключ в замочной скважине, пошли в столовую есть, по пути забыв про подземелье*";
    public String s17 = "*Испугавшись, вы бросились наверх и через 3 поворота оказались у двери, в ужасе, открыв её вы выбежали в коридор, а после поднялись к себе. И уже в своей комнате, переведя дух, не могли вспомнить чего боялись и почему бежали*";
    public String s18 = "*Ваша упорность не знала границ. Вы продолжали и продолжали спуск. Уже не было ни запахов, ни звуков, ничего. Разве, что громкий стук вашего сердца, как будто отражавшийся от стен. Много прошло времени или мало вы не знали, потому что продолжали спуск, несмотря ни на что, и в конце концов перед вами появилась дверь, безумно напоминающая ту, в которую вы когда-то вошли. Недолго думая, вы открываете дверь и выходите, оставляя ключ в замочной скважине, недоумевая вы разглядываете свои владения и приглядываетесь забываете про подземелье и возвращаетесь к себе *";
    public String s19 = "*Вы начали мямлить какое-то благословление сами не понимая, что говорите, за время, пока вы это делаете убийцы разглядывают вас с головы до ног и в какой-то момент прерывают вас: если ты монах, то, где твоя одежда? Где колпак? Да ты посмотри, у него же ключ! – говорит другой. Отдавай-ка нам ключ. Убийцы достали из-за пазухи кинжалы и пошли на вас*. ";
    public String s20 = "*Даже в полной темноте лучшим решением будет всё равно спускаться дальше. Итак, пройдя бесчисленное расстояние вниз, вы вдруг замечаете какой-то свет. Идя на него, вы натыкаетесь на полки, набитые вином, хлебом и прочей едой. Люди там недоумённо смотрят на вас. Быстро вскочив, вы всматриваетесь внимательней и замечаете, что оказались в собственной кладовой. Извинившись, вы бодро поднимаетесь наверх, но где-то по пути теряете ключ, и вскоре оказываетесь перед дверью, открыв её, вы забываете про подземелье*";
    public String s21 = "*С детства вы были не из робкого десятка, поэтому решили проклясть убийц, говоря всяческие проклятия вы замечаете, как те достают кинжалы из-за пазухи. В ужасе вы прекращаете говорить и, не дав ничего сказать им, бежите наверх, к двери. Молниеносно открыв её, вы тут же захлопываете за собой, а ключ валится из ваших рук. Через мгновение вы забываете про подземелье и со спокойной душой возвращаетесь к себе. *";
    public String s22 = "*Правильным решением, конечно же, будет вернуться назад. Повернув, вы тут же бьётесь головой о нужную вам дверь, в судороге, открыв её, вы не замечаете, как роняете ключ на каменные ступеньки, даже характерный звук не смог сбить вас с этого нехитрого дела, как открытие двери, всё-таки страх темноты берёт над вами вверх. *";
    public String s23 = getterANDSetterFile.get_Nickname() + ", - *не думая отвечаете вы. Убийцы переглянулись и рассмеялись. Конечно, его не так звали. Что за глупость? С чего вы вообще взяли, что его будут звать так же, как и вас? Может кто-то подсказал вам подобную глупость? Или вы сами приняли столь, поистине, странное решение? Как бы то ни было, пока рассказчик недоумевал с вашего решения выбрать именно этот ответ, убийцы, которые также не понимали почему вы выбрали столь неадекватное решение, достали кинжалы и пошли на вас. Естественно вы, сгорая от стыда, что выбрали именно этот ответ, побежали прочь и вскоре наткнулись на дверь, открыв которую вы оставили ключ в замочной скважине и пройдя дальше забыли про подземелье, перед этим запомнив, что не стоит выбирать решения ответы которых известны *";
    public String s25 = "*Недолго думая, вы ответили аббревиатурой: Г.Б.. И этот ответ оказался правдой. Убийцы извинились, что не признали вас раньше и расступились, давая вам пройти. И вы приняли решение: * ";
    public String s25_c = "*Раз уж ниже убийцы и головорезы лучше будет вернуться назад, с этими мыслями вы побежали назад, но где-то по пути обронили ключ, не заметив этого, вскоре перед вами предстала дверь. Вы открыли её и пройдя дальше забыли про подземелье*";
    public String s27 = "*Не зря знаменитая поговорка гласит: Если враг повернулся спиной – бей первым. Или она несколько по-другому звучала… Как бы то ни было, вы толкнули убийцу вниз, от чего тот полетел кубарём вниз, испугавшись, что тот быстро вскочит и ненароком убьёт вас, вы в ужасе побежали наверх и, вскоре, очутились перед дверью. Открыв её и вернувшись к себе, вы забыли про подземелья *";

    public void seven(){
        vip++;
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_SEVEN theme_seven = new THEME_SEVEN();
        if (getterANDSetterFile.get_Dungeon()==1){
            if (getterANDSetterFile.get_Dungeon()==1 && getterANDSetterFile.get_Church()>0){
                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s1);
                img.setImageResource(R.color.black);
                second.setText("Открыть");
                third.setText("Уйти");
                second.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {pr();
                        o_button();
                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s2);
                        second.setText("Прислушаться");
                        third.setText("Игнорировать");
                        second.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {pr();
                                o_button();
                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s3);
                                second.setText("Ускорить шаг");
                                third.setText("Подняться наверх и вызвать стражу");
                                second.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {pr();
                                        d_button();
                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s5);
                                        first.setText("Представиться" + getterANDSetterFile.get_Nickname());
                                        second.setText("Представиться священником");
                                        third.setText("Представиться главарём банды");
                                        first.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {pr();
                                                o_button();
                                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s9);
                                                second.setText("Отдать ключ");
                                                third.setText("Броситься наверх");
                                                second.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {pr();
                                                        o_button();
                                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s15);
                                                        second.setText("Толкнуть");
                                                        third.setText("Побежать наверх");
                                                        second.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {pr();
                                                                o_button();
                                                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s27);
                                                                getterANDSetterFile.set_Dungeon(0);
                                                                random();
                                                            }
                                                        });
                                                        third.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {pr();
                                                                o_button();
                                                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s17);
                                                                getterANDSetterFile.set_Dungeon(0);
                                                                random();
                                                            }
                                                        });
                                                    }
                                                });
                                                third.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {pr();
                                                        o_button();
                                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s17);
                                                        getterANDSetterFile.set_Dungeon(0);
                                                        random();
                                                    }
                                                });
                                            }
                                        });
                                        second.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {pr();
                                                o_button();
                                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s11);
                                                second.setText("Благословить");
                                                third.setText("Проклясть");
                                                second.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {pr();
                                                        o_button();
                                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s19);
                                                        second.setText("Отдать ключ");
                                                        third.setText("Броситься наверх");
                                                        second.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {pr();
                                                                o_button();
                                                                second.setText("Толкнуть");
                                                                third.setText("Побежать наверх");
                                                                second.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {pr();
                                                                        o_button();
                                                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s27);
                                                                        getterANDSetterFile.set_Dungeon(0);
                                                                        random();
                                                                    }
                                                                });
                                                                third.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {pr();
                                                                        o_button();
                                                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s17);
                                                                        getterANDSetterFile.set_Dungeon(0);
                                                                        random();
                                                                    }
                                                                });
                                                            }
                                                        });
                                                        third.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {pr();
                                                                o_button();
                                                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s17);
                                                                getterANDSetterFile.set_Dungeon(0);
                                                                random();
                                                            }
                                                        });
                                                    }
                                                });
                                                third.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {pr();
                                                        o_button();
                                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s21);
                                                        getterANDSetterFile.set_Dungeon(0);
                                                        random();
                                                    }
                                                });
                                            }
                                        });
                                        third.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {pr();
                                                o_button();
                                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s13);
                                                second.setText(getterANDSetterFile.get_Nickname());
                                                third.setText("Г.Б.");
                                                second.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {pr();
                                                        o_button();
                                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s23);
                                                        getterANDSetterFile.set_Dungeon(0);
                                                        random();
                                                    }
                                                });
                                                third.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {pr();
                                                        o_button();
                                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s25);
                                                        second.setText("Пойти дальше");
                                                        third.setText("Вернуться назад");
                                                        second.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {pr();
                                                                o_button();
                                                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s12);
                                                                second.setText("Продолжить спуск");
                                                                third.setText("Вернуться назад");
                                                                second.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {pr();
                                                                        o_button();
                                                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s20);
                                                                        getterANDSetterFile.set_Dungeon(0);
                                                                        random();
                                                                    }
                                                                });
                                                                third.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {pr();
                                                                        o_button();
                                                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s22);
                                                                        getterANDSetterFile.set_Dungeon(0);
                                                                        random();
                                                                    }
                                                                });
                                                            }
                                                        });
                                                        third.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {pr();
                                                                o_button();
                                                                description.setText(description.getText().toString() + "\n\n" + theme_seven.s25_c);
                                                                getterANDSetterFile.set_Dungeon(0);
                                                                random();
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                                third.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {pr();
                                        o_button();
                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s7);
                                        getterANDSetterFile.set_Dungeon(0);
                                        random();
                                    }
                                });
                            }
                        });
                        third.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {pr();
                                d_button();
                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s4);
                                first.setText("Продолжить спуск");
                                second.setText("Спросить кто умер");
                                third.setText("Вернуться назад");
                                first.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {pr();
                                        o_button();
                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s6);
                                        o_button();
                                        second.setText("Продолжить путь");
                                        third.setText("Повернуть назад");
                                        second.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {pr();
                                                o_button();
                                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s12);
                                                second.setText("Продолжить спуск");
                                                third.setText("Вернуться назад");
                                                second.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {pr();
                                                        o_button();
                                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s20);
                                                        getterANDSetterFile.set_Dungeon(0);
                                                        random();
                                                    }
                                                });
                                                third.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {pr();
                                                        o_button();
                                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s22);
                                                        getterANDSetterFile.set_Dungeon(0);
                                                        random();
                                                    }
                                                });
                                            }
                                        });
                                        third.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {pr();
                                                o_button();
                                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s14);
                                                getterANDSetterFile.set_Dungeon(0);
                                                random();
                                            }
                                        });
                                    }
                                });
                                second.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {pr();
                                        o_button();
                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s8);
                                        second.setText("2021");
                                        third.setText("Молча продолжить спуск вниз");
                                        second.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {pr();
                                                o_button();
                                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s16);
                                                getterANDSetterFile.set_Dungeon(0);
                                                random();
                                            }
                                        });
                                        third.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {pr();
                                                o_button();
                                                description.setText(description.getText().toString() + "\n\n" + theme_seven.s8_c);
                                                npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s18);
                                                getterANDSetterFile.set_Dungeon(0);
                                                random();
                                            }
                                        });
                                    }
                                });
                                third.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {pr();
                                        o_button();
                                        npc_tv.setText(npc_tv.getText().toString() + "\n\n" + theme_seven.s10);
                                        getterANDSetterFile.set_Dungeon(0);
                                        random();
                                    }
                                });
                            }
                        });

                    }
                });
                third.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {pr();
                        o_button();
                        description.setText(description.getText().toString() + "\n\n" + theme_seven.s1_c);
                        random();
                    }
                });
            }
            else {
                random();
            }
        }
        else{
            random();
        }
    }
}