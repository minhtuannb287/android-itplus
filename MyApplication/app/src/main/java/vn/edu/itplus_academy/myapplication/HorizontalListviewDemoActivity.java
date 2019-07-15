package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import vn.edu.itplus_academy.myapplication.fragements.HorizontalListViewFragment;

public class HorizontalListviewDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_listview_demo);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragementContainer);

        if(fragment == null){
            fragment = new HorizontalListViewFragment();

            fm.beginTransaction()
                    .add(R.id.fragementContainer, fragment)
                    .commit();
        }
    }
}
