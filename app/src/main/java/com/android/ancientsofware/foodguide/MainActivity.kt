package com.android.ancientsofware.foodguide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button);
        val intent = Intent(this, FoodMap::class.java)
        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                startActivity(intent)
            }})
    }

}
