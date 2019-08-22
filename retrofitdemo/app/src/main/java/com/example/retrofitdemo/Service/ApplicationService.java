package com.example.retrofitdemo.Service;

import com.example.retrofitdemo.Model.UserModel;
import com.example.retrofitdemo.Service.Responses.PostResponse;
import com.example.retrofitdemo.Service.Responses.PostSearchResponse;
import com.example.retrofitdemo.Util.ConstantUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApplicationService {

    //User
    @GET(ConstantUtil.Config.USER_ALL_API)
    Call<List<UserModel>> listUser();

    @GET(ConstantUtil.Config.USER_GET_API)
    Call<List<UserModel>> getOne(@Path("id") int id);

    @POST(ConstantUtil.Config.USER_POST_API)
    Call<UserModel> createUser(@Body UserModel userModel);

    @DELETE(ConstantUtil.Config.USER_DELETE_API)
    Call<String> deleteUser(@Path("id") int id);
}
