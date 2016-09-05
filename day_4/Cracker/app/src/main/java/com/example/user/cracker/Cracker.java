package com.example.user.cracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 22/08/2016.
 */
public class Cracker extends AppCompatActivity {

    EditText mNameEditText;
    EditText mEmailEditText;
    EditText mAgeEditText;
//    TextView mAnswerText;
    Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = (EditText)findViewById(R.id.question1);
//        mAnswerText = (TextView)findViewById(R.id.profile_information);
        mEmailEditText = (EditText)findViewById(R.id.question2);
        mAgeEditText = (EditText)findViewById(R.id.question3);
        mSubmitButton = (Button)findViewById(R.id.submit_details_button);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameEditText.getText().toString();
                String email = mEmailEditText.getText().toString();
                String age = mAgeEditText.getText().toString();
                Log.d("Cracker:", "Submit button clicked!");
                Log.d("Cracker", "The name given was'" + name + "'");
                Intent intent = new Intent(Cracker.this, ProfileActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("age", age);
                startActivity(intent);
            }


        });
    }
}
