package com.example.littlepaws;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.littlepaws.holder.PetDataHolder;
import com.example.littlepaws.model.Pet;
import com.example.littlepaws.retrofit.RetrofitService;
import com.example.littlepaws.retrofit.UserApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewDogs extends AppCompatActivity {

    List<Pet> allPetList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdogs);

        ImageView backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewDogs.this, Homepage_Admin.class);
                startActivity(intent);
            }
        });

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        Call<List<Pet>> call = userApi.getAllPets();
        call.enqueue(new Callback<List<Pet>>() {
            @Override
            public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {

                if (response.isSuccessful())
                {
                    List<Pet> petList = response.body();
                        allPetList.addAll(petList);

                        for(int i = 0; i < allPetList.size(); i++)
                        {
                            Pet pet = allPetList.get(i);
                            int id = pet.getId();
                            String name = pet.getName();
                            String breed = pet.getBreed();
                            String location = pet.getLocation();
                            String gender = pet.getGender();

                            if (i == 0)
                            {
                                TextView txtName = findViewById(R.id.nameofdog);
                                txtName.setText(name);
                                TextView txtBreed = findViewById(R.id.breedofdog);
                                txtBreed.setText(breed);
                                TextView txtLocation = findViewById(R.id.locationofdog);
                                txtLocation.setText(location);
                                TextView txtGender = findViewById(R.id.genderofdog);
                                txtGender.setText(gender);

                                ImageView updateBtn = findViewById(R.id.updatebtn);

                                updateBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        PetDataHolder.getInstance().setSavedPet(pet);
                                        Intent intent = new Intent(ViewDogs.this, DogInformation.class);
                                        startActivity(intent);
                                    }
                                });

                                ImageView delBtn = findViewById(R.id.deletebtn);

                                delBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        int petIdToDelete = id;
                                        Call<Void> call = userApi.deletePet(petIdToDelete);
                                        call.enqueue(new Callback<Void>() {
                                            @Override
                                            public void onResponse(Call<Void> call, Response<Void> response) {
                                                if(response.isSuccessful())
                                                {
                                                    Toast.makeText(ViewDogs.this, "Dog Deleted!", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(ViewDogs.this, ViewDogs.class);
                                                    startActivity(intent);
                                                }
                                                else
                                                {
                                                    Toast.makeText(ViewDogs.this, "Delete Error!", Toast.LENGTH_SHORT).show();
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<Void> call, Throwable t) {
                                                Toast.makeText(ViewDogs.this, "Request Error!", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                            }
                            else if (i == 1)
                            {
                                TextView txtName = findViewById(R.id.nameofdog2);
                                txtName.setText(name);
                                TextView txtBreed = findViewById(R.id.breedofdog2);
                                txtBreed.setText(breed);
                                TextView txtLocation = findViewById(R.id.locationofdog2);
                                txtLocation.setText(location);
                                TextView txtGender = findViewById(R.id.genderofdog2);
                                txtGender.setText(gender);

                                ImageView updateBtn = findViewById(R.id.updatebtn2);

                                updateBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        PetDataHolder.getInstance().setSavedPet(pet);
                                        Intent intent = new Intent(ViewDogs.this, DogInformation.class);
                                        startActivity(intent);
                                    }
                                });

                                ImageView delBtn = findViewById(R.id.deletebtn2);

                                delBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        int petIdToDelete = id;
                                        Call<Void> call = userApi.deletePet(petIdToDelete);
                                        call.enqueue(new Callback<Void>() {
                                            @Override
                                            public void onResponse(Call<Void> call, Response<Void> response) {
                                                if(response.isSuccessful())
                                                {
                                                    Toast.makeText(ViewDogs.this, "Dog Deleted!", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(ViewDogs.this, ViewDogs.class);
                                                    startActivity(intent);
                                                }
                                                else
                                                {
                                                    Toast.makeText(ViewDogs.this, "Delete Error!", Toast.LENGTH_SHORT).show();
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<Void> call, Throwable t) {
                                                Toast.makeText(ViewDogs.this, "Request Error!", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                            }
                            else if (i == 2)
                            {
                                TextView txtName = findViewById(R.id.nameofdog3);
                                txtName.setText(name);
                                TextView txtBreed = findViewById(R.id.breedofdog3);
                                txtBreed.setText(breed);
                                TextView txtLocation = findViewById(R.id.locationofdog3);
                                txtLocation.setText(location);
                                TextView txtGender = findViewById(R.id.genderofdog3);
                                txtGender.setText(gender);

                                ImageView updateBtn = findViewById(R.id.updatebtn3);

                                updateBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        PetDataHolder.getInstance().setSavedPet(pet);
                                        Intent intent = new Intent(ViewDogs.this, DogInformation.class);
                                        startActivity(intent);
                                    }
                                });

                                ImageView delBtn = findViewById(R.id.deletebtn3);

                                delBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        int petIdToDelete = id;
                                        Call<Void> call = userApi.deletePet(petIdToDelete);
                                        call.enqueue(new Callback<Void>() {
                                            @Override
                                            public void onResponse(Call<Void> call, Response<Void> response) {
                                                if(response.isSuccessful())
                                                {
                                                    Toast.makeText(ViewDogs.this, "Dog Deleted!", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(ViewDogs.this, ViewDogs.class);
                                                    startActivity(intent);
                                                }
                                                else
                                                {
                                                    Toast.makeText(ViewDogs.this, "Delete Error!", Toast.LENGTH_SHORT).show();
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<Void> call, Throwable t) {
                                                Toast.makeText(ViewDogs.this, "Request Error!", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                            }
                            else if (i == 3)
                            {
                                TextView txtName = findViewById(R.id.nameofdog4);
                                txtName.setText(name);
                                TextView txtBreed = findViewById(R.id.breedofdog4);
                                txtBreed.setText(breed);
                                TextView txtLocation = findViewById(R.id.locationofdog4);
                                txtLocation.setText(location);
                                TextView txtGender = findViewById(R.id.genderofdog4);
                                txtGender.setText(gender);

                                ImageView updateBtn = findViewById(R.id.updatebtn4);

                                updateBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        PetDataHolder.getInstance().setSavedPet(pet);
                                        Intent intent = new Intent(ViewDogs.this, DogInformation.class);
                                        startActivity(intent);
                                    }
                                });

                                ImageView delBtn = findViewById(R.id.deletebtn4);

                                delBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        int petIdToDelete = id;
                                        Call<Void> call = userApi.deletePet(petIdToDelete);
                                        call.enqueue(new Callback<Void>() {
                                            @Override
                                            public void onResponse(Call<Void> call, Response<Void> response) {
                                                if(response.isSuccessful())
                                                {
                                                    Toast.makeText(ViewDogs.this, "Dog Deleted!", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(ViewDogs.this, ViewDogs.class);
                                                    startActivity(intent);
                                                }
                                                else
                                                {
                                                    Toast.makeText(ViewDogs.this, "Delete Error!", Toast.LENGTH_SHORT).show();
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<Void> call, Throwable t) {
                                                Toast.makeText(ViewDogs.this, "Request Error!", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                            }
                            else if (i == 4)
                            {
                                TextView txtName = findViewById(R.id.nameofdog5);
                                txtName.setText(name);
                                TextView txtBreed = findViewById(R.id.breedofdog5);
                                txtBreed.setText(breed);
                                TextView txtLocation = findViewById(R.id.locationofdog5);
                                txtLocation.setText(location);
                                TextView txtGender = findViewById(R.id.genderofdog5);
                                txtGender.setText(gender);

                                ImageView updateBtn = findViewById(R.id.updatebtn5);

                                updateBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        PetDataHolder.getInstance().setSavedPet(pet);
                                        Intent intent = new Intent(ViewDogs.this, DogInformation.class);
                                        startActivity(intent);
                                    }
                                });

                                ImageView delBtn = findViewById(R.id.deletebtn5);

                                delBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        int petIdToDelete = id;
                                        Call<Void> call = userApi.deletePet(petIdToDelete);
                                        call.enqueue(new Callback<Void>() {
                                            @Override
                                            public void onResponse(Call<Void> call, Response<Void> response) {
                                                if(response.isSuccessful())
                                                {
                                                    Toast.makeText(ViewDogs.this, "Dog Deleted!", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(ViewDogs.this, ViewDogs.class);
                                                    startActivity(intent);
                                                }
                                                else
                                                {
                                                    Toast.makeText(ViewDogs.this, "Delete Error!", Toast.LENGTH_SHORT).show();
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<Void> call, Throwable t) {
                                                Toast.makeText(ViewDogs.this, "Request Error!", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                            }
                            else if (i == 5)
                            {
                                TextView txtName = findViewById(R.id.nameofdog6);
                                txtName.setText(name);
                                TextView txtBreed = findViewById(R.id.breedofdog6);
                                txtBreed.setText(breed);
                                TextView txtLocation = findViewById(R.id.locationofdog6);
                                txtLocation.setText(location);
                                TextView txtGender = findViewById(R.id.genderofdog6);
                                txtGender.setText(gender);

                                ImageView updateBtn = findViewById(R.id.updatebtn6);

                                updateBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        PetDataHolder.getInstance().setSavedPet(pet);
                                        Intent intent = new Intent(ViewDogs.this, DogInformation.class);
                                        startActivity(intent);
                                    }
                                });

                                ImageView delBtn = findViewById(R.id.deletebtn6);

                                delBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        int petIdToDelete = id;
                                        Call<Void> call = userApi.deletePet(petIdToDelete);
                                        call.enqueue(new Callback<Void>() {
                                            @Override
                                            public void onResponse(Call<Void> call, Response<Void> response) {
                                                if(response.isSuccessful())
                                                {
                                                    Toast.makeText(ViewDogs.this, "Dog Deleted!", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(ViewDogs.this, ViewDogs.class);
                                                    startActivity(intent);
                                                }
                                                else
                                                {
                                                    Toast.makeText(ViewDogs.this, "Delete Error!", Toast.LENGTH_SHORT).show();
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<Void> call, Throwable t) {
                                                Toast.makeText(ViewDogs.this, "Request Error!", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                            }
                        }

//                        Pet firstPet = allPetList.get(0);
//                        String firstPetname = firstPet.getName();
//
//                        TextView txtName = findViewById(R.id.nameofdog);
//                        txtName.setText(firstPetname);
//
//                        Pet secondPet = allPetList.get(1);
//                        String secondPetname = secondPet.getName();
//
//                        TextView txtName2 = findViewById(R.id.nameofdog2);
//                        txtName2.setText(secondPetname);


//                        int size = allPetList.size();
//
//                        for (int i = 0; i <= size; i++)
//                        {
//                            pet = new Pet[]{allPetList.get(i)};
//
//
//                            TextView txtName = findViewById(R.id.nameofdog);
//                            txtName.setText(pet[0].getName().toString());
//
//                        }

//                        String name1 = pet[0].getName().toString();
//                        String name2 = pet[1].getName().toString();
//
//
//                        TextView txtName2 = findViewById(R.id.nameofdog2);
//                        txtName2.setText(name2);

//                    for (Pet pet : petList)
//                    {
//                        int id = pet.getId();
//
////                        for
//                        String name = pet.getName();
//                        String breed = pet.getBreed();
//                        String location = pet.getLocation();
//                        String gender = pet.getGender();
//
//                        TextView txtName = findViewById(R.id.nameofdog);
//                        txtName.setText(name);
//                        TextView txtName2 = findViewById(R.id.nameofdog2);
//                        txtName2.setText(name);
//
//                    }
                }

            }

            @Override
            public void onFailure(Call<List<Pet>> call, Throwable t) {
                Toast.makeText(ViewDogs.this, "Save Failed!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
