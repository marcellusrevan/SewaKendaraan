package com.test.penyewaankendaraan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var inputTangalLahir: TextInputLayout
    private lateinit var inputNomorTelepon: TextInputLayout
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setTitle("Registration")

        inputUsername = findViewById(R.id.ilUsername)
        inputPassword = findViewById(R.id.ilPassword)
        inputEmail= findViewById(R.id.ilEmail)
        inputTangalLahir = findViewById(R.id.ilTanggalLahir)
        inputNomorTelepon = findViewById(R.id.ilNomorTelepon)

        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            var checkLogin = false
            val username: String = inputUsername.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()
            val email: String = inputEmail.getEditText()?.getText().toString()
            val tangalLahir: String = inputTangalLahir.getEditText()?.getText().toString()
            val nomorTelepon: String = inputNomorTelepon.getEditText()?.getText().toString()


            if(username.isEmpty()){
                inputUsername.setError("Username must be filled with text")
                checkLogin =false

            }
            if(password.isEmpty()){
                inputPassword.setError("Password must be filled with text")
                checkLogin =false
            }

            if(email.isEmpty()){
                inputEmail.setError("Email must be filled with text")
                checkLogin =false
            }

            if(tangalLahir.isEmpty()){
                inputTangalLahir.setError("Tanggal Lahir must be filled with text")
                checkLogin =false
            }

            if(nomorTelepon.isEmpty()) {
                inputNomorTelepon.setError("Nomor Telepon must be filled with text")
                checkLogin = false
            }
            if(!checkLogin)return@setOnClickListener
            val moveLogin = Intent( this@RegisterActivity, MainActivity::class.java)
            startActivity(moveLogin)
        }
    }
}