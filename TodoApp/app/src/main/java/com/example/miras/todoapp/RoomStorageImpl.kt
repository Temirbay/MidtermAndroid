package com.example.miras.todoapp

import io.reactivex.Observable



class RoomStorageImpl(private val database : LocalDatabase) : RoomStorage {

    override fun insert(todo: Todo) {
        database.todoDao().insert(todo)
    }

    override fun getTodosByUserId(user_id: Int): Observable<ArrayList<Todo>> {
        return database.todoDao().getTodosByUserId(user_id)
                .map { it as ArrayList<Todo> }
                .toObservable()
    }

    override fun register(user: User) {
        database.userDao().register(user)
    }

    override fun getUsers(): Observable<ArrayList<User>> {
        return database.userDao().getUsers()
                .map { it as ArrayList<User> }
                .toObservable()
    }

}