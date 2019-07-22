package vn.edu.itplus_academy.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.edu.itplus_academy.myapplication.R;
import vn.edu.itplus_academy.myapplication.models.Employee;

public class RVCustomAdapter extends RecyclerView.Adapter<RVCustomAdapter.MyViewHolder> {

    private final List<String> myList = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lv_item_rxjava, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(myView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txtName.setText(myList.get(position));
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public void addStringToList(String value){
        myList.add(value);

        notifyItemInserted(myList.size()-1);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.txtName)
        TextView txtName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
