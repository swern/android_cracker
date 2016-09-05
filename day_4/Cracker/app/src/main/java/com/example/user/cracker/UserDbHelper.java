package com.example.user.cracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 24/08/2016.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE "+ UserContract.NewUserInfo.TABLE_NAME+" ("+ UserContract.NewUserInfo.FOOD_EATEN+" TEXT, "+
                    UserContract.NewUserInfo.CALORIES+" TEXT, "+ UserContract.NewUserInfo.MEAL+" TEXT);";
    public UserDbHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
             Log.e("DATABASE OPERATIONS", "Database created / opened...");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
            Log.e("DATABASE OPERATIONS", "Table created...");

    }

    public void addInformations(String food_eaten, String calories, String meal, SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewUserInfo.FOOD_EATEN,food_eaten);
        contentValues.put(UserContract.NewUserInfo.CALORIES,calories);
        contentValues.put(UserContract.NewUserInfo.MEAL,meal);
        db.insert(UserContract.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "One row inserted...");
    }

    public Cursor getInformations(SQLiteDatabase db){

        Cursor cursor;
            String[] projections = {UserContract.NewUserInfo.FOOD_EATEN, UserContract.NewUserInfo.CALORIES,
                    UserContract.NewUserInfo.MEAL};

        cursor = db.query(UserContract.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }

    public Cursor getInput(String food_type, SQLiteDatabase sqLiteDatabase)
    {
        String[] projections = {UserContract.NewUserInfo.FOOD_EATEN, UserContract.NewUserInfo.CALORIES,
                UserContract.NewUserInfo.MEAL};
        String selection = UserContract.NewUserInfo.FOOD_EATEN+" LIKE ?";
//        do same as above for calories and meal?
        String[] selection_args = {food_type};
        Cursor cursor = sqLiteDatabase.query(UserContract.NewUserInfo.TABLE_NAME, projections, selection, selection_args,null,null,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
