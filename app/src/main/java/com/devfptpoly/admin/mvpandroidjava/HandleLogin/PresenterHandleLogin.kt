package com.devfptpoly.admin.mvpandroidjava.HandleLogin

class PresenterHandleLogin(
    var viewHandleLogin: ViewHandleLogin
) : PresenterImpHandleLogin {

    override fun handleValidateForm(name: String, password: String) {
        var isValid: Boolean
        isValid = (name.trim().length > 0) && (password.trim().length > 0)
        if (isValid) {
            viewHandleLogin.loginSuccessfully()
        } else {
            viewHandleLogin.loginErrorOccurred()
        }
    }
}