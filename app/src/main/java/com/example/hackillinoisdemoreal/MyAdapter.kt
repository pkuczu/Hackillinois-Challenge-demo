package com.example.hackillinoisdemoreal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context, val userList: List<Event>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var eventName: TextView
        var eventDescription: TextView

        init {
            eventName = itemView.findViewById(R.id.eventName)
            eventDescription = itemView.findViewById(R.id.eventDescription)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.eventName.text = userList[position].name.toString()
        holder.eventDescription.text = userList[position].description.toString()

        /*
        val textView: TextView = findViewById(R.id.textView) as TextView
                println("reached")
                textView.text = myStringBuilder.toString()
         */
    }

    override fun getItemCount(): Int {
        return userList.size

    }

}