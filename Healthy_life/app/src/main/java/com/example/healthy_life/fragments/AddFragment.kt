package com.example.healthy_life.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.healthy_life.LoginActivity
import com.example.healthy_life.R
import com.example.healthy_life.UserInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AddFragment : Fragment(R.layout.fragment_add) {
    private lateinit var userPicture : ImageView
    private lateinit var userUser : TextView
    private lateinit var addButton: Button
    private lateinit var clearButton: Button
    private lateinit var addedText: TextView
    private lateinit var weightEditText: EditText
    private val db = FirebaseDatabase.getInstance("https://healthy-life-5604b-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("UserInfo")
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo = snapshot.getValue(UserInfo::class.java)?: return
                userUser.text = userInfo.userN
                Glide.with(this@AddFragment)
                    .load(userInfo.url)
                    .placeholder(R.drawable.ic_baseline_person_24)
                    .circleCrop()
                    .into(userPicture)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addButton = view.findViewById(R.id.addButton)
        clearButton = view.findViewById(R.id.clearButton)
        addedText = view.findViewById(R.id.addedText)
        weightEditText = view.findViewById(R.id.weightEditText)
        userPicture = view.findViewById(R.id.userPicture)
        userUser = view.findViewById(R.id.userUser)



        val sharedPreferences = this.activity?.getSharedPreferences("THIS_ONE", 0)
        val texts = sharedPreferences?.getString("NOTES", "")
        addedText.text = texts
        addButton.setOnClickListener {
            val note = weightEditText.text.toString()
            val text = addedText.text.toString()
            val result = note + "\n" + text

            if (note.isEmpty()){
                Toast.makeText(activity, "There is nothing to add", Toast.LENGTH_SHORT).show()
            }

            addedText.text = result
            sharedPreferences?.edit()
                ?.putString("NOTES", result)
                ?.apply()
        }
        clearButton.setOnClickListener {
            AlertDialog.Builder(activity)
                .setTitle("Are you sure?")
                .setMessage("Do you really want to clear your parameters?")
                .setPositiveButton("CLEAR") {dialog, i ->
                    var words = addedText.text.toString()
                    if(words.isEmpty()){
                        Toast.makeText(activity, "There is nothing to delete", Toast.LENGTH_SHORT).show()
                    } else {
                        addedText.text = ""
                        sharedPreferences?.edit()
                            ?.putString("NOTES", "")
                            ?.apply()

                    }
                    dialog.dismiss()
                }
                .setNegativeButton("CANCEL") {dialog, i ->
                    dialog.dismiss()
                }.show()


        }


    }
}