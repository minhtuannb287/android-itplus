package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import vn.edu.itplus_academy.myapplication.fragements.DialogEditFragment;
import vn.edu.itplus_academy.myapplication.fragements.Fragment1;

public class FragmentDemoActivity extends AppCompatActivity implements DialogEditFragment.DialogEditFragmentListener, Fragment1.OnFirstFragmentListener {

    Button btnDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        btnDialogFragment = findViewById(R.id.btnDialogFragment);
        btnDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEditDialog();
            }
        });
    }

    @Override
    public void onItemPressed(String content) {
        // Implement phương thức trừu tượng của OnFirstFragmentListener
    }

    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        DialogEditFragment dialogEditFragment = DialogEditFragment.newInstance("Chỉnh sửa");
        dialogEditFragment.show(fm, "fragment_dialog_edit");
    }

    @Override
    public void onFinishEditDialog(String inputText) {
        Toast.makeText(this, inputText, Toast.LENGTH_LONG).show();
    }

}
