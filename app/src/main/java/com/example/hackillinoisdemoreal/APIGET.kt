package com.example.hackillinoisdemoreal

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIGET {
    @Headers("api-key: " + "events")
    @GET("event")
    fun getEvents(): Call<EventData>
}