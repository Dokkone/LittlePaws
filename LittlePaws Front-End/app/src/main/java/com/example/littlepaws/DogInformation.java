package com.example.littlepaws;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.littlepaws.holder.PetDataHolder;
import com.example.littlepaws.model.Pet;

public class DogInformation extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doginformation);

        Pet pet = PetDataHolder.getInstance().getSavedPet();

        TextView name = findViewById(R.id.nameofdogtext);
        TextView breed = findViewById(R.id.Breedofdogtext);
        TextView gender = findViewById(R.id.genderofdogtext);
        TextView location = findViewById(R.id.locationofdogtext);
        TextView description = findViewById(R.id.descriptionofdogtext);


        name.setText(pet.getName().toString());
        breed.setText(pet.getBreed().toString());
        gender.setText(pet.getGender().toString());
        location.setText(pet.getLocation().toString());
        description.setText(pet.getDescription().toString());

        ImageView backButton2 = findViewById(R.id.backButton2);
        Button adoptdogbtn = findViewById(R.id.adoptdogbtn);

        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DogInformation.this, ListOfDogs.class);
                startActivity(intent);
            }
        });

        adoptdogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DogInformation.this, Inform.class);
                startActivity(intent);
            }
        });
    }
}
