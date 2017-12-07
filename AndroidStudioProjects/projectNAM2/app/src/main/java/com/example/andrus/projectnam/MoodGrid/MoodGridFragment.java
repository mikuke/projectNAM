package com.example.andrus.projectnam.MoodGrid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrus.projectnam.MainActivity;
import com.example.andrus.projectnam.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MoodGridFragment extends Fragment implements MoodGridInterface {
    @BindView(R.id.fragmentMainScreen_recyclerView)
    RecyclerView mainRecyclerView;
    RecyclerView.LayoutManager mainLayoutManager;
    RecyclerView.Adapter mainAdapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_main_screen, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        showGrid();
    }

    private void showGrid() {
        String[] windows = {"Thirsty", "Hungry", "Sleepy", "Fuel"};
        mainLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        mainAdapter = new MoodGridAdapter(windows, (MainActivity) getActivity());
        mainRecyclerView.setLayoutManager(mainLayoutManager);
        mainRecyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void setGridLogoAndText() {
        hideProgressBar();
    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showProgressBar() {

    }
}
