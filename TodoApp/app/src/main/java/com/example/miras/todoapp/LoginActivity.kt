package com.example.miras.todoapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LoginActivity : AppCompatActivity(), LoginContract.View{


    override val presenter: LoginContract.Presenter
            by inject { parametersOf(this) }


    override fun onSuccess() {
        val intent = Intent (this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.attachView(this)

        bnLogin.setOnClickListener {
            presenter.login(etEmail.text.toString(), etPassword.text.toString())
        }
    }
}
