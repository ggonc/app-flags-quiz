package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText inputName;
    public Button btnIniciarQuiz, btnSair;
    public int acertos = 0;
    public String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName = findViewById(R.id.inputName);
        btnIniciarQuiz = findViewById(R.id.btnIniciarQuiz);
        btnSair = findViewById(R.id.btnSair);
        btnIniciarQuiz.setEnabled(false);
        inputName.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    btnIniciarQuiz.setEnabled(false);
                } else {
                    btnIniciarQuiz.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void iniciarQuiz(View view) {
        nome = inputName.getText().toString();
        Intent pergunta01 = new Intent(this, Pergunta01.class);
        pergunta01.putExtra("acertos", acertos);
        pergunta01.putExtra("nome", nome);
        startActivity(pergunta01);
    }

    public void sair(View view) {
        this.finishAffinity();
    }
}