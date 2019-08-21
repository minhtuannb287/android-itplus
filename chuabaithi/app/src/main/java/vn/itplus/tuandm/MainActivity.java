package vn.itplus.tuandm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ArrayList<ThanhPho> mArrayList;
    ThoiTietAdapter adapter;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        mArrayList = new ArrayList<ThanhPho>();
        mArrayList.add(new ThanhPho(5128638, "New York", "US"));
        mArrayList.add(new ThanhPho(2643743, "London", "GB"));

        adapter = new ThoiTietAdapter(this, R.layout.item_thanhpho, mArrayList);
        listView.setAdapter(adapter);

    }

}
