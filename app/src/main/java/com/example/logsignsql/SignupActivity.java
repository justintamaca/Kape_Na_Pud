package com.example.logsignsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.logsignsql.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = binding.fullname.getText().toString();
                String email = binding.email.getText().toString();
                String password = binding.password.getText().toString();
                String confirmpassword = binding.confirpassword.getText().toString();

                if (email.isEmpty() || fullname.isEmpty() || password.isEmpty() || confirmpassword.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirmpassword)) {
                        // Check if the email already exists
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);

                        if (!checkUserEmail) {
                            // Email doesn't exist, insert the new user
                            Boolean insert = databaseHelper.insertData(email, fullname, password);

                            if (insert) {
                                Toast.makeText(SignupActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                                // Navigate to LoginActivity after successful signup
                                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignupActivity.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // User already exists, display a message
                            Toast.makeText(SignupActivity.this, "User already exists, Please Login", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Passwords don't match, display an error
                        Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.signinredirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to LoginActivity when the user clicks "Sign In"
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
