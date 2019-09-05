package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

class RestaurantsNearByModel {
    @SerializedName("results_found")
    var mResultsFound: String = ""
    @SerializedName("results_start")
    var mResultsStart: String = ""
    @SerializedName("results_shown")
    var mResultsShown: String = ""
    @SerializedName("restaurants")
    var mRestaurants: ArrayList<RestaurantModel> = ArrayList<RestaurantModel>()
}