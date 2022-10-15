package com.example.greenflag

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnCreateAnAccount: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreateAnAccount = findViewById(R.id.btn_create)

        btnCreateAnAccount.setOnClickListener {
            val openCreateActivity = Intent()
            openCreateActivity.setClass(this,AccountActivity::class.java)
            startActivity(openCreateActivity)

        }

    }
}