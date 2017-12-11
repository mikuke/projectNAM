package com.example.andrus.projectnam.util.http;


import com.example.andrus.projectnam.models.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("5a29408e2e00000f1ea09b40")
    Call<List<Category>> getMoodGridIconAndText();

    
}
