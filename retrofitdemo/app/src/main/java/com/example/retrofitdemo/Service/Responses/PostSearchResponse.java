package com.example.retrofitdemo.Service.Responses;

import com.example.retrofitdemo.Model.PostModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostSearchResponse {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("posts")
    @Expose
    private List<PostModel> postModels;

    public int getCount() { return  count; }

    public List<PostModel> getPostModels() { return postModels; }

    @Override
    public String toString() {
        return "PostSearchResponse{" +
                "count=" + count +
                ", postModels=" + postModels +
                '}';
    }
}
