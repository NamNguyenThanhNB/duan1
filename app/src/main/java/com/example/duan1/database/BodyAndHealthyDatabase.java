package com.example.duan1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.duan1.dao.LichTrinhDao;
import com.example.duan1.dao.MucTieuDao;
import com.example.duan1.dao.NguoidungDao;
import com.example.duan1.dao.ThucPhamDao;

public class BodyAndHealthyDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "BodyAndHealthyDatabase01.db";
    public static int VERSION = 1;

    public BodyAndHealthyDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NguoidungDao.SQL_NguoiDungDB);
        db.execSQL(ThucPhamDao.SQL_ThucPhamDB);
        db.execSQL(MucTieuDao.SQL_MucTieuDB);
        db.execSQL(LichTrinhDao.SQL_LichTrinhDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
