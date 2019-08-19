package com.myapplication;

import android.annotation.TargetApi;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {


    // Table Names
    private static final String DB_QUANLYCONGVIEC = "quanlycongviec";
    private static final int DB_VERSION = 1;
    //TABLE congviec
    public static final String TABLE_CONGVIEC = "congviec";
    public static final String TIEUDE_CONGVIEC = "tieude";
    public static final String NOIDUNG_CONGVIEC= "noidung";

    SQLiteDatabase mySqLiteDatabase;

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public MySQLiteOpenHelper(Context context) {
        super(context, DB_QUANLYCONGVIEC, null, DB_VERSION);

        mySqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_CONGVIEC + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TIEUDE_CONGVIEC + " TEXT NOT NULL, " +
                NOIDUNG_CONGVIEC +" TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //..
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONGVIEC);
            onCreate(db);
        }
    }

    public ArrayList<JobItem> getAll(){
        String sql = "SELECT * FROM " + TABLE_CONGVIEC;
        Cursor cursor = mySqLiteDatabase.rawQuery(sql, null);

        ArrayList<JobItem> list = new ArrayList<>();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String tieuDe = cursor.getString(1);
            String noiDung = cursor.getString(2);

            list.add(new JobItem(id, tieuDe, noiDung));
        }

        return list;
    }

    public void Add(JobItem newObject){
        try {
            String sql = "INSERT INTO "+ TABLE_CONGVIEC +"("+ TIEUDE_CONGVIEC +", "+ NOIDUNG_CONGVIEC +") VALUES('" +
                    newObject.getTitle()+"','" + newObject.getDescription() +"' "+
                    ")";
            mySqLiteDatabase.execSQL(sql);
            Log.e("SQL", "Insert note item");
        }
      catch (SQLException ex){
            Log.e("SQL", ex.getMessage());
      }

    }
}