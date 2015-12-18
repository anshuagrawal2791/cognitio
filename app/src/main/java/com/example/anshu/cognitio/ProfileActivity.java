package com.example.anshu.cognitio;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;

import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    static String picturePath1;

    private static final int GALLERY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        //    }
        ParseUser user = ParseUser.getCurrentUser();
        //  Drawable dr = LoginSignupActivity
        // fbimage();
        ImageView imageView = (ImageView) findViewById(R.id.dp);
        if (imageView.getDrawable() == null){
            new filetoimage().execute();
        }
        else{
            Log.v("mayank", "mayank not null");
        }
        Button update_dp = (Button) findViewById(R.id.update_dp);
        Button stats = (Button) findViewById(R.id.stats);
       // Button ranking = (Button) findViewById(R.id.ranking);
        if(user!=null){
            update_dp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ImageView imageView = (ImageView) findViewById(R.id.dp);

                    Intent intent = new Intent(
                            Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    Intent.createChooser(intent, "Select Picture");
                    PackageManager packageManager = getPackageManager();

                    List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,0);
                    boolean check = activities.size()>0;
                    if (check){
                        startActivityForResult(intent,GALLERY);
                    }
                }
            });
            stats.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            ProfileActivity.this,Statistics.class);
                   startActivity(intent);
                }
            });

        }
        else{
            Toast.makeText(getApplicationContext(),
                    "User not logged in",
                    Toast.LENGTH_LONG).show();
        }
    }
   /* private void fbimage(){
        ImageView imageView = (ImageView) findViewById(R.id.dp);
        if(imageView!=null){
               Bundle mayank123 = getIntent().getExtras();
            if(mayank123==null){
                Log.d("mayank","null intent bundle");
            }
            else {
                Log.d("mayank","null not intent bundle");
            }
                String fbid =  LoginSignupActivity.id;
           // if(fbid!=null){
                 //Glide.with(this).load("http://graph.facebook.com/1615242245409408/picture?type=large").into(imageView);
                Glide.with(this).load("http://graph.facebook.com/" + fbid + "/picture?type=large").into(imageView);
                Log.d("mayank", LoginSignupActivity.id);
            imageView.buildDrawingCache(true);
            Bitmap fbbitmap2 = imageView.getDrawingCache(true);
          //  fbbitmap2 = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
            //  }
           // else{
            //    Log.d("mayank","null facebook id");
            //}
        }
        else {
            Log.d("mayank","null image view");
        }
    }
*/


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY && resultCode!=0){
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            if(cursor!=null){
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String  picturePath = cursor.getString(columnIndex);
                picturePath1 = picturePath;
                cursor.close();
                ImageView imageView = (ImageView) findViewById(R.id.dp);
                Bitmap dpbitmap = BitmapFactory.decodeFile(picturePath);
                imageView.setImageBitmap(dpbitmap);
                new storeimage().execute(dpbitmap);

               /* Bitmap dpbitmap2 = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
                dpbitmap.compress(Bitmap.CompressFormat.PNG, 0, stream2);
                byte[] byteArray2 = stream2.toByteArray();
                ParseFile parseFile2 = new ParseFile(user.getUsername()+"dp_circle.png",byteArray2);
                ParseObject dp = new ParseObject("dp");
                dp.put("pic",byteArray2);
                dp.pinInBackground();*/
            }
            else {
                Log.d("mayank", "null cursor");
            }
        }
    }
    public class storeimage extends AsyncTask<Bitmap,Void,Void>{

        @Override
        protected Void doInBackground(Bitmap... params) {
            byte[] byteArray = util.getbytearray(params[0]);
            ParseUser user = ParseUser.getCurrentUser();
            ParseFile parseFile = new ParseFile(user.getUsername()+"dp.png",byteArray);
            parseFile.saveInBackground();
            user.put("dp", parseFile);
            user.saveInBackground();
            Log.d("mayank","asynctask successful");

            //  Bitmap dpbitmap2 = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
            //ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
            //  dpbitmap.compress(Bitmap.CompressFormat.PNG, 0, stream2);
            // byte[] byteArray2 = stream2.toByteArray();
            // ParseFile parseFile2 = new ParseFile(user.getUsername()+"dp_circle.png",byteArray2);
            // ParseObject dp = new ParseObject("dp");
            // dp.put("pic",byteArray2);
            // dp.pinInBackground();
            return null;
        }
    }

    public class filetoimage extends AsyncTask<Void,Void,Void >
    {

        @Override
        protected Void doInBackground(Void... params)
        {
            ParseUser user = ParseUser.getCurrentUser();
            ParseFile pf;
            // if (ParseFacebookUtils.isLinked(user)) {
            //      pf = user.getParseFile("fbdp");
            //    Log.d("mayank", "fb linked");
            //    }
            // else {
            pf = user.getParseFile("dp");
            //     Log.d("mayank","fb not linked");
            //   }
           /* Log.d("mayank", "asynctask image mayank successful");
            Log.d("mayank", pf.getUrl());
            //  return pf.getUrl();
     //   }
        */

            if (pf != null)

            {
                pf.getDataInBackground(new

                                               GetDataCallback() {

                                                   public void done(byte[] data,
                                                                    ParseException e) {
                                                       if (e == null) {
                                                           // Decode the Byte[] into
                                                           // Bitmap
                                                           Bitmap bmp = BitmapFactory
                                                                   .decodeByteArray(
                                                                           data, 0,
                                                                           data.length);

                                                           // initialize
                                                           ImageView image = (ImageView) findViewById(R.id.dp);

                                                           // Set the Bitmap into the
                                                           // ImageView
                                                           image.setImageBitmap(bmp);

                                                       } else {
                                                           Log.d("test",
                                                                   "Problem load image the data.");
                                                       }
                                                   }
                                               }

                );

            }
            return null;

        }


      /*  @Override
        protected void onPostExecute(String result) {
            ImageView imageView = (ImageView) findViewById(R.id.dp);
            Log.d("result", result);
            Glide.with(ProfileActivity.this).load(result).into(imageView);
            Log.d("mayank", "asynctask image successful");
        }        */
    }

}