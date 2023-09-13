package com.example.hackillinoisdemoreal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.JsonObjectRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    val Base_URL = "https://adonix.hackillinois.org/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_row)
        println("reached1")
        findViewById<RecyclerView>(R.id.mRecyclerView).setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.mRecyclerView).layoutManager = linearLayoutManager


        getEvents()


    }

    private fun getEvents() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Base_URL)
            .build()
            .create(APIGET::class.java)
        val retrofitData = retrofitBuilder.getEvents()

        retrofitData.enqueue(object : Callback<EventData?> {
            override fun onResponse(call: Call<EventData?>, response: Response<EventData?>) {
                val responseBody = response.body()!!

                myAdapter = MyAdapter(baseContext, responseBody.events)
                myAdapter.notifyDataSetChanged()

                findViewById<RecyclerView>(R.id.mRecyclerView).adapter = myAdapter
            }

            override fun onFailure(call: Call<EventData?>, t: Throwable) {
                println("reachederror: ${t.message}")
            }
        })
    }

}