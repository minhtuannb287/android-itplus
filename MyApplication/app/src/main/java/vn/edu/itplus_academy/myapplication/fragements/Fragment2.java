package vn.edu.itplus_academy.myapplication.fragements;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import vn.edu.itplus_academy.myapplication.R;

public class Fragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        Button btnItem1 = (Button) view.findViewById(R.id.btnItem1);
        Button btnItem2 = (Button) view.findViewById(R.id.btnItem2);

        btnItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Button 1 clicked", Toast.LENGTH_SHORT).show();
            }
        });
        btnItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Button 2 clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
