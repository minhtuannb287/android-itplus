package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import vn.edu.itplus_academy.myapplication.helpers.MySQLiteOpenHelper;
import vn.edu.itplus_academy.myapplication.models.Employee;

public class EmployeeDetailActivity extends AppCompatActivity {

    TextView tvHoten, tvChucvu, tvPhongban, tvMota;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        Employee obj = (Employee)getIntent().getExtras()
                .getSerializable("detailEmployee");

        tvHoten = findViewById(R.id.tvHoten);
        tvChucvu= findViewById(R.id.tvChucvu);
        tvPhongban = findViewById(R.id.tvPhongban);
        tvMota= findViewById(R.id.tvMota);


        tvHoten.setText(obj.getName());
        tvChucvu.setText(obj.getChucvu());
        tvPhongban.setText(obj.getPhongban());
        tvMota.setText(obj.getMota());


    }
}
