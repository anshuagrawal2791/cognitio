package com.example.anshu.cognitio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.events.DecoEvent;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ResultActivity extends Activity {
    ArrayList<Integer> Response = new ArrayList<>();
    int score;
    int compscore;
    TextView resulttv;
    CircleImageView playerdp2;
    CircleImageView compdp2;
   // ArrayList<Question> Questions;
    int level2;
    int level;
    ArrayList<String> Questionsansweredrightly;
    TextView playername2;
    ParseUser user;
    private Handler mHandler = new Handler();
    TextView leveltv;
    TextView playerscore2;
    TextView compscore2;
    Button playagain;
    Button home;
    String Subject;
    int Class;

    DbHandler mdbHandler;
    ArrayList<Question> Questions;
    ArrayList<String> QuestionsPlayed;
    String parsetable;
    int sizequesrightlyanswered;


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
        playerscore2 = (TextView)findViewById(R.id.playerscore2);
        compscore2 = (TextView)findViewById(R.id.compscore2);
        playagain = (Button)findViewById(R.id.playagain);
        home=(Button)findViewById(R.id.home);
        mdbHandler = DbHandler.getInstance(this);
        Questionsansweredrightly = new ArrayList<>();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });


        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playanothergame();
            }
        });

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
            Subject=extras.getString("subject");
            Class=extras.getInt("class");
           // Toast.makeText(ResultActivity.this,Subject+" "+Class,Toast.LENGTH_LONG).show();
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

        //level2 = 54;
        sizequesrightlyanswered=Questionsansweredrightly.size();
        level = level2 / 10 + 1;
        leveltv.setText("Level "+level);
        compscore2.setText(compscore+"");
        playerscore2.setText(score+"");
