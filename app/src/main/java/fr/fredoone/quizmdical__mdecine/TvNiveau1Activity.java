package fr.fredoone.quizmdical__mdecine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import fr.fredoone.quizmdical__mdecine.domaine.TypeQuestion;

public class TvNiveau1Activity extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference myRef;
    private RewardedAd mRewardedAd;

    AdView mAdView;

    private TextView tvQuestion, tvScore, tvQuestionNo, tvTimer;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private Button btnNext;

    int totalQuestions;
    int qCounter = 0;
    int score = 0;

    ColorStateList dfRbColor;
    boolean answered;

    CountDownTimer countDownTimer;

    private QuestionModel currentQuestion;

    private List<QuestionModel> questionsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_niveau1);
        TypeQuestion typeQuestion = TypeQuestion.valueOf(getIntent().getStringExtra("TYPE_QUESTION"));
        int niveau = getIntent().getIntExtra("NIVEAU", 0);
        for(QuestionModel q: DataBase.addQuestions()){
            if (niveau == q.getNiveau() && typeQuestion == q.getTypeQuestion()){
                questionsList.add(q);
            }
        }
        // LoadData();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        LoadBanner();



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
                        Toast.makeText(TvNiveau1Activity.this, "Ads successfully loaded", Toast.LENGTH_SHORT).show();
                        mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {
                                // Called when a click is recorded for an ad.
                                Log.d("TAG", "Ad was clicked.");
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when ad is dismissed.
                                // Set the ad reference to null so you don't show the ad a second time.
                                Log.d("TAG", "Ad dismissed fullscreen content.");
                                mRewardedAd = null;
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when ad fails to show.
                                Log.e("TAG", "Ad failed to show fullscreen content.");
                                mRewardedAd = null;
                            }

                            @Override
                            public void onAdImpression() {
                                // Called when an impression is recorded for an ad.
                                Log.d("TAG", "Ad recorded an impression.");
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when ad is shown.
                                Log.d("TAG", "Ad showed fullscreen content.");
                            }
                        });

                    }

                });








        tvQuestion = findViewById(R.id.textQuestion);
        tvScore = findViewById(R.id.textScore);
        tvQuestionNo = findViewById(R.id.textQuestionNo);
        tvTimer = findViewById(R.id.textTime);



        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        btnNext = findViewById(R.id.btnNext);

        dfRbColor = rb1.getTextColors();



        totalQuestions = questionsList.size();
        showNextQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answered == false){
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        checkAnswer();
                        countDownTimer.cancel();
                    }else {
                        Toast.makeText(TvNiveau1Activity.this, "Veuillez sélectionner une réponse", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    showNextQuestion();
                }
            }
        });



    }

    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(rbSelected) + 1;
        if (answerNo == currentQuestion.getCorrectAnsNo()){
            score+=10;
            tvScore.setText("Score " +score);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        switch (currentQuestion.getCorrectAnsNo()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                break;
        }
        if (qCounter < totalQuestions){
            btnNext.setText("Suivant");
        }else {
            btnNext.setText("Terminé");
        }

    }

    private void showNextQuestion() {

        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);
        rb4.setTextColor(dfRbColor);


        if (qCounter < totalQuestions) {
            timer();
            currentQuestion = questionsList.get(qCounter);
            tvQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            qCounter++;
            btnNext.setText("Soumettre");
            tvQuestionNo.setText("Question: " + qCounter + "/" + totalQuestions);
            answered = false;
        } else {
            String passStatus = "";
            if (score >= 150) {
                SharedPreferences preferences = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("lastScore", score);
                editor.apply();


                editor.putInt("lastScore1", score);
                editor.apply();

                passStatus = "Bravo!! Vouz avez terminé!!"+ " Passez au Niveau supérieur";


            } else {

                SharedPreferences preferences = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("lastScore", score);
                editor.apply();

                editor.putInt("lastScore1", score);
                editor.apply();
                passStatus = "Vous avez échoué, réessayez";
            }
            new AlertDialog.Builder(this)
                    .setTitle(passStatus)
                    .setMessage("Votre score " + " Sur " + totalQuestions + " questions est " + score)
                    .setPositiveButton("Terminé", (dialogInterface, i) -> finish())
                    .setCancelable(false)
                    .show();

            if (mRewardedAd != null) {
                Activity activityContext = TvNiveau1Activity.this;
                mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                    @Override
                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                        // Handle the reward.
                        Toast.makeText(TvNiveau1Activity.this, "rewards finish", Toast.LENGTH_SHORT).show();
                        int rewardAmount = rewardItem.getAmount();
                        String rewardType = rewardItem.getType();
                    }
                });
            } else {

            }

        }
    }

    private void timer() {
        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {

                tvTimer.setText("00:" + l/1000);
            }

            @Override
            public void onFinish() {
                showNextQuestion();

            }
        }.start();
    }




    void LoadBanner() {
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }
    private void LoadData(){
        this.mDatabase =  FirebaseDatabase.getInstance();
        this.myRef = mDatabase.getReference("Questions");
        /*ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Get Post object and use values update the UI
                Post post = snapshot.getValue(Post.class);
                //..
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Getting Post failed. log a message
                Log.w(TAG, )

            }
        }

         */

        for(QuestionModel question : DataBase.addQuestions()){
            this.myRef.child(String.valueOf(question.getId())).setValue(question);


        }
    }
}