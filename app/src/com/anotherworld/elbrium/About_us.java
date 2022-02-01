package com.anotherworld.elbrium;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class About_us extends AppCompatActivity {
    @Override
    protected void onStart() {
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        super.onStart();
    }

    TextView pr, pr_text, com, j, j_text, l, l_text, an, an_text, e, e_text, bags_tv, try_tv, try_text;
    String prehistory, prehistory_txt, commands, join, join_txt, leave, leave_txt, an_nickname, an_nickname_txt, example, example_text, bags, copy_txt, vkon, vkon_txt, try_string_tv, try_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().hide();
        pr = findViewById(R.id.prehistory);
        pr_text = findViewById(R.id.prehistory_text);
        com = findViewById(R.id.commands);
        j = findViewById(R.id.join);
        j_text = findViewById(R.id.join_text);
        l = findViewById(R.id.leave);
        l_text = findViewById(R.id.leave_text);
        an = findViewById(R.id.another_nickname);
        an_text = findViewById(R.id.another_nickname_text);
        e = findViewById(R.id.example);
        e_text = findViewById(R.id.example_text);
        bags_tv = findViewById(R.id.bags);
        try_tv = findViewById(R.id.Try);
        try_text = findViewById(R.id.Try_text);
        try_string_tv = "#try ";
        try_string = "- Возвращает случайное значение: [Успешно] или [Неуспешно].";
        prehistory = "Предыстория";
        prehistory_txt = "Давным-давно человечество погрузилось во тьму. Ядерные катастрофы, войны и бесконечные катаклизмы (ответная реакция природы на действия человека). В итоге, заключив шаткое перемирие, человечество отправилось в бескрайний космос.\n" +
                "Через много лет и появляетесь вы. Пилот, цель которого добыть как можно больше Elbrium'а. Он - главный ресурс новой современности: топливо, благодаря которому человечество, живущее на пяти планетах, может вновь и вновь подниматься в воздух и исследовать ближайший и далёкий космос.\n" +
                "Прокачивайте свой корабль, общайтесь с другими пилотами и просто отдыхайте. Приключения ждут!";
        commands = "Команды";
        join = "#join ";
        join_txt = "– вход в космическое пространство.";
        leave = "#leave ";
        leave_txt = "– вернуться в главное меню.";
        an_nickname = "@чужой_ник ";
        an_nickname_txt = "– упоминание пользователя.";
        example = "*текст* ";
        example_text = "– комментирование текста в случайном месте.";
        bags = "Нашли баг? Напишите нам: ";
        copy_txt = "sup.alone.port@gmail.com";
        pr.setText(prehistory);
        pr_text.setText(prehistory_txt + "\n");
        com.setText(commands);
        j.setText(join);
        j.setTextColor(getResources().getColor(R.color.command1));
        j_text.setText(join_txt + "\n");
        l.setText(leave);
        l.setTextColor(getResources().getColor(R.color.command1));
        l_text.setText(leave_txt + "\n");
        an.setText(an_nickname);
        an.setTextColor(getResources().getColor(R.color.ping2));
        an_text.setText(an_nickname_txt + "\n");
        e.setText(example);
        e.setTextColor(getResources().getColor(R.color.comment));
        e_text.setText(example_text + "\n");
        try_tv.setText(try_string_tv);
        try_tv.setTextColor(getResources().getColor(R.color.Try));
        try_text.setText(try_string + "\n\n");
        bags_tv.setText(bags + copy_txt + "\n");
    }
}