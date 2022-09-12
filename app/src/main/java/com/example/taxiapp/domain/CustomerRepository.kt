package com.example.taxiapp.domain

import com.example.taxiapp.domain.models.Customer
import retrofit2.Response

interface CustomerRepository {
    suspend fun signUp(customer:Customer):Response<Customer>
    suspend fun signIn(userName:String,password:String):Response<Customer>
}