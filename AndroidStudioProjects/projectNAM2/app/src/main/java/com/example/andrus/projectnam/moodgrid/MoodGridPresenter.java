package com.example.andrus.projectnam.moodgrid;

import android.util.Log;

import com.example.andrus.projectnam.models.Mood;

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

    void failedRetrieval(Throwable t) {
        Log.i("presenter", "failedRetrieval: " + t);
    }
}
