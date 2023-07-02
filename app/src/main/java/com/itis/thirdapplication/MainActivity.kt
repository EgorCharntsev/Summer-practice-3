package com.itis.thirdapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itis.thirdapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val newBinding = ActivityMainBinding.inflate(layoutInflater)
        binding = newBinding
        setContentView(newBinding.root)
    }
}