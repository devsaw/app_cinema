package br.digitalhouse.app_cinema.ui.viewmodel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import kotlinx.coroutines.withContext

class ContaViewModel(application: Application) : AndroidViewModel(application) {
    val IMAGE_CAPTURE_CODE = 1000
    val IMAGE_STORAGE_CODE = 2000

    private val requestPic = MutableLiveData<Boolean>()
    val takeAPicLiveData: LiveData<Boolean> = requestPic

    private val requestStore = MutableLiveData<Boolean>()
    val findPicLiveData: LiveData<Boolean> = requestStore


    fun permissionOpenStorage(){
        if (ContextCompat.checkSelfPermission(
                getApplication(),
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                getApplication(),
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), IMAGE_STORAGE_CODE
            )
        } else {
            requestStore.value = true
        }
    }

    fun permissionTakeAPicture(){
        if (ContextCompat.checkSelfPermission(
                getApplication(),
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                getApplication(),
                arrayOf(android.Manifest.permission.CAMERA), IMAGE_CAPTURE_CODE
            )
        } else {
            requestPic.value = true
        }
    }
}