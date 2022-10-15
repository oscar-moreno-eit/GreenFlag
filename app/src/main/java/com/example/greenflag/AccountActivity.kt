package com.example.greenflag

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import java.util.regex.Matcher
import java.util.regex.Pattern

private const val TAG = "AccountActivity"

class AccountActivity : AppCompatActivity() {



    private lateinit var ivBackButton: ImageView
    private lateinit var btnCreateAnAccount: Button
    private lateinit var etEmail: EditText
    private lateinit var tvWrongEmail: TextView
    private lateinit var tvWrongPasswords: TextView

    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        ivBackButton = findViewById(R.id.iv_back_button)
        etEmail = findViewById(R.id.et_email)
        tvWrongEmail = findViewById(R.id.tv_wrong_email)
        tvWrongPasswords = findViewById(R.id.tv_wrong_passwords)

        etPassword = findViewById(R.id.et_password)
        etConfirmPassword = findViewById(R.id.et_confirm_password)

        ivBackButton.setOnClickListener{
//            super.onBackPressed()
            this.onBackPressed()
        }

        btnCreateAnAccount = findViewById(R.id.btn_create_account)

        btnCreateAnAccount.setOnClickListener {
            if (validatePassword()) {
                Toast.makeText(this, getString(R.string.account_created), Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun validatePassword(): Boolean {
        var flag: Boolean = true
        val email: String = etEmail.text.toString()
        val password: String = etPassword.text.toString()
        val confirmPassword: String = etConfirmPassword.text.toString()
        tvWrongEmail.visibility = TextView.GONE
        tvWrongPasswords.visibility = TextView.GONE

        Log.d(TAG, "validatePassword:  email $email | password $password | confirmPassword $confirmPassword ")

        if(email.contains(" ") || email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())  {
            tvWrongEmail.visibility = TextView.VISIBLE
            etEmail.requestFocus()
            flag = false
        }

        if (password != confirmPassword)  {
            tvWrongPasswords.text = getString(R.string.match)
            tvWrongPasswords.visibility = View.VISIBLE
            flag =false
        }

        if (!isValidPassword(password) || !isValidPassword(confirmPassword))  {
            tvWrongPasswords.text = getString(R.string.one_invalid)
            tvWrongPasswords.visibility = View.VISIBLE
            flag =false
        }

        return flag

    }

    private fun isValidPassword(password: String?): Boolean {
        val passwordREGEX = Pattern.compile("^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[.,<>/~`@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$");
        return passwordREGEX.matcher(password).matches()
    }
}