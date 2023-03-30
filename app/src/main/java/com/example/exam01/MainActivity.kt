package com.example.exam01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var usernameEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var loginBtn: Button
    private lateinit var remenberCheckBox: CheckBox
    private lateinit var autoLoginCheckBox: CheckBox
    private lateinit var forgotPasswordBtn: Button
    private lateinit var registerBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        usernameEt = findViewById(R.id.usernameEt)
        passwordEt = findViewById(R.id.passwordEt)
        loginBtn = findViewById(R.id.loginBtn)
        remenberCheckBox = findViewById(R.id.remenberCheckBox)
        autoLoginCheckBox = findViewById(R.id.autoLoginCheckBox)
        forgotPasswordBtn = findViewById(R.id.forgotPasswordBtn)
        registerBtn = findViewById(R.id.registerBtn)

        loginBtn.setOnClickListener(this)
        forgotPasswordBtn.setOnClickListener(this)
        registerBtn.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.loginBtn -> {
                Toast.makeText(this, "登录", Toast.LENGTH_SHORT).show()
            }
            R.id.forgotPasswordBtn -> {
                Toast.makeText(this, "忘记密码", Toast.LENGTH_SHORT).show()
            }
            R.id.registerBtn -> {
                Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}