package com.example.andrus.projectnam.mooddetails;

import android.util.Log;

import com.example.andrus.projectnam.models.DetailMood;
import com.example.andrus.projectnam.util.http.APIClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MoodDetailRequester {
    final static String TAG = "Bilbo";

    static void getResponse(final MoodDetailPresenter presenter) {
        Log.i(TAG, "getResponse: before call");
        Call<DetailMood> detailMoodList = APIClient
                .getInstance()
                .getService()
                .getThirstyCategoryItems();

        detailMoodList.enqueue(new Callback<DetailMood>() {
            @Override
            public void onResponse(Call<DetailMood> call, Response<DetailMood> response) {
                Log.i(TAG, "onResponse:");
                presenter.successfulResponse(response.body());
            }

            @Override
            public void onFailure(Call<DetailMood> call, Throwable t) {
                Log.i(TAG, "onFailure: "+t);
                presenter.failureResponse(t);
            }
        });
    }
}