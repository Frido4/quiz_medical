package fr.fredoone.quizmdical__mdecine;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private RewardedAd mRewardedAd;
    private final String TAG = "MainActivity";



    TextView mTextView2;
    Button mAnatomy;
    Button mPhysiology;
    Button mPharmacology;

    Button load_inter;

    AdView mAdView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        LoadBanner();
        LoadInterstitial();


        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.

                        mRewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;
                        Toast.makeText(MainActivity.this, "Ads successfully loaded", Toast.LENGTH_SHORT).show();
                        mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {
                                // Called when a click is recorded for an ad.
                                Log.d(TAG, "Ad was clicked.");
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when ad is dismissed.
                                // Set the ad reference to null so you don't show the ad a second time.
                                Log.d(TAG, "Ad dismissed fullscreen content.");
                                mRewardedAd = null;
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when ad fails to show.
                                Log.e(TAG, "Ad failed to show fullscreen content.");
                                mRewardedAd = null;
                            }

                            @Override
                            public void onAdImpression() {
                                // Called when an impression is recorded for an ad.
                                Log.d(TAG, "Ad recorded an impression.");
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when ad is shown.
                                Log.d(TAG, "Ad showed fullscreen content.");
                            }
                        });

                            }

                        });


        load_inter = findViewById(R.id.load_inter);
        load_inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
            }
        });




            mTextView2 = findViewById(R.id.textView2);
        mAnatomy = findViewById(R.id.btnAnatomy);
        mPhysiology = findViewById(R.id.btnPhysiology);
        mPharmacology = findViewById(R.id.btnPharmacology);





        mAnatomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mAnatomyActivityIntent= new Intent(MainActivity.this, AnatomyActivity.class);
                startActivity(mAnatomyActivityIntent);
            }
        });


        mPhysiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mPhysiologyActivityIntent= new Intent(MainActivity.this, PhysiologyActivity.class);
                startActivity(mPhysiologyActivityIntent);
            }
        });

        mPharmacology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mPharmacologyActivityIntent= new Intent(MainActivity.this, PharmacologyActivity.class);
                startActivity(mPharmacologyActivityIntent);
            }
        });


    }
    void LoadBanner(){
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
    void LoadInterstitial(){
    AdRequest adRequest = new AdRequest.Builder().build();

    InterstitialAd.load(this,getString(R.string.Interstitial_id), adRequest,
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

    public void click(View view){
        if (mRewardedAd != null) {
            Activity activityContext = MainActivity.this;
            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    // Handle the reward.
                    Toast.makeText(MainActivity.this, "rewards finish", Toast.LENGTH_SHORT).show();    
                    int rewardAmount = rewardItem.getAmount();
                    String rewardType = rewardItem.getType();
                }
            });
        } else {
            
        }
    }

}