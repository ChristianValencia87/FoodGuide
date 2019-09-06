package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

data class Restaurants(
        @SerializedName("restaurants")
        val restaurants: List<Restaurant>,
        @SerializedName("results_found")
        val results_found: String,
        @SerializedName("results_shown")
        val results_shown: String,
        @SerializedName("results_start")
        val results_start: String
)