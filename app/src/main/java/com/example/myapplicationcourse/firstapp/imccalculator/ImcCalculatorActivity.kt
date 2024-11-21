package com.example.myapplicationcourse.firstapp.imccalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationcourse.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 64
    private var currentAge: Int = 18

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnAddWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var tvAge: TextView

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
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnAddAge = findViewById(R.id.btnAddAge)
        tvAge = findViewById(R.id.tvAge)
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
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }

        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        btnAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
    }

    private fun setWeight(){
        tvWeight.text = currentWeight.toString()
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

    private fun setAge(){
        tvAge.text = currentAge.toString()
    }

    private fun initUI(){
        setAge()
        setWeight()
        setGenderColor()
    }
}