package com.example.anshu.cognitio;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

/**
 * Created by anshu on 30/10/15.
 */
public class MyApp extends Application {


    private static MyApp inst;


    @Override
    public void onCreate() {
        super.onCreate();
        inst = this;
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "1czSluBzWHomRhGftjKqwgtuNtULxCCnBktorggb", "kcGkqULira6BGj1M4uDdGkd5VMWa38NmZCVlwBZg");



        ParseFacebookUtils.initialize(this);
//        ParseUser.enableAutomaticUser();
//        ParseACL defaultACL = new ParseACL();
//
//        // If you would like all objects to be private by default, remove this
//        // line.
//        defaultACL.setPublicReadAccess(true);
//
//        ParseACL.setDefaultACL(defaultACL, true);
    }
    public static MyApp getInst(){
        return inst;

    }
    public static Context getAppContext()
    {
        return inst.getApplicationContext();
    }

}
