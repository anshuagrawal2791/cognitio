package com.example.anshu.cognitio;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;

import fr.ganfra.materialspinner.MaterialSpinner;

public class UpdateQues extends AppCompatActivity {
    String ques,opta,optb,optc,optd,corrop,email;
    Button submit;
    MaterialSpinner corrop_spn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ques);
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

        ques = ((EditText)findViewById(R.id.ques)).toString();
        opta = ((EditText)findViewById(R.id.opta)).toString();
        optb = ((EditText)findViewById(R.id.optb)).toString();
        optc = ((EditText)findViewById(R.id.optc)).toString();
        optd = ((EditText)findViewById(R.id.optd)).toString();
        submit=(Button)findViewById(R.id.submit_ques);

        ParseUser user = ParseUser.getCurrentUser();
        email = user.getEmail();
        corrop_spn = (MaterialSpinner) findViewById(R.id.corrop);
        String[] optionsforques = {"A", "B", "C" ,"D"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, optionsforques);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        corrop_spn.setAdapter(adapter);
        corrop =  corrop_spn.getSelectedItem().toString();
        Bundle extras = getIntent().getExtras();
        String table = extras.getString("tablename");

        ParseObject tableName = new ParseObject("table");

        submit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                final ProgressDialog dialog1 = new ProgressDialog(UpdateQues.this);
                dialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog1.setMessage("Opening..");
                dialog1.setIndeterminate(true);
                dialog1.setCanceledOnTouchOutside(false);
                dialog1.show();
                ParseObject tableName = new ParseObject("table");
                Log.v("MAYANK123", tableName + "got");
                tableName.put("question", ques);
                tableName.put("optionA", opta);
                tableName.put("optionB", optb);
                tableName.put("optionC", optc);
                tableName.put("optiond", optd);
                tableName.put("rightoption", optd);
                tableName.put("User_email", corrop);
                tableName.put("approval", "no");
                tableName.saveInBackground();
                dialog1.dismiss();
                Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_LONG).show();
            }
        });

    }


}