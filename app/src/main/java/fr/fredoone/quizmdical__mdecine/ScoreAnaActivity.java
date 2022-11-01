package fr.fredoone.quizmdical__mdecine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreAnaActivity extends AppCompatActivity {

    TextView tvScoreN1, tvScoreN1a, tvScoreN2, tvScoreN2a, tvScoreN3, tvScoreN3a, tvScoreN4, tvScoreN4a, tvScoreN5, tvScoreN5a, tvScoreN6, tvScoreN6a, tvScoreN7, tvScoreN7a, tvScoreN8, tvScoreN8a;
    int lastScore;
    int lastScore1;
    int lastScore3;
    int lastScore4;
    int lastScore5;
    int lastScore6;
    int lastScore7;
    int lastScore8;
    int Best1;
    int Best2;
    int Best3;
    int Best4;
    int Best5;
    int Best6;
    int Best7;
    int Best8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_ana);

        tvScoreN1 = findViewById(R.id.tvScoreN1);
        tvScoreN1a = findViewById(R.id.tvScoreN1a);
        tvScoreN2 = findViewById(R.id.tvScoreN2);
        tvScoreN2a = findViewById(R.id.tvScoreN2a);
        tvScoreN3 = findViewById(R.id.tvScoreN3);
        tvScoreN3a = findViewById(R.id.tvScoreN3a);
        tvScoreN4 = findViewById(R.id.tvScoreN4);
        tvScoreN4a = findViewById(R.id.tvScoreN4a);
        tvScoreN5 = findViewById(R.id.tvScoreN5);
        tvScoreN5a = findViewById(R.id.tvScoreN5a);
        tvScoreN6 = findViewById(R.id.tvScoreN6);
        tvScoreN6a = findViewById(R.id.tvScoreN6a);
        tvScoreN7 = findViewById(R.id.tvScoreN7);
        tvScoreN7a = findViewById(R.id.tvScoreN7a);
        tvScoreN8 = findViewById(R.id.tvScoreN8);
        tvScoreN8a = findViewById(R.id.tvScoreN8a);


        SharedPreferences preferences = getSharedPreferences("PREFS", 0);

        lastScore = preferences.getInt("lastScore", 0);
        Best1 = preferences.getInt("Best1", 0);

        lastScore1 = preferences.getInt("lastScore1", 0);
        Best2 = preferences.getInt("Best2", 0);

        lastScore3 = preferences.getInt("lastScore3", 0);
        Best3 = preferences.getInt("Best3", 0);

        lastScore4 = preferences.getInt("lastScore4", 0);
        Best4 = preferences.getInt("Best4", 0);

        lastScore5 = preferences.getInt("lastScore5", 0);
        Best5 = preferences.getInt("Best5", 0);

        lastScore6 = preferences.getInt("lastScore6", 0);
        Best6 = preferences.getInt("Best6", 0);

        lastScore7 = preferences.getInt("lastScore7", 0);
        Best7 = preferences.getInt("Best7", 0);

        lastScore8 = preferences.getInt("lastScore8", 0);
        Best8 = preferences.getInt("Best8", 0);


        if (lastScore > Best1) {
            Best1 = lastScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best1", Best1);
            editor.apply();
        }

        if (lastScore1 > Best2) {
            Best2 = lastScore1;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best2", Best2);
            editor.apply();
        }

        if (lastScore3 > Best3) {
            Best3 = lastScore3;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best3", Best3);
            editor.apply();
        }

        if (lastScore4 > Best4) {
            Best4 = lastScore4;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best4", Best4);
            editor.apply();
        }

        if (lastScore5 > Best5) {
            Best5 = lastScore5;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best5", Best5);
            editor.apply();
        }

        if (lastScore6 > Best6) {
            Best6 = lastScore6;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best6", Best6);
            editor.apply();
        }

        if (lastScore7 > Best7) {
            Best7 = lastScore7;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best7", Best7);
            editor.apply();
        }

        if (lastScore8 > Best8) {
            Best8 = lastScore8;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best8", Best8);
            editor.apply();
        }

        tvScoreN1.setText("Dernier Score N1: " + lastScore);
        tvScoreN1a.setText("Meilleur Score N1: " + Best1);
        tvScoreN2.setText("Dernier Score N2: " + lastScore1);
        tvScoreN2a.setText("Meilleur Score N2: " + Best2);
        tvScoreN3.setText("Dernier Score N3: " + lastScore3);
        tvScoreN3a.setText("Meilleur Score N3: " + Best3);
        tvScoreN4.setText("Dernier Score N4: " + lastScore4);
        tvScoreN4a.setText("Meilleur Score N4: " + Best4);
        tvScoreN5.setText("Dernier Score N5: " + lastScore5);
        tvScoreN5a.setText("Meilleur Score N5: " + Best5);
        tvScoreN6.setText("Dernier Score N6: " + lastScore6);
        tvScoreN6a.setText("Meilleur Score N6: " + Best6);
        tvScoreN7.setText("Dernier Score N7: " + lastScore7);
        tvScoreN7a.setText("Meilleur Score N7: " + Best7);
        tvScoreN8.setText("Dernier Score N8: " + lastScore8);
        tvScoreN8a.setText("Meilleur Score N8: " + Best8);
    }
}