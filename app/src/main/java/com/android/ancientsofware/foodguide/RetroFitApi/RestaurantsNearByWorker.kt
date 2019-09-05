package com.android.ancientsofware.foodguide.RetroFitApi

import com.android.ancientsofware.foodguide.Models.RestaurantModel
import com.android.ancientsofware.foodguide.Models.RestaurantsNearByModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantsNearByWorker : RestaurantsNearByInterface {

    var mRestaurants: ArrayList<RestaurantModel>? = ArrayList<RestaurantModel>()

    companion object {
        const val mBaseUrl: String = "https://developers.zomato.com"
    }

    override fun getUsers(lat: String, lon: String): Call<RestaurantsNearByModel> {
        var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var api = retrofit.create(RestaurantsNearByInterface::class.java)
        var call = api.getUsers( lat, lon)
        call.enqueue(object : Callback<RestaurantsNearByModel> {

            override fun onResponse(call: Call<RestaurantsNearByModel>, response: Response<RestaurantsNearByModel>) {
            var body = response?.body()
            mRestaurants = body?.mRestaurants
            }

            override fun onFailure(call: Call<RestaurantsNearByModel>, t: Throwable?) {

            }
        })

        return call
    }
}