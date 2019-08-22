package com.example.retrofitdemo.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitdemo.Model.PostModel;
import com.example.retrofitdemo.Model.UserModel;

import java.util.List;

public class UserListViewModel extends ViewModel {

    private MutableLiveData<List<UserModel>> mutableLiveData = new MutableLiveData<>();

    public UserListViewModel() {
    }

    public LiveData<List<UserModel>> getAll(){ return mutableLiveData; }
}
