package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

data class AllReviews(
        @SerializedName("reviews")
        val reviews: List<Any>
)