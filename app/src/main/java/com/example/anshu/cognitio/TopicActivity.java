package com.example.anshu.cognitio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class TopicActivity extends Activity {
    String Subject;
    int Class;
    TextView topictv;
    Button startmatch;
    DbHandler mdbHandler;
    ArrayList<Question> Questions;
    ArrayList<String> QuestionsPlayed;
    String parsetable;
    TextView leveltv;
    int level2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        topictv=(TextView)findViewById(R.id.topictv);
        leveltv = (TextView)findViewById(R.id.leveltv);
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
        level2 = QuestionsPlayed.size();
        leveltv.setText("Level "+(level2%10)+1);



        startmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Questions = new ArrayList<Question>(10);

                parsetable = Subject.toLowerCase()+Class+"th";
                //QuestionsPlayed.add("6bZ2GaXnvA");


                //mdbHandler.addtovienglish(QuestionsPlayed);


                ParseQuery<ParseObject> query = ParseQuery.getQuery(parsetable);
                query.setLimit(1000);
                final ProgressDialog dialog = new ProgressDialog(TopicActivity.this);
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
                            for(int i=0;i<question.size();i++)
                            {
                                if(!QuestionsPlayed.contains(question.get(i).getObjectId().toString())) {
                                    Question question1;
                                    question1 = new Question(question.get(i).getString("question"), question.get(i).getString("optionA"), question.get(i).getString("optionB"), question.get(i).getString("optionC"), question.get(i).getString("optionD"), question.get(i).getString("rightoption"), question.get(i).getObjectId().toString());
                                    Questions.add(question1);
                                }


                            }
                            dialog.dismiss();


                            Log.e("qu", "" + Questions.size());

                            Intent intent = new Intent(TopicActivity.this,QuizActivity.class);
                            intent.putParcelableArrayListExtra("Questions", Questions);
                            intent.putExtra("level",level2);
                            startActivity(intent);



                        } else {
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
        });
    }



}
