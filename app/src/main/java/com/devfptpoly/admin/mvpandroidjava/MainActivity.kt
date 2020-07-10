package com.devfptpoly.admin.mvpandroidjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.devfptpoly.admin.mvpandroidjava.HandleLogin.PresenterHandleLogin
import com.devfptpoly.admin.mvpandroidjava.HandleLogin.ViewHandleLogin
import com.devfptpoly.admin.mvpandroidjava.databinding.ActivityMainBinding

/**
 * Functional
 * Activity
 *
 * 2 interface: View, PresenterImp
 *
 */

class MainActivity : AppCompatActivity(), ViewHandleLogin {

    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        var presenterHandleLogin = PresenterHandleLogin(this)
        presenterHandleLogin.handleValidateForm("", "")
    }

    override fun loginSuccessfully() {
        Log.e(TAG, "loginSuccessfully: ")
    }

    override fun loginErrorOccurred() {
        Log.e(TAG, "loginErrorOccurred: ")
    }
}