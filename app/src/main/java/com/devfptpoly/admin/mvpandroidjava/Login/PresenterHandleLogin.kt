package com.devfptpoly.admin.mvpandroidjava.Login

class PresenterHandleLogin(
    var viewHandleLogin: ViewHandleLogin
) : PresenterImpHandleLogin {

    override fun handleValidateForm(modelHandleLogin: ModelHandleLogin) {
        var isValid: Boolean = (modelHandleLogin.userName.isNotEmpty()) && (modelHandleLogin.password.isNotEmpty())
        if (isValid) {
            viewHandleLogin.loginSuccessfully()
        } else {
            viewHandleLogin.loginErrorOccurred()
        }
    }
}