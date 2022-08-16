package com.example.a5101k.Models

class Feeds {
     var stories: ArrayList<Story> = ArrayList()
    var post: Post? = null

    constructor(post: Post){
       this.post = post
    }

    constructor(stories: ArrayList<Story>){
        this.stories = stories
    }

}