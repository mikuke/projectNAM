package com.example.andrus.projectnam.MainScreen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrus.projectnam.R;


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
        //TODO JSON image and text
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class GridView extends RecyclerView.ViewHolder {
        ImageView moodIcon;
        TextView moodText;

        public GridView(View itemView) {
            super(itemView);
            moodIcon = itemView.findViewById(R.id.adapterMainScreen_moodIcon);
            moodText = itemView.findViewById(R.id.adapterMainScreen_moodText);
        }
    }
}
