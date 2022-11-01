package fr.fredoone.quizmdical__mdecine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3500;
    ImageView mImageView;
    TextView mTextView, mTextView1;
    Animation top_wave, botton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        mImageView = findViewById(R.id.imageView);
        mTextView = findViewById(R.id.mTextView);
        mTextView1 = findViewById(R.id.mTextView1);



        top_wave = AnimationUtils.loadAnimation(this, R.anim.top_wave);
        botton = AnimationUtils.loadAnimation(this, R.anim.botton);

        mImageView.setAnimation(top_wave);
        mTextView.setAnimation(botton);
        mTextView1.setAnimation(botton);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, SPLASH_SCREEN);


    }
}