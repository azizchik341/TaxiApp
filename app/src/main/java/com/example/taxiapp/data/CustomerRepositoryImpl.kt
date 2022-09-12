package com.example.taxiapp.data

import com.example.taxiapp.domain.CustomerRepository
import com.example.taxiapp.domain.Utils
import com.example.taxiapp.domain.models.Customer
import retrofit2.Response

object CustomerRepositoryImpl: CustomerRepository {
    override suspend fun signUp(customer: Customer): Response<Customer> =
        RetrofitInstanse.api.signUp(1,Utils.CONTENT_TYPE,customer)


    override suspend fun signIn(userName: String, password: String): Response<Customer> =
        RetrofitInstanse.api.login(1,userName,password)
}