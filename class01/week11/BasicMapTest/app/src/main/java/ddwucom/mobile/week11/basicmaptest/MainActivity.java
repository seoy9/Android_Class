package ddwucom.mobile.week11.basicmaptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    final static int PERMISSION_REQ_CODE = 100;
    public final static String TAG = "FetchAddress";

    private GoogleMap mGoogleMap;
    private LocationManager locManager;

    private Marker centerMarker;

    private PolylineOptions pOptions;

    private ArrayList<Marker> markerList;

    TextView textView;

    private Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(mapReadyCallback);

        pOptions = new PolylineOptions();
        pOptions.color(Color.RED);
        pOptions.width(5);

        textView = findViewById(R.id.textView);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                locationUpdate();
                break;
            case R.id.btnStop:
                locManager.removeUpdates(locationListener);
                break;
        }
    }

    private void locationUpdate() {
        if (checkPermission()) {
            locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, locationListener);
        }
    }

    private void findAddress(LatLng latLng) {
        Double latitude = latLng.latitude;
        Double longitude = latLng.longitude;
        String adr = "";

        List<Address> address = null;

        try {
            address = geocoder.getFromLocation(latitude, longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(address == null || address.size() == 0) {
            Log.e(TAG, "주소를 찾을 수 없습니다");
        } else {
            Address addressList = address.get(0);
            ArrayList<String> addressFragments = new ArrayList<String>();

            for(int i = 0; i <= addressList.getMaxAddressLineIndex(); i++) {
                addressFragments.add(addressList.getAddressLine((i)));
            }
            Log.i(TAG, "주소를 찾았습니다");
            adr = TextUtils.join(System.getProperty("line.separator"), addressFragments)

            ;
        }
        Toast.makeText(MainActivity.this, adr, Toast.LENGTH_SHORT).show();
    }

    OnMapReadyCallback mapReadyCallback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mGoogleMap = googleMap;
            geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            markerList = new ArrayList<Marker>();

            LatLng currentLoc = new LatLng(37.6071587, 127.0429439);
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLoc, 17));

            String str = String.format("위도:%.6f, 경도:%.6f", currentLoc.latitude, currentLoc.longitude);

            MarkerOptions options = new MarkerOptions();
            options.position(currentLoc);
            options.title("현재 위치");
            options.snippet(str);
            options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

            centerMarker = mGoogleMap.addMarker(options);

            mGoogleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    marker.showInfoWindow();
                    return true;
                }
            });

            mGoogleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    LatLng latLng = marker.getPosition();
                    findAddress(latLng);
                }
            });

            mGoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    String loc = String.format("위도:%.6f, 경도:%.6f", latLng.latitude, latLng.longitude);
                    Toast.makeText(MainActivity.this, loc, Toast.LENGTH_SHORT).show();
                }
            });

            mGoogleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                @Override
                public void onMapLongClick(LatLng latLng) {;
                    Marker marker;
                    Double latitude = latLng.latitude;
                    Double longitude = latLng.longitude;
                    String sni = String.format("위도:%.6f, 경도:%.6f", latitude, longitude);
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(new LatLng(latitude, longitude));
                    markerOptions.title("신규");
                    markerOptions.snippet(sni);
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                    marker = mGoogleMap.addMarker(markerOptions);
                    markerList.add(marker);
                }
            });
        }
    };

    private boolean checkPermission() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED)  {
                ActivityCompat.requestPermissions(this,
                        new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        PERMISSION_REQ_CODE);
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == PERMISSION_REQ_CODE) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationUpdate();
            } else {
                Toast.makeText(this, "앱 실행을 위해 권한 허용이 필요함", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            LatLng currentLoc = new LatLng(location.getLatitude(), location.getLongitude());
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLoc, 17));
            String str = String.format("위도:%.6f, 경도:%.6f", currentLoc.latitude, currentLoc.longitude);

            centerMarker.setPosition(currentLoc);
            centerMarker.setSnippet(str);

            pOptions.add(currentLoc);
            mGoogleMap.addPolyline(pOptions);
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