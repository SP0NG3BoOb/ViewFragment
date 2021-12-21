package com.example.viewfragments.Fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.viewfragments.R

class fragmentThird: Fragment(R.layout.fragment_third) {
    private lateinit var enterText : EditText
    private lateinit var addButton : Button
    private lateinit var addedText : TextView
    private lateinit var clearButton: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterText = view.findViewById(R.id.enterText)
        addButton = view.findViewById(R.id.addButton)
        addedText = view.findViewById(R.id.addedText)
        clearButton = view.findViewById(R.id.clearButton)
        addButton.setOnClickListener {
            val note = enterText.text.toString()
            val text = addedText.text.toString()
            val result = note + "\n" + text
            addedText.text = result

        }
        clearButton.setOnClickListener {
            var words = addedText.text.toString()
            if (words.isEmpty()){
                Toast.makeText(activity, "There is nothing to delete", Toast.LENGTH_SHORT).show()
            } else {
                addedText.text = ""
            }
        }
    }

}