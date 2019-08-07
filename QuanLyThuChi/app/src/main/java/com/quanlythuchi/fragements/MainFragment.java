package com.quanlythuchi.fragements;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.quanlythuchi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    Button btnThem, btnGioiThieu, btnQuanLy,btnThongKe;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnThem = view.findViewById(R.id.btnThem);
        btnThem.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toThemGiaoDichFragment));
        btnGioiThieu = view.findViewById(R.id.btnGioiThieu);
        btnGioiThieu.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toGioiThieuFragment));
        btnQuanLy = view.findViewById(R.id.btnQuanLy);
        btnQuanLy.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toDanhMucFragment));
        btnThongKe = view.findViewById(R.id.btnThongKe);
        btnThongKe.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toQuanLyGiaoDichFragment));
    }
}
