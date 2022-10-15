package com.example.greenflag

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AccountActivity : AppCompatActivity() {

    private lateinit var ivBackButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        ivBackButton = findViewById(R.id.iv_back_button)
        ivBackButton.setOnClickListener{
//            super.onBackPressed()
            this.onBackPressed()
        }

    }
}