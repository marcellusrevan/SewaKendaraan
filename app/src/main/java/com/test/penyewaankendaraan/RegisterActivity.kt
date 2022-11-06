package com.test.penyewaankendaraan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout
import com.test.penyewaankendaraan.databinding.ActivityRegisterBinding
import com.test.penyewaankendaraan.databinding.RecyclerviewItemBinding
import com.test.penyewaankendaraan.room.User
import com.test.penyewaankendaraan.room.UserDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RegisterActivity : AppCompatActivity() {
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var inputTangalLahir: TextInputLayout
    private lateinit var inputNomorTelepon: TextInputLayout
    private lateinit var btnRegister: Button
    private lateinit var itemBinding: ActivityRegisterBinding
    val db by lazy { UserDB( this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemBinding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(itemBinding.root)

        val view=itemBinding.root
        setTitle("Registration")

        inputUsername = itemBinding.ilUsername
        inputPassword = itemBinding.ilPassword
        inputEmail= itemBinding.ilEmail
        inputTangalLahir = itemBinding.ilTanggalLahir
        inputNomorTelepon = itemBinding.ilNomorTelepon

        btnRegister = findViewById(R.id.btnRegister)

        itemBinding.btnRegister.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            var checkLogin = true
            val username: String = inputUsername.editText?.getText().toString()
            val password: String = inputPassword.editText?.getText().toString()
            val email: String = inputEmail.editText?.getText().toString()
            val tangalLahir: String = inputTangalLahir.editText?.getText().toString()
            val nomorTelepon: String = inputNomorTelepon.editText?.getText().toString()




            if(username.isEmpty()){
                itemBinding.ilUsername.setError("Username must be filled with text")
                checkLogin =false

            }
            if(password.isEmpty()){
                itemBinding.ilPassword.setError("Password must be filled with text")
                checkLogin =false
            }

            if(email.isEmpty()){
                itemBinding.ilEmail.setError("Email must be filled with text")
                checkLogin =false
            }

            if(tangalLahir.isEmpty()){
                itemBinding.ilTanggalLahir.setError("Tanggal Lahir must be filled with text")
                checkLogin =false
            }

            if(nomorTelepon.isEmpty()) {
                itemBinding.ilNomorTelepon.setError("Nomor Telepon must be filled with text")
                checkLogin = false
            }

            if(!checkLogin)return@OnClickListener
            CoroutineScope(Dispatchers.IO).launch {
                db.noteDao().addUser(
                    User(0,inputUsername.getEditText()?.getText().toString(),
                        inputPassword.getEditText()?.getText().toString(),
                        inputEmail.getEditText()?.getText().toString(),
                        inputTangalLahir.getEditText()?.getText().toString(),
                        inputNomorTelepon.getEditText()?.getText().toString(),)
                )
                finish()
            }
            val moveLogin = Intent( this@RegisterActivity, MainActivity::class.java)
            startActivity(moveLogin)
        })
    }
}