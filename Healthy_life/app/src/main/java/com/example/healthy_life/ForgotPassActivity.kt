package com.example.healthy_life

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPassActivity : AppCompatActivity() {
    private lateinit var emailEdit : EditText
    private lateinit var nextButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)
        init()
        regListeners()
    }
    private fun init(){
        emailEdit = findViewById(R.id.emailEdit)
        nextButton = findViewById(R.id.nextButton)
    }
    private fun regListeners(){
        nextButton.setOnClickListener {
            val email = emailEdit.text.toString()
            if (email.isEmpty()){
                Toast.makeText(this, "Please insert your email and try again!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                        Toast.makeText(
                            this,
                            "Password updater is sent to your email! Please check your email!",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {
                        Toast.makeText(this, "Something went wrong please try again!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}