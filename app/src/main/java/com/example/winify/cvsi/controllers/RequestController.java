package com.example.winify.cvsi.controllers;

import com.example.winify.cvsi.interfaces.IRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diana on 7/13/16.
 */
public class RequestController {

    public static final String SERVER_URL = "http://192.168.3.191:8080/cvsi-server/";
    private IRetrofit iRetrofit;

    public RequestController() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.3.191:8000/dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iRetrofit = retrofit.create(IRetrofit.class);
    }

//    public void getPosts(Callback<ListDto<ProductTemplate>> listDtoCallback) {
//        iRetrofit.getAllProducts();
//    }
}
