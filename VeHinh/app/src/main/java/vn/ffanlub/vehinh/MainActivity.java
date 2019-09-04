package vn.ffanlub.vehinh;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    DrawingView drawingView;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawingView = findViewById(R.id.drawing);
        TableLayout tableLayout = findViewById(R.id.paint_colors);
        TableRow tableRow = (TableRow) tableLayout.getChildAt(0);
        imageButton = (ImageButton) tableRow.getChildAt(0);

        /*
         * Bấm nút xóa thì nét vẽ sẽ sử dụng để xóa
         */
        ImageButton btnXoa = findViewById(R.id.btnErase);
        btnXoa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                drawingView.setErase(true);
            }
        });
        /*
         * Bấm nút Tạo mới thì sẽ xóa hết trang cũ đi.
         */
        ImageButton btnNew = findViewById(R.id.btnNew);
        btnNew.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                drawingView.startNew();
            }
        });

        ImageButton btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    drawingView.setDrawingCacheEnabled(true);
                    Bitmap bitmap = drawingView.getDrawingCache();
                    File f = null;
                    if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                        File file = new File(Environment.getExternalStorageDirectory(),"TTImages_cache");
                        if(!file.exists()){
                            file.mkdirs();
                        }
                        f = new File(file.getAbsolutePath()+file.separator+ "filename"+".png");
                    }
                    FileOutputStream ostream = new FileOutputStream(f);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 10, ostream);
                    ostream.close();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public void paintClicked(View view) {
        if (view != imageButton) {
            drawingView.setErase(false);
            // ImageButton imgView = (ImageButton) v;
            String color = view.getTag().toString();
            drawingView.setColor(color);
            imageButton = (ImageButton) view;
        }
    }
}
