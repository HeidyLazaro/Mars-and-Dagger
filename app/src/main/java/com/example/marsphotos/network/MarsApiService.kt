package com.example.marsphotos.network
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

//Constante para la URL base del servicio web
private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

//Compilador de retrofit
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

//Como se comunica retrofit con el servidor web
interface MarsApiService {
    //Ontiene la respuesta del servidor web
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

//Inicializa el servicio retrofit
object MarsApi{
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}