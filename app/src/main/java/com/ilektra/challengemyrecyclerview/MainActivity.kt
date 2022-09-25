package com.ilektra.challengemyrecyclerview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ilektra.challengemyrecyclerview.R

class MainActivity : AppCompatActivity(){
    private lateinit var editText: EditText
    private val data = ArrayList<String>()
    private lateinit var button: Button
    private lateinit var adapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editTextAddItems)
        button = findViewById(R.id.button)

        button.setOnClickListener { view ->



            val message = editText.text.toString()
            if ( message.isNotEmpty() ) {
                if (data.size > 10 ) {
                    Toast.makeText(this, "You added already 10 items ", Toast.LENGTH_SHORT).show()
                }  else {
                    data.add(message)
                    data.sort()

                    Snackbar.make(view, "Item added successfully  ", Snackbar.LENGTH_LONG)
                        .setAction("Item added successfully", null)
                        .show()
                }
                editText.text.clear()

            }

        }







    }
    private fun setRecyclerView() {
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.RecyclerView)
        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        // This will pass the ArrayList to our Adapter
        adapter = MyAdapter(data)
        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        recyclerview.setHasFixedSize(true)
    }
    class CustomClass {
        var item: String = ""

    }
}