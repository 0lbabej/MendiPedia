package com.example.mendipedia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ElementsAdapter(clickListener: ClickListener): RecyclerView.Adapter<ElementsAdapter.ViewHolder>() {

    private var elementModelList: List<ElementModel> = arrayListOf()
    private lateinit var context: Context
    private var clickListener: ClickListener = clickListener

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
        var elementId = elementModel.elementId
        var elementMass = elementModel.elementMass
        var elementDescription = elementModel.elementDescription

        holder.textViewElementName.text = elementName

        holder.itemView.setOnClickListener{
            clickListener.clickedElement(elementModel)
        }
    }

    override fun getItemCount(): Int {
        return elementModelList.size
    }

    interface ClickListener{
        fun clickedElement(elementModel: ElementModel)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var textViewElementName = itemView.findViewById<TextView>(R.id.textViewElementName)
    }
}