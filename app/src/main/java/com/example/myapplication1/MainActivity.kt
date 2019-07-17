package com.example.myapplication1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        about_alc.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
        bt_profile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}

