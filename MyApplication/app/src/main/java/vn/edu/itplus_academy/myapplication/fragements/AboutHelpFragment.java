package vn.edu.itplus_academy.myapplication.fragements;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;

import vn.edu.itplus_academy.myapplication.R;

public class AboutHelpFragment extends WebViewFragment {

    private static final String ARG_URL = "url";

    private String mUrl;


    public AboutHelpFragment() {
        // Required empty public constructor
    }


    public static AboutHelpFragment newInstance(String url) {
        AboutHelpFragment fragment = new AboutHelpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUrl = getArguments().getString(ARG_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = super.onCreateView(inflater, container, savedInstanceState);

        getWebView().getSettings().setJavaScriptEnabled(true);
        getWebView().getSettings().setSupportZoom(true);
        getWebView().getSettings().setBuiltInZoomControls(true);
        getWebView().loadUrl(mUrl);

        return view;
    }

}
