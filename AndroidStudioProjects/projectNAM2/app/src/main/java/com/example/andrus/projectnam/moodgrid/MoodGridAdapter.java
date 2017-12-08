package com.example.andrus.projectnam.moodgrid;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.andrus.projectnam.models.Mood;
import com.example.andrus.projectnam.mooddetails.MoodDetailFragment;
import com.example.andrus.projectnam.MainActivity;
import com.example.andrus.projectnam.R;

import java.io.UnsupportedEncodingException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MoodGridAdapter extends RecyclerView.Adapter<MoodGridAdapter.GridView> {
    private List<Mood> category;
    private MainActivity mainActivity;

    MoodGridAdapter(List<Mood> category, MainActivity mainActivity) {
        this.category = category;
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
        Mood mood = category.get(position);
        holder.moodText.setText(mood.categoryName);


        //TODO remove this.
        byte[] decodedString = Base64.decode(String.valueOf(mood.categoryLogo), Base64.DEFAULT);

        Glide.with(mainActivity)
                .load(decodedString)
                .asBitmap()
                .into(holder.moodIcon);

    }

    @Override
    public int getItemCount() {
        return category.size();
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
                    openDetailFragmentAndPass(category.get(getAdapterPosition()).categoryId);
                }
            });
        }
    }

    private void openDetailFragmentAndPass(int id) {
        MoodDetailFragment fragment = MoodDetailFragment.newInstance(id);
        FragmentManager manager = mainActivity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainActivity_frameLayout, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
