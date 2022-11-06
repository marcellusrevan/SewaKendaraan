package com.test.penyewaankendaraan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.textfield.TextInputLayout
import com.test.penyewaankendaraan.room.User
import com.test.penyewaankendaraan.room.UserDB
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var mainLayout: ConstraintLayout
    lateinit var usernameDB:String
    lateinit var passwordDB:String
    val db by lazy { UserDB( this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("User Login")

        inputUsername = findViewById(R.id.inputLayoutUsername)
        inputPassword = findViewById(R.id.inputLayoutPassword)
        mainLayout = findViewById(R.id.mainLayout)
        val btnRegister: Button = findViewById(R.id.btnRegister)
        val btnLogin: Button = findViewById(R.id.btnLogin)


        btnRegister.setOnClickListener {

            val moveRegister = Intent( this@MainActivity, RegisterActivity::class.java)
            startActivity(moveRegister)
        }

        btnLogin.setOnClickListener(View.OnClickListener {
            var checkLogin = false
            val username: String = inputUsername.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()
            runBlocking() {
                val username = async {
                    val account:User?=db.noteDao().getLogin(inputUsername.getEditText()?.getText().toString(),
                        inputPassword.getEditText()?.getText().toString())
                    if(account!=null){
                        account.username
                    }
                    else{
                        null
                    }
                }
                val password = async {
                    val account:User?=db.noteDao().getLogin(inputUsername.getEditText()?.getText().toString(),
                        inputPassword.getEditText()?.getText().toString())
                    if(account!=null){
                        account.password
                    }
                    else{
                        null
                    }
                }
                usernameDB = username.await().toString()
                passwordDB = password.await().toString()
            }

            if(username.isEmpty()){
                inputUsername.setError("Username must be filled with text")
                checkLogin=false

            }
            if(password.isEmpty()){
                inputPassword.setError("Password must be filled with text")
                checkLogin=false
            }

            if(username == usernameDB&& password== passwordDB) checkLogin=true
            if(!checkLogin)return@OnClickListener
            val moveHome = Intent(this@MainActivity, ButtonHome::class.java)
            startActivity(moveHome)
        })

    }
}