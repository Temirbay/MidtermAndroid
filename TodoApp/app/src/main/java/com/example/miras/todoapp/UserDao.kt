package com.example.miras.todoapp

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Database
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface UserDao {

    @Insert
    fun register(user : User)

    @Query("Select * from users")
    fun getUsers () : Flowable<List<User>>
}