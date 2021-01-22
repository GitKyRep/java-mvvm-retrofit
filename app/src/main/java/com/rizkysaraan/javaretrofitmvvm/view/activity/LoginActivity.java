package com.rizkysaraan.javaretrofitmvvm.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.rizkysaraan.javaretrofitmvvm.R;
import com.rizkysaraan.javaretrofitmvvm.databinding.ActivityLoginBinding;
import com.rizkysaraan.javaretrofitmvvm.utility.AlertUtil;
import com.rizkysaraan.javaretrofitmvvm.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding activityLoginBinding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBinding.getRoot());

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        activityLoginBinding.btnSignin.setOnClickListener(v -> {
            signIn();
        });
    }

    private void signIn() {
        String nip = activityLoginBinding.edtUserNip.getText().toString();
        String password = activityLoginBinding.edtUserPass.getText().toString();
        String regId = "123";
        loginViewModel.postLogin(nip, password, regId).observe(this, data -> {
            if (data.getSuccess() == 1) {
                Intent mainMenu = new Intent(LoginActivity.this, MainMenuActivity.class);
                startActivity(mainMenu);
            } else {
                AlertUtil.messageDialog(this, getString(R.string.information), data.getMessage(), getString(R.string.close), null, null, null);
            }
        });
    }
}