package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.edu.itplus_academy.myapplication.fragements.Fragment1;

public class FragmentDemoActivity extends AppCompatActivity implements Fragment1.OnFirstFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
    }

    @Override
    public void onItemPressed(String content) {
        // Implement phương thức trừu tượng của OnFirstFragmentListener
    }
}
