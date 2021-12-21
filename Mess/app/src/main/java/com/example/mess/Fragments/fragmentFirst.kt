package com.example.mess.Fragments

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Filter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mess.MainActivity
import com.example.mess.R

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




