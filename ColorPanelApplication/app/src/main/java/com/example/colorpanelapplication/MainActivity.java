package com.example.colorpanelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    GiayVe giayVe;
    ImageButton image;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        giayVe = (GiayVe) findViewById(R.id.drawing);
        LinearLayout linear = (LinearLayout) findViewById(R.id.paint_colors);
        image = (ImageButton) linear.getChildAt(0);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                giayVe.setDrawSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        /*
         * Bấm nút xóa thì nét vẽ sẽ sử dụng để xóa
         */
        Button btnXoa = (Button) findViewById(R.id.xoa);
        btnXoa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                giayVe.setErase(true);
            }
        });
        /*
         * Bấm nút Tạo mới thì sẽ xóa hết trang cũ đi.
         */
        Button btnNew = (Button) findViewById(R.id.newdraw);
        btnNew.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                giayVe.startNew();
            }
        });
    }

    /*
     * Sự kiện khi click vào một trong số các màu. màu sẽ thay đổi
     */
    public void paintClicked(View v) {
        if (v != image) {
            giayVe.setErase(false);
            // ImageButton imgView = (ImageButton) v;
            String color = v.getTag().toString();
            giayVe.setColor(color);
            image = (ImageButton) v;
        }
    }
}
