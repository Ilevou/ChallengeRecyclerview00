package com.ilektra.challengemyrecyclerview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ilektra.challengemyrecyclerview.R

class MainActivity : AppCompatActivity(){
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var adapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editTextAddItems)
        button = findViewById(R.id.button)







    }
}