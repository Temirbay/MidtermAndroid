package com.example.miras.todoapp

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val appModule = module {
    single { createSharedPrefs(androidContext()) }
    single { LocalStorageImpl(get()) as LocalStorage }

    single { createRoomStorage(androidContext())}
    single { RoomStorageImpl(get()) as RoomStorage }
}


fun createSharedPrefs (context : Context) : SharedPreferences {
    return context.applicationContext.getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)
}

fun createRoomStorage (context : Context) : LocalDatabase {
    return Room.databaseBuilder(context, LocalDatabase::class.java, "localDb")
            .allowMainThreadQueries()
            .build()
}