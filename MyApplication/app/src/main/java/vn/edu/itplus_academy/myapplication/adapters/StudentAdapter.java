package vn.edu.itplus_academy.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.itplus_academy.myapplication.R;
import vn.edu.itplus_academy.myapplication.models.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder > {
    //Dữ liệu hiện thị là danh sách sinh viên
    private List mStutents;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;

    //Hằng số hai kiểu hiện thị phần tử
    public static final int TYPE1 = 0;
    public static final int TYPE2 = 1;

    public StudentAdapter(List _student, Context mContext) {
        this.mStutents = _student;
        this.mContext = mContext;
    }
    /**
     * Những phần tử chia hết cho 3 có kiểu 1, còn lại kiểu 0
     */
    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0)
            return TYPE2;
        else
            return TYPE1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Nạp layout cho View biểu diễn phần tử sinh viên
        //Tùy thuộc viewType của phần tử
        View studentView = null;

        switch (viewType)
        {
            case TYPE1:
                studentView =
                        inflater.inflate(R.layout.student_item,
                                parent, false);
                break;
            case TYPE2:
                studentView =
                        inflater.inflate(R.layout.student_item_2,
                                parent, false);
                break;
        }

        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = (Student) mStutents.get(position);

        holder.studentname.setText(student.getmName());
        holder.birthyear.setText(student.getBirthYear()+"");


    }

    @Override
    public int getItemCount() {
        return mStutents.size();
    }

    /**
     * Lớp nắm giữ cấu trúc view
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemview;
        public TextView studentname;
        public TextView birthyear;
        public Button detail_button;

        public ViewHolder(View itemView) {
            super(itemView);
            itemview = itemView;
            studentname = itemView.findViewById(R.id.studentName);
            birthyear = itemView.findViewById(R.id.birthYear);
            detail_button = itemView.findViewById(R.id.detail_button);

            //Xử lý khi nút Chi tiết được bấm
            detail_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            studentname.getText() +" | "
                                    + " Demo function", Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }
    }


}
