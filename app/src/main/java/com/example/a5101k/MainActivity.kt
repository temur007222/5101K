package com.example.a5101k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a5101k.Adapters.FeedAdapter
import com.example.a5101k.Adapters.StoryAdapter
import com.example.a5101k.Models.Feeds
import com.example.a5101k.Models.Post
import com.example.a5101k.Models.Story

class MainActivity : AppCompatActivity() {
   lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView(){
        recyclerView = findViewById(R.id.rv_main)
        recyclerView.layoutManager = GridLayoutManager(this,1)
        refreshAdapter(getAll(), recyclerView)
    }

    private fun refreshAdapter(stories: ArrayList<Feeds>, recyclerView: RecyclerView) {
        val adapter = FeedAdapter(this, stories)
        recyclerView.adapter = adapter
    }

    private fun getAll(): ArrayList<Feeds>{
        val story = ArrayList<Story>()
        val feed = ArrayList<Feeds>()

        story.add(Story(R.drawable.volkswagen, "Anna"))
        story.add(Story(R.drawable.nat, "Mark"))
        story.add(Story(R.drawable.gtr, "Sarah"))
        story.add(Story(R.drawable.nat, "Anna"))
        story.add(Story(R.drawable.volkswagen, "Mark"))
        story.add(Story(R.drawable.gtr, "Sarah"))
        story.add(Story(R.drawable.volkswagen, "Anna"))
        story.add(Story(R.drawable.nat, "Mark"))
        story.add(Story(R.drawable.gtr, "Sarah"))
        story.add(Story(R.drawable.nat, "Anna"))
        story.add(Story(R.drawable.volkswagen, "Mark"))
        story.add(Story(R.drawable.gtr, "Sarah"))

        feed.add(Feeds(story))
        feed.add(Feeds(Post(R.drawable.gtr, R.drawable.volkswagen, "Sarah")))
        feed.add(Feeds(Post(R.drawable.nissan, R.drawable.nat, "Mark")))
        feed.add(Feeds(Post(R.drawable.volkswagen, R.drawable.gtr, "Sarah")))
        feed.add(Feeds(Post(R.drawable.nat, R.drawable.nissan, "Traver")))
        feed.add(Feeds(Post(R.drawable.gtr, R.drawable.volkswagen, "Lili")))
        feed.add(Feeds(Post(R.drawable.nissan, R.drawable.gtr, "Sarah")))
        return feed
    }

}