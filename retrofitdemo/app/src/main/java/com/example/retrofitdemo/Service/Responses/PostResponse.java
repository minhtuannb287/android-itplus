package com.example.retrofitdemo.Service.Responses;

import com.example.retrofitdemo.Model.PostModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostResponse {

    @SerializedName("post")
    @Expose
    private PostModel postModel;

    public PostModel getPostModel(){ return  postModel; }

    @Override
    public String toString() {
        return "PostResponse{" +
                "postModel=" + postModel +
                '}';
    }
}
