package com.example.littlepaws;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.littlepaws.model.Message;
import com.example.littlepaws.retrofit.RetrofitService;
import com.example.littlepaws.retrofit.UserApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link Homepage_User#newInstance} factory method to
// * create an instance of this fragment.
// */
public class Homepage_User extends Fragment {

    EditText textName, textSubject, textMessage;
    Button submit;

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public Homepage_User() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment HomeFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static Homepage_User newInstance(String param1, String param2) {
//        Homepage_User fragment = new Homepage_User();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Find the ImageView in the inflated layout
        ImageView gif_image = rootView.findViewById(R.id.gif_image);

        // Construct the URL for the GIF from drawable resource
        String gifUrl = "android.resource://" + requireActivity().getPackageName() + "/drawable/little_paws_promotional_video";

        // Load and display the GIF using Glide
        Glide.with(this)
                .load(gifUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(gif_image);

        textName = rootView.findViewById(R.id.editTextName);
        textSubject = rootView.findViewById(R.id.editTextSubject);
        textMessage = rootView.findViewById(R.id.editTextMessage);
        submit = rootView.findViewById(R.id.buttonSubmit);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        submit.setOnClickListener(view -> {

            String name = String.valueOf(textName.getText());
            String subject = String.valueOf(textSubject.getText());
            String message = String.valueOf(textMessage.getText());

            Message messages = new Message();

            messages.setName(name);
            messages.setSubject(subject);
            messages.setMessage(message);

            processFormFields();

            int choice = processFormFields();

            if (choice == 1)
            {
                userApi.save(messages)
                        .enqueue(new Callback<Message>() {
                            @Override
                            public void onResponse(Call<Message> call, Response<Message> response) {

                                textName.setText(null);
                                textSubject.setText(null);
                                textMessage.setText(null);

                                Toast.makeText(getActivity(), "Message Sent!", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Message> call, Throwable t) {

                            }
                        });
            }
            else
            {
                Toast.makeText(getActivity(), "Message Failed!", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    public int processFormFields() {   // Check For Errors:
        if (!validateName() || !validateSubject() || !validateMessage()) {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    public boolean validateName()
    {
        String name = textName.getText().toString();

        if(name.isEmpty())
        {
            textName.setError("Name cannot be empty!");
            return false;
        } else {
            textName.setError(null);
            return true;
        }
    }

    public boolean validateSubject()
    {
        String subject = textSubject.getText().toString();

        if(subject.isEmpty())
        {
            textSubject.setError("Subject cannot be empty!");
            return false;
        } else {
            textSubject.setError(null);
            return true;
        }
    }

    public boolean validateMessage()
    {
        String message = textMessage.getText().toString();

        if(message.isEmpty())
        {
            textMessage.setError("Message cannot be empty!");
            return false;
        } else {
            textMessage.setError(null);
            return true;
        }
    }
}