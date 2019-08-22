package com.example.retrofitdemo.Util;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static void showToast(Context context, String sMessage) {
        Toast.makeText(context, sMessage, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Activity activity, String sMessage) {
        Toast.makeText(activity, sMessage, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Activity activity, int iMessage) {
        Toast.makeText(activity, iMessage, Toast.LENGTH_SHORT).show();
    }

}
