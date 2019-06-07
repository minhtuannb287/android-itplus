package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Calendar;

import vn.edu.itplus_academy.myapplication.adapters.StudentAdapter;
import vn.edu.itplus_academy.myapplication.models.Student;

public class RecycleViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    StudentAdapter adapter;
    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        recyclerView = findViewById(R.id.studentsList);

        students = new ArrayList<Student>();
        //Tự phát sinh 50 dữ liệu mẫu
        for (int i = 1; i <= 50; i++) {
            students.add(new Student("Student Name"+i , 1995 + (i % 2)));
        }

        adapter = new StudentAdapter(students, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycleview_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_modify_3:
                //Sửa đội phần tử số 3
                Student student = students.get(2);
                student.setmName("TÊN MỚI SỐ 3: "
                        + Calendar.getInstance().getTimeInMillis());
                student.setBirthYear(2000);
                adapter.notifyItemChanged(2);
                return true;

            case R.id.menu_insert_2:
                //Thêm một sinh viên mới vào vị trí số 2
                Student newStudent = new Student("SINH VIÊN 2:"
                        + Calendar.getInstance().getTimeInMillis(), 1990);
                students.add(1, newStudent);
                adapter.notifyItemInserted(1);
                return true;

            case R.id.menu_remove_first:
                //Xóa sinh viên ở vị trí đầu tiên
                students.remove(0);
                adapter.notifyItemRemoved(0);
                return true;
            case R.id.menu_new_7:
                //Danh sách 7 sinh viên mới

                students.clear();//Xóa bỏ danh sách cũ

                //Thêm 7 sinh viên mới
                for (int i = 1; i <=7; i++)
                    students.add(new Student("SV Mới "+ i, 1990+i));

                //Thông báo toàn bộ dữ liệu thay đổi
                adapter.notifyDataSetChanged();

                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);


    }
}
