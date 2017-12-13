package com.example.andrus.projectnam.mooddetails;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    private double LocationLat = 58.253819;
    private double LocationLong = 22.489079;
    public double distanceLat;
    public double distanceLong;
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 1;
    private LocationManager locationManager;


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
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        new MoodDetailPresenter(this).getViewData();
    }

    @Override
    public void onResume() {
        super.onResume();
//        calculateDistance();
        updateLocation();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setDetailText(DetailMood detailList) {
        OfferListByCategory offerList = detailList.OfferListByCategory.get(0);
//        calculateDistance();

        detailHeader.setText(detailList.offerTitle);
        detailDeal.setText(offerList.offerDescription);
        detailAdvertisement.setText(detailList.companyName + " just ");
    }


    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    private void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.setTitle("Enable Location")
                .setMessage("Your Locations Settings is set to 'Off'.\nPlease Enable Location to " +
                        "use this app")
                .setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(myIntent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    }
                });
        dialog.show();
    }

    public void updateLocation() {
        if (!isLocationEnabled()) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }

    private static final LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            final double distanceLat = location.getLatitude();
            Log.i("Please", "onLocationChanged: " + location.getLongitude());

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

}