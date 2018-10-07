package com.example.ajay.aib;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CustomerDbHelper extends SQLiteOpenHelper

{
    public static final String id="Customer_id";
    public static final String TABLE_NAME="Customer_Table";
    public static final String Account="Cutomer_Account";
    public static final String Name="Customer_Name";
    public static final String Address="Customer_Address";
    public static final String Balance="Cutomer_Balance";


    public static final String DATABASE_NAME="Customer_db";
    public static final int DATABASE_VERSION=1;

    public static final String CREATE_TABLE="create table "+TABLE_NAME+"("+id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ Name+" text,"+ Address+" text,"+Account+" text,"+ Balance+" REAL DEFAULT 0);";

    public static final String DROP_TABLE="drop table if exists "+ TABLE_NAME;
    public CustomerDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("Database operations","Database created");
        SQLiteDatabase db=this.getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("Database operations","Table created");
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int i1)
    {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addCustomer(String Name,String Address,String Account)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(CustomerContract.CustomerEntry.Name,Name);
        contentValues.put(CustomerContract.CustomerEntry.Address,Address);
        contentValues.put(CustomerContract.CustomerEntry.Account,Account);

        db.insert(CustomerContract.CustomerEntry.TABLE_NAME,null,contentValues);
        Log.d("Database operations","Values Inserted");



    }

}
