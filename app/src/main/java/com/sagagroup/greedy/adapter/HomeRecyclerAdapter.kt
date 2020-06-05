package com.sagagroup.greedy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sagagroup.greedy.R
import com.sagagroup.greedy.model.Restourent
import org.w3c.dom.Text

//import com.navigationpro.navigation_view.Book
//import com.navigationpro.navigation_view.R

class HomeRecyclerAdapter(val context: Context, val itemList:ArrayList<Restourent>) : RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>()
    {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder
        {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_home_single_row,parent,false)
            return HomeViewHolder(
                view
            )

        }

        override fun getItemCount(): Int {

            return itemList.size
        }

        override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val Restourent = itemList[position]
        holder.txtname.text = Restourent.name
        holder.txtrestorentid.text = Restourent.id
        holder.txtfoodPrice.text = Restourent.cost_for_one
        holder.txtFoodRating.text = Restourent.rating
       // holder.imgFoodImage.setImageResource(Restourent.image_url)

        }
        class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val txtname: TextView = view.findViewById(R.id.txtname)
            val txtrestorentid :TextView = view.findViewById(R.id.txtrestorentnameauthor)
            val txtfoodPrice :TextView = view.findViewById(R.id.txtfoodPrice)
            val txtFoodRating:TextView = view.findViewById(R.id.txtFoodRating)
          //  val imgFoodImage:ImageView = view.findViewById(R.id.imgFoodImage)

        }}