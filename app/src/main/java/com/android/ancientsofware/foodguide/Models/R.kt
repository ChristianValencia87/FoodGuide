package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

data class R(
        @SerializedName("has_menu_status")
        val has_menu_status: HasMenuStatus,
        @SerializedName("res_id")
        val res_id: String
)