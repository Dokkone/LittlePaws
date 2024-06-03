package com.example.littlepaws;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.littlepaws.helpers.StringHelper;
import com.example.littlepaws.model.User;
import com.example.littlepaws.retrofit.RetrofitService;
import com.example.littlepaws.retrofit.UserApi;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    EditText first_name, last_name, role, email, password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeComponents();
    }

    private void initializeComponents() {
        // Hook Edit Text Fields:
        first_name = findViewById(R.id.firstname_text);
        last_name = findViewById(R.id.lastname_text);
        role = findViewById(R.id.email_text2);
        email = findViewById(R.id.email_text);
        password = findViewById(R.id.password_text);
        submit = findViewById(R.id.submitlogin);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        submit.setOnClickListener(view -> {
            String firstname = String.valueOf(first_name.getText());
            String lastname = String.valueOf(last_name.getText());
            String onEmail = String.valueOf(email.getText());
            String onPass = String.valueOf(password.getText());
            String onRole = String.valueOf(role.getText());

            User user = new User();
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(onEmail);
            user.setPassword(onPass);
            user.setRole(onRole);

            processFormFields();

            int choice = processFormFields();

            if(choice == 1)
            {
                userApi.save(user)
                        .enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                Toast.makeText(Register.this, "Save Successful!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this, Login.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                Toast.makeText(Register.this, "Save Failed!", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, "Error Occurred", t);
                            }
                        });
            }
            else
            {
                Toast.makeText(Register.this, "Save Failed!", Toast.LENGTH_SHORT).show();
            }

        });
    }
    // End of On Create Method


    public int processFormFields() {   // Check For Errors:
        if (!validateFirstName() || !validateLastName() || !validateRole() || !validateEmail() || !validatePassword()) {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    public boolean validateFirstName() {
        String firstname = first_name.getText().toString();

        // Check if First Name Is Empty
        if (firstname.isEmpty()) {
            first_name.setError("First Name cannot be empty!");
            return false;
        } else {
            first_name.setError(null);
            return true;
        }// Check if First Name Is Empty
    }
    // End of Validate First Name Field

    public boolean validateLastName() {
        String lastname = last_name.getText().toString();

        // Check if Last Name Is Empty
        if (lastname.isEmpty()) {
            last_name.setError("Last Name cannot be empty!");
            return false;
        } else {
            last_name.setError(null);
            return true;
        }// Check if Last Name Is Empty
    }
    // End of Validate Last Name Field

    public boolean validateRole() {
        String valRole = role.getText().toString();

        // Check if Role Is Empty
        if (valRole.isEmpty()) {
            role.setError("Role cannot be empty!");
            return false;
        } else {
            role.setError(null);
            return true;
        }// Check if Role Is Empty
    }
    // End of Validate Role Field

    public boolean validateEmail() {
        String valEmail = email.getText().toString();

        // Check if Email Is Empty
        if (valEmail.isEmpty()) {
            email.setError("Email cannot be empty!");
            return false;
        } else if (!StringHelper.regexEmailValidationPattern(valEmail)) {
            email.setError("Please Enter Valid Email Address");
            return false;
        } else {
            email.setError(null);
            return true;
        }// Check if Email Is Empty
    }
    // End of Validate Email Field

    public boolean validatePassword() {
        String valPass = password.getText().toString();

        // Check if Password Is Empty
        if (valPass.isEmpty()) {
            password.setError("Password cannot be empty!");
            return false;
        } else {
            password.setError(null);
            return true;
        }// Check if Password Is Empty
    }
}
//    // End of Validate Password Field
// End of Register Activity