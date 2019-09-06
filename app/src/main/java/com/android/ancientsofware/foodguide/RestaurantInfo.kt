package com.android.ancientsofware.foodguide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RestaurantInfo : AppCompatActivity() {

    private lateinit var mName: TextView
    private lateinit var mAddress: TextView
    private lateinit var mCity: TextView
    private lateinit var mCousines: TextView
    private lateinit var mPhoneNumbers: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_info)

        var bundle = intent.extras

        mName = findViewById(R.id.name)
        mAddress = findViewById(R.id.address)
        mCity = findViewById(R.id.city)
        mCousines = findViewById(R.id.cousines)
        mPhoneNumbers = findViewById(R.id.phonenumbers)
        mName.setText( "Name: " +  bundle.getString("NAME") )
        mAddress.setText( "Address: " +  bundle.getString("ADDRESS") )
        mCity.setText( "City: " +  bundle.getString("CITY") )
        mCousines.setText( "Cousines: " +  bundle.getString("CUISINES") )
        mPhoneNumbers.setText( "Phone Numbers: " +  bundle.getString("PHONENUMBERS") )

    }
}
