package com.example.driverapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.driverapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signInBtn.setOnClickListener {
            openDialog()
        }
    }
    fun openDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("SING UP")
        val layout = LayoutInflater.from(this).inflate(R.layout.diolog_item, null)
        dialog.setView(layout)
        val userEmail = layout.findViewById<EditText>(R.id.email_ed)
        val userName = layout.findViewById<EditText>(R.id.username)
        val userPhone = layout.findViewById<EditText>(R.id.phone_ed)
        val userPassword = layout.findViewById<EditText>(R.id.password_ed)
        dialog.setPositiveButton(
            "REGISTER"
        ) { p0, p1 ->
            userEmail.text.toString()
            userName.text.toString()
            userPhone.text.toString()
            userPassword.text.toString()
        }
        dialog.setNegativeButton(
            "Cancel"
        ) { dialogInterface, p1 -> dialogInterface?.dismiss() }
        dialog.show()
    }

}