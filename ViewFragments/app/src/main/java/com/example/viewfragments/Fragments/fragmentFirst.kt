package com.example.viewfragments.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.viewfragments.R

class fragmentFirst : Fragment(R.layout.fragment_first) {
    private lateinit var enterUrl: EditText
    private lateinit var saveButton: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterUrl = view.findViewById(R.id.enterUrl)
        saveButton = view.findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            var enter = enterUrl.text.toString()
            if (enter.isEmpty()) {
                Toast.makeText(activity, "enter url and try again", Toast.LENGTH_SHORT).show()

            } else{


            }
        }
    }

}