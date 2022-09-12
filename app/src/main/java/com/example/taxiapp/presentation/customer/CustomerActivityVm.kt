package com.example.taxiapp.presentation.customer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taxiapp.data.CustomerRepositoryImpl
import com.example.taxiapp.domain.models.Customer
import com.example.taxiapp.domain.usecases.SignUpUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class CustomerActivityVm:ViewModel() {
    private val repository = CustomerRepositoryImpl
    private val signUp = SignUpUseCase(repository)

    private val _customer:MutableLiveData<Response<Customer>> = MutableLiveData()
    val customer:LiveData<Response<Customer>> get() = _customer

    private val _error:MutableLiveData<String> = MutableLiveData()
    val error:LiveData<String> get() = _error

    fun signUp(customer:Customer) = viewModelScope.launch {

        try {
            val response = signUp.execute(customer)
            if (response.isSuccessful){
                _customer.value = response
            }
        }catch (e:Exception){}

    }
}