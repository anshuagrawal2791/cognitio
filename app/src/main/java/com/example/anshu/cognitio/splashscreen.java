package com.example.anshu.cognitio;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import android.content.pm.Signature;

/**
 * Created by anshu on 02/12/15.
 */
public class splashscreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    ParseUser currentUser = ParseUser.getCurrentUser();
                    if (currentUser != null) {
                        // Send logged in users to Welcome.class
                        Intent intent = new Intent(splashscreen.this, MainActivity.class);
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
            }
        };
        timerThread.start();


    }
}