//


        final CircularProgressBar circularProgressBar = (CircularProgressBar) findViewById(R.id.yourCircularProgressbar);


        circularProgressBar.setColor(Color.parseColor("#a55de9"));
        circularProgressBar.setBackgroundColor(Color.parseColor("#FFFFFF"));
        circularProgressBar.setProgress((level2 % 10) * 10);// Default duration = 1500ms


        int n=(((level2 % 10) * 10) + (Questionsansweredrightly.size() * 10) - (100));
        Log.e("n1", n + "");
        circularProgressBar.setColor(Color.parseColor("#a55de9"));
        if ((level2 % 10) * 10 + sizequesrightlyanswered * 10 < 100)
            circularProgressBar.setProgressWithAnimation((level2 % 10) * 10 + sizequesrightlyanswered * 10);
        else {
            circularProgressBar.setProgressWithAnimation(100);
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    int n=(((level2 % 10) * 10) + (sizequesrightlyanswered * 10) - (100));
                    Log.e("n2",sizequesrightlyanswered+"");
                    circularProgressBar.setProgress(0);
                    leveltv.setText("Level " + (level + 1));
                    circularProgressBar.setProgressWithAnimation(n);
                }
            }, 1600);


        }

        Log.e("level2",""+level2);
        Log.e("level2",""+(((level2 % 10) * 10) + (Questionsansweredrightly.size() * 10) - (100)));

        if(Class==6)
        {
            if(Subject.equals("English"))
            {
                mdbHandler.addtovienglish(Questionsansweredrightly);
            }
            else if(Subject.equals("Maths"))
                mdbHandler.addtovimaths(Questionsansweredrightly);
            else if(Subject.equals("Science"))
                mdbHandler.addtoviscience(Questionsansweredrightly);
            else if(Subject.equals("Social Studies"))
                mdbHandler.addtovissc(Questionsansweredrightly);
        }
        else if(Class==7)
        {
            if(Subject.equals("English"))
                mdbHandler.addtoviienglish(Questionsansweredrightly);
            else if(Subject.equals("Maths"))
                mdbHandler.addtoviimaths(Questionsansweredrightly);
            else if(Subject.equals("Science"))
                mdbHandler.addtoviiscience(Questionsansweredrightly);
            else if(Subject.equals("Social Studies"))
                mdbHandler.addtoviissc(Questionsansweredrightly);

        }
        else if(Class==8)
        {
            if(Subject.equals("English"))
                mdbHandler.addtoviiienglish(Questionsansweredrightly);
            else if(Subject.equals("Maths"))
                mdbHandler.addtoviiimaths(Questionsansweredrightly);
            else if(Subject.equals("Science"))
                mdbHandler.addtoviiiscience(Questionsansweredrightly);
            else if(Subject.equals("Social Studies"))
                mdbHandler.addtoviiissc(Questionsansweredrightly);

        }
        else if(Class==9)
        {
            if(Subject.equals("English"))
                mdbHandler.addtoixenglish(Questionsansweredrightly);
            else if(Subject.equals("Maths"))
                mdbHandler.addtoixmaths(Questionsansweredrightly);
            else if(Subject.equals("Science"))
                mdbHandler.addtoixscience(Questionsansweredrightly);
            else if(Subject.equals("Social Studies"))
                mdbHandler.addtoixssc(Questionsansweredrightly);

        }
        else if(Class==10) {
            if(Subject.equals("English"))
                mdbHandler.addtoxenglish(Questionsansweredrightly);
            else if(Subject.equals("Maths"))
                mdbHandler.addtoxmaths(Questionsansweredrightly);
            else if(Subject.equals("Science"))
                mdbHandler.addtoxscience(Questionsansweredrightly);
            else if(Subject.equals("Social Studies"))
                mdbHandler.addtoxssc(Questionsansweredrightly);

        }
        else if(Class==11)
        {
            if(Subject.equals("English"))
                mdbHandler.addtoxienglish(Questionsansweredrightly);
            else if(Subject.equals("Maths"))
                mdbHandler.addtoximaths(Questionsansweredrightly);
            else if(Subject.equals("Science"))
                mdbHandler.addtoxiscience(Questionsansweredrightly);
            else if(Subject.equals("Social Studies"))
                mdbHandler.addtoxissc(Questionsansweredrightly);

        }
        else if(Class==12)
        {
            if(Subject.equals("English"))
                mdbHandler.addtoxiienglish(Questionsansweredrightly);
            else if(Subject.equals("Maths"))
                mdbHandler.addtoxiimaths(Questionsansweredrightly);
            else if(Subject.equals("Science"))
                mdbHandler.addtoxiiscience(Questionsansweredrightly);
            else if(Subject.equals("Social Studies"))
                mdbHandler.addtoxiissc(Questionsansweredrightly);

        }
        
        



    }

    private void playanothergame() {
        if(Class==6)
        {
            if(Subject.equals("English"))
            {
                QuestionsPlayed = mdbHandler.getfromvienglish();
            }
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromvimaths();
            else if(Subject.equals("Science"))
                QuestionsPlayed=mdbHandler.getfromviscience();
            else if(Subject.equals("Social Studies"))
                QuestionsPlayed = mdbHandler.getfromvissc();
        }
        else if(Class==7)
        {
            if(Subject.equals("English"))
                QuestionsPlayed=mdbHandler.getfromviienglish();
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromviimaths();
            else if(Subject.equals("Science"))
                QuestionsPlayed=mdbHandler.getfromviiscience();
            else if(Subject.equals("Social Studies"))
                QuestionsPlayed = mdbHandler.getfromviissc();

        }
        else if(Class==8)
        {
            if(Subject.equals("English"))
                QuestionsPlayed=mdbHandler.getfromviiienglish();
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromviiimaths();
            else if(Subject.equals("Science"))
                QuestionsPlayed=mdbHandler.getfromviiiscience();
            else if(Subject.equals("Social Studies"))
                QuestionsPlayed = mdbHandler.getfromviiissc();

        }
        else if(Class==9)
        {
            if(Subject.equals("English"))
                QuestionsPlayed=mdbHandler.getfromixenglish();
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromixmaths();
            else if(Subject.equals("Science"))
                QuestionsPlayed=mdbHandler.getfromixscience();
            else if(Subject.equals("Social Studies"))
                QuestionsPlayed = mdbHandler.getfromixssc();

        }
        else if(Class==10) {
            if(Subject.equals("English"))
                QuestionsPlayed=mdbHandler.getfromxenglish();
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromxmaths();
            else if(Subject.equals("Science"))
                QuestionsPlayed=mdbHandler.getfromxscience();
            else if(Subject.equals("Social Studies"))
                QuestionsPlayed = mdbHandler.getfromxssc();

        }
        else if(Class==11)
        {
            if(Subject.equals("English"))
                QuestionsPlayed=mdbHandler.getfromxienglish();
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromximaths();
            else if(Subject.equals("Science"))
                QuestionsPlayed=mdbHandler.getfromxiscience();
            else if(Subject.equals("Social Studies"))
                QuestionsPlayed = mdbHandler.getfromxissc();

        }
        else if(Class==12)
        {
            if(Subject.equals("English"))
                QuestionsPlayed=mdbHandler.getfromxiienglish();
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromxiimaths();
            else if(Subject.equals("Science"))
                QuestionsPlayed=mdbHandler.getfromxiiscience();
            else if(Subject.equals("Social Studies"))
                QuestionsPlayed = mdbHandler.getfromxiissc();

        }

        Questions.clear();

        parsetable = Subject.toLowerCase()+Class+"th";
        //QuestionsPlayed.add("6bZ2GaXnvA");


        //mdbHandler.addtovienglish(QuestionsPlayed);


        ParseQuery<ParseObject> query = ParseQuery.getQuery(parsetable);
        query.setLimit(1000);
        final ProgressDialog dialog = new ProgressDialog(ResultActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Loading Questions..");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> question, ParseException e) {
                // dialog.dismiss();
                if (e == null) {
                    // If there are results, update the list of posts
                    // and notify the adapter
                    for(int i=0;i<question.size()&&Questions.size()<10;i++)
                    {
                        if(!QuestionsPlayed.contains(question.get(i).getObjectId().toString())) {
                            Question question1;
                            question1 = new Question(question.get(i).getString("question"), question.get(i).getString("optionA"), question.get(i).getString("optionB"), question.get(i).getString("optionC"), question.get(i).getString("optionD"), question.get(i).getString("rightoption"), question.get(i).getObjectId().toString());
                            Questions.add(question1);
                        }


                    }
                    dialog.dismiss();


                    Log.e("qu", "" + Questions.size());

                    Intent intent = new Intent(ResultActivity.this,QuizActivity.class);
                    intent.putParcelableArrayListExtra("Questions", Questions);
                    intent.putExtra("level",QuestionsPlayed.size());
                    intent.putExtra("subject",Subject);
                    intent.putExtra("class",Class);

                    startActivity(intent);



                } else {
                    dialog.dismiss();
                    Toast.makeText(ResultActivity.this,"Error",Toast.LENGTH_LONG).show();
                    Log.e("Error: " , e.getMessage());
                }
            }
        });



//                while(Questions.size()<10)
//                {
//
//                }


        //ArrayList<String> played = new ArrayList<String>();
        Log.e("fd",QuestionsPlayed.toString());
//                played.add("dfkf");
//                played.add("dfkdff");
//                played.add("dfswerekf");
//               mdbHandler.addtovienglish(played);
//                Log.e("fdfd", mdbHandler.getfromvienglish().toString());

    }
}
