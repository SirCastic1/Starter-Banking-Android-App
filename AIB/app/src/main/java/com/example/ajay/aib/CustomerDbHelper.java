package com.example.ajay.aib;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CustomerDbHelper extends SQLiteOpenHelper

{   public static final String TABLE_NAME="Customer_Table";
    public static final String id="Customer_id";
    public static final String Account="Cutomer_Account";
    public static final String Name="Customer_Name";
    public static final String Address="Customer_Address";
    public static final String Balance="Cutomer_Balance";


    public static final String DATABASE_NAME="Customer_db";
    public static final int DATABASE_VERSION=1;


    public CustomerDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("Database operations","Database created");

    }

    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String CREATE_TABLE="create table "+TABLE_NAME+"("+id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ Name+" text,"+ Address+" text,"+Account+" text,"+ Balance+" REAL DEFAULT 0);";
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("Database operations","Table created");
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int i1)
    {
        String DROP_TABLE="drop table if exists "+ TABLE_NAME;
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addCustomer(String nName,String aAddress,String aAccount)
    {


        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(CustomerDbHelper.Name,nName);
        contentValues.put(CustomerDbHelper.Address,aAddress);
        contentValues.put(CustomerDbHelper.Account,aAccount);


        db.insert(CustomerDbHelper.TABLE_NAME,null,contentValues);

        Log.d("Database operations","Values Inserted");



    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from Customer_Table", null);
        return res;
    }

}
