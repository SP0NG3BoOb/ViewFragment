package com.example.fakebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class SettingsFragment : Fragment(R.layout.activity_home_fragment) {
    private lateinit var logOut : Button
    private lateinit var reButton : Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logOut = view.findViewById(R.id.logOut)
        reButton = view.findViewById(R.id.logOut)

        logOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent())

        }
    }
}
