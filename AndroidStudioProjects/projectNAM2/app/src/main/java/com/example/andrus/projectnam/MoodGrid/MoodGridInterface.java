package com.example.andrus.projectnam.MoodGrid;

import com.example.andrus.projectnam.Models.Mood;
import com.example.andrus.projectnam.Models.Moods;

import java.util.List;

public interface MoodGridInterface {
    void setGridLogoAndText(List<Mood> moodsList);
    void notLoading();
    void loading();

}
