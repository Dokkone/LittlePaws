package com.example.littlepaws;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.littlepaws.holder.UserDataHolder;
import com.example.littlepaws.model.User;

public class Homepage_Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepageadmin);

        User user = UserDataHolder.getInstance().getLoggedInUser();

        TextView tv1 = findViewById(R.id.logintextbtn);

        tv1.setText(user.getFirstname().toString());

        ImageView addNewDogBtn = findViewById(R.id.addnewdogbtn);
        ImageView viewDogsBtn = findViewById(R.id.viewdogsbtn);

        addNewDogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Homepage_Admin.this, AddDogs.class);
                startActivity(intent);
            }
        });

        viewDogsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage_Admin.this, ViewDogs.class);
                startActivity(intent);
            }
        });
    }
}
