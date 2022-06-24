package br.digitalhouse.app_cinema.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.LruCache
import android.widget.EditText
import android.widget.ImageView
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

object ImageDownloader {
    private var memoryCash: LruCache<String, Bitmap>

    init {
        val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
        val cashSize = maxMemory / 8

        memoryCash = object : LruCache<String, Bitmap>(cashSize) {
            override fun sizeOf(key: String, value: Bitmap): Int {
                return value.byteCount / 1024
            }
        }
    }

    fun download(imageView: ImageView, url: String) {
        Thread {
            val connection = URL(url).openConnection() as HttpURLConnection

            try {
                val respCode = connection.responseCode
                if (respCode == 200) {
                    val conn = connection.inputStream
                    val bitmap = BitmapFactory.decodeStream(conn)
                    imageView.setImageBitmap(bitmap)

                    memoryCash.put(url, bitmap)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }
}