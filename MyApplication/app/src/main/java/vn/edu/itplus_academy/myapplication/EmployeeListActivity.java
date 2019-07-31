package vn.edu.itplus_academy.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.itplus_academy.myapplication.adapters.EmployeeAdapter;
import vn.edu.itplus_academy.myapplication.models.Employee;

public class EmployeeListActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD=110;
    public static final int RESULT_CODE_SAVE=0;
    public static final int RESULT_CODE_CANCEL=112;

    RecyclerView recyclerView;
    EmployeeAdapter adapter;
    ArrayList<Employee> mArrayList;
    private Button btnThemNhanVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        recyclerView = findViewById(R.id.studentsList);
        mArrayList = new ArrayList<Employee>();

        adapter = new EmployeeAdapter(mArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        btnThemNhanVien = findViewById(R.id.btnThemNhanVien);
        btnThemNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(EmployeeListActivity.this, EmployeeFormActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ADD);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_ADD){
            switch (resultCode){
                case RESULT_CODE_SAVE:

                    Employee obj = (Employee) data.getSerializableExtra("newEmployee");
                    mArrayList.add(obj);
                    adapter.notifyDataSetChanged();
                    break;
                case RESULT_CODE_CANCEL:
                    Toast.makeText(this, "Bỏ qua", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }


}
