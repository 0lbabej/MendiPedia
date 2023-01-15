package com.example.mendipedia

import android.content.ClipDescription
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Filter
import android.widget.Filterable
import android.widget.SearchView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), ElementsAdapter.ClickListener{

    private lateinit var recyclerView: RecyclerView
    private lateinit var elementsAdapter: ElementsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "List of Elements"

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

        for (id in 1..118) {
            val i = id-1
            elementList.add(ElementModel("${resources.getStringArray(R.array.elementsName)[i]}",
                "$id","${resources.getStringArray(R.array.elementsMass)[i]}",
                "${resources.getStringArray(R.array.elementsDescription)[i]}"))
        }
        return elementList
    }

    private fun showData(){
        elementsAdapter.setData(createElements())
    }

    override fun clickedElement(elementModel: ElementModel) {
        val intent = Intent(this, AboutActivity::class.java)
        intent.putExtra("choosedElementName", elementModel.elementName)
        intent.putExtra("choosedElementId", elementModel.elementId)
        intent.putExtra("choosedElementMass", elementModel.elementMass)
        intent.putExtra("choosedElementDescription", elementModel.elementDescription)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        var menuItem = menu!!.findItem(R.id.searchView)
        var searchView: SearchView = menuItem.actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE

        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                elementsAdapter.filter.filter(newText)
                return true
            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}


