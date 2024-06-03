package com.example.littlepaws;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;


public class SplashPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashPage.this, Homepage.class);
                startActivity(intent);
                finish();
            }
        }, 5000); // 5000 milliseconds (5 seconds) delay


        ImageView littlePawsLogo = findViewById(R.id.littlePawsLogo);

        String gifUrl = "android.resource://" + getPackageName() + "/drawable/little_paws_logo";

        // Load and display the GIF using Glide
        Glide.with(this)
                .load(gifUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(littlePawsLogo);
    }
}
