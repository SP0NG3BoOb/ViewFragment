package com.example.fakebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    private lateinit var logInButton : Button
    private lateinit var rregistration : Button
    private lateinit var resPassword : Button
    private lateinit var email : EditText
    private lateinit var password : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        logInButton = findViewById(R.id.logInButton)
        rregistration = findViewById(R.id.rregistration)
        resPassword = findViewById(R.id.resPassword)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

        logInButton.setOnClickListener {
            val email : String = email.text.toString()
            val password : String = password.text.toString()

            if (email.isEmpty() && password.isEmpty()){

                Toast.makeText(this, "Please enter your info", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        homePage()
                    }
                    else {
                        Toast.makeText(this, "Something's wrong. please try again", Toast.LENGTH_SHORT).show()
                    }
                }

        }
        rregistration.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }
        resPassword.setOnClickListener {
            val email = email.text.toString()
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if(task.isSuccessful){
                    Toast.makeText(this, "Please Check E-mail", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Something's wrong please try again", Toast.LENGTH_SHORT).show()
                }

            }

        }
    }
    private fun homePage(){
        startActivity(Intent(this, LoggedIn::class.java))
    }


}