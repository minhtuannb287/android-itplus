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

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE phongban (sn INTEGER PRIMARY KEY AUTOINCREMENT, ten TEXT NOT NULL, mota TEXT NOT NULL);");
        db.execSQL("CREATE TABLE comment (sn INTEGER PRIMARY KEY AUTOINCREMENT, UID TEXT NOT NULL, CHUDEID INTEGER, noidung TEXT NOT NULL, ngaysua TEXT NOT NULL);");
        db.execSQL("CREATE TABLE chude (sn INTEGER PRIMARY KEY AUTOINCREMENT, UID TEXT NOT NULL, PARENTID INTEGER, ten TEXT NOT NULL, mota TEXT NOT NULL, ngaysua TEXT NOT NULL);");
        db.execSQL("CREATE TABLE nhanvien (sn INTEGER PRIMARY KEY AUTOINCREMENT, hodem TEXT NOT NULL, ten TEXT NOT NULL, PHONGBANID INTEGER, gioitinh INTEGER, ngaysinh TEXT, hinhanh TEXT );");
        db.execSQL("CREATE TABLE chucvu (sn INTEGER PRIMARY KEY AUTOINCREMENT, ten TEXT NOT NULL, mota TEXT NOT NULL);");
        db.execSQL("CREATE TABLE thongbao (sn INTEGER PRIMARY KEY AUTOINCREMENT, UID TEXT NOT NULL, tieude TEXT NOT NULL, noidung TEXT NOT NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //..
        onCreate(db);
    }
}
