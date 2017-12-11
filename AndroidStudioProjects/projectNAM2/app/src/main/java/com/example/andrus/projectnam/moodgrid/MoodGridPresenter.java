package com.example.andrus.projectnam.moodgrid;

import android.util.Log;

import com.example.andrus.projectnam.models.Category;

import java.util.List;

class MoodGridPresenter {
    private MoodGridFragment moodGrid;

    MoodGridPresenter(MoodGridFragment moodGrid) {
        this.moodGrid = moodGrid;
    }

    void getMoodList() {
        MoodGridRequester.getServerResponse(this);
    }

    void successfulRetrieval(List<Category> moodList) {
        Log.i("presenter", "successfulRetrieval: Success");
        moodGrid.setGridLogoAndText(moodList);

    }

    void failedRetrieval(Throwable t) {
        Log.i("presenter", "failedRetrieval: " + t);
    }
}
