package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

class ReviewsModel {
    @SerializedName("rating")
    var mRating: String = ""
    @SerializedName("review_text")
    var mReviewText: String = ""
    @SerializedName("id")
    var mId: String = ""
    @SerializedName("rating_color")
    var mRatingColor: String = ""
    @SerializedName("review_time_friendly")
    var mReviewTimeFriendly: String = ""
    @SerializedName("rating_text")
    var mRatingText: String = ""
    @SerializedName("timestamp")
    var mTimeStamp: String = ""
    @SerializedName("likes")
    var mLikes: String = ""
    @SerializedName("user")
    var mUser: UserModel = UserModel()
    @SerializedName("comments_count")
    var mCommentsCount: String = ""
}