package fr.fredoone.quizmdical__mdecine.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import fr.fredoone.quizmdical__mdecine.R;
import fr.fredoone.quizmdical__mdecine.domaine.TypeQuestion;

public class PharmacologyActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    AdView mAdView;

    Button tvNiveau1Pharma, tvNiveau2Pharma, tvNiveau3Pharma, tvNiveau4Pharma, tvNiveau5Pharma, tvNiveau6Pharma, tvNiveau7Pharma, tvNiveau8Pharma, tvScoreP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacology);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        LoadBanner();
        LoadInterstitial();

        tvNiveau1Pharma=findViewById(R.id.tvNiveau1);
        tvNiveau2Pharma=findViewById(R.id.tvNiveau2);
        tvNiveau3Pharma=findViewById(R.id.tvNiveau3);
        tvNiveau4Pharma=findViewById(R.id.tvNiveau4);
        tvNiveau5Pharma=findViewById(R.id.tvNiveau5);
        tvNiveau6Pharma=findViewById(R.id.tvNiveau6);
        tvNiveau7Pharma=findViewById(R.id.tvNiveau7);
        tvNiveau8Pharma=findViewById(R.id.tvNiveau8);
        tvScoreP = findViewById(R.id.tvScoreP);




        tvNiveau1Pharma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PharmacologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 1);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHARMACOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau2Pharma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PharmacologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 2);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHARMACOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau3Pharma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PharmacologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 3);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHARMACOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau4Pharma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PharmacologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 4);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHARMACOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau5Pharma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PharmacologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 5);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHARMACOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau6Pharma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PharmacologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 6);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHARMACOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau7Pharma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PharmacologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 7);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHARMACOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau8Pharma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PharmacologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 8);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHARMACOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvScoreP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  tvScorePActivityIntent = new Intent(PharmacologyActivity.this, ScoreActivity.class);
                tvScorePActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHARMACOLOGY.toString());
                startActivity( tvScorePActivityIntent);

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(PharmacologyActivity.this);
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