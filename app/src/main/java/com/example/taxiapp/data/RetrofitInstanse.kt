package com.example.taxiapp.data

import com.example.taxiapp.domain.Utils.Companion.API_KEY
import com.example.taxiapp.domain.Utils.Companion.APPLICATION_ID
import com.example.taxiapp.domain.Utils.Companion.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanse {
    val requestInterceptor = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .addHeader("X-Parse-Application-Id",APPLICATION_ID)
            .addHeader("X-Parse-REST-API-Key",API_KEY)
            .build()
        return@Interceptor chain.proceed(request)
    }


    private val loggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(requestInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: CustomerApi by lazy {
        retrofit.create(CustomerApi::class.java)
    }

}