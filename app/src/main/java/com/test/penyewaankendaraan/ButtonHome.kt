package com.test.penyewaankendaraan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Exception

class ButtonHome : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.radio_button)
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.mobil ->{
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
                R.id.profile -> {
                    val intent = Intent(this, CameraMain::class.java)
                    startActivity(intent)
                }
                R.id.transaksi ->{
                    val intent = Intent(this, TransaksiView::class.java)
                    startActivity(intent)
                }


                R.id.map ->{
                    val intent = Intent(this, MapMain::class.java)
                    startActivity(intent)
                }

                R.id.exit -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    fun setActivity(activity: AppCompatActivity){
        val moveActivity = Intent(this, activity::class.java)
        startActivity(moveActivity)
    }
}