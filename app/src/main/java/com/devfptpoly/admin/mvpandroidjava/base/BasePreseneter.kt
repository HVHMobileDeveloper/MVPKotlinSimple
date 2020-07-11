package com.devfptpoly.admin.mvpandroidjava.base

import androidx.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePreseneter<V>(@Volatile var view: V?) {
    companion object {
        /**
         * var compositeDisposables: CompositeDisposable
         * Every method which will be part of presenter layer will be added in it so
         * we could dispose off them once the are no more in our use
         */
        var compositeDisposable: CompositeDisposable = CompositeDisposable()
    }

    init {

    }

    protected fun view(): V? {
        return view
    }

    @CallSuper
    fun unbindView() {
        if (compositeDisposable != null) {
            compositeDisposable.clear()
            compositeDisposable.dispose()
        }
        this.view = null
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.addAll(disposable)
    }
}