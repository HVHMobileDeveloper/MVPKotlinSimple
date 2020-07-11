package com.devfptpoly.admin.mvpandroidjava.ui.login

class LoginPresenterImpl(
    var loginView: LoginView
) : LoginPresenter {

    override fun handleValidateForm(modelLogin: ModelLogin) {
        var isValid: Boolean =
            (modelLogin.userName.isNotEmpty()) && (modelLogin.password.isNotEmpty())
        if (isValid) {
            loginView.navigateToHome()
        } else {
            loginView.onPasswordError()
        }
    }
}