package com.example.andrus.projectnam.MoodGrid;

import com.example.andrus.projectnam.Models.Mood;
import com.example.andrus.projectnam.Models.Moods;
import com.example.andrus.projectnam.util.http.APIClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MoodGridRequester {

    static void getServerResponse(final MoodGridPresenter presenter) {
        Call<List<Mood>> response = APIClient
                .getInstance()
                .getService()
                .getMoodGridIconAndText();

        response.enqueue(new Callback<List<Mood>>() {
            @Override
            public void onResponse(Call<List<Mood>> call, Response<List<Mood>> response) {
                presenter.successfulRetrieval(response.body());
            }

            @Override
            public void onFailure(Call<List<Mood>> call, Throwable t) {
                presenter.failedRetrieval();
            }
        });
    }
}
