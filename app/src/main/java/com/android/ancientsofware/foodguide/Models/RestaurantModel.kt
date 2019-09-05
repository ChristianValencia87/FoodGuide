package com.android.ancientsofware.foodguide.Models

import com.google.gson.annotations.SerializedName

class RestaurantModel {
    @SerializedName("id")
    var mId: Int = 0;
    @SerializedName("name")
    var mName: String = ""
    @SerializedName("url")
    var mUrl: String = ""
    @SerializedName("location")
    var mLocation: LocationModel = LocationModel()
    @SerializedName("average_cost_for_two")
    var mAverageCost2: String = ""
    @SerializedName("price_range")
    var mPriceRange: String = ""
    @SerializedName("currency")
    var mCurrency: String = ""
    @SerializedName("thumb")
    var mThumb: String = ""
    @SerializedName("featured_image")
    var mFeatureImage: String = ""
    @SerializedName("photos_url")
    var mPhotosUrl: String = ""
    @SerializedName("menu_url")
    var mMenuUrl: String = ""
    @SerializedName("events_url")
    var mEventsUrl: String = ""
    @SerializedName("user_rating")
    var mUserRating: UserRatingModel = UserRatingModel()
    @SerializedName("has_online_delivery")
    var mHasOnlineDelivery: String = ""
    @SerializedName("is_delivering_now")
    var mIsDeliveringNow: String = ""
    @SerializedName("has_table_booking")
    var mHasTableBooking: String = ""
    @SerializedName("deeplink")
    var mDeepLink: String = ""
    @SerializedName("cuisines")
    var mCuisines: String = ""
    @SerializedName("all_reviews_count")
    var mAllReviewsCount: String = ""
    @SerializedName("photo_count")
    var mPhotoCount: String  = ""
    @SerializedName("phone_numbers")
    var mPhoneNumbers: String = ""
    @SerializedName("photos")
    var mPhotos: ArrayList<PhotosModel> = ArrayList<PhotosModel>()
    @SerializedName("all_reviews")
    var mReviews: ArrayList<ReviewsModel> = ArrayList<ReviewsModel>()
}