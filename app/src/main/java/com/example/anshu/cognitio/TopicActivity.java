package com.example.anshu.cognitio;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

public class TopicActivity extends Activity {
    String Subject;
    int Class;
    TextView topictv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        topictv=(TextView)findViewById(R.id.topictv);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            Subject = extras.getString("Subject");
            Class = extras.getInt("Class");
            topictv.setText(Subject);

        }
        else
        {
            //..oops!
        }
    }

}
