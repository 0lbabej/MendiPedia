package com.example.mendipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val elementList = ArrayList<ElementModel>()
    lateinit var elementsAdapter: ElementsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        elementsAdapter = ElementsAdapter(elementList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = elementsAdapter
        prepareElementData()
    }

    fun prepareElementData() {
        var element = ElementModel("H")
        elementList.add(element)
        element = ElementModel("He")
        elementList.add(element)
    }
}