package com.example.seth.assignment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String h1,h2,h3,h4,h5,h6,h7,h8,h9,h10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Bundle in=getIntent().getExtras();
        h1=in.getString("h1");
        h2=in.getString("h2");
        h3=in.getString("h3");
        h4=in.getString("h4");
        h5=in.getString("h5");
        h6=in.getString("h6");
        h7=in.getString("h7");
        h8=in.getString("h8");
        h9=in.getString("h9");
        h10=in.getString("h10");

        h1=h1.substring(0,2)+"."+h1.substring(2,h1.length());
        h2=h2.substring(0,2)+"."+h2.substring(2,h2.length());
        h3=h3.substring(0,2)+"."+h3.substring(2,h3.length());
        h4=h4.substring(0,2)+"."+h4.substring(2,h4.length());
        h5=h5.substring(0,2)+"."+h5.substring(2,h5.length());
        h6=h6.substring(0,2)+"."+h6.substring(2,h6.length());
        h7=h7.substring(0,2)+"."+h7.substring(2,h7.length());
        h8=h8.substring(0,2)+"."+h8.substring(2,h8.length());
        h9=h9.substring(0,2)+"."+h9.substring(2,h9.length());
        h10=h10.substring(0,2)+"."+h10.substring(2,h10.length());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

/**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(40.010787,11.6257324);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Dan"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        LatLng sydney1 = new LatLng(23.079732,79.145508);
        mMap.addMarker(new MarkerOptions().position(sydney1).title("John"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney1));
        LatLng sydney2 = new LatLng(37.985339,37.985339);
        mMap.addMarker(new MarkerOptions().position(sydney2).title("Daniel"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney2));
        LatLng sydney3 = new LatLng(40.774042,-73.959961);
        mMap.addMarker(new MarkerOptions().position(sydney3).title("Johnny"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney3));
        LatLng sydney4 = new LatLng(36.155618, 13.9746094);
        mMap.addMarker(new MarkerOptions().position(sydney4).title("Makiyo"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney4));
    }
}
