package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

data class RatingObj(
        @SerializedName("bg_color")
        val bg_color: BgColor,
        @SerializedName("title")
        val title: Title
)