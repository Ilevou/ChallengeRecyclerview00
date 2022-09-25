package com.ilektra.challengemyrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso


class MyAdapter(private val data: ArrayList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(property: String, index: Int) {
            val title = view.findViewById<TextView>(R.id.textView)
            val imageView = view.findViewById<ImageView>(R.id.imageView)

            Picasso.get()
                //+ System.currentTimeMillis() it is calling every millis a different url.
                .load("https://api.lorem.space/image/movie?=" + System.currentTimeMillis())
                .networkPolicy(NetworkPolicy.NO_STORE)
                .into(imageView)

            title.text = property
            view.setOnClickListener { deleteItem(index) }



        }

    }
    fun deleteEverything() {
        data.clear()
        notifyDataSetChanged()

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view1 =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
        return MyViewHolder(view1)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position], position)
    }
    fun deleteItem(index: Int) {
        data.removeAt(index)
        notifyDataSetChanged()
    }

}
