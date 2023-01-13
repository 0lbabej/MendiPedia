package com.example.mendipedia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ElementsAdapter: RecyclerView.Adapter<ElementsAdapter.ViewHolder>() {

    private var elementModelList: List<ElementModel> = arrayListOf()
    private lateinit var context: Context

    fun setData(elementModel: List<ElementModel>){
        this.elementModelList = elementModel
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.element_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var elementModel = elementModelList.get(position)
        var elementName = elementModel.elementName

        holder.textViewElementName.text = elementName
    }

    override fun getItemCount(): Int {
        return elementModelList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var textViewElementName = itemView.findViewById<TextView>(R.id.textViewElementName)
    }
}