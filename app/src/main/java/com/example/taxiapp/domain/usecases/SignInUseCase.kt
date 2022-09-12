package com.example.taxiapp.domain.usecases

import com.example.taxiapp.domain.CustomerRepository
import com.example.taxiapp.domain.models.Customer

class SignInUseCase(private val repository: CustomerRepository) {
    suspend fun execute(userName: String,password:String) = repository.signIn(userName,password)
}