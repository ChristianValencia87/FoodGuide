package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

class LocationModel {
    @SerializedName("address")
    var mAddress: String = ""
    @SerializedName("locality")
    var mLocality: String = ""
    @SerializedName("city")
    var mCity: String = ""
    @SerializedName("latitude")
    var mLatitude: String = ""
    @SerializedName("longitude")
    var mLongitude: String = ""
    @SerializedName("zipcode")
    var mZipCode: String = ""
    @SerializedName("country_id")
    var mCountryId: String = ""

}