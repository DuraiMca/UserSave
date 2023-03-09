package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.myapplication.Model.User
import com.example.myapplication.R

class ListAdapter:RecyclerView.Adapter<ListAdapter.viewholder>() {

    private var userList= emptyList<User>()
    class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
   fun setData(user:List<User>){
       this.userList=user;
       notifyDataSetChanged()
   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
     return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row_data,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
    val currentItem=userList[position]
        holder.itemView.findViewById<TextView>(R.id.txtcount).setText(currentItem.id.toString())
        holder.itemView.findViewById<TextView>(R.id.txtname).setText(currentItem.firstname.toString())
        holder.itemView.findViewById<TextView>(R.id.txtage).setText(currentItem.age.toString())
    }

    override fun getItemCount(): Int {
return userList.size
    }


}