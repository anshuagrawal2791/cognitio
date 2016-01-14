package com.example.anshu.cognitio;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import junit.framework.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Profile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profile.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    PieChart pieChart;

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    int matchesplayed;
    int matcheswon;
    int matcheslost;
    int matchestied;
    int index;
    ProgressDialog dialog2;
    TextView statstv;
    TextView Class;
    TextView city;
    ArrayList<Integer> indexy = new ArrayList<>();
    View v;
    private static final int GALLERY = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_profile, container, false);
        indexy.add(0, 1);
        indexy.add(1, 2);
        indexy.add(2, 3);
        sp = getActivity().getSharedPreferences("Details", Context.MODE_PRIVATE);

        //    }
        ParseUser user = ParseUser.getCurrentUser();


        TextView name = (TextView) v.findViewById(R.id.name);
        statstv = (TextView) v.findViewById(R.id.statstv);

        if (user.getString("name") != null)
            name.setText("Anshuman Agrawal");
            //name.setText(user.getString("name"));
        else
            name.setText(user.getUsername());

        if (user.getString("class") != null) {
            Class = (TextView) v.findViewById(R.id.Class);
            Class.setText(user.getString("class"));

        }
        if (user.getString("city") != null) {
            city = (TextView) v.findViewById(R.id.city);
            city.setText(user.getString("city"));

        }

        final ImageView imageView = (ImageView) v.findViewById(R.id.dp);
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


                                                       // Set the Bitmap into the
                                                       // ImageView
                                                       imageView.setImageBitmap(bmp);

                                                   } else {
                                                       Log.d("test",
                                                               "Problem load image the data.");
                                                   }
                                               }
                                           }

            );
        }

            //imageView.setImageBitmap(user.getParseFile("dp"));


            //  Drawable dr = LoginSignupActivity
            // fbimage();


            matchesplayed = user.getInt("matchesplayed");
            matcheswon = user.getInt("matcheswon");
            matcheslost = user.getInt("matcheslost");
            matchestied = user.getInt("matchestied");

            if (matchesplayed == 0)
                statstv.setText("No Stats");

            Log.e("ststs", "" + matchesplayed);
            Log.e("ststs", "" + matcheswon);
            Log.e("ststs", "" + matchestied);
            Log.e("ststs", "" + matcheslost);

            pieChart = (PieChart) v.findViewById(R.id.piechart);
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
            return v;


    }





    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    public void setData(){
        ArrayList<String> xVals;
        ArrayList<Entry>  yVals;
        ArrayList<Integer> colors;
        xVals = new ArrayList<String>();
        yVals = new ArrayList<Entry>();
        colors = new ArrayList<Integer>();
        if(matchestied>0) {
            xVals.add("Tied");
            yVals.add(new Entry(matchestied, indexy.get(0)));
            colors.add(indexy.get(0)-1,Color.GRAY);
            indexy.remove(0);
        }
        if(matcheswon>0)
        {
            xVals.add("Won");
            yVals.add(new Entry(matcheswon, indexy.get(0)));
            colors.add(indexy.get(0)-1,Color.GREEN);
            indexy.remove(0);
        }
        if(matcheslost>0)
        {
            xVals.add("Lost");
            yVals.add(new Entry(matcheslost, indexy.get(0)));
            colors.add(indexy.get(0)-1,Color.RED);
            indexy.remove(0);
        }


        //yVals.add(new Entry(matchestied, 0));
        //yVals.add(new Entry(matcheswon, 1));

        PieDataSet dataSet = new PieDataSet(yVals,"Performance");

        // colors.add(0,Color.GRAY);


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
    public int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        final float totalPixels = width * height;
        final float totalReqPixelsCap = reqWidth * reqHeight * 2;
        while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
            inSampleSize++;
        }

        return inSampleSize;
    }







    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
