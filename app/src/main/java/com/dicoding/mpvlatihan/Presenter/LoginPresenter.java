package com.dicoding.mpvlatihan.Presenter;

import com.dicoding.mpvlatihan.Model.User;
import com.dicoding.mpvlatihan.View.iLoginView;

public class LoginPresenter implements iLoginPresenter{

    iLoginView loginView;

    public LoginPresenter(iLoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int isLoginCode = user.isValidData();

        if (isLoginCode == 0)
            loginView.onLoginError("You must enter your email");
        else if (isLoginCode == 1)
            loginView.onLoginError("You must enter valid email");
        else if (isLoginCode == 2)
            loginView.onLoginError("Password lenght must be greather than 6");
        else loginView.onLoginSucces("Login Success");

    }
}
