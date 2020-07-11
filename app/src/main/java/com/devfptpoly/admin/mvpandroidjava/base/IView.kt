package com.devfptpoly.admin.mvpandroidjava.base

interface IView {
    fun hideLoading()
    fun showLoading()
    fun loadError(e: Throwable)
    fun loadError(msg: String)
}