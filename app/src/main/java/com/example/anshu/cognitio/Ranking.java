package com.example.anshu.cognitio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.parse.CountCallback;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class Ranking extends AppCompatActivity {
  //  ArrayList<Integer> usercount;
    int usercount;
    int highscore;
    int avgscore;
    int yourscore;
    HorizontalBarChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       mChart = (HorizontalBarChart) findViewById(R.id.horbarchart);
        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);
        mChart.setDescription("");
        mChart.setPinchZoom(false);
        mChart.setDrawGridBackground(false);

        XAxis xl = mChart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setDrawAxisLine(true);
        xl.setDrawGridLines(true);
       // xl.setGridLineWidth(0.3f);


        YAxis yl = mChart.getAxisLeft();
        yl.setDrawAxisLine(true);
        yl.setDrawGridLines(true);
       // yl.setGridLineWidth(0.3f);


        ParseUser user = ParseUser.getCurrentUser();
        String email = user.getEmail();
        ParseQuery<ParseUser> query1 = ParseUser.getQuery();  // fot total user count
        ParseQuery<ParseUser> query2 = ParseUser.getQuery();  // for high score
        query2.orderByAscending("score");
        ParseQuery<ParseUser> query3 = ParseUser.getQuery();  // for average score
       // query.whereEqualTo("email",email);
        query1.countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                if(e==null){
                    usercount = count;
                }
                else{
                    Toast.makeText(Ranking.this,"some error", Toast.LENGTH_LONG).show();
                }

            }
        });
        query2.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> list, ParseException e) {
                highscore = list.get(0).getInt("score");
            }
        });

        setData(usercount, highscore, avgscore , yourscore);

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

        BarDataSet set1 = new BarDataSet(yVals1, "DataSet 1");

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(xVals, dataSets);
        data.setValueTextSize(10f);
        mChart.setData(data);
    }

}
