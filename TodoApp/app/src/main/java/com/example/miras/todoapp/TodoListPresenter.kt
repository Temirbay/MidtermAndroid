package com.example.miras.todoapp

import android.util.Log
import com.example.miras.todoapp.core.BaseListener
import com.example.miras.todoapp.core.BasePresenter


class TodoListPresenter(private val repository: TodoListContract.Repository)
    : BasePresenter<TodoListContract.View>(),
        TodoListContract.Presenter,
        BaseListener.onReadFinishedListener {

    override fun getDoneTodos() {
        repository.getDoneTodos(this)
    }

    override fun getUndoneTodos() {
        repository.getUndoneTodos(this)
    }

    override fun onReadFinished(items: ArrayList<Todo>) {

        Log.d ("Miras", items.toString())

        getView()?.setAdapter(items)
    }

    override fun viewIsReady() { }


    override fun destroy() {
        detachView()
    }

}