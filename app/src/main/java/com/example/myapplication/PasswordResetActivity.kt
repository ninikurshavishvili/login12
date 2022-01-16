package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordResetActivity : AppCompatActivity() {
    private lateinit var editTextTextEmail: EditText
    private lateinit var buttonSendEmail: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)
        init()
        registerListeners()
    }

    private fun init(){
        buttonSendEmail.findViewById<Button>(R.id.buttonSendEmail)
        editTextTextEmail.findViewById<EditText>(R.id.editTextTextEmail)

        }
    private fun registerListeners(){
        buttonSendEmail.setOnClickListener {
            val email = editTextTextEmail.text.toString()
            if(email.isEmpty()){
                Toast.makeText(this,"Empty Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "chek email", Toast.LENGTH_SHORT).show()
                    }

                    }




                }
        }

    }



