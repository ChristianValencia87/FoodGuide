package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

class UserRatingModel {
    @SerializedName("aggregate_rating")
    var mAggregateRating: String = ""
    @SerializedName("rating_text")
    var mRatingText: String = ""
    @SerializedName("rating_color")
    var mRatingColor: String = ""
    @SerializedName("votes")
    var mVotes: String = ""
}