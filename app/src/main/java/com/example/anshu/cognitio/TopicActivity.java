package com.example.anshu.cognitio;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class TopicActivity extends Activity {
    int usercount;
    int highscore;
    int avgscore;
    int yourscore;
    int scoresum;
    HorizontalBarChart mChart;
    String Subject;
    int Class;
    TextView topictv;
    Button startmatch,upd_qes;
    DbHandler mdbHandler;
    ArrayList<Question> Questions;
    ArrayList<String> QuestionsPlayed;
    String parsetable;
    TextView leveltv;
    int level2;
    ArrayList<Integer> scores;
    int rank;
    String key;
    TextView ranktv;
    ImageView topicimage;
    SharedPreferences sp;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        topictv=(TextView)findViewById(R.id.topictv);
        leveltv = (TextView)findViewById(R.id.leveltv);
        startmatch=(Button)findViewById(R.id.startmatch);
        upd_qes=(Button)findViewById(R.id.upd_qes);
        mdbHandler = DbHandler.getInstance(this);
        ranktv=(TextView)findViewById(R.id.ranktv);
        topicimage = (ImageView)findViewById(R.id.topicimage);
        sp=getSharedPreferences("ranks",MODE_PRIVATE);
        editor=sp.edit();

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            Subject = extras.getString("Subject");
            Class = extras.getInt("Class");
            topictv.setText(Subject);
            //Class+=5;
            // Toast.makeText(this,""+Class,Toast.LENGTH_LONG).show();

        }
        else
        {
            //Toast.makeText(this,"ERROR",Toast.LENGTH_LONG).show();
        }
        if(Subject.equals("English"))
            topicimage.setImageDrawable(getResources().getDrawable(R.drawable.e));
        else if(Subject.equals("Maths"))
            topicimage.setImageDrawable(getResources().getDrawable(R.drawable.m));
        else if(Subject.equals("Science"))
            topicimage.setImageDrawable(getResources().getDrawable(R.drawable.sc));
        else if(Subject.equals("SocialStudies"))
            topicimage.setImageDrawable(getResources().getDrawable(R.drawable.sst));
        else if(Subject.equals("GeneralKnowledge"))
            topicimage.setImageDrawable(getResources().getDrawable(R.drawable.gk));
        else if(Subject.equals("Physics"))
            topicimage.setImageDrawable(getResources().getDrawable(R.drawable.p));
        else if(Subject.equals("Chemistry"))
            topicimage.setImageDrawable(getResources().getDrawable(R.drawable.c));
        else if(Subject.equals("Biology"))
            topicimage.setImageDrawable(getResources().getDrawable(R.drawable.b));
        else if(Subject.equals("History"))
            topicimage.setImageDrawable(getResources().getDrawable(R.drawable.h));
        else if(Subject.equals("Civics"))
            topicimage.setImageDrawable(getResources().getDrawable(R.drawable.cv));
        else if(Subject.equals("Geography"))
            topicimage.setImageDrawable(getResources().getDrawable(R.drawable.g));
        else if(Subject.equals("Economics"))
            topicimage.setImageDrawable(getResources().getDrawable(R.drawable.ec));

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
            else if(Subject.equals("SocialStudies"))
                QuestionsPlayed = mdbHandler.getfromvissc();
            else if(Subject.equals("GeneralKnowledge"))
                QuestionsPlayed = mdbHandler.getfromvigk();
        }
        else if(Class==7)
        {
            if(Subject.equals("English"))
                QuestionsPlayed=mdbHandler.getfromviienglish();
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromviimaths();
            else if(Subject.equals("Science"))
                QuestionsPlayed=mdbHandler.getfromviiscience();
            else if(Subject.equals("SocialStudies"))
                QuestionsPlayed = mdbHandler.getfromviissc();
            else if(Subject.equals("GeneralKnowledge"))
                QuestionsPlayed = mdbHandler.getfromviigk();

        }
        else if(Class==8)
        {
            if(Subject.equals("English"))
                QuestionsPlayed=mdbHandler.getfromviiienglish();
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromviiimaths();
            else if(Subject.equals("GeneralKnowledge"))
                QuestionsPlayed = mdbHandler.getfromviiigk();
        else if(Subject.equals("Physics"))
                QuestionsPlayed = mdbHandler.getfromviiiphysics();
        else if(Subject.equals("Chemistry"))
                QuestionsPlayed = mdbHandler.getfromviiichem();
        else if(Subject.equals("Biology"))
                QuestionsPlayed = mdbHandler.getfromviiibio();
        else if(Subject.equals("History"))
                QuestionsPlayed = mdbHandler.getfromviiihistory();
        else if(Subject.equals("Civics"))
                QuestionsPlayed = mdbHandler.getfromviiicivic();
        else if(Subject.equals("Geography"))
                QuestionsPlayed = mdbHandler.getfromviiigeo();
        else if(Subject.equals("Economics"))
                QuestionsPlayed = mdbHandler.getfromviiieco();


        }
        else if(Class==9)
        {
            if(Subject.equals("English"))
                QuestionsPlayed=mdbHandler.getfromixenglish();
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromixmaths();
            else if(Subject.equals("GeneralKnowledge"))
                QuestionsPlayed = mdbHandler.getfromixgk();
            else if(Subject.equals("Physics"))
                QuestionsPlayed = mdbHandler.getfromixphysics();
            else if(Subject.equals("Chemistry"))
                QuestionsPlayed = mdbHandler.getfromixchem();
            else if(Subject.equals("Biology"))
                QuestionsPlayed = mdbHandler.getfromixbio();
            else if(Subject.equals("History"))
                QuestionsPlayed = mdbHandler.getfromixhistory();
            else if(Subject.equals("Civics"))
                QuestionsPlayed = mdbHandler.getfromixcivic();
            else if(Subject.equals("Geography"))
                QuestionsPlayed = mdbHandler.getfromixgeo();
            else if(Subject.equals("Economics"))
                QuestionsPlayed = mdbHandler.getfromixeco();

        }
        else if(Class==10) {
            if(Subject.equals("English"))
                QuestionsPlayed=mdbHandler.getfromxenglish();
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromxmaths();
            else if(Subject.equals("GeneralKnowledge"))
                QuestionsPlayed = mdbHandler.getfromxgk();
            else if(Subject.equals("Physics"))
                QuestionsPlayed = mdbHandler.getfromxphysics();
            else if(Subject.equals("Chemistry"))
                QuestionsPlayed = mdbHandler.getfromxchem();
            else if(Subject.equals("Biology"))
                QuestionsPlayed = mdbHandler.getfromxbio();
            else if(Subject.equals("History"))
                QuestionsPlayed = mdbHandler.getfromxhistory();
            else if(Subject.equals("Civics"))
                QuestionsPlayed = mdbHandler.getfromxcivic();
            else if(Subject.equals("Geography"))
                QuestionsPlayed = mdbHandler.getfromxgeo();
            else if(Subject.equals("Economics"))
                QuestionsPlayed = mdbHandler.getfromxeco();

        }
        else if(Class==11)
        {
            if(Subject.equals("English"))
                QuestionsPlayed=mdbHandler.getfromxienglish();
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromximaths();
            else if(Subject.equals("GeneralKnowledge"))
                QuestionsPlayed = mdbHandler.getfromxigk();
          else if(Subject.equals("Physics"))
                QuestionsPlayed = mdbHandler.getfromxiphysics();
          else if(Subject.equals("Chemistry"))
                QuestionsPlayed = mdbHandler.getfromxichem();
          else if(Subject.equals("Biology"))
                QuestionsPlayed = mdbHandler.getfromxibio();
          

        }
        else if(Class==12)
        {
            if(Subject.equals("English"))
                QuestionsPlayed=mdbHandler.getfromxiienglish();
            else if(Subject.equals("Maths"))
                QuestionsPlayed=mdbHandler.getfromxiimaths();
            else if(Subject.equals("GeneralKnowledge"))
                QuestionsPlayed = mdbHandler.getfromxiigk();
            else if(Subject.equals("Physics"))
                QuestionsPlayed = mdbHandler.getfromxiiphysics();
            else if(Subject.equals("Chemistry"))
                QuestionsPlayed = mdbHandler.getfromxiichem();
            else if(Subject.equals("Biology"))
                QuestionsPlayed = mdbHandler.getfromxiibio();

        }
        level2 = QuestionsPlayed.size();
        leveltv.setText("Level " + (level2 / 10 + 1));


        startmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Questions = new ArrayList<Question>(10);

                parsetable = Subject.toLowerCase() + Class + "th";
                //QuestionsPlayed.add("6bZ2GaXnvA");


                //mdbHandler.addtovienglish(QuestionsPlayed);


                ParseQuery<ParseObject> query = ParseQuery.getQuery(parsetable);
                query.setLimit(1000);
                final ProgressDialog dialog = new ProgressDialog(TopicActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("Opening Questions...");
                dialog.setIndeterminate(true);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
               // Toast.makeText(TopicActivity.this,key+rank+usercount,Toast.LENGTH_LONG).show();
                String ToPut= ""+rank+"/"+usercount;
                Log.e("TOPUT",ToPut);
                editor.putString(""+Class + "th "+ Subject,ToPut);
                editor.commit();
                query.findInBackground(new FindCallback<ParseObject>() {

                    @Override
                    public void done(List<ParseObject> question, ParseException e) {
                        // dialog.dismiss();
                        if (e == null) {
                            // If there are results, update the list of posts
                            // and notify the adapter
//                            Toast.makeText(TopicActivity.this,question.get(0).get("approval").toString(),Toast.LENGTH_LONG).show();
                            // Log.e("approval",question.get(0).getString("approval"));
                            for (int i = 0; i < question.size() && Questions.size() < 10; i++) {
                                if ((!QuestionsPlayed.contains(question.get(i).getObjectId().toString())) && (!question.get(i).getString("approval").equals("no"))) {
                                    Question question1;
                                    question1 = new Question(question.get(i).getString("question"), question.get(i).getString("optionA"), question.get(i).getString("optionB"), question.get(i).getString("optionC"), question.get(i).getString("optionD"), question.get(i).getString("rightoption"), question.get(i).getObjectId().toString(), question.get(i).getString("credit"));
                                    Questions.add(question1);
                                }


                            }
                            dialog.dismiss();


                            Log.e("qu", "" + Questions.size());
                            if (Questions.size() == 10) {
                                Intent intent = new Intent(TopicActivity.this, QuizActivity.class);
                                intent.putParcelableArrayListExtra("Questions", Questions);
                                intent.putExtra("level", level2);
                                intent.putExtra("subject", Subject);
                                intent.putExtra("class", Class);
                                intent.putIntegerArrayListExtra("scores",scores);

                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Congratulations!You've completed all the questions!", Toast.LENGTH_LONG).show();
                            }


                        } else {
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Congratulations!You've completed all the questions!", Toast.LENGTH_LONG).show();
                            Log.e("Error: ", e.getMessage());
                        }
                    }
                });


//                while(Questions.size()<10)
//                {
//
//                }


                //ArrayList<String> played = new ArrayList<String>();
                Log.e("fd", QuestionsPlayed.toString());
//                for(int i=0;i<10;i++)
//                Log.e("fd",Questions.get(i).getQuestion().toString());
////                played.add("dfkf");
//                played.add("dfkdff");
//                played.add("dfswerekf");
//               mdbHandler.addtovienglish(played);
//                Log.e("fdfd", mdbHandler.getfromvienglish().toString());
            }
        });

        upd_qes.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent intent_upd =    new Intent(TopicActivity.this,UpdateQues.class);
                intent_upd.putExtra("tablename" ,Subject.toLowerCase()+Class+"th");
                Log.v("mayank",Subject.toLowerCase()+Class+"th");
                startActivity(intent_upd);

            }
        });




        scores = new ArrayList<Integer>();
        mChart = (HorizontalBarChart) findViewById(R.id.horbarchart);
        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);
        mChart.setDescription("");
        mChart.setPinchZoom(false);
        mChart.setDrawGridBackground(false);
        mChart.animateY(2500);


        XAxis xl = mChart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setDrawAxisLine(true);
        // xl.setDrawGridLines(true);
        // xl.setGridLineWidth(0.3f);


        YAxis yl = mChart.getAxisLeft();
        yl.setDrawAxisLine(true);
        // yl.setDrawGridLines(true);
        yl.setGridLineWidth(0.6f);


        ParseUser user = ParseUser.getCurrentUser();
        String email = user.getEmail();
         key = (Subject.toLowerCase()).replaceAll("\\s","")+Class;
        yourscore = user.getInt(key);

        ParseQuery<ParseUser> query3 = ParseUser.getQuery();  // for average score
        ParseQuery<ParseUser> query2 = ParseUser.getQuery();  // for high score
        query2.orderByDescending(key);
        final ProgressDialog dialog = new ProgressDialog(TopicActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Opening..");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        query2.findInBackground(new FindCallback<ParseUser>()

        {
            @Override
            public void done (List < ParseUser > list, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < list.size(); i++) {

                        if(list.get(i).getInt(key)>0)
                            scores.add(list.get(i).getInt(key));
                        Log.e("mayank12345", Integer.toString(scores.size()));

                    }
                    usercount = scores.size();
                    Log.e("mayank key", key);
                    rank = scores.indexOf(yourscore)+1;
                    ranktv.setText(rank+"/"+usercount);
                    highscore = list.get(0).getInt(key);

                    for (int i = 0; i < list.size(); i++) {
                        scoresum = scoresum + list.get(i).getInt(key);
                    }
                    if (usercount != 0) {
                        avgscore = scoresum / usercount;
                    } else {
                        Log.e("mayank", "zero no. of users");
                    }
                    setData(usercount, highscore, avgscore, yourscore);
                    dialog.dismiss();
                }
            }
        });

    }

    private void setData(int a , int b , int c , int d) {
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("Highest Score");
        xVals.add("Average Score");
        xVals.add("Your Score");
        yVals1.add(new BarEntry((float) b, 0));
        yVals1.add(new BarEntry((float) c, 1));
        yVals1.add(new BarEntry((float) d, 2));
        Log.e("mayank",Integer.toString(b)+Integer.toString(c)+Integer.toString(d)+Integer.toString(a));
        BarDataSet set1 = new BarDataSet(yVals1, "Your Stastics");

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(xVals, dataSets);
        data.setValueTextSize(10f);
        mChart.setData(data);
    }




}