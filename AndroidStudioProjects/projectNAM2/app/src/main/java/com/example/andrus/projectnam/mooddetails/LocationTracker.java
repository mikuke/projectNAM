package com.example.andrus.projectnam.mooddetails;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.andrus.projectnam.MainActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class LocationTracker extends AppCompatActivity {

    public static final int REQUEST_ACCESS_TO_COARSE_LOCATION = 1;
    private boolean permission;
    public static final String TAG = "Location";
    private FusedLocationProviderClient fusedLocation;
    private MainActivity mainActivity;
    public static Location location;

    LocationTracker(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public boolean checkPermissionRequestIfNot() {
        fusedLocation = LocationServices.getFusedLocationProviderClient(mainActivity);
        if (ContextCompat.checkSelfPermission(mainActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(mainActivity, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                ActivityCompat.requestPermissions(mainActivity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_ACCESS_TO_COARSE_LOCATION);
            } else {
                ActivityCompat.requestPermissions(mainActivity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_ACCESS_TO_COARSE_LOCATION);
            }
        } else {
            permission = true;
            trackCurrentLocation();
        }
        return permission;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //Permission granted!
            permission = true;
            trackCurrentLocation();
        } else {
            //Disable functionality
            permission = false;
        }
    }

    private void trackCurrentLocation() {
        if (permission) {
            fusedLocation.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
//                    if (location != null) {
                    LocationTracker.location = location;
//                    }
                }
            });
            fusedLocation.getLastLocation().addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.i(TAG, "6/7 onFailure: " + e);
                }
            });
        }
    }
}
