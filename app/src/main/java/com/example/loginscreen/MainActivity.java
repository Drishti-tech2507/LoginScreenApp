package com.example.loginscreen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                // Username validation (exactly 6 characters)
                if (user.length() != 6) {
                    Toast.makeText(MainActivity.this,
                            "Username must be exactly 6 characters",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Password validation (8 chars, 1 upper, 1 lower, 1 special)
                if (!isValidPassword(pass)) {
                    Toast.makeText(MainActivity.this,
                            "Password must be 8 characters with 1 uppercase, 1 lowercase & 1 special character",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                // If all conditions pass
                Toast.makeText(MainActivity.this,
                        "Login Successful",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Password validation method
    private boolean isValidPassword(String password) {
        if (password.length() != 8)
            return false;

        String passwordPattern =
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8}$";

        return password.matches(passwordPattern);
    }
}