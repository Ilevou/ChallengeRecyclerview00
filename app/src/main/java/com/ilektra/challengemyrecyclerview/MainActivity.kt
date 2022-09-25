package com.ilektra.challengemyrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.ilektra.challengemyrecyclerview.R

class MainActivity : AppCompatActivity(){
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editTextAddItems)
        button = findViewById(R.id.button)







    }
}