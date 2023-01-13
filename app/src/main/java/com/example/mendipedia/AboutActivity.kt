package com.example.mendipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AboutActivity : AppCompatActivity() {

    private lateinit var textViewChoosedElementName: TextView
    private lateinit var textViewChoosedElementId: TextView
    private lateinit var textViewChoosedElementMass: TextView
    private lateinit var textViewChoosedElementDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        initData()
    }

    private fun initData(){
        textViewChoosedElementName = findViewById(R.id.textViewChoosedElementName)
        textViewChoosedElementId = findViewById(R.id.textViewChoosedElementId)
        textViewChoosedElementMass = findViewById(R.id.textViewChoosedElementMass)
        textViewChoosedElementDescription = findViewById(R.id.textViewChoosedElementDescription)

        getData()
    }

    private fun getData(){
        var intent = intent.extras
        var elementName = intent!!.getString("elementName")
        textViewChoosedElementName.text = elementName
//        textViewChoosedElementId.text = elementId
//        textViewChoosedElementMass.text = elementMass
//        textViewChoosedElementDescription.text = elementDescription
    }
}