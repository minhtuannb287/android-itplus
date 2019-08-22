package com.example.retrofitdemo.Service;

import com.example.retrofitdemo.Util.ConstantUtil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(ConstantUtil.Config.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());


    private static Retrofit retrofit = builder.build();

    private static ApplicationService applicationService = retrofit.create(ApplicationService.class);

    public static ApplicationService getUsers(){ return applicationService; }

}
