package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

data class Location(
        @SerializedName("address")
        val address: String,
        @SerializedName("city")
        val city: String,
        @SerializedName("city_id")
        val city_id: String,
        @SerializedName("country_id")
        val country_id: Int,
        @SerializedName("latitude")
        val latitude: String,
        @SerializedName("locality")
        val locality: String,
        @SerializedName("locality_verbose")
        val locality_verbose: String,
        @SerializedName("longitude")
        val longitude: String,
        @SerializedName("zipcode")
        val zipcode: String
)