package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ranking extends AppCompatActivity {

    List<Pontuacao> ranking = new ArrayList<>();
    public int acertos;
    public String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        TableLayout tableRanking = findViewById(R.id.tableRanking);
        acertos = getIntent().getIntExtra("acertos", 0);
        nome = getIntent().getStringExtra("nome");
        Pontuacao user = new Pontuacao(nome, acertos);
        ranking.add(user);

        for (Pontuacao pontuacao : ranking) {
            // Create a new table row
            TableRow row = new TableRow(this);

            // Create the text views for the row
            TextView cellNome = new TextView(this);
            cellNome.setText(pontuacao.getNome());
            cellNome.setTextSize(20); // Set text size to 16dp
            TableRow.LayoutParams params1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            params1.width = 210;
            cellNome.setLayoutParams(params1); // Set width to 230dp
            cellNome.setPadding(10, 0, 0, 0); // Add left padding of 10dp

            TextView cellPontuacao = new TextView(this);
            cellPontuacao.setText(String.valueOf(pontuacao.getAcertos()));
            cellPontuacao.setTextSize(20); // Set text size to 16dp
            TableRow.LayoutParams params2 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            params2.width = 130;
            cellPontuacao.setLayoutParams(params2); // Set width to 100dp
            cellPontuacao.setPadding(10, 0, 0, 0); // Add left padding of 10dp
            cellPontuacao.setGravity(Gravity.CENTER); // Center the content horizontally

            // Add the text views to the row
            row.addView(cellNome);
            row.addView(cellPontuacao);

            // Add the row to the table
            tableRanking.addView(row);
        }
    }

    public void responderNovamente(View view) {
        Intent intent = new Intent(Ranking.this, Pergunta01.class);
        intent.putExtra("acertos", 0);
        intent.putExtra("nome", nome);
        startActivity(intent);
        finish(); // finish the Ranking activity
        finishAffinity(); // finish all activities in the task, including MainActivity
    }

    public void voltarParaTelaInicial(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finishAffinity();
    }
}

class Pontuacao {
    private String nome;
    private int acertos;

    public Pontuacao(final String nome, final int acertos) {
        this.nome = nome;
        this.acertos = acertos;
    }

    public String getNome() { return this.nome; }
    public int getAcertos() { return this.acertos; }
}