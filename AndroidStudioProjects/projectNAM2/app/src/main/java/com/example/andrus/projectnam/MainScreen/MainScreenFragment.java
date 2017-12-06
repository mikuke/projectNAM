package com.example.andrus.projectnam.MainScreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrus.projectnam.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainScreenFragment extends Fragment {
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

        initialize();
        showGrid();
    }

    private void initialize() {
        mainLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        mainAdapter = new MainScreenGridAdapter();
    }

    private void showGrid() {
        mainRecyclerView.setLayoutManager(mainLayoutManager);
        mainRecyclerView.setAdapter(mainAdapter);
    }
}
