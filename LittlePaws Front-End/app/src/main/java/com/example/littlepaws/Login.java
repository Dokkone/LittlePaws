package com.example.littlepaws;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.littlepaws.holder.UserDataHolder;
import com.example.littlepaws.model.User;
import com.example.littlepaws.retrofit.RetrofitService;
import com.example.littlepaws.retrofit.UserApi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button loginButton, submitLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeComponents();
    }

    private void initializeComponents() {
        // Hook Edit Text Fields:
        username = findViewById(R.id.email_text);
        password = findViewById(R.id.password_text);
        loginButton = findViewById(R.id.login_button);
        submitLogin = findViewById(R.id.submitlogin);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        submitLogin.setOnClickListener(view ->
        {
            String email = username.getText().toString();
            String OnPass = password.getText().toString();

            Call<User> call = userApi.login(new User(email,OnPass));
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful())
                    {
                        User logged = response.body();

                        String role = logged.getRole().toString();

                        if(role.equals("admin"))
                        {
                            UserDataHolder.getInstance().setLoggedInUser(logged);
                            Intent intent = new Intent(Login.this, Homepage_Admin.class);
                            startActivity(intent);
                        }
                        else if(role.equals("client"))
                        {
                            UserDataHolder.getInstance().setLoggedInUser(logged);
                            Intent intent = new Intent(Login.this, UserPages.class);
                            startActivity(intent);

                        }
                        else
                        {

                            String wrong = logged.getRole().toString();
                            Toast.makeText(Login.this, wrong, Toast.LENGTH_SHORT).show();
                        }

                    }
                    else
                    {
                        Toast.makeText(Login.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(Login.this, "Save Failed!", Toast.LENGTH_SHORT).show();
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, "Error Occurred", t);
                }
            });
        });
// Working
//        submitLogin.setOnClickListener(view ->
//        {
//            String email = username.getText().toString();
//            String OnPass = password.getText().toString();
//
//            Call<ResponseBody> call = userApi.login(new User(email,OnPass));
//            call.enqueue(new Callback<ResponseBody>() {
//                @Override
//                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                    if (response.isSuccessful())
//                    {
//                        Intent intent = new Intent(Login.this, UserPages.class);
//                        startActivity(intent);
//                    }
//                    else
//                    {
//                        Toast.makeText(Login.this, "Save Failed!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<ResponseBody> call, Throwable t) {
//                    Toast.makeText(Login.this, "Save Failed!", Toast.LENGTH_SHORT).show();
//                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, "Error Occurred", t);
//
//                }
//            });
//        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click, for example, start the registration activity
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
        //@mymail.mapua.edu.ph for admin; other emails for users

//        //USERS
//        submitLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Handle button click, for example, start the registration activity
//                Intent intent = new Intent(Login.this, UserPages.class);
//                startActivity(intent);
//            }
//        });
//
//        //ADMIN
//        submitLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Handle button click, for example, start the registration activity
//                Intent intent = new Intent(Login.this, Homepage_Admin.class);
//                startActivity(intent);
//            }
//        });
    }
}