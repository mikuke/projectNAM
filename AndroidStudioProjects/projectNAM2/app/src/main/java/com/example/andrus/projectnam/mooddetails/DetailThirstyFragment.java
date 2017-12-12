package com.example.andrus.projectnam.mooddetails;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andrus.projectnam.R;
import com.example.andrus.projectnam.models.DetailMood;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailThirstyFragment extends Fragment implements MoodDetailInterface {
    @BindView(R.id.fragmentDetailThirsty_header)
    TextView detailHeader;
    @BindView(R.id.fragmentDetailThirsty_deal)
    TextView detailDeal;
    @BindView(R.id.fragmentDetailThirsty_advertisement)
    TextView detailAdvertisement;
    public String TAG = "Bilbo";

    public static DetailThirstyFragment newInstance() {
        return new DetailThirstyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.i(TAG, "onCreateView: yup");
        return inflater.inflate(R.layout.fragment_detail_thirsty, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        new MoodDetailPresenter(this).getViewData();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setDetailText(DetailMood detailList) {
        String just = getString(R.string.advertisement);
        Log.i(TAG, "setDetailText: " + detailList);
        detailHeader.setText(detailList.offerTitle);
        detailDeal.setText(detailList.OfferListByCategory.get(0).offerDescription);
        detailAdvertisement.setText(detailList.companyName + " just ");
    }
}
