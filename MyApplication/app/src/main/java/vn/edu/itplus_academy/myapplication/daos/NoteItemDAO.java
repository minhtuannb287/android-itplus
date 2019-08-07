package vn.edu.itplus_academy.myapplication.daos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import vn.edu.itplus_academy.myapplication.helpers.MySQLiteOpenHelper;
import vn.edu.itplus_academy.myapplication.models.NoteItem;

public class NoteItemDAO {
    MySQLiteOpenHelper mySQLiteOpenHelper;
    SQLiteDatabase mySqLiteDatabase;

    public NoteItemDAO(Context context) {
        this.mySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        this.mySqLiteDatabase = mySQLiteOpenHelper.getWritableDatabase();
    }

    public void closeConnection(){
        if(mySqLiteDatabase != null ){
            mySqLiteDatabase.close();
        }
    }

    public ArrayList<NoteItem> getAll(){
        String sql = "SELECT * FROM ghichu";
        Cursor cursor = mySqLiteDatabase.rawQuery(sql, null);

        ArrayList<NoteItem> list = new ArrayList<>();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            boolean trangThai = cursor.getInt(1)==1 ? true: false;
            String tieuDe = cursor.getString(2);
            String noiDung = cursor.getString(3);

            list.add(new NoteItem(id, tieuDe, noiDung, trangThai));
        }

        return list;
    }

    public void Add(NoteItem noteItem){
        int trangthai = noteItem.getTrang_thai()? 1: 0;
        String sql = "INSERT INTO ghichu(tieude, noidung, trangthai) VALUES('" +
                noteItem.getTieu_de()+"','" + noteItem.getNoi_dung() + "'," + trangthai +
                ")";
        mySqLiteDatabase.execSQL(sql);
        Log.e("SQL", "Insert note item");
    }

    public void Update(NoteItem noteItem){
        int trangthai = noteItem.getTrang_thai()? 1: 0;
        String sql = "UPDATE ghichu SET tieude='" +
                noteItem.getTieu_de()+"',noidung='" + noteItem.getNoi_dung() + "',trangthai=" + trangthai +
                " WHERE id="+noteItem.getId();
        mySqLiteDatabase.execSQL(sql);
        Log.e("SQL", "Update note item");
    }

    public void Delete(int id){
        String sql = "DELETE FROM ghichu WHERE id="+id;
        mySqLiteDatabase.execSQL(sql);
        Log.e("SQL", "Delete note item");
    }
}
