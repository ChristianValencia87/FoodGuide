package com.android.ancientsofware.foodguide.RetroFitApi

import com.android.ancientsofware.foodguide.Models.Restaurants
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.Query

interface RestaurantsNearByInterface {

    @Headers("user-key: 8c6bf444698e35e862128a6abc9c68cf")
    @GET("api/v2.1/search?radius=1000")
    fun getUsers(@Query("lat") lat: String, @Query("lon") lon: String, @Query("q") city: String): Call<Restaurants>
}