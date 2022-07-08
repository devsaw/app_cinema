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
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.ui.viewmodel.ContaViewModel

class ContaFragment : Fragment(R.layout.fragment_conta) {
    private lateinit var accViewModel: ContaViewModel
    private lateinit var imageView: ImageView
    private lateinit var btnShare: Button
    private lateinit var btnTakePic: Button
    private lateinit var btnOpenStore: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        accViewModel = ViewModelProvider(this).get(ContaViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        clickListener()
        observerSetup()
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
        if (requestCode == accViewModel.IMAGE_CAPTURE_CODE) {
            val foto = data?.getParcelableExtra<Bitmap>("data")

            imageView.setImageBitmap(foto)
            val extras = data?.extras
            val img = extras!!.get("data")
            imageView.setImageBitmap(img as Bitmap)
        }

        if (requestCode == accViewModel.IMAGE_STORAGE_CODE) {
            val source = ImageDecoder.createSource(requireContext().contentResolver, data?.data!!)
            val bitmap = ImageDecoder.decodeBitmap(source)
            imageView.setImageBitmap(bitmap)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == accViewModel.IMAGE_CAPTURE_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, accViewModel.IMAGE_CAPTURE_CODE)
            }
        }

        if (requestCode == accViewModel.IMAGE_STORAGE_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, accViewModel.IMAGE_STORAGE_CODE)
            }
        }
    }

    private fun clickListener() {
        btnOpenStore.setOnClickListener { accViewModel.permissionOpenStorage() }

        btnTakePic.setOnClickListener { accViewModel.permissionTakeAPicture() }

        btnShare.setOnClickListener {
            val intentShared = Intent(Intent.ACTION_SEND)
            intentShared.type = "text/plain"
            intentShared.putExtra(
                Intent.EXTRA_TEXT,
                "Olá, eu estou usando o aplicativo Cine EX para gerenciar meus filmes, venha você também!"
            )
            startActivity(intentShared)
        }
    }

    private fun observerSetup() {
        accViewModel.takeAPicLiveData.observe(viewLifecycleOwner) { status ->
            when (status) {
                true -> openCam()
                false -> Log.i("TIRAR_FOTO", "Ação cancelada")
            }
        }

        accViewModel.findPicLiveData.observe(viewLifecycleOwner) { status ->
            when (status) {
                true -> openStorage()
                false -> Log.i("ESCOLHER_FOTO", "Ação cancelada")
            }
        }
    }

    private fun openCam() {
        val intentCapture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intentCapture, accViewModel.IMAGE_CAPTURE_CODE)
    }

    private fun openStorage() {
        val intentStorage = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intentStorage, accViewModel.IMAGE_STORAGE_CODE)
    }
}