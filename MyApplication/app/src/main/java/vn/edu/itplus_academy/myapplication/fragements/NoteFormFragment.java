package vn.edu.itplus_academy.myapplication.fragements;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import vn.edu.itplus_academy.myapplication.R;
import vn.edu.itplus_academy.myapplication.daos.NoteItemDAO;
import vn.edu.itplus_academy.myapplication.models.NoteItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteFormFragment extends Fragment {

    TextInputEditText txtTieuDe, txtNoiDung;
    Switch chkTrangThai;
    Button btnLuu;
    NoteItem noteItem;
    boolean flag = false;

    public NoteFormFragment() {
        // Required empty public constructor
    }

    public NoteFormFragment(NoteItem noteItem) {
        this.noteItem = noteItem;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note_form, container, false);

        txtTieuDe= view.findViewById(R.id.txtTieuDe);
         txtNoiDung = view.findViewById(R.id.txtNoiDung);
         chkTrangThai = view.findViewById(R.id.chkTrangThai);

         if(noteItem != null){
             txtTieuDe.setText(noteItem.getTieu_de());
             txtNoiDung.setText(noteItem.getNoi_dung());
             chkTrangThai.setChecked(noteItem.getTrang_thai());
             flag = true;
         }

         btnLuu = view.findViewById(R.id.btnLuu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tieude = txtTieuDe.getText().toString();
                String noidung = txtNoiDung.getText().toString();
                boolean trangthai = chkTrangThai.isChecked();

                NoteItemDAO dao = new NoteItemDAO(getActivity());
                if(flag){
                    noteItem.setTieu_de(tieude);
                    noteItem.setNoi_dung(noidung);
                    noteItem.setTrang_thai(trangthai);
                    dao.Update(noteItem);
                }else {
                    noteItem = new NoteItem(0, tieude, noidung, trangthai);
                    dao.Add(noteItem);
                }
            }
        });


        return view;
    }

}
