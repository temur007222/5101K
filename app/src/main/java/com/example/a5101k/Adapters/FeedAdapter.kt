package com.example.a5101k.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a5101k.Models.Feeds
import com.example.a5101k.Models.Story
import com.example.a5101k.R
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(var context: Context, var items: ArrayList<Feeds>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

     private var ADDSTORY = 0
    private var STORY = 1

    override fun getItemViewType(position: Int): Int {
        if (isHeader(position))
            return ADDSTORY
        return STORY
    }

    private fun isHeader(position: Int): Boolean {
        return position == 0
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ADDSTORY) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.story_rv, parent, false)
            return CreateViewHolder(context,view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is CreateViewHolder){
            val recyclerView=holder.recyclerView
            refreshAdapter(story.stories, recyclerView )
        }

        if (holder is StoryViewHolder) {
            val tv_fullname = holder.tv_fullname

           Glide.with(context).load(story.post?.photo).into(holder.post)
            Glide.with(context).load(story.post?.profile).into(holder.profile)
            tv_fullname.text = story.post?.name
        }
    }

    private fun refreshAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context, stories)
        recyclerView.adapter = adapter
    }

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var post: ImageView = view.findViewById(R.id.iv_photo)
        var profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var tv_fullname: TextView = view.findViewById(R.id.tv_fullname)
    }

    class CreateViewHolder(context: Context,view: View):RecyclerView.ViewHolder(view){
        var recyclerView: RecyclerView = view.findViewById(R.id.rv_story)

        init {
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.layoutManager = manager
        }
    }

}