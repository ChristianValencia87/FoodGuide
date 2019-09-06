package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

data class UserRating(
        @SerializedName("aggregate_rating")
        val aggregate_rating: String,
        @SerializedName("rating_color")
        val rating_color: String,
        @SerializedName("rating_obj")
        val rating_obj: RatingObj,
        @SerializedName("rating_text")
        val rating_text: String,
        @SerializedName("votes")
        val votes: String
)