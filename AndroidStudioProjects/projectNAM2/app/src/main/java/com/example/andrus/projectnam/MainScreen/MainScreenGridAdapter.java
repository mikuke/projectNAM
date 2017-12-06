package com.example.andrus.projectnam.MainScreen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrus.projectnam.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainScreenGridAdapter extends RecyclerView.Adapter<MainScreenGridAdapter.GridView> {

    @Override
    public GridView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.adapter_main_screen, parent, false);

        return new GridView(view);
    }

    @Override
    public void onBindViewHolder(GridView holder, int position) {
        //Update
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class GridView extends RecyclerView.ViewHolder {
        @BindView(R.id.adapterMainScreen_moodIcon)
        ImageView moodIcon;
        @BindView(R.id.adapterMainScreen_moodText)
        TextView moodText;

        public GridView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
