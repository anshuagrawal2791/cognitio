package com.example.anshu.cognitio;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by anshu on 02/12/15.
 */
public class splashscreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        ParseObject generalknowledge6th = new ParseObject("generalknowledge6th");
        generalknowledge6th.put("optionA","");
        generalknowledge6th.put("optionB","");
        generalknowledge6th.put("optionC","");
        generalknowledge6th.put("optionD", "");
        generalknowledge6th.put("question", "");
        generalknowledge6th.put("rightoption", "");
       generalknowledge6th.put("approval", "");
       generalknowledge6th.saveInBackground();

      ParseObject english6th = new ParseObject("english6th");
      english6th.put("approval", "yes");

      /*  ParseObject socialstudies6th = new ParseObject("socialstudies6th");
        socialstudies6th.put("optionA","");
        socialstudies6th.put("optionB","");
        socialstudies6th.put("optionC","");
        socialstudies6th.put("optionD","");
        socialstudies6th.put("question","");
        socialstudies6th.put("rightoption", "");
        socialstudies6th.saveInBackground();

        ParseObject generalknowledge7th = new ParseObject("generalknowledge7th");
        generalknowledge7th.put("optionA","");
        generalknowledge7th.put("optionB","");
        generalknowledge7th.put("optionC","");
        generalknowledge7th.put("optionD", "");
        generalknowledge7th.put("question", "");
        generalknowledge7th.put("rightoption", "");
        generalknowledge7th.saveInBackground();

        ParseObject socialstudies7th = new ParseObject("socialstudies7th");
        socialstudies7th.put("optionA","");
        socialstudies7th.put("optionB","");
        socialstudies7th.put("optionC","");
        socialstudies7th.put("optionD","");
        socialstudies7th.put("question","");
        socialstudies7th.put("rightoption", "");
        socialstudies7th.saveInBackground();

        ParseObject generalknowledge8th = new ParseObject("generalknowledge8th");
        generalknowledge8th.put("optionA","");
        generalknowledge8th.put("optionB","");
        generalknowledge8th.put("optionC","");
        generalknowledge8th.put("optionD", "");
        generalknowledge8th.put("question", "");
        generalknowledge8th.put("rightoption", "");
        generalknowledge8th.saveInBackground();

        ParseObject physics8th = new ParseObject("physics8th");
        physics8th.put("optionA","");
        physics8th.put("optionB","");
        physics8th.put("optionC","");
        physics8th.put("optionD", "");
        physics8th.put("question", "");
        physics8th.put("rightoption", "");
        physics8th.saveInBackground();

        ParseObject chemistry8th = new ParseObject("chemistry8th");
        chemistry8th.put("optionA","");
        chemistry8th.put("optionB","");
        chemistry8th.put("optionC","");
        chemistry8th.put("optionD", "");
        chemistry8th.put("question", "");
        chemistry8th.put("rightoption", "");
        chemistry8th.saveInBackground();

        ParseObject biology8th = new ParseObject("biology8th");
        biology8th.put("optionA","");
        biology8th.put("optionB","");
        biology8th.put("optionC","");
        biology8th.put("optionD", "");
        biology8th.put("question", "");
        biology8th.put("rightoption", "");
        biology8th.saveInBackground();

        ParseObject history8th = new ParseObject("history8th");
        history8th.put("optionA","");
        history8th.put("optionB","");
        history8th.put("optionC","");
        history8th.put("optionD", "");
        history8th.put("question", "");
        history8th.put("rightoption", "");
        history8th.saveInBackground();

        ParseObject civics8th = new ParseObject("civics8th");
        civics8th.put("optionA","");
        civics8th.put("optionB","");
        civics8th.put("optionC","");
        civics8th.put("optionD", "");
        civics8th.put("question", "");
        civics8th.put("rightoption", "");
        civics8th.saveInBackground();

        ParseObject geography8th = new ParseObject("geography8th");
        geography8th.put("optionA","");
        geography8th.put("optionB","");
        geography8th.put("optionC","");
        geography8th.put("optionD", "");
        geography8th.put("question", "");
        geography8th.put("rightoption", "");
        geography8th.saveInBackground();

        ParseObject economics8th = new ParseObject("economics8th");
        economics8th.put("optionA","");
        economics8th.put("optionB","");
        economics8th.put("optionC","");
        economics8th.put("optionD", "");
        economics8th.put("question", "");
        economics8th.put("rightoption", "");
        economics8th.saveInBackground();

        ParseObject generalknowledge9th = new ParseObject("generalknowledge9th");
        generalknowledge9th.put("optionA","");
        generalknowledge9th.put("optionB","");
        generalknowledge9th.put("optionC","");
        generalknowledge9th.put("optionD", "");
        generalknowledge9th.put("question", "");
        generalknowledge9th.put("rightoption", "");
        generalknowledge9th.saveInBackground();

        ParseObject physics9th = new ParseObject("physics9th");
        physics9th.put("optionA","");
        physics9th.put("optionB","");
        physics9th.put("optionC","");
        physics9th.put("optionD", "");
        physics9th.put("question", "");
        physics9th.put("rightoption", "");
        physics9th.saveInBackground();

        ParseObject chemistry9th = new ParseObject("chemistry9th");
        chemistry9th.put("optionA","");
        chemistry9th.put("optionB","");
        chemistry9th.put("optionC","");
        chemistry9th.put("optionD", "");
        chemistry9th.put("question", "");
        chemistry9th.put("rightoption", "");
        chemistry9th.saveInBackground();

        ParseObject biology9th = new ParseObject("biology9th");
        biology9th.put("optionA","");
        biology9th.put("optionB","");
        biology9th.put("optionC","");
        biology9th.put("optionD", "");
        biology9th.put("question", "");
        biology9th.put("rightoption", "");
        biology9th.saveInBackground();

        ParseObject history9th = new ParseObject("history9th");
        history9th.put("optionA","");
        history9th.put("optionB","");
        history9th.put("optionC","");
        history9th.put("optionD", "");
        history9th.put("question", "");
        history9th.put("rightoption", "");
        history9th.saveInBackground();

        ParseObject civics9th = new ParseObject("civics9th");
        civics9th.put("optionA","");
        civics9th.put("optionB","");
        civics9th.put("optionC","");
        civics9th.put("optionD", "");
        civics9th.put("question", "");
        civics9th.put("rightoption", "");
        civics9th.saveInBackground();

        ParseObject geography9th = new ParseObject("geography9th");
        geography9th.put("optionA","");
        geography9th.put("optionB","");
        geography9th.put("optionC","");
        geography9th.put("optionD", "");
        geography9th.put("question", "");
        geography9th.put("rightoption", "");
        geography9th.saveInBackground();

        ParseObject economics9th = new ParseObject("economics9th");
        economics9th.put("optionA","");
        economics9th.put("optionB","");
        economics9th.put("optionC","");
        economics9th.put("optionD", "");
        economics9th.put("question", "");
        economics9th.put("rightoption", "");
        economics9th.saveInBackground();

        ParseObject generalknowledge10th = new ParseObject("generalknowledge10th");
        generalknowledge10th.put("optionA","");
        generalknowledge10th.put("optionB","");
        generalknowledge10th.put("optionC","");
        generalknowledge10th.put("optionD", "");
        generalknowledge10th.put("question", "");
        generalknowledge10th.put("rightoption", "");
        generalknowledge10th.saveInBackground();

        ParseObject physics10th = new ParseObject("physics10th");
        physics10th.put("optionA","");
        physics10th.put("optionB","");
        physics10th.put("optionC","");
        physics10th.put("optionD", "");
        physics10th.put("question", "");
        physics10th.put("rightoption", "");
        physics10th.saveInBackground();

        ParseObject chemistry10th = new ParseObject("chemistry10th");
        chemistry10th.put("optionA","");
        chemistry10th.put("optionB","");
        chemistry10th.put("optionC","");
        chemistry10th.put("optionD", "");
        chemistry10th.put("question", "");
        chemistry10th.put("rightoption", "");
        chemistry10th.saveInBackground();

        ParseObject biology10th = new ParseObject("biology10th");
        biology10th.put("optionA","");
        biology10th.put("optionB","");
        biology10th.put("optionC","");
        biology10th.put("optionD", "");
        biology10th.put("question", "");
        biology10th.put("rightoption", "");
        biology10th.saveInBackground();

        ParseObject history10th = new ParseObject("history10th");
        history10th.put("optionA","");
        history10th.put("optionB","");
        history10th.put("optionC","");
        history10th.put("optionD", "");
        history10th.put("question", "");
        history10th.put("rightoption", "");
        history10th.saveInBackground();

        ParseObject civics10th = new ParseObject("civics10th");
        civics10th.put("optionA","");
        civics10th.put("optionB","");
        civics10th.put("optionC","");
        civics10th.put("optionD", "");
        civics10th.put("question", "");
        civics10th.put("rightoption", "");
        civics10th.saveInBackground();

        ParseObject geography10th = new ParseObject("geography10th");
        geography10th.put("optionA","");
        geography10th.put("optionB","");
        geography10th.put("optionC","");
        geography10th.put("optionD", "");
        geography10th.put("question", "");
        geography10th.put("rightoption", "");
        geography10th.saveInBackground();

        ParseObject economics10th = new ParseObject("economics10th");
        economics10th.put("optionA","");
        economics10th.put("optionB","");
        economics10th.put("optionC","");
        economics10th.put("optionD", "");
        economics10th.put("question", "");
        economics10th.put("rightoption", "");
        economics10th.saveInBackground();


        ParseObject physics11th = new ParseObject("physics11th");
        physics11th.put("optionA","");
        physics11th.put("optionB","");
        physics11th.put("optionC","");
        physics11th.put("optionD", "");
        physics11th.put("question", "");
        physics11th.put("rightoption", "");
        physics11th.saveInBackground();

        ParseObject chemistry11th = new ParseObject("chemistry11th");
        chemistry11th.put("optionA","");
        chemistry11th.put("optionB","");
        chemistry11th.put("optionC","");
        chemistry11th.put("optionD", "");
        chemistry11th.put("question", "");
        chemistry11th.put("rightoption", "");
        chemistry11th.saveInBackground();

        ParseObject biology11th = new ParseObject("biology11th");
        biology11th.put("optionA","");
        biology11th.put("optionB","");
        biology11th.put("optionC","");
        biology11th.put("optionD", "");
        biology11th.put("question", "");
        biology11th.put("rightoption", "");
        biology11th.saveInBackground();

        ParseObject generalknowledge11th = new ParseObject("generalknowledge11th");
        generalknowledge11th.put("optionA","");
        generalknowledge11th.put("optionB","");
        generalknowledge11th.put("optionC","");
        generalknowledge11th.put("optionD", "");
        generalknowledge11th.put("question", "");
        generalknowledge11th.put("rightoption", "");
        generalknowledge11th.saveInBackground();

        ParseObject physics12th = new ParseObject("physics12th");
        physics12th.put("optionA","");
        physics12th.put("optionB","");
        physics12th.put("optionC","");
        physics12th.put("optionD", "");
        physics12th.put("question", "");
        physics12th.put("rightoption", "");
        physics12th.saveInBackground();

        ParseObject chemistry12th = new ParseObject("chemistry12th");
        chemistry12th.put("optionA","");
        chemistry12th.put("optionB","");
        chemistry12th.put("optionC","");
        chemistry12th.put("optionD", "");
        chemistry12th.put("question", "");
        chemistry12th.put("rightoption", "");
        chemistry12th.saveInBackground();

        ParseObject biology12th = new ParseObject("biology12th");
        biology12th.put("optionA","");
        biology12th.put("optionB","");
        biology12th.put("optionC","");
        biology12th.put("optionD", "");
        biology12th.put("question", "");
        biology12th.put("rightoption", "");
        biology12th.saveInBackground();

        ParseObject generalknowledge12th = new ParseObject("generalknowledge12th");
        generalknowledge12th.put("optionA","");
        generalknowledge12th.put("optionB","");
        generalknowledge12th.put("optionC","");
        generalknowledge12th.put("optionD", "");
        generalknowledge12th.put("question", "");
        generalknowledge12th.put("rightoption", "");
        generalknowledge12th.saveInBackground();   */


        findViewById(R.id.loading).setVisibility(View.VISIBLE);

        final boolean[] isConnected = {util.checkConnection(splashscreen.this)};

        Log.e("connection", Boolean.toString(isConnected[0]));


        if(isConnected[0]) {
            Thread timerThread = new Thread(){
                public void run(){
                    try{
                        //ParseUser user= ParseUser.getCurrentUser();

                            sleep(3000);




                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    finally {
                        ParseUser currentUser = ParseUser.getCurrentUser();
                        if (currentUser != null) {
                            // Send logged in users to Welcome.class
                            Intent intent = new Intent(splashscreen.this, MainActivity.class);
                            //findViewById(R.id.loading).setVisibility(View.GONE);
                            startActivity(intent);
                            finish();
                            //Toast.makeText(this,"a",Toast.LENGTH_LONG).show();
                        } else {
                            // Send user to LoginSignupActivity.class
                            Intent intent = new Intent(splashscreen.this,
                                    LoginSignupActivity.class);
                            startActivity(intent);
                            finish();
                            //Toast.makeText(this,"b",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            };
            timerThread.start();





        }
        else {

            RelativeLayout coordinatorLayout = (RelativeLayout) findViewById(R.id
                    .coordinatorLayout);
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "No Network", Snackbar.LENGTH_INDEFINITE);
            

            snackbar.show();

            Thread timerThread = new Thread(){
                    public void run(){
                        try{
                            //ParseUser user= ParseUser.getCurrentUser();
                            while(isConnected[0] ==false) {
                                sleep(1000);
                                if(util.checkConnection(splashscreen.this)==true)
                                    isConnected[0] =true;

                            }

                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        finally {
                            ParseUser currentUser = ParseUser.getCurrentUser();
                            if (currentUser != null) {
                                // Send logged in users to Welcome.class
                                Intent intent = new Intent(splashscreen.this, MainActivity.class);
                                //findViewById(R.id.loading).setVisibility(View.GONE);
                                startActivity(intent);
                                finish();
                                //Toast.makeText(this,"a",Toast.LENGTH_LONG).show();
                            } else {
                                // Send user to LoginSignupActivity.class
                                Intent intent = new Intent(splashscreen.this,
                                        LoginSignupActivity.class);
                                startActivity(intent);
                                finish();
                                //Toast.makeText(this,"b",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                };
                timerThread.start();


//            Toast.makeText(splashscreen.this,"c",Toast.LENGTH_LONG).show();
//            findViewById(R.id.loading).setVisibility(View.GONE);



        }




    }
}
