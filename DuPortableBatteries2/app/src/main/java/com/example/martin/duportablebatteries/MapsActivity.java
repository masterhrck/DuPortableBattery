package com.example.martin.duportablebatteries;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompatBase;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Url;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, Callback<List<Battery>> {

    private GoogleMap mMap;
    private List<Battery> batList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.16.0.121")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IDuPortableService service = retrofit.create(IDuPortableService.class);
        Call<List<Battery>> batteriesCall = service.getBatteries(true, 1,1,1 );

            batteriesCall.enqueue(this);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng RoyalPrincess = new LatLng(42.65857458990684, 18.06070938706398);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(RoyalPrincess));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent intent = new Intent(MapsActivity.this, displayData.class);

                String id = marker.getTitle();



                Battery bat = batList.get(Integer.parseInt(id)-1);

                intent.putExtra("id",marker.getTitle());
                intent.putExtra("percent",bat.getPercent());
                intent.putExtra("state",bat.getState());
                intent.putExtra("posX",bat.getPosX());
                intent.putExtra("posY",bat.getPosY());
                intent.putExtra("time",bat.getTime());

                startActivity(intent);

                return true;
            }

        });

    }

    @Override
    public void onResponse(Call<List<Battery>> call, Response<List<Battery>> response) {
        batList = response.body();

        for(Battery bat : batList){
            LatLng gps = new LatLng(Double.parseDouble(bat.getPosX()), Double.parseDouble(bat.getPosY()));
            mMap.addMarker(new MarkerOptions().position(gps).title(bat.getId()));

        }

    }

    @Override
    public void onFailure(Call<List<Battery>> call, Throwable t) {
        Toast.makeText(this, "Error loading data", Toast.LENGTH_SHORT).show();
    }
}
