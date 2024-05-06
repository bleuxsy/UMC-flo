package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySplashBinding
import com.example.myapplication.databinding.FragmentLookBinding

class SplashActivity : AppCompatActivity(){
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //몇초뒤에 main으로 넘어가도록
        val handler = Handler(Looper.getMainLooper())

        handler.postDelayed({
            startActivity(this,MainActivity::class.java)
        })
    }
}