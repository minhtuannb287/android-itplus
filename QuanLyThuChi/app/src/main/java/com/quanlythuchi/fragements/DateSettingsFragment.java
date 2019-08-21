package com.quanlythuchi.fragements;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quanlythuchi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DateSettingsFragment extends Fragment {


    public DateSettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date_settings, container, false);
    }

}
