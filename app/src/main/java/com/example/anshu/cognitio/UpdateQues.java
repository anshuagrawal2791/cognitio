package com.example.anshu.cognitio;

import android.app.ProgressDialog;
import android.content.Intent;
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

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import fr.ganfra.materialspinner.MaterialSpinner;

public class UpdateQues extends AppCompatActivity {
    EditText ques,opta,optb,optc,optd;
    String  ques_str,opta_str,optb_str,optc_str,optd_str,corrop,email;
    Button submit , preview;
    MaterialSpinner corrop_spn;
    String table;
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


        submit=(Button)findViewById(R.id.submit_ques);
        preview=(Button)findViewById(R.id.preview);


        corrop_spn = (MaterialSpinner) findViewById(R.id.corrop);
        String[] optionsforques = {"A", "B", "C" ,"D"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, optionsforques);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        corrop_spn.setAdapter(adapter);

        Bundle extras = getIntent().getExtras();
        table = extras.getString("tablename");

        //    ParseObject tableName = new ParseObject(table);

        submit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                ques = ((EditText) findViewById(R.id.ques));
                opta = ((EditText) findViewById(R.id.opta));
                optb = ((EditText) findViewById(R.id.optb));
                optc = ((EditText) findViewById(R.id.optc));
                optd = ((EditText) findViewById(R.id.optd));

                ques_str = ((EditText) findViewById(R.id.ques)).getText().toString();
                opta_str = ((EditText) findViewById(R.id.opta)).getText().toString();
                optb_str = ((EditText) findViewById(R.id.optb)).getText().toString();
                optc_str = ((EditText) findViewById(R.id.optc)).getText().toString();
                optd_str = ((EditText) findViewById(R.id.optd)).getText().toString();
                corrop = corrop_spn.getSelectedItem().toString();
                if (ques_str.equals("")) {
                    ques.setError("This Field is required");
                } else if (opta_str.equals("")) {
                    opta.setError("This Field is required");
                } else if (optb_str.equals("")) {
                    optb.setError("This Field is required");
                } else if (optc_str.equals("")) {
                    optc.setError("This Field is required");
                } else if (optd_str.equals("")) {
                    optd.setError("This Field is required");
                } else if (corrop.equals("Select Option")) {
                    corrop_spn.setError("This Field is required");
                } else {
                    ParseUser user = ParseUser.getCurrentUser();
                    email = user.getEmail();

                    final ProgressDialog dialog1 = new ProgressDialog(UpdateQues.this);
                    dialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialog1.setMessage("Submitting..");
                    dialog1.setIndeterminate(true);
                    dialog1.setCanceledOnTouchOutside(false);
                    dialog1.show();
                    ParseObject tableName = new ParseObject(table);
                    Log.v("MAYANK789", table);

                    Log.v("MAYANK123", tableName + "got");
                    //   ParseQuery<ParseObject> teamQuery = ParseQuery.getQuery("Team");
                    tableName.put("User_email", email);
                    tableName.put("question", ques_str);
                    tableName.put("optionA", opta_str);
                    tableName.put("optionB", optb_str);
                    tableName.put("optionC", optc_str);
                    tableName.put("optionD", optd_str);
                    tableName.put("rightoption", corrop);
                    Log.v("mayank1234",corrop);
                    tableName.put("approval", "no");
                    // tableName.saveInBackground();

                    tableName.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {

                            dialog1.dismiss();
                            Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_LONG).show();
                            if (e != null)
                                Toast.makeText(UpdateQues.this, "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });


        preview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent prev = new Intent(UpdateQues.this,Preview.class);
                ques_str = ((EditText) findViewById(R.id.ques)).getText().toString();
                opta_str = ((EditText) findViewById(R.id.opta)).getText().toString();
                optb_str = ((EditText) findViewById(R.id.optb)).getText().toString();
                optc_str = ((EditText) findViewById(R.id.optc)).getText().toString();
                optd_str = ((EditText) findViewById(R.id.optd)).getText().toString();
                prev.putExtra("ques_str",ques_str);
                prev.putExtra("opta_str",opta_str);
                prev.putExtra("optb_str",optb_str);
                prev.putExtra("optc_str",optc_str);
                prev.putExtra("optd_str",optd_str);
                startActivity(prev);

                Log.v("intent100" , ques_str);


            }
        });

    }


}