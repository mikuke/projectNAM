package com.example.andrus.projectnam.MainScreen;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrus.projectnam.DetailScreen.DetailScreenFragment;
import com.example.andrus.projectnam.MainActivity;
import com.example.andrus.projectnam.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainScreenGridAdapter extends RecyclerView.Adapter<MainScreenGridAdapter.GridView> {
    private String[] windows;
    private MainActivity mainActivity;

    MainScreenGridAdapter(String[] windows, MainActivity mainActivity) {
        this.windows = windows;
        this.mainActivity = mainActivity;
    }

    @Override
    public GridView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.adapter_main_screen, parent, false);

        return new GridView(view);
    }

    @Override
    public void onBindViewHolder(GridView holder, int position) {
        holder.moodText
                .setText(windows[position]);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class GridView extends RecyclerView.ViewHolder {
        @BindView(R.id.adapterMainScreen_moodIcon)
        ImageView moodIcon;
        @BindView(R.id.adapterMainScreen_moodText)
        TextView moodText;

        GridView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDetailFragment(windows[getAdapterPosition()]);
                }
            });
        }
    }

    private void showDetailFragment(String window) {
        DetailScreenFragment fragment = DetailScreenFragment.newInstance(window);
        FragmentManager manager = mainActivity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainActivity_frameLayout, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
