package com.example.myapplicationcourse.firstapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationcourse.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSaludApp = findViewById<AppCompatButton>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<AppCompatButton>(R.id.btnIMCApp)

        btnSaludApp.setOnClickListener {
            navigateToSaludApp()
        }

        btnIMCApp.setOnClickListener {
            navigateToIMCApp()
        }

    }

    private fun navigateToIMCApp() {
        TODO("Not yet implemented")
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}