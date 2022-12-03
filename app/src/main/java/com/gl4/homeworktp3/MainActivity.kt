package com.gl4.homeworktp3

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // define the global variable
    private lateinit var question1: TextView
    // Add button Move to Activity
    private lateinit var nextActivityButton: Button
    private var theme: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // by ID we can use each component which id is assign in xml file
        // use findViewById() to get the Button
        nextActivityButton = findViewById(R.id.first_activity_button)
        question1 = findViewById(R.id.question1_id)

        // In question1 get the TextView use by findViewById()
        // In TextView set question Answer for message
        "Q1 - How to pass the data between activities in Android? Ans - Intent".trimIndent()
            .also { question1.text = it }

        // Add_button add clicklistener
        nextActivityButton.setOnClickListener {
            // Intents are objects of the android.content.Intent type. Your code can send them to the Android system defining
            // the components you are targeting. Intent to start an activity called SecondActivity with the following code.
            val intent = Intent(this, SecondActivity::class.java)
            // start the activity connect to the specified class
            startActivity(intent)
        }
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#F4D35E")))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.action_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_switch)
        {
            changeTheme()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun changeTheme() {
        /*val toast = Toast.makeText(applicationContext, "clicked", Toast.LENGTH_LONG)
        toast.show()*/
        theme = !theme
        if(theme) {
            supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#0D3B66")))
        }else {
            supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#F4D35E")))
        }

    }
}
