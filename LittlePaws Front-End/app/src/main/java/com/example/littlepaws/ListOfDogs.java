package com.example.littlepaws;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.littlepaws.holder.PetDataHolder;
import com.example.littlepaws.model.Pet;
import com.example.littlepaws.retrofit.RetrofitService;
import com.example.littlepaws.retrofit.UserApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link ListOfDogs#newInstance} factory method to
// * create an instance of this fragment.
// */

public class ListOfDogs extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public ListOfDogs() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment ListOfDogs.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static ListOfDogs newInstance(String param1, String param2) {
//        ListOfDogs fragment = new ListOfDogs();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    List<Pet> allPetList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
////            mParam1 = getArguments().getString(ARG_PARAM1);
////            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//        // Inflate the layout for this fragment
//        View rootView = inflater.inflate(R.layout.fragment_list_of_dogs, container, false);
//
//        // Find adopt buttons
//        Button adoptbtn = rootView.findViewById(R.id.adoptbtn);
//        Button adoptbtn2 = rootView.findViewById(R.id.adoptbtn2);
//        Button adoptbtn3 = rootView.findViewById(R.id.adoptbtn3);
//        Button adoptbtn4 = rootView.findViewById(R.id.adoptbtn4);
//        Button adoptbtn5 = rootView.findViewById(R.id.adoptbtn5);
//        Button adoptbtn6 = rootView.findViewById(R.id.adoptbtn6);
//
//        // Set click listeners for adopt buttons
//        adoptbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start DogInformationActivity when adoptbtn is clicked
//                startActivityForDogInformation();
//            }
//        });
//
//        adoptbtn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start DogInformationActivity when adoptbtn2 is clicked
//                startActivityForDogInformation();
//            }
//        });
//
//        adoptbtn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start DogInformationActivity when adoptbtn3 is clicked
//                startActivityForDogInformation();
//            }
//        });
//
//        adoptbtn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start DogInformationActivity when adoptbtn4 is clicked
//                startActivityForDogInformation();
//            }
//        });
//
//        adoptbtn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start DogInformationActivity when adoptbtn5 is clicked
//                startActivityForDogInformation();
//            }
//        });
//
//        adoptbtn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start DogInformationActivity when adoptbtn6 is clicked
//                startActivityForDogInformation();
//            }
//        });
//
//        return rootView;

        View view = inflater.inflate(R.layout.fragment_list_of_dogs, container, false);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        Call<List<Pet>> call = userApi.getAllPets();
        call.enqueue(new Callback<List<Pet>>() {
            @Override
            public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {

                if (response.isSuccessful()) {
                    List<Pet> petList = response.body();
                    allPetList.addAll(petList);

                    for (int i = 0; i < allPetList.size(); i++) {
                        Pet pet = allPetList.get(i);
                        String name = pet.getName();
                        String breed = pet.getBreed();
                        String location = pet.getLocation();
                        String gender = pet.getGender();

                        if ( i == 0 )
                        {
                            TextView txtName = view.findViewById(R.id.namedog1);
                            txtName.setText(name);

                            Button btn = view.findViewById(R.id.adoptbtn);

                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    PetDataHolder.getInstance().setSavedPet(pet);
                                    Intent intent = new Intent(getActivity(), DogInformation.class);
                                    startActivity(intent);
                                }
                            });
                        }
                        else if ( i == 1 )
                        {
                            TextView txtName = view.findViewById(R.id.namedog);
                            txtName.setText(name);

                            Button btn = view.findViewById(R.id.adoptbtn2);

                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    PetDataHolder.getInstance().setSavedPet(pet);
                                    Intent intent = new Intent(getActivity(), DogInformation.class);
                                    startActivity(intent);
                                }
                            });
                        }
                        else if ( i == 2 )
                        {
                            TextView txtName = view.findViewById(R.id.namedog4);
                            txtName.setText(name);

                            Button btn = view.findViewById(R.id.adoptbtn4);

                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    PetDataHolder.getInstance().setSavedPet(pet);
                                    Intent intent = new Intent(getActivity(), DogInformation.class);
                                    startActivity(intent);
                                }
                            });
                        }
                        else if ( i == 3 )
                        {
                            TextView txtName = view.findViewById(R.id.namedog3);
                            txtName.setText(name);

                            Button btn = view.findViewById(R.id.adoptbtn3);

                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    PetDataHolder.getInstance().setSavedPet(pet);
                                    Intent intent = new Intent(getActivity(), DogInformation.class);
                                    startActivity(intent);
                                }
                            });
                        }
                        else if ( i == 4 )
                        {
                            TextView txtName = view.findViewById(R.id.namedog6);
                            txtName.setText(name);

                            Button btn = view.findViewById(R.id.adoptbtn6);

                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    PetDataHolder.getInstance().setSavedPet(pet);
                                    Intent intent = new Intent(getActivity(), DogInformation.class);
                                    startActivity(intent);
                                }
                            });
                        }
                        else if ( i == 5 )
                        {
                            TextView txtName = view.findViewById(R.id.namedog5);
                            txtName.setText(name);

                            Button btn = view.findViewById(R.id.adoptbtn5);

                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    PetDataHolder.getInstance().setSavedPet(pet);
                                    Intent intent = new Intent(getActivity(), DogInformation.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    }
                }

            }
            @Override
            public void onFailure(Call<List<Pet>> call, Throwable t) {
                Toast.makeText(getActivity(), "Save Failed!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

//    // Method to start DogInformationActivity
//    private void startActivityForDogInformation() {
//        Intent intent = new Intent(getActivity(), DogInformation.class);
//        startActivity(intent);
//    }
}