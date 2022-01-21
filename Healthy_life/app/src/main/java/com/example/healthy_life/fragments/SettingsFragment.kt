package com.example.healthy_life.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.healthy_life.LoginActivity
import com.example.healthy_life.R
import com.example.healthy_life.TermsActivity
import com.example.healthy_life.UserMakeActivity
import com.google.firebase.auth.FirebaseAuth

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var logOutButton: Button
    private lateinit var termsButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logOutButton = view.findViewById(R.id.logOutButton)
        termsButton = view.findViewById(R.id.termsButton)

        logOutButton.setOnClickListener {
            AlertDialog.Builder(activity)
                .setTitle("ARE YOU SURE?")
                .setMessage("Do you really want to log out?")
                .setPositiveButton("LOG OUT") {dialog, i ->
                    FirebaseAuth.getInstance().signOut()
                    startActivity(Intent(activity, LoginActivity::class.java))
                    Toast.makeText(activity, "You logged out!", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                .setNegativeButton("CANCEL"){dialog, i ->
                    dialog.dismiss()
                }.show()
        }

        termsButton.setOnClickListener {
            startActivity(Intent(activity, TermsActivity::class.java))
        }

    }
}