package com.dicoding.mpvlatihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dicoding.mpvlatihan.Presenter.LoginPresenter;
import com.dicoding.mpvlatihan.Presenter.iLoginPresenter;
import com.dicoding.mpvlatihan.View.ActivitySuccess;
import com.dicoding.mpvlatihan.View.iLoginView;

public class MainActivity extends AppCompatActivity implements iLoginView {

   EditText edtEmail, edtPassword;
   Button btnLogin;

   iLoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(v -> loginPresenter.onLogin(edtEmail.getText().toString(), edtPassword.toString()));
    }

    @Override
    public void onLoginSucces(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ActivitySuccess.class);
        startActivity(intent);
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}