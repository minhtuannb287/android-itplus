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
    private static final String DB_QUANLYNHANVIEN = "quanlynhanvien";
    private static final int DB_VERSION = 1;
    //TABLE phongban
    public static final String TABLE_PHONGBAN = "phongban";
    public static final String TEN_PHONGBAN = "ten";
    public static final String MOTA_PHONGBAN = "mota";

    //TABLE comment
    public static final String TABLE_COMMENT = "comment";
    public static final String UID_COMMENT = "UID";
    public static final String CHUDEID_COMMENT = "CHUDEID";
    public static final String NOIDUNG_COMMENT = "noidung";
    public static final String NGAYSUA_COMMENT = "ngaysua";
    public static final String TABLE_CHUDE = "chude";
    public static final String TABLE_NHANVIEN = "nhanvien";
    public static final String TABLE_CHUCVU = "chucvu";
    public static final String TABLE_THONGBAO = "thongbao";
    public static final String TABLE_GHICHU = "ghichu";


    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public MySQLiteOpenHelper(Context context) {
        super(context, DB_QUANLYNHANVIEN, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_PHONGBAN + " (sn INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TEN_PHONGBAN + " TEXT NOT NULL, " +
                MOTA_PHONGBAN +" TEXT);");
        db.execSQL("CREATE TABLE "+ TABLE_COMMENT + " (sn INTEGER PRIMARY KEY AUTOINCREMENT, " +
                UID_COMMENT +" TEXT NOT NULL, " +
                CHUDEID_COMMENT + " INTEGER, " +
                NOIDUNG_COMMENT + " TEXT NOT NULL, " +
                NGAYSUA_COMMENT + " TEXT );");
        db.execSQL("CREATE TABLE "+ TABLE_CHUDE + " (sn INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "UID TEXT NOT NULL, " +
                "PARENTID INTEGER, " +
                "ten TEXT NOT NULL, " +
                "mota TEXT NOT NULL, " +
                "ngaysua TEXT );");
        db.execSQL("CREATE TABLE "+ TABLE_NHANVIEN + " (sn INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "hodem TEXT NOT NULL, ten TEXT NOT NULL, " +
                "PHONGBANID INTEGER, " +
                "gioitinh INTEGER, " +
                "ngaysinh TEXT, " +
                "hinhanh TEXT );");
        db.execSQL("CREATE TABLE "+ TABLE_CHUCVU + " (sn INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ten TEXT NOT NULL, " +
                "mota TEXT);");
        db.execSQL("CREATE TABLE "+ TABLE_THONGBAO + " (sn INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "UID TEXT NOT NULL, " +
                "tieude TEXT NOT NULL, " +
                "noidung TEXT NOT NULL);");
        db.execSQL("CREATE TABLE "+ TABLE_GHICHU + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "trangthai INTEGER NOT NULL, " +
                "tieude TEXT NOT NULL, " +
                "noidung TEXT NOT NULL);");

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
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_GHICHU);
            onCreate(db);
        }
    }
}
