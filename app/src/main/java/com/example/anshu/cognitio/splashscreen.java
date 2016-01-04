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
