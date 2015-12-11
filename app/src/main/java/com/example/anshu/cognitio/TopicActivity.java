package com.example.anshu.cognitio;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TopicActivity extends Activity {
    String Subject;
    int Class;
    TextView topictv;
    Button startmatch;
    DbHandler mdbHandler;

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

        }
        else
        {
            Toast.makeText(this,"ERROR",Toast.LENGTH_LONG).show();
        }

        startmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> played = new ArrayList<String>();
                played.add("dfkf");
                played.add("dfkdff");
                played.add("dfswerekf");
               mdbHandler.addtovienglish(played);
                Log.e("fdfd", mdbHandler.getfromvienglish().toString());
            }
        });
    }



}
