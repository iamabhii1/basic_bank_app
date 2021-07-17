package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7842,'Akash Sharma', 'akash@gmail.com','1234','9974653719', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Gatianjli Tripathi', 'gita@gmail.com','2238','9995647738', 3000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8695,'Surya Rana', 'surya@gmail.com','1196','7511645896', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9858,'Vikram Rathore', 'vikramRath@gmail.com','7999','9991112344', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7240,'Shivam Kumar', 'shivam@gmail.com','6369','9392618562', 5790)");
        db.execSQL("insert into " + TABLE_NAME + " values(8239,'Piyush Mishra', 'piyush@gmail.com','1285','8855640238', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3468,'Yash Pratap', 'yash@gmail.com','9862','7813644215', 5500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Khushi Jadhav', 'khushi@gmail.com','4122','6915011531', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Rohit Sharma', 'iamrohit@gmail.com','2582','430926378', 1100)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Rohit Patidar', 'rohit@gmail.com','5450','8272259151', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5154,'Anurag Kshyapa', 'anurag@gmail.com','6563','9025674200', 8400)");
        db.execSQL("insert into " + TABLE_NAME + " values(8421,'Hitish Kumar', 'hitish@gmail.com','1203','999001199', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1822,'Naveen Chaturvedi', 'naveen@gmail.com','5566','9119541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9912,'Devang Sharma', 'devangshr@gmail.com','2876','6254352215', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(6530,'M.S.Dhoni', 'farhan@gmail.com','6692','6893641266', 999)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}