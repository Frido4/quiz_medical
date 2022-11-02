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

public class PhysiologyActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    AdView mAdView;

    Button tvNiveau1Physiology, tvNiveau2Physiology, tvNiveau3Physiology, tvNiveau4Physiology, tvNiveau5Physiology, tvNiveau6Physiology, tvNiveau7Physiology, tvNiveau8Physiology, tvScorePhy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiology);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        LoadBanner();
        LoadInterstitial();

        tvNiveau1Physiology=findViewById(R.id.tvNiveau1);
        tvNiveau2Physiology=findViewById(R.id.tvNiveau2);
        tvNiveau3Physiology=findViewById(R.id.tvNiveau3);
        tvNiveau4Physiology=findViewById(R.id.tvNiveau4);
        tvNiveau5Physiology=findViewById(R.id.tvNiveau5);
        tvNiveau6Physiology=findViewById(R.id.tvNiveau6);
        tvNiveau7Physiology=findViewById(R.id.tvNiveau7);
        tvNiveau8Physiology=findViewById(R.id.tvNiveau8);
        tvScorePhy = findViewById(R.id.tvScorePhy);


        tvNiveau1Physiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PhysiologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 1);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHYSIOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });


        tvNiveau2Physiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PhysiologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 2);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHYSIOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });


        tvNiveau3Physiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PhysiologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 3);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHYSIOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau4Physiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PhysiologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 4);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHYSIOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvNiveau5Physiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PhysiologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 5);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHYSIOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });


        tvNiveau6Physiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PhysiologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 6);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHYSIOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });


        tvNiveau7Physiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PhysiologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 7);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHYSIOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });


        tvNiveau8Physiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNiveau1ActivityIntent = new Intent(PhysiologyActivity.this, QuizActivity.class);
                tvNiveau1ActivityIntent.putExtra("NIVEAU", 8);
                tvNiveau1ActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHYSIOLOGY.toString());
                startActivity(tvNiveau1ActivityIntent);
            }
        });

        tvScorePhy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  tvScorePhyActivityIntent= new Intent(PhysiologyActivity.this, ScoreActivity.class);
                tvScorePhyActivityIntent.putExtra("TYPE_QUESTION", TypeQuestion.PHYSIOLOGY.toString());
                startActivity(tvScorePhyActivityIntent);

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(PhysiologyActivity.this);
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