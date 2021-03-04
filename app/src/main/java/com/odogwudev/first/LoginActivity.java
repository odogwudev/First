package com.odogwudev.first;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button btnSignUp, btnLogin;
    ImageView ivLogo;
    TextView txtLogo, txtSlogan;
    TextInputLayout tilUsername, tilPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);
        ivLogo = findViewById(R.id.ivLogo);
        txtLogo = findViewById(R.id.txtLogo);
        txtSlogan = findViewById(R.id.txtSlogan);
        tilUsername = findViewById(R.id.tilUsername);
        tilPassword = findViewById(R.id.tilPassword);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);

                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(btnSignUp, "signup_button_tran");
                pairs[1] = new Pair<View, String>(btnLogin, "go_button_tran");
                pairs[2] = new Pair<View, String>(ivLogo, "logo_image");
                pairs[3] = new Pair<View, String>(txtLogo, "logo_text");
                pairs[4] = new Pair<View, String>(txtSlogan, "logo_desc");
                pairs[5] = new Pair<View, String>(tilUsername, "username_tran");
                pairs[6] = new Pair<View, String>(tilPassword, "password_tran");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });
    }
}