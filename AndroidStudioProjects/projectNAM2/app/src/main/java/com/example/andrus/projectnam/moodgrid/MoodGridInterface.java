package com.example.andrus.projectnam.moodgrid;

import com.example.andrus.projectnam.models.Mood;

import java.util.List;

public interface MoodGridInterface {
    void setGridLogoAndText(List<Mood> moodsList);
    void notLoading();
    void loading();

}
