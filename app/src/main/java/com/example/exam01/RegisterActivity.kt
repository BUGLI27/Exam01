package com.example.exam01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import com.example.exam01.utils.showToast

class RegisterActivity : AppCompatActivity() {

    private lateinit var usernameRegisterEt: EditText
    private lateinit var passwordRegisterEt: EditText
    private lateinit var sexRadioGroup: RadioGroup
    private lateinit var sexRadioButton: RadioButton
    private lateinit var phoneRegisterEt: EditText
    private lateinit var departmentSpinner: Spinner
    private lateinit var hobbyCheckBox1: CheckBox
    private lateinit var hobbyCheckBox2: CheckBox
    private lateinit var hobbyCheckBox3: CheckBox
    private lateinit var hobbyCheckBox4: CheckBox
    private lateinit var confirmRegisterBtn: Button

    private var username = ""
    private var password = ""
    private var phone = ""
    private var checkBoxList = listOf<CheckBox>()
    private val hobbies: ArrayList<String> = arrayListOf()
    private var sex = "男"
    private var dept = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
    }

    private fun init() {
        usernameRegisterEt = findViewById(R.id.usernameRegisterEt)
        passwordRegisterEt = findViewById(R.id.passwordRegisterEt)
        sexRadioGroup = findViewById(R.id.sexRadioGroup)
        sexRadioButton = findViewById(R.id.male)
        phoneRegisterEt = findViewById(R.id.phoneRegisterEt)
        departmentSpinner = findViewById(R.id.departmentSpinner)
        hobbyCheckBox1 = findViewById(R.id.hobbyCheckBox1)
        hobbyCheckBox2 = findViewById(R.id.hobbyCheckBox2)
        hobbyCheckBox3 = findViewById(R.id.hobbyCheckBox3)
        hobbyCheckBox4 = findViewById(R.id.hobbyCheckBox4)
        confirmRegisterBtn = findViewById(R.id.confirmRegisterBtn)

        checkBoxList = listOf(hobbyCheckBox1, hobbyCheckBox2, hobbyCheckBox3, hobbyCheckBox4)

        getSex()
        getFavorite()
    }

    private fun getSex() {
        sexRadioGroup.setOnCheckedChangeListener { _, i ->
            when (i) {
                R.id.male -> sexRadioButton = findViewById(R.id.male)
                R.id.female -> sexRadioButton = findViewById(R.id.female)
            }
            sex = sexRadioButton.text.toString()
        }
    }

    private fun getFavorite() {
        checkBoxList.forEach {
            it.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    hobbies.add(it.text.toString())
                }
            }
        }
    }

    fun myClick(view: View) {
        when (view.id) {
            R.id.confirmRegisterBtn -> {
                username = usernameRegisterEt.text.toString().trim()
                password = passwordRegisterEt.text.toString().trim()
                phone = phoneRegisterEt.text.toString().trim()
                dept = departmentSpinner.selectedItem.toString()

                if (username == "" || password == "") {
                    "请填写账号密码".showToast(this)
                } else if (dept == "") {
                    "请选择部门".showToast(this)
                } else {
                    // 跳转
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.apply {
                        putExtra("username", username)
                        putExtra("password", password)
                        putExtra("phone", phone)
                        putExtra("sex", sex)
                        putExtra("hobbies", hobbies)
                        putExtra("dept", dept)
                    }
                    startActivity(intent)
                }
            }
        }
    }

}