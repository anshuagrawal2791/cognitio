package com.example.anshu.cognitio;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;
import com.parse.SignUpCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
    TextView fgtpwd;
    String emailforlink;

    CallbackManager callbackManager;

    ParseUser parseUser;
    String name = null, email = null;
    public static String id ;


    //ParseFile parseFile3;
    Button fbTest;

    public static final List<String> mPermissions = new ArrayList<String>() {{

        add("public_profile");
        add("email");

    }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String fbid =  LoginSignupActivity.id;
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

        fgtpwd = (TextView)findViewById(R.id.fgtpwd);


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



                    ParseQuery<ParseUser> query = ParseUser.getQuery();
                    query.whereEqualTo("email", usernametxt);
                    final ProgressDialog dialog = new ProgressDialog(LoginSignupActivity.this);
                    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialog.setMessage("Logging In...");
                    dialog.setIndeterminate(true);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                    query.findInBackground(new FindCallback<ParseUser>() {
                        @Override
                        public void done(List<ParseUser> objects, ParseException e) {
                            if(!objects.isEmpty()) {

                                ParseUser.logInInBackground(usernametxt, passwordtxt,
                                        new LogInCallback() {
                                            public void done(ParseUser user, ParseException e) {
                                                dialog.dismiss();
                                                if (user != null) {
                                                    // If user exist and authenticated, send user to Welcome.class
                                                    Intent intent = new Intent(LoginSignupActivity.this, MainActivity.class);
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                    startActivity(intent);
                                                    Toast.makeText(getApplicationContext(),
                                                            "Successfully Logged in",
                                                            Toast.LENGTH_LONG).show();
                                                    //dialog.dismiss();
                                                    //finish();
                                                } else {
                                                    Toast.makeText(
                                                            getApplicationContext(),
                                                            "Wrong Password!!",
                                                            Toast.LENGTH_LONG).show();
                                                    //dialog.dismiss();
                                                }
                                            }
                                        });
                            } else {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "No such user exist, please signup",
                                        Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            }
                        }
                    });
                }


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

                    final ProgressDialog dialog = new ProgressDialog(LoginSignupActivity.this);
                    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialog.setMessage("Signing Up...");
                    dialog.setIndeterminate(true);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                    // Save new user data into Parse.com Data Storage
                    ParseUser user = new ParseUser();
                    user.setEmail(usernametxt);
                    user.setUsername(usernametxt);
                    user.setPassword(passwordtxt);
                    user.put("english6", 0);
                    user.put("maths6", 0);
                    user.put("science6", 0);
                    user.put("socialstudies6", 0);
                    user.put("gk6", 0);

                    user.put("english7", 0);
                    user.put("maths7", 0);
                    user.put("science7", 0);
                    user.put("socialstudies7",0);
                    user.put("gk7", 0);

                    user.put("english8", 0);
                    user.put("maths8", 0);
                    // user.put("science8", 0);
                    // user.put("socialstudies8",0);
                    user.put("physics8",0);
                    user.put("chem8",0);
                    user.put("bio8",0);
                    user.put("history8",0);
                    user.put("civic8",0);
                    user.put("geo8",0);
                    user.put("eco8",0);
                    user.put("gk8",0);

                    user.put("english9", 0);
                    user.put("maths9", 0);
                    //  user.put("science9", 0);
                    //  user.put("socialstudies9",0);
                    user.put("physics9",0);
                    user.put("chem9",0);
                    user.put("bio9",0);
                    user.put("history9",0);
                    user.put("civic9",0);
                    user.put("geo9",0);
                    user.put("eco9",0);
                    user.put("gk9",0);

                    user.put("english10", 0);
                    user.put("maths10", 0);
                    // user.put("science10", 0);
                    // user.put("socialstudies10",0);
                    user.put("physics10",0);
                    user.put("chem10",0);
                    user.put("bio10",0);
                    user.put("history10",0);
                    user.put("civic10",0);
                    user.put("geo10",0);
                    user.put("eco10",0);
                    user.put("gk10",0);

                    user.put("english11", 0);
                    user.put("maths11", 0);
                    //  user.put("science11", 0);
                    // user.put("socialstudies11",0);
                    user.put("physics11",0);
                    user.put("chem11",0);
                    user.put("bio11",0);
                    user.put("gk11",0);

                    user.put("english12", 0);
                    user.put("maths12", 0);
                    // user.put("science12", 0);
                    // user.put("socialstudies12",0);
                    user.put("physics12",0);
                    user.put("chem12",0);
                    user.put("bio12",0);
                    user.put("gk12",0);

                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            dialog.dismiss();
                            if (e == null) {
                                // Show a simple Toast message upon successful registration
                                Toast.makeText(getApplicationContext(),
                                        "Successfully Signed up, please log in.",
                                        Toast.LENGTH_LONG).show();
                                //dialog.dismiss();
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Sign up Error", Toast.LENGTH_LONG)
                                        .show();
                                Log.e("sig", e.toString());
                                //dialog.dismiss();
                            }
                        }
                    });
                }

            }
        });
