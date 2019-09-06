package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

data class HasMenuStatus(
        @SerializedName("delivery")
        val delivery: String,
        @SerializedName("takeaway")
        val takeaway: String
)