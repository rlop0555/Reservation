package com.example.reservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.reservation.data.User
import com.example.reservation.data.UserDao
import com.example.reservation.data.UserDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        val btnGuest: Button = findViewById(R.id.btnGuest)
        btnGuest.setOnClickListener {
            val intent = Intent(this, BeginReservationActivity::class.java)
            startActivity(intent)
        }
    }
}