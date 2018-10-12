package com.example.miras.todoapp

import com.example.miras.todoapp.core.BaseListener
import com.example.miras.todoapp.core.IPresenter
import com.example.miras.todoapp.core.IView
import java.security.MessageDigest

interface LoginContract {

    interface View : IView<Presenter> {
        fun onSuccess ()
        fun onError (message : String)
    }

    interface Presenter : IPresenter<View> {
        fun login (email : String, password : String )
    }

    interface Repository {
        fun login (email: String, password: String, listener: BaseListener.onLoginFinishedListener)
    }
}