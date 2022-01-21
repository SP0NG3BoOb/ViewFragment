package com.example.healthy_life

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UserMakeActivity : AppCompatActivity() {
    private lateinit var userEdit : EditText
    private lateinit var urlEdit : EditText
    private lateinit var homeButton: Button
    private lateinit var applyButton: Button
    private lateinit var userPic : ImageView
    private lateinit var userName : TextView
    private val db = FirebaseDatabase.getInstance("https://healthy-life-5604b-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("UserInfo")
    private val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_make)
        init()
        regListeners()

        db.child(auth.currentUser?.uid!!).addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo = snapshot.getValue(UserInfo::class.java)?: return
                userName.text = userInfo.userN
                Glide.with(this@UserMakeActivity)
                    .load(userInfo.url)
                    .placeholder(R.drawable.ic_baseline_person_24)
                    .circleCrop()
                    .into(userPic)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun init(){
        userEdit = findViewById(R.id.userEdit)
        urlEdit = findViewById(R.id.urlEdit)
        homeButton = findViewById(R.id.homeButton)
        applyButton = findViewById(R.id.applyButton)
        userPic = findViewById(R.id.userPic)
        userName = findViewById(R.id.userName)

        homeButton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
    private fun regListeners(){

        applyButton.setOnClickListener {
            val userN = userEdit.text.toString()
            val url = urlEdit.text.toString()
            val userInfo = UserInfo(userN, url)
            if (userN.isEmpty() && url.isEmpty()){
                Toast.makeText(this, "there is nothing to save", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (url.isNotEmpty()){
                val userInfo = UserInfo(userN, url)
                db.child(auth.currentUser?.uid!!).setValue(userInfo)
            }

            if (userN.isNotEmpty()){
                val userInfo = UserInfo(userN, url)
                db.child(auth.currentUser?.uid!!).setValue(userInfo)
            }
            if (url.isNotEmpty() && userN.isNotEmpty()){
                val userInfo = UserInfo(userN,url)

                db.child(auth.currentUser?.uid!!).setValue(userInfo)
            }
            db.child(auth.currentUser?.uid!!).setValue(userInfo)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Settings applied successfully!", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(this, "Something went wrong! Try again!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }


        }
    }
}