package com.example.a5101k.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a5101k.Models.Story
import com.example.a5101k.R
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(var context: Context, var items: ArrayList<Story>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_item, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is StoryViewHolder){
            Glide.with(context).load(story.image).into(holder.image)
            holder.name.text = story.name
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }

    class StoryViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ShapeableImageView = view.findViewById(R.id.s_image)
        var name: TextView = view.findViewById(R.id.s_name)
    }
}