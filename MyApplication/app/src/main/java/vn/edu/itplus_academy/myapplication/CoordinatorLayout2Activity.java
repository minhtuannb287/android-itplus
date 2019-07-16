package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CoordinatorLayout2Activity extends AppCompatActivity {

    Button btnSnackbarAndFAB,btnFabFlowWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout2);

        btnSnackbarAndFAB = findViewById(R.id.btnSnackbarAndFAB);
        btnSnackbarAndFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CoordinatorLayout2Activity.this, "btn cliked", Toast.LENGTH_LONG);
                Intent intent = new Intent(CoordinatorLayout2Activity.this, SnackbarFabActivity.class);
                CoordinatorLayout2Activity.this.startActivity(intent);

            }
        });

        btnFabFlowWidget = findViewById(R.id.btnFabFlowWidget);
        btnFabFlowWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CoordinatorLayout2Activity.this, "btn cliked", Toast.LENGTH_LONG);
                Intent intent = new Intent(CoordinatorLayout2Activity.this, FabFlowWidgetActivity.class);
                CoordinatorLayout2Activity.this.startActivity(intent);

            }
        });
    }
}
