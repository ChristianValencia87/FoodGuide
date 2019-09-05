package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

class UserModel {
    @SerializedName("name")
    var mName: String = ""
    @SerializedName("zomato_handle")
    var mZomatoHandle: String = ""
    @SerializedName("foodie_level")
    var mFoodieLevel: String = ""
    @SerializedName("foodie_level_num")
    var mFoodieLevelNum: String = ""
    @SerializedName("foodie_color")
    var mFoodieColor: String = ""
    @SerializedName("profile_url")
    var mProfileUrl: String = ""
    @SerializedName("profile_deeplink")
    var mProfileDeepLink: String = ""
    @SerializedName("profile_image")
    var mProfileManager: String = ""
}