package com.example.sqlite_module;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class Dtabasehelper extends SQLiteOpenHelper {


    public static final String TABLE_CUSTOMER_DET = "customer_det";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_ACTIVE = "active";

    public Dtabasehelper(@Nullable Context context) {
        super(context,"company.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= "CREATE TABLE " + TABLE_CUSTOMER_DET + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT," + COLUMN_AGE + " INTEGER," + COLUMN_ACTIVE + " BOOL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addone(Customer_Model customer)
    {
        String name= customer.getName();
        int age=customer.getAge();
        boolean active=customer.isActive();

        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_AGE,age);
        cv.put(COLUMN_ACTIVE,active);

        SQLiteDatabase db=this.getWritableDatabase();
        long insert = db.insert(TABLE_CUSTOMER_DET, null, cv);

        if(insert==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public List<Customer_Model> viewdata()
    {
        List<Customer_Model> returnlist =new ArrayList<>();
        String statement="Select * from "+TABLE_CUSTOMER_DET;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(statement,null);

        if (cursor.moveToFirst())
        {
            do {
                int id=cursor.getInt(0);
                String name=cursor.getString(1);
                int no=cursor.getInt(2);
                boolean active=cursor.getInt(3)==1?true:false;
                returnlist.add(new Customer_Model(id,name,no,active));
            }while (cursor.moveToNext());
        }
        else
        {
            //not contain data
        }

        return returnlist;
    }

    public void deleteone(Customer_Model customer)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="DELETE FROM "+TABLE_CUSTOMER_DET+" Where "+COLUMN_ID+"="+customer.getId();
        Cursor cursor = db.rawQuery(qry, null);
        cursor.moveToFirst();
    }

    /*
    Deleted query bolean method
    public bolean deleteone(Customer_Model customer)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="DELETE FROM "+TABLE_CUSTOMER_DET+" Where "+COLUMN_ID+"="+customer.getId();
        Cursor cursor = db.rawQuery(qry, null);
        if(cursor.moveToFirst)
        {
            return true;
        }

        else
        {
        return false
        }
    }
     */
}
