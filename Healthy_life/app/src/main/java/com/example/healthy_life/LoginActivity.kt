package com.example.healthy_life

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.healthy_life.fragments.HomeFragment
import com.example.healthy_life.fragments.HomeFragmentDirections
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var forgotPass: Button
    private lateinit var logButton: Button
    private lateinit var regButton: Button
    private lateinit var emailEdit: EditText
    private lateinit var passwordEdit: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (FirebaseAuth.getInstance().currentUser != null){
            startActivity(Intent(this, HomeActivity::class.java))
        }
        setContentView(R.layout.activity_login)
        init()
        registerListeners()
    }

    private fun init() {
        forgotPass = findViewById(R.id.forgotPass)
        logButton = findViewById(R.id.logButton)
        regButton = findViewById(R.id.regButton)
        emailEdit = findViewById(R.id.emailEdit)
        passwordEdit = findViewById(R.id.passwordEdit)

    }

    private fun registerListeners() {
        regButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        forgotPass.setOnClickListener {
            startActivity(Intent(this, ForgotPassActivity::class.java))
        }
        logButton.setOnClickListener {
            val email = emailEdit.text.toString()
            val pass = passwordEdit.text.toString()

            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please write email or password and try again",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, HomeActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "User Not Found!", Toast.LENGTH_SHORT).show()
                    }
                }


        }
    }
}
