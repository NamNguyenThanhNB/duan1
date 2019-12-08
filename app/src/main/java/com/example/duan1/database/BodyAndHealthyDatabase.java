package com.example.duan1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.duan1.dao.NguoidungDao;

public class BodyAndHealthyDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "BodyAndHealthyDatabase01.db";
    public static final int VERSION = 1;

    public BodyAndHealthyDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NguoidungDao.SQL_NguoiDungDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
