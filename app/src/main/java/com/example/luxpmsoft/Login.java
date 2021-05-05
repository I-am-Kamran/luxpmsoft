package com.example.luxpmsoft;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextInputEditText textEmail;
    TextInputEditText textPassword;
    TextInputLayout textInputEmail;
    TextInputLayout textInputPassword;
    Button login;
    ConstraintLayout layoutLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);

        textInputEmail = findViewById(R.id.textFieldEmail);
        textInputPassword = findViewById(R.id.textFieldPassword);

        layoutLogin = findViewById(R.id.layoutLogin);
        login = findViewById(R.id.buttonLogin);

        login.setOnClickListener(v -> {
            if (validation()) {
                loginScreen();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        textEmail.setText("");
        textPassword.setText("");
    }

    private void loginScreen() {
        startActivity(new Intent(Login.this, WelcomeScreen.class));
    }

    private boolean validation() {

        if (!textEmail.getText().toString().trim().equals("test@luxpmsoft.com")) {
            Snackbar.make(layoutLogin, "Invalid Email", Snackbar.LENGTH_SHORT)
                    .show();

            return false;
        }

        if (!textPassword.getText().toString().trim().equals("test1234")) {
            Snackbar.make(layoutLogin, "Invalid Password", Snackbar.LENGTH_SHORT)
                    .show();
            return false;
        }

        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}