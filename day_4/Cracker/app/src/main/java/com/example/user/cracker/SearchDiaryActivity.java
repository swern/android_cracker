package com.example.user.cracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 24/08/2016.
 */
public class SearchDiaryActivity extends ActionBarActivity {
    TextView Display_food_type, Display_Calories, Display_Meal;
    EditText Search_Diary;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_diary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_diary_layout);
        Search_Diary = (EditText)findViewById(R.id.search_diary);
        Display_food_type = (TextView)findViewById(R.id.display_food_type);
        Display_Calories = (TextView)findViewById(R.id.display_calories);
        Display_Meal = (TextView)findViewById(R.id.display_meal);
//        maybe add in food_type
        Display_Calories.setVisibility(View.GONE);
        Display_Meal.setVisibility(View.GONE);
        Display_food_type.setVisibility(View.GONE);
    }

    public void searchDiary(View view){

        search_diary = Search_Diary.getText().toString();
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        Cursor cursor = userDbHelper.getInput(search_diary,sqLiteDatabase);
        if(cursor.moveToFirst()){
            String FOOD_TYPE = cursor.getString(0);
            String CALORIES = cursor.getString(1);
            String MEAL = cursor.getString(2);
//            maybe add in food_type
            Display_food_type.setText(FOOD_TYPE);
            Display_Calories.setText(CALORIES);
            Display_Meal.setText(MEAL);
            Display_Calories.setVisibility(View.VISIBLE);
            Display_Meal.setVisibility(View.VISIBLE);
//            Display_food_type.setText(View.VISIBLE);
        }
    }

}
