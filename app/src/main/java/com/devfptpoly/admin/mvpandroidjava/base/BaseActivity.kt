package com.devfptpoly.admin.mvpandroidjava.base

import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.devfptpoly.admin.mvpandroidjava.R

abstract class BaseActivity : AppCompatActivity(), IView {

    /**
     * A dialog showing a progress indicator and optional text message or view.
     */
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayout()
        initializeProgressDialog()
        init(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        onStartScreen()
    }

    private fun initializeProgressDialog() {
        if (progressDialog != null) {
            progressDialog = ProgressDialog(this)
            progressDialog!!.isIndeterminate = true
            progressDialog!!.setCancelable(false)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        System.gc()
        System.runFinalization()
        dismissProgress()
        progressDialog = null
    }

    abstract fun setLayout()
    abstract fun init(savedInstanceState: Bundle?)
    abstract fun onStartScreen()
    abstract fun stopScreen()

    fun showProgress(
        msgResId: Int,
        keyListener: DialogInterface.OnKeyListener?
    ) {
        if (isFinishing) return

        if (progressDialog!!.isShowing) return

        if (msgResId != 0) {
            progressDialog!!.setMessage(resources.getString(msgResId))
        }

        if (keyListener != null) {
            progressDialog?.setOnKeyListener(keyListener)
        } else {
            progressDialog?.setCancelable(false)
        }

        progressDialog?.show()
    }

    /**
     * param is cancel
     */
    fun setCancelAbleProgress() {
        if (progressDialog != null) {
            progressDialog?.setCancelable(true)
        }
    }

    /**
     * cancel progress dialog
     */
    fun dismissProgress() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog?.dismiss()
        }
    }

    override fun hideLoading() {
        dismissProgress()
    }

    override fun showLoading() {
        showProgress(R.string.loading, null)
    }

    override fun loadError(e: Throwable) {
        showHttpError(e)
    }

    override fun loadError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    /*
    Improper handling in real case
     */
    protected fun showHttpError(e: Throwable) {
        loadError(e.localizedMessage)
    }

    override fun onStop() {
        super.onStop()
        stopScreen()
    }


}