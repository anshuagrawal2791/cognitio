package com.example.anshu.cognitio;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;


public class QuizActivity extends Activity {

    ArrayList<Question> Questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            Questions = extras.getParcelableArrayList("Questions");

            Log.e("dfjd",Questions.get(0).getQuestion().toString());

        }
        else
        {
            Toast.makeText(this,"ERROR",Toast.LENGTH_LONG).show();
        }
    }

}
