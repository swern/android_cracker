package com.example.user.cracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 23/08/2016.
 */
public class FoodInputActivity extends AppCompatActivity {
    EditText foodType, Calories;
    Spinner Meal;
    TextView mealPrompt;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Cracker:", "FoodInputActivity.onCreateCalled");
        setContentView(R.layout.food_input_activity);
        foodType = (EditText) findViewById(R.id.food_type);
        Calories = (EditText) findViewById(R.id.calories);
        Meal = (Spinner) findViewById(R.id.meal_choice);

    }

    public void addFood(View view){

        String food = foodType.getText().toString();
        String calories = Calories.getText().toString();
        String meal = Meal.getSelectedItem().toString();
        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addInformations(food,calories,meal,sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
            userDbHelper.close();
    }

}
