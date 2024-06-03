package com.example.littlepaws;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.littlepaws.model.Adopt;
import com.example.littlepaws.model.Message;
import com.example.littlepaws.retrofit.RetrofitService;
import com.example.littlepaws.retrofit.UserApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Inform extends AppCompatActivity {

    EditText name, subject, message;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        ImageView design1 = findViewById(R.id.design1);
        ImageView design2 = findViewById(R.id.design2);
        ImageView backButton3 = findViewById(R.id.backButton3);

        backButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inform.this, DogInformation.class);
                startActivity(intent);
            }
        });

        String gifUrl = "android.resource://" + getPackageName() + "/drawable/design_up";

        // Load and display the GIF using Glide
        Glide.with(this)
                .load(gifUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(design1);

        gifUrl = "android.resource://" + getPackageName() + "/drawable/design_down";

        // Load and display the GIF using Glide
        Glide.with(this)
                .load(gifUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(design2);

        name = findViewById(R.id.nameEditText);
        subject = findViewById(R.id.subjectEditText);
        message = findViewById(R.id.editText);
        submit = findViewById(R.id.submitButton);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        submit.setOnClickListener(view -> {

            String OnName = String.valueOf(name.getText());
            String OnSubject = String.valueOf(subject.getText());
            String OnMessage = String.valueOf(message.getText());

            Adopt adopt = new Adopt();

            adopt.setName(OnName);
            adopt.setSubject(OnSubject);
            adopt.setMessage(OnMessage);

            processFormFields();

            int choice = processFormFields();

            if (choice == 1)
            {
                userApi.save(adopt)
                        .enqueue(new Callback<Adopt>() {
                            @Override
                            public void onResponse(Call<Adopt> call, Response<Adopt> response) {

                                name.setText(null);
                                subject.setText(null);
                                message.setText(null);

                                Toast.makeText(Inform.this, "Adoption Request Sent!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Inform.this, DogInformation.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(Call<Adopt> call, Throwable t) {

                            }
                        });
            }
            else
            {
                Toast.makeText(Inform.this, "Message Failed!", Toast.LENGTH_SHORT).show();
            }
        });

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
        String valName = name.getText().toString();

        if(valName.isEmpty())
        {
            name.setError("Name cannot be empty!");
            return false;
        } else {
            name.setError(null);
            return true;
        }
    }

    public boolean validateSubject()
    {
        String valSubject = subject.getText().toString();

        if(valSubject.isEmpty())
        {
            subject.setError("Subject cannot be empty!");
            return false;
        } else {
            subject.setError(null);
            return true;
        }
    }

    public boolean validateMessage()
    {
        String valMessage = message.getText().toString();

        if(valMessage.isEmpty())
        {
            message.setError("Message cannot be empty!");
            return false;
        } else {
            message.setError(null);
            return true;
        }
    }
}
