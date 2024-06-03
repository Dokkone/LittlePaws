package com.example.littlepaws;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Login.class);
                startActivity(intent);
            }
        });

        Button register_button = findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Register.class);
                startActivity(intent);
            }
        });

        ImageView gif_image = findViewById(R.id.gif_image);

        String gifUrl = "android.resource://" + getPackageName() + "/drawable/little_paws_promotional_video";

        // Load and display the GIF using Glide
        Glide.with(this)
                .load(gifUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(gif_image);
    }
}
