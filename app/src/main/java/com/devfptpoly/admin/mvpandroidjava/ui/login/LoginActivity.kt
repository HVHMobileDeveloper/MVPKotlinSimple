package com.devfptpoly.admin.mvpandroidjava.ui.login

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.devfptpoly.admin.mvpandroidjava.R
import com.devfptpoly.admin.mvpandroidjava.base.BaseActivity
import com.devfptpoly.admin.mvpandroidjava.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Functional
 * Activity
 *
 * 2 interface: View, PresenterImp
 *
 */

class LoginActivity : BaseActivity(), LoginView {

    companion object {
        val TAG: String = "MainActivity"
    }

    private lateinit var loginImpl: LoginPresenterImpl

    override fun setLayout() {
        val mainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
            )
    }

    override fun init(savedInstanceState: Bundle?) {
        loginImpl = LoginPresenterImpl(this)
        btnLogin.setOnClickListener { loginSubmit() }
    }

    override fun onStartScreen() {
        TODO("Not yet implemented")
    }

    override fun stopScreen() {
        TODO("Not yet implemented")
    }

    private fun loginSubmit() {
        val userName = edtUserName.text.toString()
        val password = edtPassword.text.toString()
        val modelHandleLogin = ModelLogin(userName = userName, password = password)
        loginImpl.handleValidateForm(modelHandleLogin)
    }

    override fun navigateToHome() {
        Log.d(TAG, "navigateToHome: ${0}")
    }

    override fun onBackPress() {
        Log.e(TAG, "onBackPress: ")
    }

    override fun onPasswordError() {
        Log.e(TAG, "onPasswordError: ")
    }


}