//        fbTest = (Button) findViewById(R.id.fbsignuptest);
//        fbTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(LoginSignupActivity.this, login3.class);
//                startActivity(i);
//            }
//        });


        fgtpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginSignupActivity.this);
                builder.setTitle("Forgot Password");
                //  builder.setMessage("Enter Email");
                builder.setCancelable(true);

// Set up the input
                final EditText input = new EditText(LoginSignupActivity.this);
// Specify the type of input expected; this, for example, sets the input as email
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                builder.setView(input,20,50,20,20);
                input.setHint("Email");
                input.setSingleLine();






// Set up the buttons
                builder.setPositiveButton("Send Reset Link", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {
                        emailforlink = input.getText().toString();
                        Log.e("ft", emailforlink);

                        if (emailforlink != null) {
                            String emailsend = emailforlink;
                            Log.e("mayank debug", emailsend);
                            final int e = Log.e("reset password", emailsend);
                            final ProgressDialog dialog1 = new ProgressDialog(LoginSignupActivity.this);
                            dialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                            dialog1.setMessage("Sending Reset Link...");
                            dialog1.setIndeterminate(true);
                            dialog1.setCanceledOnTouchOutside(false);
                            dialog1.show();
                            ParseUser.requestPasswordResetInBackground(emailsend, new RequestPasswordResetCallback() {
                                @Override
                                public void done(ParseException e) {
                                    if (e == null) {
                                        Toast.makeText(getApplicationContext(), "Reset Link Successfully Sent", Toast.LENGTH_LONG).show();
                                        dialog1.dismiss();

                                    } else {
                                        Toast.makeText(getApplicationContext(), "Something went wrong.Please Try Again", Toast.LENGTH_LONG).show();
                                        Log.e("reset password", "link not sent", e);
                                        dialog1.dismiss();
                                    }
                                }
                            });
                        }
                        else {
                            Log.d("mayank123","null edit text" );

                        }


                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });

    }

    private void getUserDetailsFromFB() {
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(final JSONObject object, GraphResponse response) {
                        try{
                            //What to do after Facebook Login is successful
                            email = response.getJSONObject().getString("email");
                            name = response.getJSONObject().getString("name");
//                            picture = response.toString();
//                            Log.e("Pic",picture);
                            //tv.setText(email + "   " + name);
                            id = response.getJSONObject().getString("id");
                            Log.d("mayank",id);

                            ParseQuery<ParseUser> query = ParseUser.getQuery();
                            query.whereEqualTo("email", email);
                            final ProgressDialog dialog = new ProgressDialog(LoginSignupActivity.this);
                            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                            dialog.setMessage("Logging In...");
                            dialog.setIndeterminate(true);
                            dialog.setCanceledOnTouchOutside(false);
                            dialog.show();

                            query.findInBackground(new FindCallback<ParseUser>() {
                                public void done(List<ParseUser> objects, ParseException e) {
                                    if (e == null) {
                                        // The query was successful.
                                        //Toast.makeText(getApplicationContext(), "In", Toast.LENGTH_LONG).show();
                                        if(objects.isEmpty()) {
                                            //Sign up
                                            ParseUser user = new ParseUser();
                                            user.setEmail(email);
                                            user.setUsername(email);
                                            user.put("name", name);
                                            user.setPassword(id);
                                            user.put("english6", 0);
                                            user.put("maths6", 0);
                                            user.put("science6", 0);
                                            user.put("socialstudies6", 0);
                                            user.put("english7", 0);
                                            user.put("maths7", 0);
                                            user.put("science7", 0);
                                            user.put("socialstudies7",0);
                                            user.put("english8", 0);
                                            user.put("maths8", 0);
                                            user.put("science8", 0);
                                            user.put("socialstudies8",0);
                                            user.put("english9", 0);
                                            user.put("maths9", 0);
                                            user.put("science9", 0);
                                            user.put("socialstudies9",0);
                                            user.put("english10", 0);
                                            user.put("maths10", 0);
                                            user.put("science10", 0);
                                            user.put("socialstudies10",0);
                                            user.put("english11", 0);
                                            user.put("maths11", 0);
                                            user.put("science11", 0);
                                            user.put("socialstudies11",0);
                                            user.put("english12", 0);
                                            user.put("maths12", 0);
                                            user.put("science12", 0);
                                            user.put("socialstudies12",0);

                                            user.signUpInBackground(new SignUpCallback() {
                                                public void done(ParseException e) {

                                                    if (e == null) {
                                                        // Hooray! Let them use the app now.
                                                        new getbmglide().execute(id);
                                                        Log.e("fblogin", "Done, Dude!! You signed up");


                                                        //


                                                        //dialog.dismiss();


                                                        //Toast.makeText(getApplicationContext(), "Done, Dude!! You signed up", Toast.LENGTH_LONG).show();
                                                    } else {
                                                        // Sign up didn't succeed. Look at the ParseException
                                                        // to figure out what went wrong
                                                        Toast.makeText(getApplicationContext(), "Unable to connect. Try Again", Toast.LENGTH_LONG).show();
                                                        Log.e("mayank", e.toString());
                                                        // dialog.dismiss();
                                                    }
                                                }
                                            });
                                        } else {

                                            ParseUser.logInInBackground(email, id,
                                                    new LogInCallback() {
                                                        public void done(ParseUser user, ParseException e) {

                                                            if (user != null) {
                                                                //new getbmglide().execute(id);
                                                                // If user exist and authenticated, send user to Welcome.class

                                                                //   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                                                                Intent intent = new Intent(LoginSignupActivity.this, MainActivity.class);
                                                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                startActivity(intent);
                                                                Toast.makeText(getApplicationContext(),
                                                                        "Welcome Back "+name,
                                                                        Toast.LENGTH_LONG).show();
                                                                dialog.dismiss();

                                                                //finish();
                                                            } else {
                                                                Toast.makeText(
                                                                        getApplicationContext(),
                                                                        "Error",
                                                                        Toast.LENGTH_LONG).show();
                                                            }
                                                        }
                                                    });
                                            //Login
                                            //Toast.makeText(getApplicationContext(), "Already Exists. Logging in... Welcome!", Toast.LENGTH_LONG).show();
//                                            Intent intent = new Intent(
//                                                    LoginSignupActivity.this,
//                                                    MainActivity.class);
//                                            startActivity(intent);
//                                            Toast.makeText(getApplicationContext(),
//                                                    "Welcome Back",
//                                                    Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        dialog.dismiss();
                                        // Something went wrong.
                                        Toast.makeText(getApplicationContext(), "Error! Try Again", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                        } catch (JSONException e) {
                            //If anything goes wrong
                            Log.e("my",e.toString());
                        }
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "name,email,picture");
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

    public class getbmglide extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... params) {

            try {
                Bitmap fbdp = Glide.
                        with(LoginSignupActivity.this).
                        load("http://graph.facebook.com/" + params[0] + "/picture?type=large").
                        asBitmap().
                        into(-1, -1).
                        get();
                byte[] fbarray = util.getbytearray(fbdp);
                ParseUser user = ParseUser.getCurrentUser();
                ParseFile parseFilefb = new ParseFile("fb_dp.png",fbarray);


                parseFilefb.saveInBackground();

                user.put("dp", parseFilefb);
                user.saveInBackground();

                Thread timerThread = new Thread(){
                    public void run(){
                        try{
                            ParseUser user= ParseUser.getCurrentUser();
                            while(user.getParseFile("dp").getUrl()==null)
                                sleep(2000);

                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                timerThread.start();
                timerThread.join();

                Log.e("mayank", "asynctask2 successful");
            } catch (final ExecutionException |InterruptedException  e) {
                Log.e("mayank", e.getMessage());
            }
            return null;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {

            Intent intent = new Intent(LoginSignupActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),
                    "Successfully Logged in",
                    Toast.LENGTH_LONG).show();

        }

    }









}