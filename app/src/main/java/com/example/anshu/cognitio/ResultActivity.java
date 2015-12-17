package com.example.anshu.cognitio;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.events.DecoEvent;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Collection;

import de.hdodenhof.circleimageview.CircleImageView;

public class ResultActivity extends Activity {
    ArrayList<Integer> Response = new ArrayList<>();
    int score;
    int compscore;
    TextView resulttv;
    CircleImageView playerdp2;
    CircleImageView compdp2;
    ArrayList<Question> Questions;
    int level2;
    int level;
    ArrayList<String> Questionsansweredrightly = new ArrayList<>();
    TextView playername2;
    ParseUser user;
    private Handler mHandler = new Handler();
    TextView leveltv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        user = ParseUser.getCurrentUser();
        playername2 = (TextView) findViewById(R.id.playername2);
        resulttv = (TextView) findViewById(R.id.resulttv);
        playerdp2 = (CircleImageView) findViewById(R.id.playerdp2);
        compdp2 = (CircleImageView) findViewById(R.id.compdp2);
        leveltv = (TextView)findViewById(R.id.leveltv);

        ParseUser user = ParseUser.getCurrentUser();
        ParseFile pf;
        pf = user.getParseFile("dp");
        byte[] bitmapdata = new byte[0];
        try {
            bitmapdata = pf.getData();
        } catch (ParseException e) {
            Log.e("dfd", e.toString());
        }

        if (pf != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length);
            playerdp2.setImageBitmap(bitmap);
        } else
            playerdp2.setImageResource(R.drawable.userdefault);
        //ImageView image2 = (ImageView)findViewById(R.id.compdp);
        compdp2.setImageResource(R.drawable.userdefault);


        if (user.getString("name") != null)
            playername2.setText(user.getString("name"));
        else
            playername2.setText("YOU");


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Response = extras.getIntegerArrayList("response");
            //score = extras.getInt("score");
            compscore = extras.getInt("compscore");
            Questions = extras.getParcelableArrayList("Questions");
            level2 = extras.getInt("level");
            Log.e("Response", Response.toString());
            // Log.e("Response",""+score);
            Log.e("Response", "" + compscore);


        } else {
            Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show();
        }

        for (int i = 0; i < 10; i++) {
            if (Response.get(i) != -1) {
                score += Response.get(i);
                Questionsansweredrightly.add(Questions.get(i).getId());

            }

        }
        if (score > compscore) {
            resulttv.setText("YOU WIN!");
            playerdp2.setBorderColor(Color.GREEN);
            compdp2.setBorderColor(Color.RED);

        } else if (score == compscore) {
            resulttv.setText("IT'S A TIE!");
            playerdp2.setBorderColor(Color.WHITE);
            compdp2.setBorderColor(Color.WHITE);
        } else {
            resulttv.setText("YOU LOSE!");
            playerdp2.setBorderColor(Color.RED);
            compdp2.setBorderColor(Color.GREEN);
        }
        Log.e("Response", "" + score);
        Log.e("Response", Questionsansweredrightly.toString());
        Log.e("Response", level2 + "");
        Log.e("Response", level + "");

        // DecoView arcView = (DecoView)findViewById(R.id.dynamicArcView);
        // Create background track

        level2 = 54;
        level = level2 % 10 + 1;
        leveltv.setText("Level "+level);
//


        final CircularProgressBar circularProgressBar = (CircularProgressBar) findViewById(R.id.yourCircularProgressbar);


        circularProgressBar.setColor(Color.parseColor("#a55de9"));
        circularProgressBar.setBackgroundColor(Color.parseColor("#FFFFFF"));
        circularProgressBar.setProgress((level2 % 10) * 10);// Default duration = 1500ms


        circularProgressBar.setColor(Color.parseColor("#a55de9"));
        if ((level2 % 10) * 10 + Questionsansweredrightly.size() * 10 < 100)
            circularProgressBar.setProgressWithAnimation((level2 % 10) * 10 + Questionsansweredrightly.size() * 10);
        else {
            circularProgressBar.setProgressWithAnimation(100);
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    circularProgressBar.setProgress(0);
                    leveltv.setText("Level "+(level+1));
                    circularProgressBar.setProgressWithAnimation((level2 % 10) * 10 + (Questionsansweredrightly.size() * 10) - 100);
                }
            }, 1600);


        }
//        else
//        {
//            circularProgressBar.setProgressWithAnimation(100);
//            circularProgressBar.setProgressWithAnimation((level2%10)*10+Questionsansweredrightly.size()-100);
//
//
//        }



    }
}
