package com.android.ancientsofware.foodguide.RetroFitApi

import android.util.Log
import com.android.ancientsofware.foodguide.Models.Restaurant
import com.android.ancientsofware.foodguide.Models.Restaurants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantsNearByWorker : RestaurantsNearByInterface {

    var mRestaurants: List<Restaurant>? = ArrayList()

    companion object {
        const val mBaseUrl: String = "https://developers.zomato.com"
    }

    val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    val client : OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    override fun getUsers(lat: String, lon: String, city: String): Call<Restaurants> {
        var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        var api = retrofit.create(RestaurantsNearByInterface::class.java)
        var call = api.getUsers( lat, lon, city)
        call.enqueue(object : Callback<Restaurants> {

            override fun onResponse(call: Call<Restaurants>, response: Response<Restaurants>) {
                var body = response?.body()
                mRestaurants = body?.restaurants
            }

            override fun onFailure(call: Call<Restaurants>, t: Throwable?) {
                Log.d("Tag", "Error")
            }
        })

        return call
    }
}