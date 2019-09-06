package com.android.ancientsofware.foodguide.Utils

import android.graphics.BitmapFactory
import android.graphics.Bitmap
import java.io.InputStream


class ImageLoader {

    fun loadImage(path: InputStream): Bitmap?  {
        val icon = BitmapFactory.decodeStream(path)
        return icon
    }

}