package com.devfptpoly.admin.mvpandroidjava.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
        didInitialize()
    }

    abstract fun initialize()
    abstract fun didInitialize()
}