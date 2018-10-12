package com.example.miras.todoapp

import com.example.miras.todoapp.core.BaseListener
import com.example.miras.todoapp.core.IPresenter
import com.example.miras.todoapp.core.IView

interface TodoListContract {

    interface View : IView<Presenter> {
        fun setAdapter (items : ArrayList<Todo>)
        fun showMessage (message : String)
    }

    interface Presenter : IPresenter<View> {
        fun getDoneTodos ()
        fun getUndoneTodos ()
    }

    interface Repository {
        fun getDoneTodos (listener : BaseListener.onReadFinishedListener)
        fun getUndoneTodos (listener : BaseListener.onReadFinishedListener)
    }

}