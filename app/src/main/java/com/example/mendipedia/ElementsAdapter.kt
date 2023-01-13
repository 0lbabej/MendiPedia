package com.example.mendipedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ElementsAdapter(val elementsList: List<ElementModel>) : RecyclerView.Adapter<ElementsAdapter.MyViewHolder>(){
    class MyViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.textViewElementName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.element_card, parent, false)
        return  MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val element = elementsList[position]
        holder.name.text = element.name
    }

    override fun getItemCount(): Int {
        return elementsList.size
    }
}