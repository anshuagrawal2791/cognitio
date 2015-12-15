package com.example.anshu.cognitio;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

import java.util.ArrayList;


public class QuizActivity extends Activity {


    ArrayList<Question> Questions;
    ArrayList<Question> Right;
    ArrayList<Question> Wrong;
    int score=0;
    int compscore=0;
    int level;
    DbHandler dbHandler;
    TextView playername;
    TextView playerscoretv;
    TextView compscoretv;

    TextView timer;
    TextView Question;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    ParseUser user;
    MyCountDownTimer countDownTimer;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        user = ParseUser.getCurrentUser();
        playerscoretv = (TextView) findViewById(R.id.playerscore);
        compscoretv = (TextView) findViewById(R.id.computerscore);
        playername = (TextView) findViewById(R.id.playername);
        Question = (TextView) findViewById(R.id.question);
        buttonA = (Button) findViewById(R.id.optionA);
        buttonB = (Button) findViewById(R.id.optionB);
        buttonC = (Button) findViewById(R.id.optionC);
        buttonD = (Button) findViewById(R.id.optionD);
        timer = (TextView) findViewById(R.id.timer);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Questions = extras.getParcelableArrayList("Questions");

            Log.e("dfjd", "" + Questions.size());
            level = extras.getInt("level");

        } else {
            Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show();
        }

        if (user.getString("name") != null)
            playername.setText(user.getString("name"));
        else
            playername.setText(user.getUsername().toString());

        setup(i);

    }

    public void setup(int i)
    {
        countDownTimer = new MyCountDownTimer(10000 /* 20 Sec */,
                1000);
        final String rightoption = Questions.get(i).getAnswer();
        Log.e("rig",rightoption);
        playerscoretv.setText("" + score);
        compscoretv.setText("" + compscore);
        Question.setText(Questions.get(i).getQuestion().toString());
        buttonA.setText(Questions.get(i).getOptionA().toString());
        buttonB.setText(Questions.get(i).getOptionB().toString());
        buttonC.setText(Questions.get(i).getOptionC().toString());
        buttonD.setText(Questions.get(i).getOptionD().toString());



        countDownTimer.start();
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightoption.equals("a")) {
                    buttonA.setBackgroundColor(Color.GREEN);
                    score += Integer.parseInt(timer.getText().toString()) / 1000;
                    playerscoretv.setText("" + score);
                    countDownTimer.onFinish();

                } else {
                    buttonA.setBackgroundColor(Color.RED);
                    countDownTimer.onFinish();
                }

            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightoption .equals("b")) {
                    buttonB.setBackgroundColor(Color.GREEN);
                    score += Integer.parseInt(timer.getText().toString()) / 1000;
                    playerscoretv.setText("" + score);
                    countDownTimer.onFinish();

                } else {
                    buttonB.setBackgroundColor(Color.RED);
                    countDownTimer.onFinish();
                }

            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightoption .equals("c")) {
                    buttonC.setBackgroundColor(Color.GREEN);
                    score += Integer.parseInt(timer.getText().toString()) / 1000;
                    playerscoretv.setText("" + score);
                    countDownTimer.onFinish();

                } else {
                    buttonC.setBackgroundColor(Color.RED);
                    countDownTimer.onFinish();
                }

            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightoption .equals("e")) {
                    buttonD.setBackgroundColor(Color.GREEN);
                    score += Integer.parseInt(timer.getText().toString()) / 1000;
                    playerscoretv.setText("" + score);
                    countDownTimer.onFinish();

                } else {
                    buttonD.setBackgroundColor(Color.RED);
                    countDownTimer.onFinish();
                }

            }
        });


    }



    class MyCountDownTimer extends CountDownTimer
    {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        public void onFinish() {
            if(i<9)
                setup(i);
            else
            {
                Log.e("dfd","queiz over");
            }
        }
        @Override
        public void onTick(long millisUntilFinished) {
            timer.setText(""+millisUntilFinished/1000);
        }

    }

}

