package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import vn.edu.itplus_academy.myapplication.fragements.AboutHelpFragment;

public class ContactActivity extends AppCompatActivity {

    public static final String KEY_SHOW_WHAT = "show_what";
    public static final String VALUE_SHOW_ABOUT = "show_about";
    public static final String VALUE_SHOW_HELP = "show_help";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String valueShow = bundle.getString(KEY_SHOW_WHAT, "");

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (valueShow.equals(VALUE_SHOW_ABOUT)) {
                AboutHelpFragment aboutHelpFragment = AboutHelpFragment.newInstance("http://4fanclub.vn/detail/14.html");
                fragmentTransaction.add(R.id.contactMainFrame, aboutHelpFragment);
                fragmentTransaction.commit();
            } else if (valueShow.equals(VALUE_SHOW_HELP)) {
                AboutHelpFragment aboutHelpFragment = AboutHelpFragment.newInstance("http://4fanclub.vn/detail/6.html");
                fragmentTransaction.add(R.id.contactMainFrame, aboutHelpFragment);
                fragmentTransaction.commit();
            }
        }
    }
}
