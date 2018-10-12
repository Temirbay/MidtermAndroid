package com.example.miras.todoapp

import android.content.SharedPreferences


class LocalStorageImpl(private val pref : SharedPreferences)
    : LocalStorage {

    override fun saveId(id: Int) {
        pref.edit()
                .putInt("USER_ID", id)
                .apply()
    }

    override fun getId(): Int? =
        pref.getInt("USER_ID", 0)

    override fun saveEmail(email: String) {
        pref.edit()
                .putString("USER_EMAIL", email)
                .apply()
    }

    override fun getEmail(): String? =
            pref.getString("USER_EMAIL", null)
}