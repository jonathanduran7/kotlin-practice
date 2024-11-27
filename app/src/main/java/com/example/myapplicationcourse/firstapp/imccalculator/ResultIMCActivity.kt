package com.example.myapplicationcourse.firstapp.imccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationcourse.R

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var btnRecalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result: Double = intent.extras?.getDouble(ImcCalculatorActivity.IMC_KEY) ?: -1.0
        val resultRounded = String.format("%.2f", result)

        val tvResult = findViewById<TextView>(R.id.tvResultIMC)
        tvResult.text = "Tu índice de masa corporal es $resultRounded"

        btnRecalculate = findViewById(R.id.btnRecalculate)
        btnRecalculate.setOnClickListener {
            finish()
        }

    }
}