package com.example.littlepaws;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.littlepaws.holder.PetDataHolder;
import com.example.littlepaws.model.Pet;

public class UpdateDogs extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedog);

//        Pet pet = PetDataHolder.getInstance().getSavedPet();
//
//        EditText et = findViewById(R.id.dogNameEditText);
//
//        et.setText(pet.getName().toString());
//
//        ImageView backButton = findViewById(R.id.backButton);
//        Button addDogBtn = findViewById(R.id.addDogBtn);
//
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(UpdateDogs.this, ViewDogs.class);
//                startActivity(intent);
//            }
//        });
//
//        addDogBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(UpdateDogs.this, ViewDogs.class);
//                startActivity(intent);
//            }
//        });
    }
}
