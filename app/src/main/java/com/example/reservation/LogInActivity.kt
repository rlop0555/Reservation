package com.example.reservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.reservation.data.User
import com.example.reservation.data.UserDatabase

class LogInActivity : AppCompatActivity() {
    private val userDatabase by lazy { UserDatabase.getDatabase(this).userDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        try {
            userDatabase.addUser(User(username = "johndoe", password = "12345", name = "John Doe",
                mailingAddress = "1234 Doe Lane", billingAddress = "4567 Doe Lane", earnedPoints = 5,
                preferredPaymentMethod = 0, preferredDinerId = 21))
        } catch(e: java.lang.Exception) {
            println(e.toString())
            Toast.makeText(applicationContext,
                e.toString(),
                Toast.LENGTH_LONG).show()
        }

        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            if(findViewById<EditText>(R.id.username).text.isEmpty() ||
                findViewById<EditText>(R.id.password).text.isEmpty()) {
                Toast.makeText(applicationContext,
                    "Please enter all fields",
                    Toast.LENGTH_SHORT).show()
            } else{
                val username = findViewById<EditText>(R.id.username).text.toString()
                val password = findViewById<EditText>(R.id.password).text.toString()

                val user : User = userDatabase.attemptLogin(username, password)

                if(user != null) {
                    Toast.makeText(applicationContext,
                        user.name,
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext,
                        "fuck you",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}