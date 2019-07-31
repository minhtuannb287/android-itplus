package vn.edu.itplus_academy.myapplication.helpers;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {


    // Table Names
    private static final String TABLE_PHONGBAN = "phongban";
    private static final String TABLE_COMMENT = "comment";
    private static final String TABLE_CHUDE = "chude";
    private static final String TABLE_NHANVIEN = "nhanvien";
    private static final String TABLE_CHUCVU = "chucvu";
    private static final String TABLE_THONGBAO = "thongbao";


    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_PHONGBAN + " (sn INTEGER PRIMARY KEY AUTOINCREMENT, ten TEXT NOT NULL, mota TEXT NOT NULL);");
        db.execSQL("CREATE TABLE "+ TABLE_COMMENT + " (sn INTEGER PRIMARY KEY AUTOINCREMENT, UID TEXT NOT NULL, CHUDEID INTEGER, noidung TEXT NOT NULL, ngaysua TEXT NOT NULL);");
        db.execSQL("CREATE TABLE "+ TABLE_CHUDE + " (sn INTEGER PRIMARY KEY AUTOINCREMENT, UID TEXT NOT NULL, PARENTID INTEGER, ten TEXT NOT NULL, mota TEXT NOT NULL, ngaysua TEXT NOT NULL);");
        db.execSQL("CREATE TABLE "+ TABLE_NHANVIEN + " (sn INTEGER PRIMARY KEY AUTOINCREMENT, hodem TEXT NOT NULL, ten TEXT NOT NULL, PHONGBANID INTEGER, gioitinh INTEGER, ngaysinh TEXT, hinhanh TEXT );");
        db.execSQL("CREATE TABLE "+ TABLE_CHUCVU + " (sn INTEGER PRIMARY KEY AUTOINCREMENT, ten TEXT NOT NULL, mota TEXT NOT NULL);");
        db.execSQL("CREATE TABLE "+ TABLE_THONGBAO + " (sn INTEGER PRIMARY KEY AUTOINCREMENT, UID TEXT NOT NULL, tieude TEXT NOT NULL, noidung TEXT NOT NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //..
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PHONGBAN);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENT);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHUDE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NHANVIEN);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHUCVU);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_THONGBAO);
            onCreate(db);
        }
    }
}
