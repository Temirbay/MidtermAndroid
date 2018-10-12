package com.example.miras.todoapp


interface LocalStorage {

    fun saveEmail(email : String)

    fun getEmail() : String?

    fun saveId(id : Int)

    fun getId() : Int?


}