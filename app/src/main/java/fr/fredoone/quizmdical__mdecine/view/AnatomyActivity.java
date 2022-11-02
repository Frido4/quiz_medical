package fr.fredoone.quizmdical__mdecine.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import fr.fredoone.quizmdical__mdecine.R;
import fr.fredoone.quizmdical__mdecine.domaine.TypeQuestion;

public class AnatomyActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    AdView mAdView;
    int score= 0;
    Button tvNiveau1, tvNiveau2, tvNiveau3, tvNiveau4, tvNiveau5, tvNiveau6, tvNiveau7, tvNiveau8, tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anatomy);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        LoadBanner();
        LoadInterstitial();

        tvNiveau1=findViewById(R.id.tvNiveau1);
        tvNiveau2=findViewById(R.id.tvNiveau2);
        tvNiveau3=findViewById(R.id.tvNiveau3);
        tvNiveau4=findViewById(R.id.tvNiveau4);
        tvNiveau5=findViewById(R.id.tvNiveau5);
        tvNiveau6=findViewById(R.id.tvNiveau6);
        tvNiveau7=findViewById(R.id.tvNiveau7);
        tvNiveau8=findViewById(R.id.tvNiveau8);
        tvScore = findViewById(R.id.tvScore);

        tvNiveau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(AnatomyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 1);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.ANATOMY.toString());
                startActivity(tvNiveau1ActivityIntent);


            }
        });

        tvNiveau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(AnatomyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 2);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.ANATOMY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(AnatomyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 3);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.ANATOMY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(AnatomyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 4);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.ANATOMY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });


        tvNiveau5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(AnatomyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 5);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.ANATOMY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });


        tvNiveau6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(AnatomyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 5);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.ANATOMY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(AnatomyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 7);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.ANATOMY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(AnatomyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 8);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.ANATOMY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvScoreActivityIntent = new Intent(AnatomyActivity.this, ScoreActivity.class);
                tvScoreActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.ANATOMY.toString());
                startActivity(tvScoreActivityIntent);

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(AnatomyActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
            }
        });
    }

    void LoadBanner() {
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    void LoadInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, getString(R.string.Interstitial_id), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                    }
                });
    }
    }