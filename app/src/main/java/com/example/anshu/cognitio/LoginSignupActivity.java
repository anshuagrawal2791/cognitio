package com.example.anshu.cognitio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginSignupActivity extends AppCompatActivity {

    Button loginbutton;
    Button signup;
    //Button mBtnFb;
    String usernametxt;
    String passwordtxt;
    EditText password;
    EditText username;
    TextView tv;

    CircleImageView mProfileImage;
    Button mBtnFb,fgtpwd;
    TextView mUsername, mEmailID;
    Profile mFbProfile;

    ParseUser parseUser;
    String name = null, email = null;

    public static final List<String> mPermissions = new ArrayList<String>() {{

        add("public_profile");
        add("email");

    }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        loginbutton = (Button) findViewById(R.id.login);
        signup = (Button) findViewById(R.id.signup);
        mBtnFb = (Button)findViewById(R.id.mBtnFb);
        fgtpwd = (Button)findViewById(R.id.fgtpwd);   // fgtpwd = forgot password


        tv = (TextView)findViewById(R.id.tv);


// forgot  password click listener

        fgtpwd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent = new Intent(LoginSignupActivity.this,ForgotPassword.class);
                startActivity(intent);
            }
        });

      //  mBtnFb = (Button) findViewById(R.id.btn_fb_login);

        // Login Button Click Listener
        loginbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Retrieve the text entered from the EditText
                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();

                if (usernametxt.equals("") || passwordtxt.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please complete the details",
                            Toast.LENGTH_LONG).show();}
                    else{

                // Send data to Parse.com for verification
                ParseUser.logInInBackground(usernametxt, passwordtxt,
                        new LogInCallback() {
                            public void done(ParseUser user, ParseException e) {
                                if (user != null) {
                                    // If user exist and authenticated, send user to Welcome.class
                                    Intent intent = new Intent(
                                            LoginSignupActivity.this,
                                            MainActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(),
                                            "Successfully Logged in",
                                            Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    Toast.makeText(
                                            getApplicationContext(),
                                            "No such user exist, please signup",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });}
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Retrieve the text entered from the EditText
                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();

                // Force user to fill up the form
                if (usernametxt.equals("") || passwordtxt.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please complete the sign up form",
                            Toast.LENGTH_LONG).show();

                } else {
                    // Save new user data into Parse.com Data Storage
                    ParseUser user = new ParseUser();
                    user.setUsername(usernametxt);
                    user.setPassword(passwordtxt);
                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                // Show a simple Toast message upon successful registration
                                Toast.makeText(getApplicationContext(),
                                        "Successfully Signed up, please log in.",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Sign up Error", Toast.LENGTH_LONG)
                                        .show();
                            }
                        }
                    });
                }

            }
        });



        mBtnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseFacebookUtils.logInWithReadPermissionsInBackground(LoginSignupActivity.this, mPermissions, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException err) {
                        if (user == null) {
                            Log.e("MyApp", "Uh oh. The user cancelled the Facebook login.");
                        } else if (user.isNew()) {
                            Log.e("MyApp", "User signed up and logged in through Facebook!");
                            getUserDetailsFromFB();
                            //saveNewUser();
                        } else {
                            Log.e("MyApp", "User logged in through Facebook!");
                            getUserDetailsFromParse();
                        }
                    }
                });
            }
        });}





    private void getUserDetailsFromFB() {
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
           /* handle the result */
                        Intent intent = new Intent(
                                LoginSignupActivity.this,
                                MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),
                                "Successfully Logged in",
                                Toast.LENGTH_LONG).show();
                        finish();


                        try{
                            email=response.getJSONObject().getString("email");
                            tv.setText(email);
                            parseUser=ParseUser.getCurrentUser();
                            parseUser.setEmail(email);

                        } catch (JSONException e) {
                           Log.e("my",e.toString());
                        }

//
                    }
                }
        ).executeAsync();



    }




    private void getUserDetailsFromParse() {
       parseUser = ParseUser.getCurrentUser();
//
//        }
        email = (parseUser.getEmail());
       // name = (parseUser.getUsername());
        Intent intent = new Intent(
                LoginSignupActivity.this,
                MainActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),
                "Welcome Back",
                Toast.LENGTH_LONG).show();


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.onActivityResult(requestCode, resultCode, data);
    }



}
