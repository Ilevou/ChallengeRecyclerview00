package com.ilektra.challengemyrecyclerview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.ilektra.challengemyrecyclerview.R
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(){
    private lateinit var fab: FloatingActionButton
    private lateinit var editText: EditText
    private val data = ArrayList<String>()
    private lateinit var button: Button
    private lateinit var adapter: MyAdapter
    private lateinit var imageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editTextAddItems)
        button = findViewById(R.id.button)
        fab = findViewById(R.id.floatingActionButton)
        imageView = findViewById(R.id.imageView)
        button.setOnClickListener { view ->



            val message = editText.text.toString()
            if ( message.isNotEmpty() ) {
                if (data.size > 10 ) {
                    Toast.makeText(this, "You added already 10 items ", Toast.LENGTH_SHORT).show()
                }  else {
                    data.add(message)
                    data.sort()
                    adapter.notifyDataSetChanged()


                    Snackbar.make(view, "Item added successfully  ", Snackbar.LENGTH_SHORT)
                        .setAction("Item added successfully", null)
                        .show()
                }
                editText.text.clear()

            }

        }

        fab.setOnClickListener {
            adapter.deleteEverything()

        }

        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imageView);
        setRecyclerView()


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
}
