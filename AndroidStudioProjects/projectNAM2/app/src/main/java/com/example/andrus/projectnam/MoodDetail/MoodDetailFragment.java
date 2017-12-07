package com.example.andrus.projectnam.MoodDetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrus.projectnam.R;


public class MoodDetailFragment extends Fragment {

    private String gridImageText;

    public static MoodDetailFragment newInstance(String iconText) {
        MoodDetailFragment fragment = new MoodDetailFragment();
        fragment.gridImageText = iconText;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_detail_thirsty, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
