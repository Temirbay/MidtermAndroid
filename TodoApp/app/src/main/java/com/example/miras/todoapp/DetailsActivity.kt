package com.example.miras.todoapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_details.*
import org.koin.android.ext.android.inject

class DetailsActivity : AppCompatActivity() {

    private val roomStorage : RoomStorage by inject()

    private val localStorage : LocalStorage by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (intent.getStringExtra("type") == "add") {

            bnOk.setOnClickListener {

                roomStorage.insert(Todo(0, etTitle.text.toString(),
                        etBody.text.toString(), false, localStorage.getId()!!))

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
        else {
            bnOk.visibility = View.GONE

        }
    }
}
