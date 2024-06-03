package com.example.littlepaws;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.littlepaws.helpers.StringHelper;
import com.example.littlepaws.model.Pet;
import com.example.littlepaws.model.User;
import com.example.littlepaws.retrofit.RetrofitService;
import com.example.littlepaws.retrofit.UserApi;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDogs extends AppCompatActivity {

    EditText dogName, dogBreed, dogLocation, dogDescription;
    RadioGroup rg;
    RadioButton rb, male, female;
    String selectedValue;
    String dogGender;
    Button addDog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddogs);

        initializeComponents();

        ImageView backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddDogs.this, Homepage_Admin.class);
                startActivity(intent);
            }
        });
    }

    private void initializeComponents() {
        // Hook Edit Text Fields:
        dogName = findViewById(R.id.dogNameEditText);
        dogBreed = findViewById(R.id.dogBreedEditText);
        rg = findViewById(R.id.dogGenderRadioGroup);
        male = findViewById(R.id.radioButtonMale);
        female = findViewById(R.id.radioButtonMale);
        dogLocation = findViewById(R.id.dogLocationCityEditText);
        dogDescription = findViewById(R.id.dogDescriptionEditText);
        addDog = findViewById(R.id.addDogBtn);

        rg.setOnCheckedChangeListener((group, checkedId) -> {

            rb = findViewById(checkedId);
            selectedValue = rb.getText().toString();

            dogGender = selectedValue;
        });

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        addDog.setOnClickListener(view -> {
            String name = String.valueOf(dogName.getText());
            String breed = String.valueOf(dogBreed.getText());
            String location = String.valueOf(dogLocation.getText());
            String description = String.valueOf(dogDescription.getText());

            Pet pet = new Pet();
            pet.setName(name);
            pet.setBreed(breed);
            pet.setGender(dogGender);
            pet.setLocation(location);
            pet.setDescription(description);

            processFormFields();

            int choice = processFormFields();

            if(choice == 1)
            {
                userApi.save(pet)
                        .enqueue(new Callback<Pet>() {
                            @Override
                            public void onResponse(Call<Pet> call, Response<Pet> response) {
                                dogName.setText(null);
                                dogBreed.setText(null);
                                dogLocation.setText(null);
                                dogDescription.setText(null);
                                male.setChecked(false);
                                female.setChecked(false);
                                Toast.makeText(AddDogs.this, "Dog Added!", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Pet> call, Throwable t) {
                                Toast.makeText(AddDogs.this, "Save Failed!", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
            else
            {
                Toast.makeText(AddDogs.this, "Save Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public int processFormFields() {   // Check For Errors:
        if (!validateName() || !validateBreed() || !validateGender() || !validateLocation() || !validateDescription()) {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    public boolean validateName() {
        String name = dogName.getText().toString();

        // Check if dogName Is Empty
        if (name.isEmpty()) {
            dogName.setError("Dog Name cannot be empty!");
            return false;
        } else {
            dogName.setError(null);
            return true;
        }// Check if dogName Is Empty
    }
    // End of Validate dogName Field

    public boolean validateBreed() {
        String breed = dogBreed.getText().toString();

        // Check if dogBreed Is Empty
        if (breed.isEmpty()) {
            dogBreed.setError("Dog Breed cannot be empty!");
            return false;
        } else {
            dogBreed.setError(null);
            return true;
        }// Check if dogBreed Is Empty
    }
    // End of Validate dogBreed Field

    public boolean validateGender() {

        // Check if Gender Is Empty
        if (rg.getCheckedRadioButtonId() ==  -1) {
            Toast.makeText(AddDogs.this, "Please select Gender!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }// Check if Gender Is Empty
    }
    // End of Validate Gender Field

    public boolean validateLocation() {
        String location = dogLocation.getText().toString();

        // Check if dogLocation Is Empty
        if (location.isEmpty()) {
            dogLocation.setError("Dog Location cannot be empty!");
            return false;
        } else {
            dogLocation.setError(null);
            return true;
        }// Check if dogLocation Is Empty
    }
    // End of Validate dogLocation Field

    public boolean validateDescription() {
        String description = dogDescription.getText().toString();

        // Check if dogDescription Is Empty
        if (description.isEmpty()) {
            dogDescription.setError("Dog Description cannot be empty!");
            return false;
        } else {
            dogDescription.setError(null);
            return true;
        }// Check if dogDescription Is Empty
    }
    // End of Validate dogDescription Field

}
