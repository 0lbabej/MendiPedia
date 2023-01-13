package com.example.mendipedia

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), ElementsAdapter.ClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var elementsAdapter: ElementsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
    }

    private fun initData(){
        recyclerView = findViewById(R.id.recyclerView)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        elementsAdapter = ElementsAdapter(this)
        recyclerView.adapter = elementsAdapter
        showData()
    }

    private fun createElements(): List<ElementModel>{
        var elementList = ArrayList<ElementModel>()
//        elementList.add(ElementModel("", "", "", ""))
        elementList.add(ElementModel("H", "1", "1,00797", "Водород"))
        elementList.add(ElementModel("He", "2", "4,0026", "Гелий"))
        elementList.add(ElementModel("Li", "3", "6,939", "Литий"))
        elementList.add(ElementModel("Be", "4", "9,0122", "Бериллий"))
        elementList.add(ElementModel("B", "5", "10,811", "Бор"))
        elementList.add(ElementModel("C", "6", "12,01115", "Углерод"))
        elementList.add(ElementModel("N", "7", "14,0067", "Азот"))
        elementList.add(ElementModel("O", "8", "15,9994", "Кислород"))
        elementList.add(ElementModel("F", "9", "18,9984", "Фтор"))
        elementList.add(ElementModel("Ne", "10", "20,179", "Неон"))
        elementList.add(ElementModel("Na", "11", "22,9898", "Натрий"))
        elementList.add(ElementModel("Mg", "12", "24,305", "Магний"))
        elementList.add(ElementModel("Al", "13", "26,9815", "Алюминий"))
        elementList.add(ElementModel("Si", "14", "28,085", "Кремний"))


        return elementList
    }
    private fun showData(){
        elementsAdapter.setData(createElements())
    }

    override fun clickedElement(elementModel: ElementModel) {
        startActivity(Intent(this, AboutActivity::class.java).putExtra("elementName", elementModel.elementName))
    }
}



