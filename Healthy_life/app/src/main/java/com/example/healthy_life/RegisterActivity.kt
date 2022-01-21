package com.example.healthy_life

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var editEmail : EditText
    private lateinit var editPass : EditText
    private lateinit var editPassCh : EditText
    private lateinit var termsCheck : CheckBox
    private lateinit var regButton: Button
    private lateinit var termsButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
        registerListeners()
    }
    private fun init(){
        editEmail = findViewById(R.id.editEmail)
        editPass = findViewById(R.id.editPass)
        editPassCh = findViewById(R.id.editPassCh)
        termsCheck = findViewById(R.id.termsCheck)
        regButton = findViewById(R.id.regButton)
        termsButton = findViewById(R.id.termsButton)

        termsButton.setOnClickListener {
            startActivity(Intent(this, TermsActivity::class.java))
        }
    }
    private fun registerListeners(){

        regButton.setOnClickListener {
            val email = editEmail.text.toString()
            val password = editPass.text.toString()
            val passRepeat = editPassCh.text.toString()
            if (email.isEmpty() || password.isEmpty() || passRepeat.isEmpty()){
                Toast.makeText(this, "Please fill empty bars and agree with terms and conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!termsCheck.isChecked){
                Toast.makeText(this, "Please agree with terms and conditions", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (password.length != 8){
                Toast.makeText(this, "Password must contain min.8 symbols", Toast.LENGTH_SHORT).show()
            }
            if(password != passRepeat){
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        startActivity(Intent(this, UserMakeActivity::class.java))
                        Toast.makeText(
                            this,
                            "Registration has been completed successfully!",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    }else {
                        Toast.makeText(this, "Something went wrong please try again", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}