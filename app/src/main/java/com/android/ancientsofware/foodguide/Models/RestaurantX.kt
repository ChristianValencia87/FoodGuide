package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

data class RestaurantX(
        @SerializedName("R")
        val R: R,
        @SerializedName("all_reviews")
        val all_reviews: AllReviews,
        @SerializedName("all_reviews_count")
        val all_reviews_count: String,
        @SerializedName("apikey")
        val apikey: String,
        @SerializedName("average_cost_for_two")
        val average_cost_for_two: String,
        @SerializedName("book_again_url")
        val book_again_url: String,
        @SerializedName("book_form_web_view_url")
        val book_form_web_view_url: String,
        @SerializedName("cuisines")
        val cuisines: String,
        @SerializedName("currency")
        val currency: String,
        @SerializedName("deeplink")
        val deeplink: String,
        @SerializedName("establishment")
        val establishment: List<Any>,
        @SerializedName("establishment_types")
        val establishment_types: List<Any>,
        @SerializedName("events_url")
        val events_url: String,
        @SerializedName("featured_image")
        val featured_image: String,
        @SerializedName("has_online_delivery")
        val has_online_delivery: String,
        @SerializedName("has_table_booking")
        val has_table_booking: String,
        @SerializedName("highlights")
        val highlights: List<String>,
        @SerializedName("id")
        val id: String,
        @SerializedName("include_bogo_offers")
        val include_bogo_offers: Boolean,
        @SerializedName("is_book_form_web_view")
        val is_book_form_web_view: String,
        @SerializedName("is_delivering_now")
        val is_delivering_now: String,
        @SerializedName("is_table_reservation_supported")
        val is_table_reservation_supported: String,
        @SerializedName("is_zomato_book_res")
        val is_zomato_book_res: String,
        @SerializedName("location")
        val location: Location,
        @SerializedName("menu_url")
        val menu_url: String,
        @SerializedName("mezzo_provider")
        val mezzo_provider: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("offers")
        val offers: List<Any>,
        @SerializedName("opentable_support")
        val opentable_support: String,
        @SerializedName("phone_numbers")
        val phone_numbers: String,
        @SerializedName("photo_count")
        val photo_count: String,
        @SerializedName("photos_url")
        val photos_url: String,
        @SerializedName("price_range")
        val price_range: String,
        @SerializedName("switch_to_order_menu")
        val switch_to_order_menu: String,
        @SerializedName("thumb")
        val thumb: String,
        @SerializedName("timings")
        val timings: String,
        @SerializedName("url")
        val url: String,
        @SerializedName("user_rating")
        val user_rating: UserRating
)
