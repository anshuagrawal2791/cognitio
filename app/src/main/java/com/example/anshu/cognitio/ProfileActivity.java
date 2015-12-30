package com.example.anshu.cognitio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class ProfileActivity extends AppCompatActivity {
    static String picturePath1;
    MaterialSpinner spinner1;
    MaterialSpinner spinner2;
    PieChart pieChart;

    SharedPreferences sp ;
    SharedPreferences.Editor editor;
    int matchesplayed;
    int matcheswon;
    int matcheslost;
    int matchestied;
    int index;
    ProgressDialog dialog2;
    TextView statstv;

    private static final int GALLERY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        //    }
        ParseUser user = ParseUser.getCurrentUser();


        String[] ITEMSforcity = {"Ajmer", "Sikar", "Jaipur"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSforcity);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1 = (MaterialSpinner) findViewById(R.id.citysp);
        spinner1.setAdapter(adapter1);
        String[] ITEMSforclass = {"Sixth", "Seventh", "Eighth", "Ninth", "Tenth", "Eleventh","Twelth"};;
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSforclass);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2 = (MaterialSpinner) findViewById(R.id.classsp);
        spinner2.setAdapter(adapter2);
        TextView name = (TextView)findViewById(R.id.name);
        statstv = (TextView)findViewById(R.id.statstv);

        if(user.getString("name")!=null)
            name.setText(user.getString("name"));
        else
            name.setText(user.getUsername());

        if(user.getString("class")!=null)
        {
            String userclass= user.getString("class");

            if(userclass.equals("Sixth"))
                index=0;
            else if (userclass.equals("Seventh"))
                index=1;
            else if (userclass.equals("Eighth"))
                index=2;
            else if (userclass.equals("Ninth"))
                index=3;
            else if (userclass.equals("Tenth"))
                index=4;
            else if (userclass.equals("Eleventh"))
                index=5;
            else if (userclass.equals("Twelfth"))
                index=6;

            spinner2.setSelection(index+1);
            Log.e("cls",index+"");


        }




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
        //Button stats = (Button) findViewById(R.id.stats);
        Button updateprofile = (Button) findViewById(R.id.updateprofile);


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


            updateprofile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = ((EditText) findViewById(R.id.name)).getText().toString();
                   ParseUser user = ParseUser.getCurrentUser();
                    String userclass =  spinner2.getSelectedItem().toString();
                    String city =  spinner1.getSelectedItem().toString();

                    user.put("name",name);
                    user.put("class",userclass);
                    user.put("city",city);
                    final ProgressDialog dialog = new ProgressDialog(ProfileActivity.this);
                    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialog.setMessage("Saving...");
                    dialog.setIndeterminate(true);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                    user.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            dialog.dismiss();
                            if(e!=null)
                                Toast.makeText(ProfileActivity.this,"Error",Toast.LENGTH_LONG).show();
                        }
                    });

                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(),
                    "User not logged in",
                    Toast.LENGTH_LONG).show();
        }

        sp = getSharedPreferences("Details", MODE_PRIVATE);


        matchesplayed = sp.getInt("matchesplayed", 0);
        matcheswon = sp.getInt("matcheswon", 0);
        matcheslost = sp.getInt("matcheslost", 0);
        matchestied = sp.getInt("matchestied", 0);

        if(matchesplayed==0)
            statstv.setText("No Stats");

        Log.e("ststs",""+matchesplayed);
        Log.e("ststs",""+matcheswon);
        Log.e("ststs",""+matchestied);
        Log.e("ststs",""+matcheslost);

        pieChart = (PieChart) findViewById(R.id.piechart);
        // pieChart.setUsePercentValues(true);
        pieChart.setDescription("Statistics");
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setExtraRightOffset(20f);
        setData();
        Legend l = pieChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColorTransparent(true);
        pieChart.setCenterText(generateCenterSpannableText());

        pieChart.setTransparentCircleColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(110);

        pieChart.setHoleRadius(58f);
        pieChart.setTransparentCircleRadius(61f);

        pieChart.setDrawCenterText(true);

        pieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true);
        pieChart.setHighlightPerTapEnabled(true);



    }

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
                dialog2 = new ProgressDialog(ProfileActivity.this);
                dialog2.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog2.setMessage("Uploading...");
                dialog2.setIndeterminate(true);
                dialog2.setCanceledOnTouchOutside(false);
                dialog2.show();
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

            user.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                    if(e!=null) {
                        Toast.makeText(ProfileActivity.this, "Error", Toast.LENGTH_LONG).show();
                        dialog2.dismiss();

                    }
                    else
                        dialog2.dismiss();
                }
            });
            Log.e("mayank","asynctask successful");

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

    public void setData(){
        ArrayList<String> xVals;
        ArrayList<Entry>  yVals;
        ArrayList<Integer> colors;
        xVals = new ArrayList<String>();
        yVals = new ArrayList<Entry>();
        colors = new ArrayList<Integer>();
        xVals.add("Tied");
        xVals.add("Won");
        xVals.add("Lost");
        yVals.add(new Entry(matchestied, 0));
        yVals.add(new Entry(matcheswon, 1));
        yVals.add(new Entry(matcheslost, 2));
        PieDataSet dataSet = new PieDataSet(yVals,"Performance");

        colors.add(0,Color.GRAY);
        colors.add(1,Color.GREEN);
        colors.add(2,Color.RED);
        dataSet.setColors(colors);
        dataSet.setSliceSpace(2f);
        dataSet.setSelectionShift(10f);
        PieData pieData = new PieData(xVals,dataSet);
        pieChart.setData(pieData);
        pieChart.notifyDataSetChanged();
        pieChart.invalidate();
    }
    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, 0, 0);
        //  s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        // s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        // s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        //  s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        //  s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }

}