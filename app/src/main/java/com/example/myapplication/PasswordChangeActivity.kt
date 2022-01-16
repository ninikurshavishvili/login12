package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {

    private lateinit var editTextTextPassword: EditText
    private lateinit var buttonPasswordChange: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)

        init()
        registerListeners()
    }

    private fun init() {
        editTextTextPassword = findViewById(R.id.editTextTextPassword)
        buttonPasswordChange = findViewById(R.id.buttonPasswordChange)
    }

    private fun registerListeners() {
        buttonPasswordChange.setOnClickListener {
            val newPassword = editTextTextPassword.text.toString()
            if(newPassword.isEmpty()){
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            }
            FirebaseAuth
                .getInstance().currentUser
                ?.updatePassword(newPassword)
                ?.addOnCompleteListener{ task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }

}