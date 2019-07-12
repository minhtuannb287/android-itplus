package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        setTitle(R.string.menu_cardview);
    }
}
