package com.example.retrofitdemo.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitdemo.Model.PostModel;

import java.util.List;

public class PostListViewModel extends ViewModel {

    private MutableLiveData<List<PostModel>> mutableLiveData = new MutableLiveData<>();

    public PostListViewModel() {
    }

    public LiveData<List<PostModel>> getAll(){ return mutableLiveData; }
}
