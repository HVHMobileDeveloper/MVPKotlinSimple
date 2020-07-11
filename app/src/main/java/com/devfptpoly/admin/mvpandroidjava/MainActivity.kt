package com.devfptpoly.admin.mvpandroidjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.devfptpoly.admin.mvpandroidjava.Login.ModelHandleLogin
import com.devfptpoly.admin.mvpandroidjava.Login.PresenterHandleLogin
import com.devfptpoly.admin.mvpandroidjava.Login.ViewHandleLogin
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

class MainActivity : BaseActivity(), ViewHandleLogin {

    companion object {
        val TAG: String = "MainActivity"
    }

    private lateinit var presenterHandleLogin: PresenterHandleLogin

    override fun initialize() {
        val mainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        presenterHandleLogin = PresenterHandleLogin(this)
    }

    override fun didInitialize() {
        btnLogin.setOnClickListener { loginSubmit() }
    }

    private fun loginSubmit() {
        val userName = edtUserName.text.toString()
        val password = edtPassword.text.toString()
        val modelHandleLogin = ModelHandleLogin(userName = userName, password = password)
        presenterHandleLogin.handleValidateForm(modelHandleLogin)
    }

    override fun loginSuccessfully() {
        Log.e(TAG, "loginSuccessfully: ")
    }

    override fun loginErrorOccurred() {
        Log.e(TAG, "loginErrorOccurred: ")
    }
}