package com.sagagroup.greedy.fragment

import android.app.AlertDialog
import android.app.DownloadManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.sagagroup.greedy.adapter.HomeRecyclerAdapter
import com.sagagroup.greedy.R
import com.sagagroup.greedy.model.Restourent
import com.sagagroup.greedy.util.ConnectionManager
import org.json.JSONObject


class HomeFragment : Fragment() {
    lateinit var  recyclerHome:RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var btncheckconnection:Button



    lateinit var recyclerAdapter: HomeRecyclerAdapter
    val RestourentInfoList= arrayListOf<Restourent>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerHome = view.findViewById(R.id.recyclerHome)
        btncheckconnection =view.findViewById(R.id.btncheckconnection)

        btncheckconnection.setOnClickListener {
            if (ConnectionManager().checkConnectivity(activity as Context))
            {
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Success")
                dialog.setMessage("Internet connection found")
                dialog.setPositiveButton("ok"){ text,listener ->

                }
                dialog.setNegativeButton("Cancel"){text,listener ->
                }
                dialog.create()
                dialog.show()

            }
            else
            {
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Error")
                dialog.setMessage("Internet connection not found")
                dialog.setPositiveButton("ok"){ text,listener ->

                }
                dialog.setNegativeButton("Cancel"){text,listener ->
                }
                dialog.create()
                dialog.show()

            }



        }
        layoutManager = LinearLayoutManager(activity)


        // for server side ..
        val queue = Volley.newRequestQueue(activity as Context)
        val url = " http://13.235.250.119/v2/restaurants/fetch_result/ "

        if (ConnectionManager().checkConnectivity(activity as Context)){
            val jsonObjectRequest = object : JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {

                // Here we will handle the response
                try {
                    progressLayout.visibility = View.GONE
                    val success = it.getBoolean("success")

                    if (success){

                        val data = it.getJSONArray("data")
                        for (i in 0 until data.length()){
                            val bookJsonObject = data.getJSONObject(i)
                            val bookObject = Book(
                                bookJsonObject.getStrinag("book_id"),
                                bookJsonObject.getString("name"),
                                bookJsonObject.getString("author"),
                                bookJsonObject.getString("rating"),
                                bookJsonObject.getString("price"),
                                bookJsonObject.getString("image")
                            )
                            bookInfoList.add(bookObject)
                            recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookInfoList)

                            recyclerDashboard.adapter = recyclerAdapter



val jsonObjectRequest = object : JsonObjectRequest(Request.Method.GET,url,null, Response.Listener {

            val success = it.getBoolean("success")
            if(success)
            {
                val data = it.getJSONArray("data")
                for(i in 0 until data.length())
                {
                       val RestourentJsonObject = data.getJSONObject(i)
                        val RestourentObject = Restourent(
                            RestourentJsonObject.getString("id"),
                            RestourentJsonObject.getString("name"),
                            RestourentJsonObject.getString("rating"),
                            RestourentJsonObject.getString("cost_for_one"),
                            RestourentJsonObject.getString("image_url"))

                    RestourentInfoList.add(RestourentObject)
                    recyclerAdapter = HomeRecyclerAdapter(
                        activity as Context,RestourentInfoList

                    )
                    recyclerHome.adapter = recyclerAdapter
                    recyclerHome.layoutManager = layoutManager
                    recyclerHome.addItemDecoration(DividerItemDecoration(recyclerHome.context,(layoutManager as LinearLayoutManager).orientation))

                }

            } else{
                Toast.makeText(activity as Context,"some error",Toast.LENGTH_SHORT).show()


            }

        } ,Response.ErrorListener {
            println("Error is $it")
        }
        ){

            override fun getHeaders(): MutableMap<String, String> {

                val headers = HashMap<String,String>()
                headers["Content - type"] = "application/json"
                headers["token"] = "9bf534118365f1"
                return headers

            }



        }

        queue.add(jsonObjectRequest)

        return view

    }

}
