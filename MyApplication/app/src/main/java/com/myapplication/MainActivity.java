package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnThem;

    SQLiteDatabase database;
    ArrayAdapter<JobItem> adapter;
    List<JobItem> mArrayList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySQLiteOpenHelper database = new MySQLiteOpenHelper(this);

        mArrayList = database.getAll();
        mArrayList.add(new JobItem(1,"A", "cde"));
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mArrayList);

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        btnThem = findViewById(R.id.btnThem);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
