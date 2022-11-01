package fr.fredoone.quizmdical__mdecine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ScorePhaActivity extends AppCompatActivity {

    TextView tvScoreN1P, tvScoreN1aP, tvScoreN2P, tvScoreN2aP, tvScoreN3P, tvScoreN3aP, tvScoreN4P, tvScoreN4aP, tvScoreN5P, tvScoreN5aP, tvScoreN6P, tvScoreN6aP, tvScoreN7P, tvScoreN7aP, tvScoreN8P, tvScoreN8aP;
    int lastScoreP;
    int lastScore1P;
    int lastScore3P;
    int lastScore4P;
    int lastScore5P;
    int lastScore6P;
    int lastScore7P;
    int lastScore8P;
    int Best1P;
    int Best2P;
    int Best3P;
    int Best4P;
    int Best5P;
    int Best6P;
    int Best7P;
    int Best8P;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_pha);

        tvScoreN1P = findViewById(R.id.tvScoreN1P);
        tvScoreN1aP = findViewById(R.id.tvScoreN1aP);
        tvScoreN2P = findViewById(R.id.tvScoreN2P);
        tvScoreN2aP = findViewById(R.id.tvScoreN2aP);
        tvScoreN3P = findViewById(R.id.tvScoreN3P);
        tvScoreN3aP = findViewById(R.id.tvScoreN3aP);
        tvScoreN4P = findViewById(R.id.tvScoreN4P);
        tvScoreN4aP = findViewById(R.id.tvScoreN4aP);
        tvScoreN5P = findViewById(R.id.tvScoreN5P);
        tvScoreN5aP = findViewById(R.id.tvScoreN5aP);
        tvScoreN6P = findViewById(R.id.tvScoreN6P);
        tvScoreN6aP = findViewById(R.id.tvScoreN6aP);
        tvScoreN7P = findViewById(R.id.tvScoreN7P);
        tvScoreN7aP = findViewById(R.id.tvScoreN7aP);
        tvScoreN8P = findViewById(R.id.tvScoreN8P);
        tvScoreN8aP = findViewById(R.id.tvScoreN8aP);


        SharedPreferences preferences = getSharedPreferences("PREFS", 0);

        lastScoreP = preferences.getInt("lastScoreP", 0);
        Best1P = preferences.getInt("Best1P", 0);

        lastScore1P = preferences.getInt("lastScore1P", 0);
        Best2P = preferences.getInt("Best2P", 0);

        lastScore3P = preferences.getInt("lastScore3P", 0);
        Best3P = preferences.getInt("Best3P", 0);

        lastScore4P = preferences.getInt("lastScore4P", 0);
        Best4P = preferences.getInt("Best4P", 0);

        lastScore5P = preferences.getInt("lastScore5P", 0);
        Best5P = preferences.getInt("Best5P", 0);

        lastScore6P = preferences.getInt("lastScore6P", 0);
        Best6P = preferences.getInt("Best6P", 0);

        lastScore7P = preferences.getInt("lastScore7P", 0);
        Best7P = preferences.getInt("Best7P", 0);

        lastScore8P = preferences.getInt("lastScore8P", 0);
        Best8P = preferences.getInt("Best8P", 0);


        if (lastScoreP > Best1P) {
            Best1P = lastScoreP;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best1P", Best1P);
            editor.apply();
        }

        if (lastScore1P > Best2P) {
            Best2P = lastScore1P;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best2P", Best2P);
            editor.apply();
        }

        if (lastScore3P > Best3P) {
            Best3P = lastScore3P;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best3P", Best3P);
            editor.apply();
        }

        if (lastScore4P > Best4P) {
            Best4P = lastScore4P;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best4P", Best4P);
            editor.apply();
        }

        if (lastScore5P > Best5P) {
            Best5P = lastScore5P;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best5P", Best5P);
            editor.apply();
        }

        if (lastScore6P > Best6P) {
            Best6P = lastScore6P;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best6P", Best6P);
            editor.apply();
        }

        if (lastScore7P > Best7P) {
            Best7P = lastScore7P;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best7P", Best7P);
            editor.apply();
        }

        if (lastScore8P > Best8P) {
            Best8P = lastScore8P;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best8P", Best8P);
            editor.apply();
        }

        tvScoreN1P.setText("Dernier Score N1: " + lastScoreP);
        tvScoreN1aP.setText("Meilleur Score N1: " + Best1P);
        tvScoreN2P.setText("Dernier Score N2: " + lastScore1P);
        tvScoreN2aP.setText("Meilleur Score N2: " + Best2P);
        tvScoreN3P.setText("Dernier Score N3: " + lastScore3P);
        tvScoreN3aP.setText("Meilleur Score N3: " + Best3P);
        tvScoreN4P.setText("Dernier Score N4: " + lastScore4P);
        tvScoreN4aP.setText("Meilleur Score N4: " + Best4P);
        tvScoreN5P.setText("Dernier Score N5: " + lastScore5P);
        tvScoreN5aP.setText("Meilleur Score N5: " + Best5P);
        tvScoreN6P.setText("Dernier Score N6: " + lastScore6P);
        tvScoreN6aP.setText("Meilleur Score N6: " + Best6P);
        tvScoreN7P.setText("Dernier Score N7: " + lastScore7P);
        tvScoreN7aP.setText("Meilleur Score N7: " + Best7P);
        tvScoreN8P.setText("Dernier Score N8: " + lastScore8P);
        tvScoreN8aP.setText("Meilleur Score N8: " + Best8P);
    }
}