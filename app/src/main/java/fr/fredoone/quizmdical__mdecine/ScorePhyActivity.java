package fr.fredoone.quizmdical__mdecine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ScorePhyActivity extends AppCompatActivity {

    TextView tvScoreN1Phy, tvScoreN1aPhy, tvScoreN2Phy, tvScoreN2aPhy, tvScoreN3Phy, tvScoreN3aPhy, tvScoreN4Phy, tvScoreN4aPhy, tvScoreN5Phy, tvScoreN5aPhy,tvScoreN6Phy, tvScoreN6aPhy, tvScoreN7Phy, tvScoreN7aPhy, tvScoreN8Phy, tvScoreN8aPhy;
    int lastScorePhy;
    int lastScore1Phy;
    int lastScore3Phy;
    int lastScore4Phy;
    int lastScore5Phy;
    int lastScore6Phy;
    int lastScore7Phy;
    int lastScore8Phy;
    int Best1Phy;
    int Best2Phy;
    int Best3Phy;
    int Best4Phy;
    int Best5Phy;
    int Best6Phy;
    int Best7Phy;
    int Best8Phy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_phy);


        tvScoreN1Phy = findViewById(R.id.tvScoreN1Phy);
        tvScoreN1aPhy = findViewById(R.id.tvScoreN1aPhy);
        tvScoreN2Phy = findViewById(R.id.tvScoreN2Phy);
        tvScoreN2aPhy = findViewById(R.id.tvScoreN2aPhy);
        tvScoreN3Phy = findViewById(R.id.tvScoreN3Phy);
        tvScoreN3aPhy = findViewById(R.id.tvScoreN3aPhy);
        tvScoreN4Phy = findViewById(R.id.tvScoreN4Phy);
        tvScoreN4aPhy = findViewById(R.id.tvScoreN4aPhy);
        tvScoreN5Phy = findViewById(R.id.tvScoreN5Phy);
        tvScoreN5aPhy = findViewById(R.id.tvScoreN5aPhy);
        tvScoreN6Phy = findViewById(R.id.tvScoreN6Phy);
        tvScoreN6aPhy = findViewById(R.id.tvScoreN6aPhy);
        tvScoreN7Phy = findViewById(R.id.tvScoreN7Phy);
        tvScoreN7aPhy = findViewById(R.id.tvScoreN7aPhy);
        tvScoreN8Phy = findViewById(R.id.tvScoreN8Phy);
        tvScoreN8aPhy = findViewById(R.id.tvScoreN8aPhy);


        SharedPreferences preferences = getSharedPreferences("PREFS", 0);

        lastScorePhy = preferences.getInt("lastScorePhy", 0);
        Best1Phy = preferences.getInt("Best1Phy", 0);

        lastScore1Phy = preferences.getInt("lastScore1Phy", 0);
        Best2Phy = preferences.getInt("Best2Phy", 0);

        lastScorePhy = preferences.getInt("lastScore3Phy", 0);
        Best1Phy = preferences.getInt("Best3Phy", 0);

        lastScore1Phy = preferences.getInt("lastScore4Phy", 0);
        Best2Phy = preferences.getInt("Best4Phy", 0);

        lastScorePhy = preferences.getInt("lastScore5Phy", 0);
        Best1Phy = preferences.getInt("Best5Phy", 0);

        lastScore1Phy = preferences.getInt("lastScore6Phy", 0);
        Best2Phy = preferences.getInt("Best6Phy", 0);

        lastScorePhy = preferences.getInt("lastScore7Phy", 0);
        Best1Phy = preferences.getInt("Best7Phy", 0);

        lastScore1Phy = preferences.getInt("lastScore8Phy", 0);
        Best2Phy = preferences.getInt("Best8Phy", 0);


        if (lastScorePhy > Best1Phy) {
            Best1Phy = lastScorePhy;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best1Phy", Best1Phy);
            editor.apply();
        }

        if (lastScore1Phy > Best2Phy) {
            Best2Phy = lastScore1Phy;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best2Phy", Best2Phy);
            editor.apply();
        }

        if (lastScore3Phy > Best3Phy) {
            Best3Phy = lastScore3Phy;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best3Phy", Best3Phy);
            editor.apply();
        }

        if (lastScore4Phy > Best4Phy) {
            Best4Phy = lastScore4Phy;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best4Phy", Best4Phy);
            editor.apply();
        }

        if (lastScore5Phy > Best5Phy) {
            Best5Phy = lastScore5Phy;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best5Phy", Best5Phy);
            editor.apply();
        }

        if (lastScore6Phy > Best6Phy) {
            Best6Phy = lastScore6Phy;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best6Phy", Best6Phy);
            editor.apply();
        }

        if (lastScore7Phy > Best7Phy) {
            Best7Phy = lastScore7Phy;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best7Phy", Best7Phy);
            editor.apply();
        }

        if (lastScore8Phy > Best8Phy) {
            Best8Phy = lastScore8Phy;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best8Phy", Best8Phy);
            editor.apply();
        }

        tvScoreN1Phy.setText("Dernier Score N1: " + lastScorePhy);
        tvScoreN1aPhy.setText("Meilleur Score N1: " + Best1Phy);
        tvScoreN2Phy.setText("Dernier Score N2: " + lastScore1Phy);
        tvScoreN2aPhy.setText("Meilleur Score N2: " + Best2Phy);
        tvScoreN3Phy.setText("Dernier Score N3: " + lastScore3Phy);
        tvScoreN3aPhy.setText("Meilleur Score N3: " + Best3Phy);
        tvScoreN4Phy.setText("Dernier Score N4: " + lastScore4Phy);
        tvScoreN4aPhy.setText("Meilleur Score N4: " + Best4Phy);
        tvScoreN5Phy.setText("Dernier Score N5: " + lastScore5Phy);
        tvScoreN5aPhy.setText("Meilleur Score N5: " + Best5Phy);
        tvScoreN6Phy.setText("Dernier Score N6: " + lastScore6Phy);
        tvScoreN6aPhy.setText("Meilleur Score N6: " + Best6Phy);
        tvScoreN7Phy.setText("Dernier Score N7: " + lastScore7Phy);
        tvScoreN7aPhy.setText("Meilleur Score N7: " + Best7Phy);
        tvScoreN8Phy.setText("Dernier Score N8: " + lastScore8Phy);
        tvScoreN8aPhy.setText("Meilleur Score N8: " + Best8Phy);

    }
}