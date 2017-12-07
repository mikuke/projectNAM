package com.example.andrus.projectnam.MoodGrid;

import android.util.Log;

import com.example.andrus.projectnam.Models.Mood;

import java.util.List;

class MoodGridPresenter {
    private MoodGridFragment moodGrid;

    MoodGridPresenter(MoodGridFragment moodGrid) {
        this.moodGrid = moodGrid;
    }

    void getMoodList() {
        MoodGridRequester.getServerResponse(this);
    }

    void successfulRetrieval(List<Mood> moodList) {
        Log.i("presenter", "successfulRetrieval: Success");
        moodGrid.setGridLogoAndText(moodList);
    }

    void failedRetrieval() {
        Log.i("presenter", "failedRetrieval: it failed");
    }
}
