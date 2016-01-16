package com.example.anshu.cognitio;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.parse.ParseException;
import com.parse.ParseFile;
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

    CircularProgressBar timer;
    TextView Question;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    TextView creditstv;
    ParseUser user;
    long instscore;
    int numcompright;
    ProgressBar playerprogressbar;
    ProgressBar compprogressbar;
    ArrayList<Integer> comprightanswers = new ArrayList<>();
    ArrayList<Integer> companswerset;
    private Handler mHandler = new Handler();
    MyCountDownTimer countDownTimer;
    ArrayList<Integer> Response = new ArrayList<>();
    int level2;
    TextView timertv;
    String Subject;
    int Class;
    byte[] bitmapdata;


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
        creditstv=(TextView)findViewById(R.id.creditstv);
        timer = (CircularProgressBar) findViewById(R.id.timer);
        playerprogressbar = (ProgressBar)findViewById(R.id.playerprogressbar);
        compprogressbar = (ProgressBar)findViewById(R.id.compprogressbar);
        timertv=(TextView)findViewById(R.id.timertv);



        ImageView image = (ImageView) findViewById(R.id.playerdp);
        ParseUser user = ParseUser.getCurrentUser();
        ParseFile pf;
        pf = user.getParseFile("dp");
        if(pf!=null){
        bitmapdata = new byte[0];
        try {
            bitmapdata = pf.getData();
        } catch (ParseException e) {
            Log.e("dfd",e.toString());
        }}

        if(pf!=null)
        {Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length);
            image.setImageBitmap(bitmap);}
        else
        image.setImageResource(R.drawable.userdefault);
        ImageView image2 = (ImageView)findViewById(R.id.compdp);
        image2.setImageResource(R.drawable.userdefault);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Questions = extras.getParcelableArrayList("Questions");
            Subject=extras.getString("subject");
            Class = extras.getInt("class");
            Log.e("dfjd", "" + Questions.size());
            level2 = extras.getInt("level");

        } else {
            Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show();
        }
        level=(level2/10)+1;

        if (user.getString("name") != null)
            playername.setText(user.getString("name"));
        else
            playername.setText("You");

        if(level<=6)
        numcompright = (int)(Math.random() * (level+5));
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
        {
            companswerset.add(0);
            Response.add(0);
        }

        for(int k=0;k<10;k++)
        {
            if(comprightanswers.contains(k)){
                if(level<=10)
                companswerset.set(k,level+(int)(Math.random() * (11-level)));
            else
            companswerset.set(k,level+(int)Math.random()*(1));}
            else
                companswerset.set(k,0);
        }




        Log.e("Companswers",companswerset.toString());
        Log.e("Questions",Questions.get(0).getQuestion().toString());
        Log.e("Questions",Questions.size()+"");
        setup(0);

    }

    public void setup(final int j)
    {
        countDownTimer = new MyCountDownTimer(11000 /* 20 Sec */,
                1000);
        final String rightoption = Questions.get(j).getAnswer();
        Log.e("rig", rightoption);
        playerscoretv.setText("" + score);
        playerprogressbar.setProgress((int) score);
        compprogressbar.setProgress((int) (compscore));
        compscoretv.setText("" + compscore);
        Question.setText(Questions.get(j).getQuestion().toString());
        buttonA.setText(Questions.get(j).getOptionA().toString());
        buttonA.setBackgroundColor(Color.GRAY);
        buttonB.setBackgroundColor(Color.GRAY);
        buttonC.setBackgroundColor(Color.GRAY);
        buttonD.setBackgroundColor(Color.GRAY);
        buttonB.setText(Questions.get(j).getOptionB().toString());
        buttonC.setText(Questions.get(j).getOptionC().toString());
        buttonD.setText(Questions.get(j).getOptionD().toString());
        if(Questions.get(j).getCredit()!=null)
        {
            creditstv.setVisibility(View.VISIBLE);
            creditstv.setText(Questions.get(j).getCredit().toString());
        }



        countDownTimer.start();
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightoption.equals("a")) {
                    buttonA.setBackgroundColor(Color.GREEN);
                    score += instscore;
                    Response.set(j, (int) instscore);
                   // Toast.makeText(QuizActivity.this,""+Response.get(j), Toast.LENGTH_LONG).show();
                    playerscoretv.setText("" + score);
                    playerprogressbar.setProgress((int) score);
                    compprogressbar.setProgress((int) (compscore));
                    compscoretv.setText("" + compscore);
                    buttonB.setClickable(false);
                    buttonC.setClickable(false);
                    buttonD.setClickable(false);
                    buttonA.setClickable(false);
                    countDownTimer.onFinish();


                } else {
                    buttonA.setBackgroundColor(Color.RED);
                    Response.set(j,-1);
                    if(rightoption.equals("b"))
                        buttonB.setBackgroundColor(Color.GREEN);
                    else if(rightoption.equals("c"))
                        buttonC.setBackgroundColor(Color.GREEN);
                    else if(rightoption.equals("d"))
                        buttonD.setBackgroundColor(Color.GREEN);
                    buttonB.setClickable(false);
                    buttonC.setClickable(false);
                    buttonD.setClickable(false);
                    buttonA.setClickable(false);
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
                    Response.set(j,(int)instscore);
                  //  Toast.makeText(QuizActivity.this,""+Response.get(j), Toast.LENGTH_LONG).show();
                    playerscoretv.setText("" + score);
                    playerprogressbar.setProgress((int) score);
                    compprogressbar.setProgress((int) (compscore));
                    compscoretv.setText("" + compscore);
                    buttonB.setClickable(false);
                    buttonC.setClickable(false);
                    buttonD.setClickable(false);
                    buttonA.setClickable(false);
                    countDownTimer.onFinish();

                } else {
                    buttonB.setBackgroundColor(Color.RED);
                    Response.set(j, -1);
                    if(rightoption.equals("a"))
                        buttonA.setBackgroundColor(Color.GREEN);
                    else if(rightoption.equals("c"))
                        buttonC.setBackgroundColor(Color.GREEN);
                    else if(rightoption.equals("d"))
                        buttonD.setBackgroundColor(Color.GREEN);
                    buttonB.setClickable(false);
                    buttonC.setClickable(false);
                    buttonD.setClickable(false);
                    buttonA.setClickable(false);
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
                    Response.set(j,(int)instscore);
                  //  Toast.makeText(QuizActivity.this,""+Response.get(j), Toast.LENGTH_LONG).show();
                    playerscoretv.setText("" + score);
                    playerprogressbar.setProgress((int) score);
                    compprogressbar.setProgress((int) (compscore));
                    compscoretv.setText("" + compscore);
                    buttonB.setClickable(false);
                    buttonC.setClickable(false);
                    buttonD.setClickable(false);
                    buttonA.setClickable(false);
                    countDownTimer.onFinish();

                } else {
                    buttonC.setBackgroundColor(Color.RED);
                    Response.set(j, -1);
                    if(rightoption.equals("b"))
                        buttonB.setBackgroundColor(Color.GREEN);
                    else if(rightoption.equals("a"))
                        buttonA.setBackgroundColor(Color.GREEN);
                    else if(rightoption.equals("d"))
                        buttonD.setBackgroundColor(Color.GREEN);
                    buttonB.setClickable(false);
                    buttonC.setClickable(false);
                    buttonD.setClickable(false);
                    buttonA.setClickable(false);
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
                    Response.set(j,(int)instscore);
                 //   Toast.makeText(QuizActivity.this,""+Response.get(j), Toast.LENGTH_LONG).show();
                    playerscoretv.setText("" + score);
                    playerprogressbar.setProgress((int) score);
                    compprogressbar.setProgress((int) (compscore));
                    compscoretv.setText("" + compscore);
                    buttonB.setClickable(false);
                    buttonC.setClickable(false);
                    buttonD.setClickable(false);
                    buttonA.setClickable(false);
                    countDownTimer.onFinish();

                } else {
                    buttonD.setBackgroundColor(Color.RED);
                    Response.set(j, -1);
                    if(rightoption.equals("b"))
                        buttonB.setBackgroundColor(Color.GREEN);
                    else if(rightoption.equals("a"))
                        buttonA.setBackgroundColor(Color.GREEN);
                    else if(rightoption.equals("c"))
                        buttonC.setBackgroundColor(Color.GREEN);
                    buttonB.setClickable(false);
                    buttonC.setClickable(false);
                    buttonD.setClickable(false);
                    buttonA.setClickable(false);
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
            if(i<10)
            compscore+=companswerset.get(i);
//            compscoretv.setText(compscore);
            mHandler.postDelayed(new Runnable() {
                public void run() {
                    i++;

                    if (i <= 9)
                        setup(i);
                    else {
                        //compscore+=companswerset.get(9);
                        compprogressbar.setProgress((int) (compscore));
                        compscoretv.setText("" + compscore);


                        Log.e("dfd", "queiz over");
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(QuizActivity.this,ResultActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                intent.putExtra("compscore", compscore);
                                intent.putParcelableArrayListExtra("Questions", Questions);
                                intent.putExtra("level", level2);
                                intent.putExtra("subject", Subject);
                                intent.putExtra("class",Class);
                               // intent.putExtra("score",score);
                                intent.putIntegerArrayListExtra("response",Response);
                                startActivity(intent);
                            }
                        },2000);

                    }

                }
            }, 2000);

        }
        @Override
        public void onTick(long millisUntilFinished) {
            timer.setProgressWithAnimation((millisUntilFinished / 100) - 10);
            timertv.setText(""+millisUntilFinished/1000);
            instscore=millisUntilFinished/1000;
        }

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
            System.exit(0);
        }
        return super.onKeyDown(keyCode, event);
    }

}

