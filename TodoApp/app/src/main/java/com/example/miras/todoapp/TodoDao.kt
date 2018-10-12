package com.example.miras.todoapp

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface TodoDao {

    @Query("Select * from todos where user_id = :user_id")
    fun getTodosByUserId (user_id : Int) : Flowable<List<Todo>>

    @Insert
    fun insert (todo: Todo)

}