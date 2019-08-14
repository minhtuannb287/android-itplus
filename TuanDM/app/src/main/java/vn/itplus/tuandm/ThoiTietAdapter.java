package vn.itplus.tuandm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

public class ThoiTietAdapter extends ArrayAdapter {

    ArrayList<ThanhPho> mArrayList = new ArrayList<ThanhPho>();
    Context mContext;
    int mLayoutResource;

    public ThoiTietAdapter(Context context, int resource, ArrayList<ThanhPho> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mLayoutResource = resource;
        mArrayList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mLayoutResource, null);

        final ThanhPho thanhPho = mArrayList.get(position);
        TextView txtTieuDe = convertView.findViewById(R.id.txtTieuDe);


        txtTieuDe.setText(thanhPho.getName() + ", " + thanhPho.getCountry());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, ChiTietActivity.class);
                intent.putExtra("thanhPho", thanhPho);

                mContext.startActivity(intent);
            }
        });

        return convertView;
    }
}
