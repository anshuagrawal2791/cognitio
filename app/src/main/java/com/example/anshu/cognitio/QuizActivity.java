package com.example.anshu.cognitio;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

import java.util.ArrayList;


public class QuizActivity extends Activity {


    ArrayList<Question> Questions;
    ArrayList<Question> Right;
    ArrayList<Question> Wrong;
    long score=0;
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
    long instscore;
    int numcompright;
    ProgressBar playerprogressbar;
    ProgressBar compprogressbar;
    ArrayList<Integer> comprightanswers = new ArrayList<>();
    ArrayList<Integer> companswerset;
    private Handler mHandler = new Handler();
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
        playerprogressbar = (ProgressBar)findViewById(R.id.playerprogressbar);
        compprogressbar = (ProgressBar)findViewById(R.id.compprogressbar);



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

        if(level<=8)
        numcompright = (int)(Math.random() * (level+3));
        else
        numcompright=(int)(Math.random() * 11);

        while(comprightanswers.size()<numcompright)
        {
            int n = (int)(Math.random() * (10));
            if(!comprightanswers.contains(n))
                comprightanswers.add(n);
        }

        companswerset = new ArrayList<>();

        for(int k=0;k<10;k++)
            companswerset.add(0);

        for(int k=0;k<10;k++)
        {
            if(comprightanswers.contains(k))
                companswerset.set(k,(int)(Math.random() * (11)));
            else
                companswerset.set(k,0);
        }




        Log.e("Companswers",companswerset.toString());
        setup(0);

    }

    public void setup(int j)
    {
        countDownTimer = new MyCountDownTimer(11000 /* 20 Sec */,
                1000);
        final String rightoption = Questions.get(j).getAnswer();
        Log.e("rig",rightoption);
        playerscoretv.setText("" + score);
        playerprogressbar.setProgress((int)score);
        compscoretv.setText("" + compscore);
        compprogressbar.setProgress((int)(compscore));
        Question.setText(Questions.get(j).getQuestion().toString());
        buttonA.setText(Questions.get(j).getOptionA().toString());
        buttonA.setBackgroundColor(Color.GRAY);
        buttonB.setBackgroundColor(Color.GRAY);
        buttonC.setBackgroundColor(Color.GRAY);
        buttonD.setBackgroundColor(Color.GRAY);
        buttonB.setText(Questions.get(j).getOptionB().toString());
        buttonC.setText(Questions.get(j).getOptionC().toString());
        buttonD.setText(Questions.get(j).getOptionD().toString());



        countDownTimer.start();
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightoption.equals("a")) {
                    buttonA.setBackgroundColor(Color.GREEN);
                    score += instscore;
                    Toast.makeText(QuizActivity.this,""+score, Toast.LENGTH_LONG).show();
                    playerscoretv.setText("" + score);
                    buttonB.setClickable(false);
                    buttonC.setClickable(false);
                    buttonD.setClickable(false);
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
                    score += instscore;
                    Toast.makeText(QuizActivity.this,""+score, Toast.LENGTH_LONG).show();
                    playerscoretv.setText("" + score);
                    buttonA.setClickable(false);
                    buttonC.setClickable(false);
                    buttonD.setClickable(false);
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
                    score += instscore;
                    Toast.makeText(QuizActivity.this,""+score, Toast.LENGTH_LONG).show();
                    playerscoretv.setText("" + score);
                    buttonB.setClickable(false);
                    buttonA.setClickable(false);
                    buttonD.setClickable(false);
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
                if (rightoption .equals("d")) {
                    buttonD.setBackgroundColor(Color.GREEN);
                    score += instscore;
                    Toast.makeText(QuizActivity.this,""+score, Toast.LENGTH_LONG).show();
                    playerscoretv.setText("" + score);
                    buttonB.setClickable(false);
                    buttonC.setClickable(false);
                    buttonA.setClickable(false);
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
            countDownTimer.cancel();
            compscore+=companswerset.get(i);
//            compscoretv.setText(compscore);
            mHandler.postDelayed(new Runnable() {
                public void run() {
                    i++;

                    if (i <= 9)
                        setup(i);
                    else {
                        Log.e("dfd", "queiz over");
                    }

                }
            }, 2000);

        }
        @Override
        public void onTick(long millisUntilFinished) {
            timer.setText(""+millisUntilFinished/1000);
            instscore=millisUntilFinished/1000;
        }

    }

}

