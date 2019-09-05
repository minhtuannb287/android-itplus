package vn.itplus.mymapapplication;


import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;

    Button btnCheckGPS, btnCheckNetwork;
    TextView latitudeField, longitudeField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo đối tượng LocationManager
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        latitudeField = (TextView) findViewById(R.id.txtKinhDo);
        longitudeField = (TextView) findViewById(R.id.txtViDo);

        btnCheckGPS = (Button) findViewById(R.id.btnCheckGPS);
        btnCheckGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEnabledGPS();
            }
        });

        btnCheckNetwork = (Button) findViewById(R.id.btnCheckNetwork);
        btnCheckNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEnabledNetwork();
            }
        });
    }

    // 1-A. Kiểm tra GPS đã được bật chưa và yêu cầu
    private void checkEnabledGPS() {
        // Kiểm tra trạng thái GPS
        boolean isGPSEnabled = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);

        // Nếu GPS chưa được bật thì hiển thị cài đặt GPS
        if (!isGPSEnabled) {
            Toast.makeText(MainActivity.this, "GPS đang tắt", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "GPS được bật", Toast.LENGTH_SHORT).show();
            getLocationInfo(LocationManager.GPS_PROVIDER);
        }
    }

    // 1-B. Kiểm tra GPS đã được bật chưa và yêu cầu
    private void checkEnabledNetwork() {
        // Kiểm tra trạng thái Network
        boolean isGPSEnabled = locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        // Hiển thị trạng thái Network
        if (!isGPSEnabled) {
            Toast.makeText(MainActivity.this, "Network đang tắt", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Network được bật", Toast.LENGTH_SHORT).show();
            getLocationInfo(LocationManager.NETWORK_PROVIDER);
        }
    }

    // 2. Lấy thông tin tọa độ thông qua cảm biến LocationProvider (GPS/Network)
    private void getLocationInfo(String provider) {
        try {
            // Đăng ký cập nhật tọa độ
            locationManager.requestLocationUpdates(provider, 1500, 1, this);

            // Khởi tạo đối tượng Location lưu trữ thông tin vị trí tọa độ
            Location location = locationManager.getLastKnownLocation(provider);
            if (location != null) {
                onLocationChanged(location);
            } else {
                Toast.makeText(MainActivity.this, "Location is NULL", Toast.LENGTH_SHORT).show();
                latitudeField.setText("Location not available");
                longitudeField.setText("Location not available");
            }
        } catch (SecurityException secE) {
            Toast.makeText(MainActivity.this, "Location isn't avaiable", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            locationManager.removeUpdates(this); // Hủy cập nhật tọa độ
        } catch (SecurityException secE) {
            Toast.makeText(MainActivity.this, "Location isn't avaiable", Toast.LENGTH_SHORT).show();
        }
    }

    double lat;
    double lng;

    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lng = location.getLongitude();
        latitudeField.setText(String.valueOf(lat));
        longitudeField.setText(String.valueOf(lng));
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

    String address;
    String state;
    String city;
    String district;
    String country;
    String postalCode;
    String knownName;

    // Lấy thông tin địa lý
    public void onClickGetGEO(View view) {
        final ProgressDialog progress = ProgressDialog.show(this, "Thông báo",
                "Đang truy cập thông tin GPS", true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                /*
                 * Hoặc sử dụng API GOOGLE:
                 * http://maps.googleapis.com/maps/api/geocode/json?latlng=21,105&sensor=false&language=en
                 */
                Geocoder gCoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                ArrayList<Address> addresses;
                try {
                    addresses = (ArrayList<Address>) gCoder.getFromLocation(
                            lat, lng, 1);
                    if (addresses != null && addresses.size() > 0) {
                        address = addresses.get(0).getAddressLine(0);
                        city = addresses.get(0).getLocality();
                        state = addresses.get(0).getAdminArea();
                        district = addresses.get(0).getSubAdminArea();
                        country = addresses.get(0).getCountryName();
                        postalCode = addresses.get(0).getPostalCode();
                        knownName = addresses.get(0).getFeatureName();
                        Log.e("APIService", address + "\n" + city + "\n" +
                                state + "\n" + country + "\n" +
                                postalCode + "\n" + knownName + "\n");
                    } else {
                        city = "Không tìm thấy dữ liệu";
                        district = "Không tìm thấy dữ liệu";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    public void run() {
                        TextView thanhpho = (TextView) findViewById(R.id.city);
                        TextView quan = (TextView) findViewById(R.id.district);
                        thanhpho.setText(address + "\n" + city + "\n" +
                                state + "\n");
                        quan.setText(country + "\n" +
                                postalCode + "\n" + knownName + "\n");
                        progress.cancel();
                    }
                });
            }
        }).start();
    }
}