package com.example.user.cracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

/**
 * Created by user on 24/08/2016.
 */
public class DataListActivity extends ActionBarActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_activity);
        listView = (ListView) findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        cursor = userDbHelper.getInformations(sqLiteDatabase);
        if (cursor.moveToFirst()) {
            do {

                String food_type, calories, meal;
                food_type = cursor.getString(0);
                calories = cursor.getString(1);
                meal = cursor.getString(2);
                DataProvider dataProvider = new DataProvider(food_type, calories, meal);
                listDataAdapter.add(dataProvider);

            } while (cursor.moveToNext());
        }
    }

}
