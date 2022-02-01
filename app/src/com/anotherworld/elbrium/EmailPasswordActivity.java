package com.anotherworld.elbrium;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.appcompat.app.AppCompatActivity;

public class EmailPasswordActivity extends AppCompatActivity implements View.OnClickListener{ // Класс регистрации
    EditText registration_nickname;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText ETemail;
    private EditText ETpassword;
    int number=0;
    String s;
    public void signin (String email, String password)
    { // Метод входа, используется Firebase
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    CreatorFiles sd = new CreatorFiles();
                    sd.create();
                    s = registration_nickname.getText().toString();
                    GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();

                    if(!s.contains(" "))getterANDSetterFile.set_Nickname(s);
                    else Toast.makeText(getApplicationContext(),"Неправильный никнейм",Toast.LENGTH_SHORT).show();
                    number = 1;
                    if(!s.contains(" ")){
                        getterANDSetterFile.set_Sign(1);
                        startActivity(new Intent(EmailPasswordActivity.this, Scrolling.class));
                    }
                    else Toast.makeText(getApplicationContext(),"Неправильный никнейм",Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(getApplicationContext(), "Aвторизация провалена", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void registration (String email, String password){ // Метод регистрации, используется Firebase
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                CreatorFiles sd = new CreatorFiles();
                sd.create();
                s = registration_nickname.getText().toString();
                GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
                if(!s.contains(" "))getterANDSetterFile.set_Nickname(s);
                else Toast.makeText(getApplicationContext(),"Неправильный никнейм",Toast.LENGTH_SHORT).show();
                number = 1;
                if(!s.contains(" ")){
                    getterANDSetterFile.set_Sign(1);
                    startActivity(new Intent(EmailPasswordActivity.this, Scrolling.class));
                }
                else Toast.makeText(getApplicationContext(),"Неправильный никнейм",Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_sign_in)
        {
            try {
                s = registration_nickname.getText().toString();
                GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
                if(!s.contains(" "))getterANDSetterFile.set_Nickname(s);
                signin(ETemail.getText().toString(),ETpassword.getText().toString());
                number = 1;
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else if (view.getId() == R.id.btn_registration)
        {
            try {
                registration(ETemail.getText().toString(),ETpassword.getText().toString());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_password);
        getSupportActionBar().hide();
        CreatorFiles sd = new CreatorFiles();
        sd.create();  // Создание всех файлов
        registration_nickname = findViewById(R.id.registration_nickname);
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        number = getterANDSetterFile.get_Sign();
        mAuth = FirebaseAuth.getInstance();
        getterANDSetterFile.set_BaseLevel(0);
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    s = registration_nickname.getText().toString();
                    GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
                    if(!s.contains(" "))getterANDSetterFile.set_Nickname(s);
                }
            }
        };
        ETemail = findViewById(R.id.et_email);
        ETpassword = findViewById(R.id.et_password);
        findViewById(R.id.btn_sign_in).setOnClickListener(this);
        findViewById(R.id.btn_registration).setOnClickListener(this);
    }
}
