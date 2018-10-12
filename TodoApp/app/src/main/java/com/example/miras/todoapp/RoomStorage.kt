package com.example.miras.todoapp

import io.reactivex.Observable


interface RoomStorage {
    fun getTodosByUserId (user_id : Int) : Observable<ArrayList<Todo>>
    fun insert (todo : Todo)

    fun register (user : User)
    fun getUsers () : Observable<ArrayList<User>>
}