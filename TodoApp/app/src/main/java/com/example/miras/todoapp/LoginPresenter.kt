package com.example.miras.todoapp

import com.example.miras.todoapp.core.BaseListener
import com.example.miras.todoapp.core.BasePresenter

class LoginPresenter(private val repository: LoginContract.Repository)
    : BasePresenter<LoginContract.View>(),
        LoginContract.Presenter,
        BaseListener.onLoginFinishedListener {
    override fun viewIsReady() {

    }

    override fun destroy() {

    }

    override fun login(email: String, password: String) {
        repository.login(email, password, this)
    }

    override fun onLoginSuccess() {
        getView()?.onSuccess()
    }

    override fun onLoginError(message: String) {
        getView()?.onError(message)
    }


}