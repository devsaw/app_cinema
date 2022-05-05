package br.digitalhouse.app_cinema.fragments.conta.view

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
import br.digitalhouse.app_cinema.redefinirsenha.view.TelaRedefinirSenhaActivity

class ContaFragment : Fragment(R.layout.fragment_conta) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        botaoTirar()
        botaoAbrir()
        botaoRedefinir()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val foto = data?.getParcelableExtra<Bitmap>("data")
            var imageView = view?.findViewById<ImageView>(R.id.imageViewConta)
            imageView?.setImageBitmap(foto)

            var extras = data?.extras
            var img = extras!!.get("data")
            imageView?.setImageBitmap(img as Bitmap)

        }

        if (requestCode == 2) {
            val source = ImageDecoder.createSource(requireContext().contentResolver, data?.data!!)
            val bitmap = ImageDecoder.decodeBitmap(source)
            var imageView = view?.findViewById<ImageView>(R.id.imageViewConta)
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
                var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, 1)
            }
        }

        if (requestCode == 2) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                var intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, 2)
            }
        }
    }

    fun botaoAbrir() {
        val buttonAbrir = view?.findViewById<Button>(R.id.btnAbrir)
        buttonAbrir?.setOnClickListener { validaAbrir() }
    }

    fun botaoTirar() {
        val buttonTirar = view?.findViewById<Button>(R.id.btnTirar)
        buttonTirar?.setOnClickListener { validaTirar() }
    }

    fun validaTirar() {
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
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 1)
        }
    }


    fun validaAbrir() {
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
            var intent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 2)
        }
    }


    fun botaoRedefinir(){
        var botaoRedefinir = view?.findViewById<Button>(R.id.btnContaRedefinirSenha)
        botaoRedefinir?.setOnClickListener{
            var intentRedefinir = Intent(requireContext(), TelaRedefinirSenhaActivity::class.java)
            startActivity(intentRedefinir)
        }
    }


}