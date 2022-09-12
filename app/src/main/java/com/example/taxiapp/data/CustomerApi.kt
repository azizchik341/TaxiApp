package com.example.taxiapp.data

import com.example.taxiapp.domain.models.Customer
import retrofit2.Response
import retrofit2.http.*

interface CustomerApi {

    @POST("users")
    suspend fun signUp(
        @Header("X-Parse-Revocable-Session") session: Int,
        @Header("Content-Type") type: String,
        @Body user: Customer,
    ):Response<Customer>

    @GET("login")
    suspend fun login(
        @Header("X-Parse-Revocable-Session") session: Int,
        @Query("username") username: String,
        @Query("password") password: String,
    ):Response<Customer>
}