package br.digitalhouse.app_cinema.data

import android.util.Log
import br.digitalhouse.app_cinema.data.dto.MoviesInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/"

private val interceptor = HttpLoggingInterceptor {
    Log.d("RETROFIT_CLIENT", it)
}
    .apply { level = HttpLoggingInterceptor.Level.BODY }

private val client = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()

val filmesApi: MoviesInterface = retrofit.create(MoviesInterface::class.java)