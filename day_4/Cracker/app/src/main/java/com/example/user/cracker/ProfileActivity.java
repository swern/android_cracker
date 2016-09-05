package com.example.user.cracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 22/08/2016.
 */
public class ProfileActivity extends AppCompatActivity {

    TextView mAnswerText;
    TextView mEmailText;
    TextView mAgeText;
    Button mGetStartedButton;
    Button mViewDiaryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Cracker:", "ProfileActivity.onCreateCalled");
        setContentView(R.layout.profile_activity);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("name");
        String email = extras.getString("email");
        String age = extras.getString("age");

        mAnswerText = (TextView)findViewById(R.id.name_information);
        mEmailText = (TextView)findViewById(R.id.email_information);
        mAgeText = (TextView)findViewById(R.id.age_information);
        mGetStartedButton = (Button)findViewById(R.id.get_started_button);
        mViewDiaryButton = (Button) findViewById(R.id.view_diary_button);
        mAnswerText.setText(name);
        mEmailText.setText(email);
        mAgeText.setText(age);

            mGetStartedButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ProfileActivity.this, FoodInputActivity.class);
                    startActivity(intent);
                }
            });

            mViewDiaryButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ProfileActivity.this, DataListActivity.class);
                    startActivity(intent);
                }

            });
    }

    public void viewDiary(View view){
        Intent intent = new Intent(this,DataListActivity.class);
        startActivity(intent);
    }

    public void searchDiary(View view){
        Intent intent = new Intent(this,SearchDiaryActivity.class);
        startActivity(intent);
    }
}
