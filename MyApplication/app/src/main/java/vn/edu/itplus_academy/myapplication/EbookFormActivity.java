package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.widget.picker.Picker;

import android.app.DatePickerDialog;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import vn.edu.itplus_academy.myapplication.models.Ebook;

public class EbookFormActivity extends AppCompatActivity {

    List<String> listTacGia;
    List<Ebook> listEbook;
    DatePickerDialog datePickerDialog;
    EditText etNgay, etTenSach;
    Spinner spTacGia;
    Button btThemSach;
    ListView lvEbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook_form);

        lvEbook = findViewById(R.id.lvBook);
        etTenSach = findViewById(R.id.etTenSach);
        btThemSach = findViewById(R.id.btThemSach);
        spTacGia = findViewById(R.id.spTacGia);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getListTacGia());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTacGia.setAdapter(dataAdapter);

        final ArrayAdapter<Ebook> ebookAdapter = new ArrayAdapter<Ebook>(this,
                android.R.layout.simple_list_item_1, getListEbook());
        lvEbook.setAdapter(ebookAdapter);

        //lệnh xử lý DatePickerDialog
        etNgay = findViewById(R.id.etNgay);
        etNgay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Calendar calendar = Calendar.getInstance();
                int ngay = calendar.get(Calendar.DAY_OF_MONTH);
                int thang = calendar.get(Calendar.MONTH);
                int nam = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(EbookFormActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        etNgay.setText(i2 + "/" + (i1+1) + "/" + i);
                    }
                }, nam, thang, ngay);

                datePickerDialog.show();
            }
        });

        btThemSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tacGia = String.valueOf(spTacGia.getSelectedItem());
                String ten = etTenSach.getText().toString();
                String ngayNhap = etNgay.getText().toString();

                Ebook obj = new Ebook();
                obj.setID(listEbook.size() + 1);
                obj.setTenSach(ten);
                obj.setTacGia(tacGia);
                obj.setNgayNhap(ngayNhap);

                listEbook.add(obj);

                ebookAdapter.notifyDataSetChanged();
            }
        });
    }

    public List<String> getListTacGia(){
        listTacGia = new ArrayList<>();
        listTacGia.add("Thạch Lam");
        listTacGia.add("Tô Hoài");
        listTacGia.add("Vũ Trọng Phụng");
        listTacGia.add("Nguyễn Du");

        return listTacGia;
    }

    public List<Ebook> getListEbook(){
        listEbook = new ArrayList<>();
        if(listEbook.isEmpty()){
            Ebook obj = new Ebook();
            obj.setID(1);
            obj.setTacGia("Thạch Lam");
            obj.setTenSach("Hai đứa trẻ");
            obj.setNgayNhap("26/07/2019");
            listEbook.add(obj);
        }
        return listEbook;
    }
}
