package com.example.anshu.cognitio;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TopicActivity extends Activity {
    String Subject;
    int Class;
    TextView topictv;
    Button startmatch;
    DbHandler mdbHandler;
    ArrayList<Question> Questions;
    ArrayList<String> QuestionsPlayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        topictv=(TextView)findViewById(R.id.topictv);
        startmatch=(Button)findViewById(R.id.startmatch);
        mdbHandler = DbHandler.getInstance(this);


        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            Subject = extras.getString("Subject");
            Class = extras.getInt("Class");
            topictv.setText(Subject);
            Class+=5;
            Toast.makeText(this,""+Class,Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"ERROR",Toast.LENGTH_LONG).show();
        }

        startmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Questions = new ArrayList<Question>(10);
                if(Class==6)
                {
                    if(Subject.equals("English"))
                        QuestionsPlayed=mdbHandler.getfromvienglish();
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
                else if(Class==10)
                {
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

                while(Questions.size()<10)
                {

                }


//                ArrayList<String> played = new ArrayList<String>();
//                played.add("dfkf");
//                played.add("dfkdff");
//                played.add("dfswerekf");
//               mdbHandler.addtovienglish(played);
//                Log.e("fdfd", mdbHandler.getfromvienglish().toString());
            }
        });
    }



}
