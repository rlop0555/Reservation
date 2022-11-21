package com.example.reservation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SelectTableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_table)

        val bundle = intent.extras

        if (bundle != null) {
            findViewById<TextView>(R.id.nameView).text = bundle.get("resName") as CharSequence?
            findViewById<TextView>(R.id.textView3).text = bundle.get("phone") as CharSequence?
            findViewById<TextView>(R.id.textView4).text = bundle.get("date") as CharSequence?
            findViewById<TextView>(R.id.textView5).text = bundle.get("guests") as CharSequence?
        }

    }
}