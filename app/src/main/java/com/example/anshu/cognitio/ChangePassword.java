package com.example.anshu.cognitio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button chan_pwd = (Button) findViewById(R.id.chan_pwd);
        chan_pwd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
               final EditText current_pwd = (EditText) findViewById(R.id.current_pwd);
                final String current_password = current_pwd.toString();
               final EditText new_pwd = (EditText) findViewById(R.id.new_pwd);
               final String new_password = new_pwd.toString();
               final EditText var_new_pwd = (EditText) findViewById(R.id.var_new_pwd);
              final  String var_new_password = var_new_pwd.toString();
                ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser!=null){
                    ParseUser.logInInBackground(ParseUser.getCurrentUser().getUsername().toString(), current_password, new LogInCallback() {
                        public void done(ParseUser user, ParseException e) {
                            if (user != null) {
                                if (new_password.equals(var_new_password)) {
                                    user.setPassword(new_password);
                                    user.saveInBackground();
                                    Toast.makeText(getApplicationContext(), "Password successfully changed", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Password doesn't match. Please Try Again.", Toast.LENGTH_LONG).show();
                                }
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Wrong Current Password. Please Try Again.", Toast.LENGTH_LONG).show();
                                Log.e("wrong password","mayank",e);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(), "Could Not change. Please Try Again.", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

}
