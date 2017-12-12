package com.example.andrus.projectnam.mooddetails;

import android.util.Log;

import com.example.andrus.projectnam.models.DetailMood;

class MoodDetailPresenter {
    private MoodDetailInterface detailInterface;
    public String TAG = "Bilbo";

    MoodDetailPresenter(MoodDetailInterface detailInterface) {
        this.detailInterface = detailInterface;
    }

    void getViewData() {
        Log.i(TAG, "getViewData:");
        MoodDetailRequester.getResponse(this);
    }

    void successfulResponse(DetailMood detailMoods) {
        Log.i(TAG, "successfulResponse:");
        detailInterface.setDetailText(detailMoods);
    }

    void failureResponse(Throwable t) {

    }
}
