package vn.edu.itplus_academy.myapplication.fragements;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import vn.edu.itplus_academy.myapplication.FragmentDemoActivity;
import vn.edu.itplus_academy.myapplication.R;


public class DialogEditFragment extends DialogFragment implements TextView.OnEditorActionListener {

    private EditText mEditText;

    public DialogEditFragment() {
        // Required empty public constructor
    }

    public static DialogEditFragment newInstance(String title) {
        DialogEditFragment frag = new DialogEditFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        //Bat su kien khi nguoi dung nhan phim DONE
        if(EditorInfo.IME_ACTION_DONE == i){
            DialogEditFragmentListener activity = (DialogEditFragmentListener)getActivity();
            activity.onFinishEditDialog(mEditText.getText().toString());
            this.dismiss();
            return true;
        }
        return false;
    }

    public interface DialogEditFragmentListener{
        void onFinishEditDialog(String inputText);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialog_edit, container, false);
        // Get field from view
        mEditText = (EditText) view.findViewById(R.id.txtYourName);
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Nhập họ tên");
        getDialog().setTitle(title);
        // Show soft keyboard automatically and request focus to field
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        mEditText.setOnEditorActionListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }



}
