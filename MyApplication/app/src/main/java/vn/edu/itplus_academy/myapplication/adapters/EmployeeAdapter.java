package vn.edu.itplus_academy.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.itplus_academy.myapplication.EmployeeDetailActivity;
import vn.edu.itplus_academy.myapplication.R;
import vn.edu.itplus_academy.myapplication.models.Employee;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    //Dữ liệu hiện thị là danh sách sinh viên
    public List mList;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;
    // Start with first item selected
    private int focusedItem = 0;

    private static AdapterView.OnItemClickListener onItemClickListener;

    public EmployeeAdapter(List _list, Context mContext) {
        this.mList = _list;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Nạp layout cho View biểu diễn phần tử
        //Tùy thuộc viewType của phần tử
        View view = null;

        view = inflater.inflate(R.layout.item_employee,
                parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        // Handle key up and key down and attempt to move selection
        recyclerView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                RecyclerView.LayoutManager lm = recyclerView.getLayoutManager();

                // Return false if scrolled to the bounds and allow focus to move off the list
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
                        return tryMoveSelection(lm, 1);
                    } else if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
                        return tryMoveSelection(lm, -1);
                    }
                }

                return false;
            }
        });
    }

    private boolean tryMoveSelection(RecyclerView.LayoutManager lm, int direction) {
        int tryFocusItem = focusedItem + direction;

        // If still within valid bounds, move the selection, notify to redraw, and scroll
        if (tryFocusItem >= 0 && tryFocusItem < getItemCount()) {
            notifyItemChanged(focusedItem);
            focusedItem = tryFocusItem;
            notifyItemChanged(focusedItem);
            lm.scrollToPosition(focusedItem);
            return true;
        }

        return false;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee obj = (Employee) mList.get(position);

        holder.tvHoten.setText(obj.getName());
        holder.tvChucvu.setText(obj.getChucvu());
        holder.tvPhongban.setText(obj.getPhongban());
        holder.tvMota.setText(obj.getMota());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvHoten, tvChucvu, tvPhongban, tvMota;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHoten = itemView.findViewById(R.id.tvName);
            tvChucvu = itemView.findViewById(R.id.tvPosition);
            tvPhongban = itemView.findViewById(R.id.tvDepartment);
            tvMota = itemView.findViewById(R.id.tvDescribe);

            // Handle item click and set the selection
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    notifyItemChanged(focusedItem);
//                    focusedItem = getLayoutPosition();
//                    notifyItemChanged(focusedItem);
                    Intent intent = new Intent(mContext, EmployeeDetailActivity.class);
                    Employee obj = (Employee) mList.get(getLayoutPosition());
                    intent.putExtra("detailEmployee", obj);
                    mContext.startActivity(intent);
                }
            });
        }


    }



}
