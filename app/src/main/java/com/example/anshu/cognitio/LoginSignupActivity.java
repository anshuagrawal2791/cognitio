package com.example.anshu.cognitio;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
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
    LoginButton mBtnFb;
    TextView mUsername, mEmailID;
    Profile mFbProfile;

    CallbackManager callbackManager;

    ParseUser parseUser;
    String name = null, email = null;

    Button fbTest;

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

        FacebookSdk.sdkInitialize(this.getApplicationContext());


        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        loginbutton = (Button) findViewById(R.id.login);
        callbackManager = CallbackManager.Factory.create();

        signup = (Button) findViewById(R.id.signup);
        mBtnFb = (LoginButton)findViewById(R.id.mBtnFb);
        mBtnFb.setReadPermissions("email");
        tv = (TextView)findViewById(R.id.tv);


        mBtnFb.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                getUserDetailsFromFB();
            }

            @Override
            public void onCancel() {
                // App code
                Log.v("LoginActivity", "cancel");
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Log.v("LoginActivity", exception.getCause().toString());
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
                    user.setEmail(usernametxt);
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
        fbTest = (Button) findViewById(R.id.fbsignuptest);
        fbTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginSignupActivity.this, login3.class);
                startActivity(i);
            }
        });

    }

    private void getUserDetailsFromFB() {
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try{
                            //What to do after Facebook Login is successful
                            email = response.getJSONObject().getString("email");
                            name = response.getJSONObject().getString("name");
                            tv.setText(email + "   " + name);
                            ParseUser user = new ParseUser();
                            user.setEmail(email);
                            user.setUsername(name);

                            StringBuffer str = new StringBuffer(name);
                            str.substring(0, 6);
                            user.setPassword(str.toString());
                            /*Intent intent = new Intent(
                                    LoginSignupActivity.this,
                                    MainActivity.class);
                            startActivity(intent);*/
                            user.signUpInBackground(new SignUpCallback() {
                                public void done(ParseException e) {
                                    if (e == null) {
                                        // Hooray! Let them use the app now.
                                        Toast.makeText(getApplicationContext(), "Done, Dude!!", Toast.LENGTH_LONG).show();
                                    } else {
                                        // Sign up didn't succeed. Look at the ParseException
                                        // to figure out what went wrong
                                        Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                            //finish();

                        } catch (JSONException e) {
                            //If anything goes wrong
                            Log.e("my",e.toString());
                        }
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "name,email");
        request.setParameters(parameters);
        request.executeAsync();



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
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }



}
