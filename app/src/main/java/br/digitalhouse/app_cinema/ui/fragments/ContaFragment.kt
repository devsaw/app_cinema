package br.digitalhouse.app_cinema.ui.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.ui.interfaces.MessageInterface
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class ContaFragment : Fragment(R.layout.fragment_conta), MessageInterface {
    private lateinit var imageView: ImageView
    private lateinit var btnShare: Button
    private lateinit var btnTakePic: Button
    private lateinit var btnOpenStore: Button
    private var resultBitMap: Bitmap? = null
    private val IMAGE_CAPTURE_CODE = 1
    private val IMAGE_STORAGE_CODE = 2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        clickListener()
    }

    private fun initView() {
        btnShare = requireView().findViewById(R.id.btnCompartilhar)
        btnTakePic = requireView().findViewById(R.id.btnTirar)
        btnOpenStore = requireView().findViewById(R.id.btnAbrir)
        imageView = requireView().findViewById(R.id.imageViewConta)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_CAPTURE_CODE) {
            val foto = data?.getParcelableExtra<Bitmap>("data")
            imageView.setImageBitmap(foto)
            val extras = data?.extras
            val img = extras!!.get("data") as Bitmap
            imageView.setImageBitmap(img)
            resultBitMap = img
        }

        if (requestCode == IMAGE_STORAGE_CODE) {
            val source = ImageDecoder.createSource(requireContext().contentResolver, data?.data!!)
            val bitmap = ImageDecoder.decodeBitmap(source)
            imageView.setImageBitmap(bitmap)
            resultBitMap = bitmap
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == IMAGE_CAPTURE_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, IMAGE_CAPTURE_CODE)
            }
        }

        if (requestCode == IMAGE_STORAGE_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, IMAGE_STORAGE_CODE)
            }
        }
    }

    fun permissionOpenStorage() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), IMAGE_STORAGE_CODE
            )
        } else {
            val intentStorage =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intentStorage, IMAGE_STORAGE_CODE)
        }
    }

    fun permissionTakeAPicture() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(android.Manifest.permission.CAMERA), IMAGE_CAPTURE_CODE
            )
        } else {
            val intentCapture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intentCapture, IMAGE_CAPTURE_CODE)
        }
    }


    private fun sharedInfo() {
        val shareIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Olá, eu estou usando o aplicativo Cine EX para gerenciar meus filmes, venha você também!")
        }
        startActivity(shareIntent)
    }

    private fun clickListener() {
        btnOpenStore.setOnClickListener { permissionOpenStorage() }

        btnTakePic.setOnClickListener { permissionTakeAPicture() }

        btnShare.setOnClickListener { sharedInfo() }
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}