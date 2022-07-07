package br.digitalhouse.app_cinema.ui.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import br.digitalhouse.app_cinema.R

class ContaFragment : Fragment(R.layout.fragment_conta) {
    private lateinit var botaoCompartilhar: Button
    private lateinit var botaoTirar: Button
    private lateinit var botaoAbrir: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        botaoCompartilhar = view.findViewById(R.id.btnCompartilhar)
        botaoTirar = view.findViewById(R.id.btnTirar)
        botaoAbrir = view.findViewById(R.id.btnAbrir)
        clickListener()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val foto = data?.getParcelableExtra<Bitmap>("data")
            val imageView = view?.findViewById<ImageView>(R.id.imageViewConta)
            imageView?.setImageBitmap(foto)
            val extras = data?.extras
            val img = extras!!.get("data")
            imageView?.setImageBitmap(img as Bitmap)
        }

        if (requestCode == 2) {
            val source = ImageDecoder.createSource(requireContext().contentResolver, data?.data!!)
            val bitmap = ImageDecoder.decodeBitmap(source)
            val imageView = view?.findViewById<ImageView>(R.id.imageViewConta)
            imageView?.setImageBitmap(bitmap)
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, 1)
            }
        }

        if (requestCode == 2) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, 2)
            }
        }
    }

    private fun validaTirar() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this.requireActivity(),
                arrayOf(android.Manifest.permission.CAMERA),
                1
            )
        } else {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 1)
        }
    }


    private fun validaAbrir() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this.requireActivity(),
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 2
            )
        } else {
            val intent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 2)
        }
    }


    private fun clickListener() {
        botaoAbrir.setOnClickListener { validaAbrir() }
        botaoTirar.setOnClickListener { validaTirar() }
        botaoCompartilhar.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Olá, eu estou usando o aplicativo Cine EX para gerenciar meus filmes, venha você também!"
            )
            startActivity(intent)
        }
    }

}