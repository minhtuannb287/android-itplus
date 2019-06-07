package vn.edu.itplus_academy.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Intent data = getIntent();
        TextView textView1, textView2, textView3;
        Button btn = findViewById(R.id.btnBanDo);
        Button btnAdvantageIntent = findViewById(R.id.btnAdvantageIntent);

        textView1 = findViewById(R.id.textView1);
        textView1.setText(data.getStringExtra("Key_1"));

        textView2 = findViewById(R.id.textView2);
        int giaTri1 = data.getIntExtra("Key_2", 0);
        textView2.setText(String.valueOf(giaTri1));

        boolean giaTri3 = data.getBooleanExtra("Key_3", false);
        textView3 = findViewById(R.id.textView3);
        textView3.setText(String.valueOf(giaTri3));

        // Sử dụng Bundle
        Bundle bundle = data.getExtras();
        if (bundle != null) {
            String value1 = bundle.getString("Key_1", "");
            int value2 = bundle.getInt("Key_2", 0);
            boolean value3 = bundle.getBoolean("Key_3", false);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo:21.0294498,105.8544441"));
                startActivity(intent);
            }
        });

        btnAdvantageIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),
                        IntentAvantageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(IntentAvantageActivity.KEY_SHOW_WHAT, IntentAvantageActivity.VALUE_SHOW_ABOUT);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

}
