package com.example.reservation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BeginReservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_begin_reservation)

        val btnSubmit: Button = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            if(findViewById<EditText>(R.id.editGuests).text.isEmpty() ||
                findViewById<EditText>(R.id.editTextPhone).text.isEmpty() ||
                findViewById<EditText>(R.id.editTextDate).text.isEmpty() ||
                findViewById<EditText>(R.id.editTextDate).text.isEmpty()) {

                Toast.makeText(applicationContext,
                    "Please enter all fields",
                    Toast.LENGTH_SHORT).show()
            } else {
                val bundle = Bundle()
                bundle.putString("resName", findViewById<EditText>(R.id.resName).text.toString())
                bundle.putString("phone", findViewById<EditText>(R.id.editTextPhone).text.toString())
                bundle.putString("date", findViewById<EditText>(R.id.editTextDate).text.toString())
                bundle.putString("guests", findViewById<EditText>(R.id.editGuests).text.toString())

                val intent = Intent(this, SelectTableActivity::class.java)
                intent.putExtras(bundle)

                startActivity(intent)
            }
        }
    }
}