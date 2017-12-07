package com.example.andrus.projectnam.util.http;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.mocky.io/v2/")
            .addConverterFactory(new GsonConverterFactory())
            .build();
}
