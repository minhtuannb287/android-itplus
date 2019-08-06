package vn.edu.itplus_academy.myapplication.helpers;

import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import vn.edu.itplus_academy.myapplication.R;

public class ToastMessageHelper {
    public static void showToast(Context context, String sMessage, String mType) {
        Toast toast = Toast.makeText(context, sMessage, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastContentView = (LinearLayout) toast.getView();
        ImageView imageView = new ImageView(context);
        switch (mType){
            case "error":
                imageView.setImageResource(R.drawable.ic_exit);
                break;
            case "info":
                imageView.setImageResource(R.drawable.ic_liked);
                break;
            case "warning":
                imageView.setImageResource(R.drawable.ic_help);
                break;
        }

        toastContentView.addView(imageView, 0);
        toast.show();
    }
}
