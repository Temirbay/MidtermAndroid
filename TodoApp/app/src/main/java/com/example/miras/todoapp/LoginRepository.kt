package com.example.miras.todoapp

import android.annotation.SuppressLint
import com.example.miras.todoapp.core.BaseListener

class LoginRepository(private val roomStorage: RoomStorage,
                      private val localStorage: LocalStorage)
    :LoginContract.Repository{

    @SuppressLint("CheckResult")
    override fun login(email: String, password: String, listener: BaseListener.onLoginFinishedListener) {
        roomStorage.getUsers().subscribe {
            for (item in it) {
                if (item.email == email && item.password == password) {
                    listener.onLoginSuccess()
                    localStorage.saveId(item.uuid)
                    localStorage.saveEmail(item.email)
                    return@subscribe
                }
            }
            val user = User(0, email, password)
            roomStorage.register(user)
            localStorage.saveId(user.uuid)
            localStorage.saveEmail(user.email)
        }
    }
}