package vn.edu.itplus_academy.myapplication.adapters;

import android.content.Context;
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

import vn.edu.itplus_academy.myapplication.R;
import vn.edu.itplus_academy.myapplication.daos.NoteItemDAO;
import vn.edu.itplus_academy.myapplication.fragements.NoteFormFragment;
import vn.edu.itplus_academy.myapplication.models.NoteItem;

public class NoteItemAdapter extends ArrayAdapter<NoteItem> {

    ArrayList<NoteItem> mNoteItems = new ArrayList<NoteItem>();
    Context mContext;
    int mLayoutResource;

    public NoteItemAdapter(Context context, int resource, ArrayList<NoteItem> lst) {
        super(context, resource, lst);

        this.mContext = context;
        this.mLayoutResource = resource;
        mNoteItems = lst;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mLayoutResource, null);

        final NoteItem noteItem = mNoteItems.get(position);
        TextView txtTieuDe = convertView.findViewById(R.id.txtTieuDe);
        TextView txtNoiDung = convertView.findViewById(R.id.txtNoiDung);
        Switch chkTrangThai = convertView.findViewById(R.id.chkTrangThai);
        Button btn = convertView.findViewById(R.id.btnXoa);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteItemDAO dao = new NoteItemDAO(view.getContext());
                dao.Delete(noteItem.getId());


            }
        });

        txtTieuDe.setText(noteItem.getTieu_de());
        txtNoiDung.setText(noteItem.getNoi_dung());
        chkTrangThai.setChecked(noteItem.getTrang_thai());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Fragment fragment = new NoteFormFragment(noteItem);
                    ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flContent, fragment)
                            .commit();
            }
        });

        return convertView;
    }
}
