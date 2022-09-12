package com.example.taxiapp.domain.usecases

import com.example.taxiapp.domain.CustomerRepository
import com.example.taxiapp.domain.models.Customer

class SignUpUseCase(private val repository: CustomerRepository) {
    suspend fun execute(cutomer:Customer) = repository.signUp(cutomer)
}