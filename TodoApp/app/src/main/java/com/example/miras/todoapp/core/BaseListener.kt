package com.example.miras.todoapp.core

import com.example.miras.todoapp.Todo


interface BaseListener {

    interface onReadFinishedListener {
        fun onReadFinished(items : ArrayList<Todo>)
    }


    interface onLoginFinishedListener {
        fun onLoginSuccess()
        fun onLoginError(message : String)
    }
}
