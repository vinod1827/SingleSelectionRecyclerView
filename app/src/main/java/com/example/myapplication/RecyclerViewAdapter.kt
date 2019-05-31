package com.example.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.single_row_item.view.*

class RecyclerViewAdapter(private val mModelList: List<Model>?) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var previousPosition: Int = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_row_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = mModelList!![position]
        holder.itemView.textView.text = model.text
        holder.itemView.view.setBackgroundColor(if (model.isSelected) Color.CYAN else Color.WHITE)

        holder.itemView.textView.setOnClickListener {
            model.isSelected = !model.isSelected
            //  if (mModelList.filter { it.isSelected }.isEmpty()) previousPosition = -1

            if (previousPosition != -1 && previousPosition != position) {
                mModelList.get(previousPosition).isSelected = false
                previousPosition = position
            } else {
                previousPosition = position
            }
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return mModelList?.size ?: 0
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }
}
