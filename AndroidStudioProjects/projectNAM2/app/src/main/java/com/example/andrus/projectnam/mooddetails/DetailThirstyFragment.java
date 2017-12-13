package com.example.andrus.projectnam.mooddetails;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andrus.projectnam.MainActivity;
import com.example.andrus.projectnam.R;
import com.example.andrus.projectnam.models.DetailMood;
import com.example.andrus.projectnam.models.OfferListByCategory;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailThirstyFragment extends Fragment implements MoodDetailInterface {
    @BindView(R.id.fragmentDetailThirsty_header)
    TextView detailHeader;
    @BindView(R.id.fragmentDetailThirsty_deal)
    TextView detailDeal;
    @BindView(R.id.fragmentDetailThirsty_advertisement)
    TextView detailAdvertisement;
    private Location destination = new Location("destination");
    private float distance;

    public static DetailThirstyFragment newInstance() {
        return new DetailThirstyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_detail_thirsty, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        new MoodDetailPresenter(this).getViewData();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void getDistance(OfferListByCategory category) {
        Location currentLocation = LocationTracker.location;
        double destLat = category.locationLat;
        double destLong = category.LocationLong;
        destination.setLatitude(destLat);
        destination.setLongitude(destLong);
        distance = currentLocation.distanceTo(destination);//Meters
    }

    @Override
    public void setDetailText(DetailMood detailList) {
        OfferListByCategory offerList = detailList.OfferListByCategory.get(0);

        detailHeader.setText(detailList.offerTitle);
        detailDeal.setText(offerList.offerDescription);

        setDistance(detailList);
    }

    @SuppressLint("SetTextI18n")
    public void setDistance(DetailMood detailList) {
        boolean havePermission = new LocationTracker((MainActivity) getActivity()).checkPermissionRequestIfNot();
        if (havePermission && LocationTracker.location != null) {
            getDistance(detailList.OfferListByCategory.get(0));
            detailAdvertisement.setText(detailList.companyName + " just " + distance);
        } else {
            detailAdvertisement.setText("No connection");
        }
    }

}