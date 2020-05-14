package com.sagagroup.greedy.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sagagroup.greedy.adapter.HomeRecyclerAdapter
import com.sagagroup.greedy.R
import com.sagagroup.greedy.model.Restourent


class HomeFragment : Fragment() {
    lateinit var  recyclerHome:RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val restorentList = arrayListOf(
        "res1","res2","res3","res4","res5","res6","res7","res8"
      ,"res9","res10")

    lateinit var recyclerAdapter: HomeRecyclerAdapter
    val RestourentInfoList = arrayListOf<Restourent>(
        Restourent("P.S. I love You", "Cecelia Ahern", "Rs. 299", "4.5",R.drawable.ps_ily),
        Restourent("The Great Gatsby", "F. Scott Fitzgerald", "Rs. 399", "4.2", R.drawable.great_gatsby),
        Restourent("Anna Karenina", "Leo Tolstoy", "Rs. 199", "4.3", R.drawable.anna_kare),
      Restourent ("Madame Bovary", "Gustave Flaubert", "Rs. 500", "4.0", R.drawable.madame),
       Restourent ("War and Peace", "Leo Tolstoy", "Rs. 249", "4.8", R.drawable.war_and_peace),
        Restourent("Lolita", "Vladimir Nabokov", "Rs. 349", "3.9", R.drawable.lolita),
        Restourent("Middlemarch", "George Eliot", "Rs. 599", "4.2", R.drawable.middlemarch),
        Restourent("The Adventures of Huckleberry Finn", "Mark Twain", "Rs. 699", "4.5", R.drawable.adventures_finn),
        Restourent("Moby-Dick", "Herman Melville", "Rs. 499", "4.5", R.drawable.moby_dick),
        Restourent("The Lord of the Rings", "J.R.R Tolkien", "Rs. 749", "5.0", R.drawable.lord_of_rings)
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerHome = view.findViewById(R.id.recyclerHome)
        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = HomeRecyclerAdapter(
            activity as Context,RestourentInfoList

        )
        recyclerHome.adapter = recyclerAdapter
        recyclerHome.layoutManager = layoutManager
        recyclerHome.addItemDecoration(DividerItemDecoration(recyclerHome.context,(layoutManager as LinearLayoutManager).orientation))
       return view

    }

}
