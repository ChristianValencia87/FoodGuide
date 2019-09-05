package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

class PhotosModel {
    @SerializedName("id")
    var mId: String = ""
    @SerializedName("url")
    var mUrl: String = ""
    @SerializedName("thumb_url")
    var mThumbUrl: String = ""
    @SerializedName("user")
    var mUser: UserModel = UserModel()
    @SerializedName("res_id")
    var mResId: String = ""
    @SerializedName("caption")
    var mCaption: String = ""
    @SerializedName("timestamp")
    var mTimeStamp: String = ""
    @SerializedName("friendly_time")
    var mFriendlyTime: String = ""
    @SerializedName("width")
    var mWidth: String = ""
    @SerializedName("height")
    var mHeight: String  = ""
    @SerializedName("comments_count")
    var mCommentsCount: String = ""
    @SerializedName("likes_count")
    var mLikesCount: String = ""
}