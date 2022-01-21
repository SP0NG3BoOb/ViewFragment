package com.example.healthy_life.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.healthy_life.R
import com.example.healthy_life.UserInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var welcomeText : TextView
    private lateinit var breakfastButton: Button
    private lateinit var lunchButton: Button
    private lateinit var dinnerButton: Button
    private lateinit var waterButton: Button
    private lateinit var waterText: TextView
    private lateinit var userGuy: TextView
    private var calories = 0.0
    private var litres = 1.0

    private val db = FirebaseDatabase.getInstance("https://healthy-life-5604b-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("UserInfo")
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo = snapshot.getValue(UserInfo::class.java)?: return
                userGuy.text = userInfo.userN
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        welcomeText = view.findViewById(R.id.welcomeText)
        breakfastButton = view.findViewById(R.id.breakfastButton)
        lunchButton = view.findViewById(R.id.lunchButton)
        dinnerButton = view.findViewById(R.id.dinnerButton)
        waterButton = view.findViewById(R.id.waterButton)
        waterText = view.findViewById(R.id.waterText)
        userGuy = view.findViewById(R.id.userGuy)

        val controller = Navigation.findNavController(view)


        waterButton.setOnClickListener {
            var add = litres++
            waterText.setText("You drank: $add L").toString()



        }
        breakfastButton.setOnClickListener {
            controller.navigate(HomeFragmentDirections.actionHomeFragmentToFoodFragment())
        }
        lunchButton.setOnClickListener {
            controller.navigate(HomeFragmentDirections.actionHomeFragmentToFoodFragment())
        }
        dinnerButton.setOnClickListener {
            controller.navigate(HomeFragmentDirections.actionHomeFragmentToFoodFragment())
        }



    }



}