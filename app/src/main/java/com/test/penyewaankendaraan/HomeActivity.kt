package com.test.penyewaankendaraan


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.penyewaankendaraan.databinding.ActivityMainBinding


class HomeActivity : AppCompatActivity() {
    var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = HomeAdapter(TaskList.taskList)
        //binding?.taskRv?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}