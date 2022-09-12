package com.example.taxiapp.presentation.customer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.taxiapp.R
import com.example.taxiapp.databinding.ActivityMainBinding
import com.example.taxiapp.databinding.DiologItemBinding
import com.example.taxiapp.domain.models.Customer

class CustomerActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: CustomerActivityVm by lazy {
        CustomerActivityVm()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button2.setOnClickListener {
            register()
        }
    }

    private fun register() {
        val builder = AlertDialog.Builder(this@CustomerActivity)
        val dialogLayout = (DiologItemBinding.inflate(layoutInflater))
        with(builder) {
            setTitle("SIGN UP")
            setMessage("Please use email to register")
            setPositiveButton("Register") { dialog, wich ->
                viewModel.signUp(
                    Customer(
                        null,
                        dialogLayout.username.text.toString(),
                        dialogLayout.passwordEd.text.toString(),
                        dialogLayout.emailEd.text.toString(),
                        dialogLayout.phoneEd.text.toString()
                    )
                )
            }
            setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
        }
        builder.setView(dialogLayout.root).show()
    }

//

}