package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import vn.edu.itplus_academy.myapplication.models.Employee;

public class EmployeeFormActivity extends AppCompatActivity {

    private EditText edId, edTen, edChucvu, edPhongban, edGioithieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_form);

        edId = findViewById(R.id.edId);
        edTen = findViewById(R.id.edTen);
        edChucvu = findViewById(R.id.edChucvu);
        edPhongban = findViewById(R.id.edPhongban);
        edGioithieu = findViewById(R.id.edGioithieu);
    }

    public  void btnOK(View view){
        sendToMain(EmployeeListActivity.RESULT_CODE_SAVE);
    }
    public  void btnCancel(View view){
        setResult(EmployeeListActivity.RESULT_CODE_CANCEL);
        finish();
    }

//    public  void btnCancel(View view){
//        onBackPressed();
//    }


    public void sendToMain(int resultcode)
    {
        Intent intent= new Intent();

        Employee obj = new Employee();
        obj.setId(edId.getText().toString());
        obj.setName(edTen.getText().toString());
        obj.setChucvu(edChucvu.getText().toString());
        obj.setPhongban(edPhongban.getText().toString());
        obj.setMota(edGioithieu.getText().toString());
        intent.putExtra("newEmployee",obj);
        setResult(resultcode, intent);

        finish();
    }
}
