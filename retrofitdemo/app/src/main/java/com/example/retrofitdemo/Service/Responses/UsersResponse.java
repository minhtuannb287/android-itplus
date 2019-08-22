package com.example.retrofitdemo.Service.Responses;

import com.example.retrofitdemo.Model.PostModel;
import com.example.retrofitdemo.Model.UserModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersResponse {

    @SerializedName("users")
    @Expose
    private List<UserModel> users;

    public List<UserModel> getAll() { return users; }

    @Override
    public String toString() {
        return "PostSearchResponse{" +
                " postModels=" + users +
                '}';
    }
}
