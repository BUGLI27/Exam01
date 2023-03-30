package com.example.exam01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var registerResultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        init()
    }

    private fun init() {
        registerResultText = findViewById(R.id.registerResultText)

        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")
        val phone = intent.getStringExtra("phone")
        val sex = intent.getStringExtra("sex")
        val dept = intent.getStringExtra("dept")
        val hobbies = intent.getStringArrayListExtra("hobbies")

        val result = "用户名：$username\n" +
                "密码：$password\n" +
                "性别：$sex\n" +
                "联系电话：$phone\n" +
                "部门：$dept\n" +
                "兴趣爱好：${hobbies?.joinToString(separator = "、")}"
        registerResultText.text = result
    }
}