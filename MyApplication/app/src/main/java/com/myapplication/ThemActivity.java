package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemActivity extends AppCompatActivity {

    Button btnLuu, btnBoQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);


        btnLuu = findViewById(R.id.btnLuu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tieude = findViewById(R.id.txtTieuDe);
                EditText noidung = findViewById(R.id.txtNoiDung);
                JobItem obj = new JobItem();
                obj.setTitle(tieude.getText().toString());
                obj.setDescription(noidung.getText().toString());

                MySQLiteOpenHelper database = new MySQLiteOpenHelper(ThemActivity.this);
                database.Add(obj);

                Toast.makeText(ThemActivity.this, "Thêm thành công", Toast.LENGTH_LONG).show();

            }
        });

        btnBoQua = findViewById(R.id.btnBoQua);
        btnBoQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
