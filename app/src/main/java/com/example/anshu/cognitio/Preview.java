package com.example.anshu.cognitio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Preview extends AppCompatActivity {
    TextView Question;
    String  ques_str,opta_str,optb_str,optc_str,optd_str,name;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);


        Question = (TextView) findViewById(R.id.question);
        buttonA = (Button) findViewById(R.id.optionA);
        buttonB = (Button) findViewById(R.id.optionB);
        buttonC = (Button) findViewById(R.id.optionC);
        buttonD = (Button) findViewById(R.id.optionD);


        ques_str = getIntent().getExtras().getString("ques_str");
        opta_str = getIntent().getExtras().getString("opta_str");
        optb_str = getIntent().getExtras().getString("optb_str");
        optc_str = getIntent().getExtras().getString("optc_str");
        optd_str = getIntent().getExtras().getString("optd_str");
        name =  getIntent().getExtras().getString("name");

        Question.setText(ques_str);
        buttonA.setText(opta_str);
        buttonB.setText(optb_str);
        buttonC.setText(optc_str);
        buttonD.setText(optd_str);


    }



}
