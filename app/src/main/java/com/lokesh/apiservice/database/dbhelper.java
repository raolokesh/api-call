package com.lokesh.apiservice.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.lokesh.apiservice.UserRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class dbhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Appdatabase";
    private static final  int DATABASE_VERSION = 1;
    private static final String TableName = "userdetail";

public dbhelper(@Nullable Context context){
    super(context,DATABASE_NAME,null,DATABASE_VERSION);
}

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TableName + " (\n" +
                "    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    plaza_id INT,\n" +
                "    login_name VARCHAR(255),\n" +
                "    first_name VARCHAR(255),\n" +
                "    last_name VARCHAR(255),\n" +
                "    password VARCHAR(255),\n" +
                "    roletype INT,\n" +
                "    updateserver INT\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TableName);
        onCreate(db);
    }

    public void insertUser(int plaza_id,String login_name,String first_name,String last_name,String password, int roletype,int update){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("plaza_id",plaza_id);
        values.put("login_name ",login_name);
        values.put("first_name",first_name);
        values.put("last_name",last_name);
        values.put("password",password);
        values.put("roletype",roletype);
        values.put("updateserver",update);
        db.insert(TableName,null,values);
    }
    public void updateserverId(int plaza_id,String login_name,int updateserver){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "UPDATE "+ TableName + " SET updateserver = ? WHERE plaza_id = ? AND login_name = ?";
        Object[] whereArgs = {updateserver,plaza_id,login_name};
        db.execSQL(query,whereArgs);
    }

    public List<UserRegister> getUsersSendToServer(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from "+TableName+" where updateserver = 1";
        Cursor cursor = db.rawQuery(query,null);
        List<UserRegister> userRegisters = new ArrayList<UserRegister>();


        while (cursor.moveToNext()) {
            String plaza_id = cursor.getString(cursor.getColumnIndex("plaza_id"));
            String login_name = cursor.getString(cursor.getColumnIndex("login_name"));
            String first_name = cursor.getString(cursor.getColumnIndex("first_name"));
            String last_name = cursor.getString(cursor.getColumnIndex("last_name"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String roletype = cursor.getString(cursor.getColumnIndex("roletype"));
            UserRegister user = new UserRegister(Integer.parseInt(plaza_id),login_name,first_name,last_name,
                    password,Integer.parseInt(roletype));
            userRegisters.add(user);
        }
        cursor.close();

        return userRegisters;


    }


}
