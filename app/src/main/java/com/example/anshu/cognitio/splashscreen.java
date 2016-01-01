package com.example.anshu.cognitio;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;

import com.parse.ParseUser;

/**
 * Created by anshu on 02/12/15.
 */
public class splashscreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        findViewById(R.id.loading).setVisibility(View.VISIBLE);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    boolean isConnected = util.checkConnection(splashscreen.this);
                    Log.v("connection", Boolean.toString(isConnected));


                    if(isConnected) {
                        ParseUser currentUser = ParseUser.getCurrentUser();
                        if (currentUser != null) {
                            // Send logged in users to Welcome.class
                            Intent intent = new Intent(splashscreen.this, MainActivity.class);
                            //findViewById(R.id.loading).setVisibility(View.GONE);
                            startActivity(intent);
                            finish();
                        } else {
                            // Send user to LoginSignupActivity.class
                            Intent intent = new Intent(splashscreen.this,
                                    LoginSignupActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(splashscreen.this);
                        builder.setTitle("Not Connected");
                        builder.setMessage("Please check your connection settings.");
                        builder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                        AlertDialog dialog = builder.create();
                    }

                }
            }
        };
        timerThread.start();



    }
}
