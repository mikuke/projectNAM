package com.example.andrus.projectnam.mooddetails;

import com.example.andrus.projectnam.models.DetailMood;

import java.util.List;

public class MoodDetailPresenter {
    private MoodDetailInterface detailInterface;

    void getViewData(MoodDetailInterface detailInterface) {
        this.detailInterface = detailInterface;
        MoodDetailRequester.getResponse(this);
    }

    void successfulResponse(DetailMood detailMoods) {
        detailInterface.setDetailText(detailMoods);
    }

    void failureResponse(Throwable t) {

    }
}
