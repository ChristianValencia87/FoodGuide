package com.android.ancientsofware.foodguide

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog
import com.android.ancientsofware.foodguide.Models.RestaurantModel
import com.android.ancientsofware.foodguide.RetroFitApi.RestaurantsNearByWorker
import com.google.android.gms.location.*

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class FoodMap : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var mLastLocation: Location
    private lateinit var mLocationRequest: LocationRequest
    private lateinit var mFusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var mSavedLocation: LatLng
    private lateinit var mRestaurantsNearByWorker: RestaurantsNearByWorker
    private var mRestaurantsNearByList: ArrayList<RestaurantModel>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_map)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps()
        }

        mRestaurantsNearByWorker = RestaurantsNearByWorker()

    }

    override fun onPause() {
        super.onPause()
        stoplocationUpdates()
        saveLastLocation()
    }

    override fun onResume() {
        super.onResume()
        if(checkPermissionForLocation(this))
            startLocationUpdates()

    }

    fun initializeSavedLastLocation() {
        val sharedPreference =  getSharedPreferences("FOOD_GUIDE",Context.MODE_PRIVATE)
        val lastLocationExist = sharedPreference.getBoolean("LAST_LOCATION", false)
        if(lastLocationExist) {
            var latitude = sharedPreference.getLong("LAST_LOCATION_LATITUDE", 0)
            var longitude = sharedPreference.getLong("LAST_LOCATION_LONGITUDE", 0)

            mSavedLocation = LatLng(latitude.toDouble(), longitude.toDouble())
        }
    }

    fun saveLastLocation() {
        if(::mLastLocation.isInitialized) {
            val sharedPreference = getSharedPreferences("FOOD_GUIDE", Context.MODE_PRIVATE)
            var editor = sharedPreference.edit()
            editor.putBoolean("LAST_LOCATION", true)
            editor.putLong("LAST_LOCATION_LATITUDE", mLastLocation.latitude.toLong())
            editor.putLong("LAST_LOCATION_LONGITUDE", mLastLocation.longitude.toLong())
            editor.commit()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.setMinZoomPreference(14.0f);
        mMap.setMaxZoomPreference(20.0f);
        if(::mLastLocation.isInitialized) {
            val location = LatLng(mLastLocation.latitude, mLastLocation.longitude)
            mMap.addMarker(MarkerOptions().position(location).title("You"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(location))
        }
        else {
            initializeSavedLastLocation()
            if(::mSavedLocation.isInitialized) {
                mMap.addMarker(MarkerOptions().position(mSavedLocation).title("You"))
                mMap.moveCamera(CameraUpdateFactory.newLatLng(mSavedLocation))
            }
        }
    }

    fun checkPermissionForLocation(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (context.checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED){
                true
            }else{
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                        1)
                false
            }
        } else {
            true
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
        }
    }


    private fun buildAlertMessageNoGps() {

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    startActivityForResult(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                            , 11)
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.cancel()
                    finish()
                }
        val alert: AlertDialog = builder.create()
        alert.show()
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            locationResult.lastLocation
            onLocationChanged(locationResult.lastLocation)
        }
    }

    fun onLocationChanged(location: Location) {

        mLastLocation = location
        if (mLastLocation != null) {
            mRestaurantsNearByWorker.getUsers(mLastLocation.latitude.toString(), mLastLocation.longitude.toString())
            mRestaurantsNearByList = mRestaurantsNearByWorker.mRestaurants
            onMapReady(mMap)
        }
    }

    protected fun startLocationUpdates() {

        mLocationRequest = LocationRequest()
        mLocationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest!!.setInterval(2000)
        mLocationRequest!!.setFastestInterval(1000)

        val builder = LocationSettingsRequest.Builder()
        builder.addLocationRequest(mLocationRequest!!)
        val locationSettingsRequest = builder.build()

        val settingsClient = LocationServices.getSettingsClient(this)
        settingsClient.checkLocationSettings(locationSettingsRequest)

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        mFusedLocationProviderClient!!.requestLocationUpdates(mLocationRequest, mLocationCallback,
                Looper.myLooper())
    }

    private fun stoplocationUpdates() {
        mFusedLocationProviderClient!!.removeLocationUpdates(mLocationCallback)
    }
}
