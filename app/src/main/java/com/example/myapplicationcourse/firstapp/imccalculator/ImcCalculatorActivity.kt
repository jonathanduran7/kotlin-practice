package com.example.myapplicationcourse.firstapp.imccalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationcourse.R

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender("male")
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender("female")
            setGenderColor()
        }
    }

    private fun changeGender(viewName: String){

        if(viewName.lowercase() == "male"){
            isMaleSelected = true
            isFemaleSelected = false
        }else{
            isMaleSelected = false
            isFemaleSelected = true
        }
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))

    }

    private fun getBackgroundColor(isComponentSelected: Boolean): Int {
       val colorReference = if (isComponentSelected) {
           R.color.background_component_selected
       } else {
           R.color.background_component
       }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI(){
        setGenderColor()
    }
}