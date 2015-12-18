package com.example.anshu.cognitio;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    Button startmatch;
    DbHandler mdbHandler;
    ArrayList<Question> Questions;
    ArrayList<String> QuestionsPlayed;
    String parsetable;
    TextView leveltv;
    int level2;
    ArrayList<String> emailuser1;


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
        leveltv.setText("Level "+(level2/10+1));



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
                dialog.setMessage("Loading Chart Data...");
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
                            for (int i = 0; i < question.size() && Questions.size() < 10; i++) {
                                if (!QuestionsPlayed.contains(question.get(i).getObjectId().toString())) {
                                    Question question1;
                                    question1 = new Question(question.get(i).getString("question"), question.get(i).getString("optionA"), question.get(i).getString("optionB"), question.get(i).getString("optionC"), question.get(i).getString("optionD"), question.get(i).getString("rightoption"), question.get(i).getObjectId().toString());
                                    Questions.add(question1);
                                }


                            }
                            dialog.dismiss();


                            Log.e("qu", "" + Questions.size());

                            Intent intent = new Intent(TopicActivity.this, QuizActivity.class);
                            intent.putParcelableArrayListExtra("Questions", Questions);
                            intent.putExtra("level", level2);
                            intent.putExtra("subject", Subject);
                            intent.putExtra("class", Class);

                            startActivity(intent);


                        } else {
                            dialog.dismiss();
                            Toast.makeText(TopicActivity.this, "Error", Toast.LENGTH_LONG).show();
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
//                played.add("dfkf");
//                played.add("dfkdff");
//                played.add("dfswerekf");
//               mdbHandler.addtovienglish(played);
//                Log.e("fdfd", mdbHandler.getfromvienglish().toString());
            }
        });
        emailuser1 = new ArrayList<String>();
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
        final String key = (Subject.toLowerCase()).replaceAll("\\s","")+Class;
        yourscore = user.getInt(key);

        ParseQuery<ParseUser> query3 = ParseUser.getQuery();  // for average score
        ParseQuery<ParseUser> query2 = ParseUser.getQuery();  // for high score
        query2.orderByAscending("score");
        final ProgressDialog dialog = new ProgressDialog(TopicActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Signing Up...");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
            query2.findInBackground(new FindCallback<ParseUser>()

            {
                @Override
                public void done (List < ParseUser > list, ParseException e) {
                    if (e == null) {
                        for (int i = 0; i < list.size(); i++) {

                            emailuser1.add(list.get(i).getString("email"));
                            Log.e("mayank12345", Integer.toString(emailuser1.size()));

                        }
                        usercount = emailuser1.size();
                        Log.e("mayank key", key);
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
        yVals1.add(new BarEntry((float) b, 1));
        yVals1.add(new BarEntry((float) c, 2));
        yVals1.add(new BarEntry((float) d, 3));
       Log.e("mayank",Integer.toString(b)+Integer.toString(c)+Integer.toString(d)+Integer.toString(a));
        BarDataSet set1 = new BarDataSet(yVals1, "Your Stastics");

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(xVals, dataSets);
        data.setValueTextSize(10f);
        mChart.setData(data);
    }




}
