package com.example.miras.todoapp

import android.annotation.SuppressLint
import android.util.Log
import com.example.miras.todoapp.core.BaseListener

class TodoRepository(private val roomStorage: RoomStorage,
                     private val localStorage: LocalStorage)
    : TodoListContract.Repository{

    @SuppressLint("CheckResult")
    override fun getDoneTodos(listener: BaseListener.onReadFinishedListener) {
        roomStorage.getTodosByUserId(localStorage.getId()!!)
                .subscribe {

                    val list = ArrayList<Todo>()
                    for (item in it) {
                        if (!item.done)
                            list.add(item)
                    }
                    listener.onReadFinished(list)
        }
    }

    @SuppressLint("CheckResult")
    override fun getUndoneTodos(listener: BaseListener.onReadFinishedListener) {
        roomStorage.getTodosByUserId(localStorage.getId()!!)
                .subscribe {
                    val list = ArrayList<Todo>()
                    for (item in it) {
                        if (item.done)
                            list.add(item)
                    }
                    listener.onReadFinished(list)
                }
    }
}