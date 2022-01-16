package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class PrifileActivity : AppCompatActivity() {

    private lateinit var textView2: TextView
    private lateinit var buttonPasswordChange: Button
    private lateinit var buttonLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prifile)

        init()
        registerListeners()


        textView2.text = FirebaseAuth.getInstance().currentUser?.uid



    }

    private fun init() {
        textView2 = findViewById(R.id.textView2)
        buttonPasswordChange = findViewById(R.id.buttonPasswordChange)
        buttonLogout = findViewById(R.id.buttonLogout)
    }


    private fun registerListeners(){
        buttonLogout.setOnClickListener {
           FirebaseAuth.getInstance().signOut()
           startActivity(Intent(this, LoginActivity::class.java))
           finish()

        }

        buttonPasswordChange.setOnClickListener {
            startActivity(Intent(this, PasswordChangeActivity::class.java))
        }

    }

}