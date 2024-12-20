package com.example.myapplicationcourse.firstapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationcourse.R
import com.example.myapplicationcourse.firstapp.imccalculator.ImcCalculatorActivity
import com.example.myapplicationcourse.firstapp.settings.SettingsActivity
import com.example.myapplicationcourse.firstapp.superheroapp.SuperHeroeListActivity
import com.example.myapplicationcourse.firstapp.todoApp.TodoActivity

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
        val btnTodoApp = findViewById<AppCompatButton>(R.id.todoApp)
        val btnSuperHero = findViewById<AppCompatButton>(R.id.btnSuperHero)
        val btnSettings = findViewById<AppCompatButton>(R.id.btnSettings)

        btnSaludApp.setOnClickListener {
            navigateToSaludApp()
        }

        btnIMCApp.setOnClickListener {
            navigateToIMCApp()
        }

        btnTodoApp.setOnClickListener {
            navigateToTodoApp()
        }

        btnSuperHero.setOnClickListener {
            navigateToSuperHero()
        }

        btnSettings.setOnClickListener {
            navigateToSettings()
        }
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTodoApp(){
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSuperHero(){
        val intent = Intent(this, SuperHeroeListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSettings(){
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

}