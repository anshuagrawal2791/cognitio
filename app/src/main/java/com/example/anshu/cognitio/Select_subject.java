package com.example.anshu.cognitio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Select_subject extends AppCompatActivity {

    public int Class;
    public String Subject;
    public TextView classtv;
    ImageView iv1;
    ImageView iv2;
    ImageView iv3;
    ImageView iv4;
    ImageView iv5;
    ImageView iv6;
    ImageView iv7;
    ImageView iv8;
    ImageView iv9;
    ImageView iv10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_select_subject);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {

            Class = extras.getInt("class");
            // Toast.makeText(this,""+Class,Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show();
            System.exit(0);
        }

        classtv = (TextView)findViewById(R.id.classtv);
        classtv.setText("Class "+ Class);
        iv1=(ImageView)findViewById(R.id.iv1);
        iv2=(ImageView)findViewById(R.id.iv2);
        iv3=(ImageView)findViewById(R.id.iv3);
        iv4=(ImageView)findViewById(R.id.iv4);
        iv5=(ImageView)findViewById(R.id.iv5);
        iv6=(ImageView)findViewById(R.id.iv6);
        iv7=(ImageView)findViewById(R.id.iv7);
        iv8=(ImageView)findViewById(R.id.iv8);
        iv9=(ImageView)findViewById(R.id.iv9);
        iv10=(ImageView)findViewById(R.id.iv10);

        if(Class==6||Class==7)
        {
            iv1.setImageResource(R.drawable.e);
            iv2.setImageResource(R.drawable.m);
            iv3.setImageResource(R.drawable.sc);
            iv4.setImageResource(R.drawable.sst);
            iv5.setImageResource(R.drawable.gk);
            iv6.setVisibility(View.GONE);
            iv7.setVisibility(View.GONE);
            iv8.setVisibility(View.GONE);
            iv9.setVisibility(View.GONE);
            iv10.setVisibility(View.GONE);
            iv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject", "English");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });
iv5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
        intent.putExtra("Subject", "GeneralKnowledge");
        intent.putExtra("Class", Class);
        startActivity(intent);
    }
});
iv2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
        intent.putExtra("Subject", "Maths");
        intent.putExtra("Class", Class);
        startActivity(intent);
    }
});
iv3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
        intent.putExtra("Subject", "Science");
        intent.putExtra("Class", Class);
        startActivity(intent);
    }
});
iv4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),TopicActivity.class);
                    intent.putExtra("Subject","SocialStudies");
                    intent.putExtra("Class",Class);
                    startActivity(intent);
                }
            });

        }
        if(Class==8||Class==9||Class==10)
        {
            iv1.setImageResource(R.drawable.e);
            iv2.setImageResource(R.drawable.p);
            iv3.setImageResource(R.drawable.c);
            iv4.setImageResource(R.drawable.b);
            iv5.setImageResource(R.drawable.m);
            iv6.setImageResource(R.drawable.profile);
            iv7.setImageResource(R.drawable.cv);
            iv8.setImageResource(R.drawable.g);
            iv9.setImageResource(R.drawable.ec);
            iv10.setImageResource(R.drawable.gk);
            iv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject", "English");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });
iv10.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
        intent.putExtra("Subject", "GeneralKnowledge");
        intent.putExtra("Class", Class);
        startActivity(intent);
    }
});
iv2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
        intent.putExtra("Subject", "Physics");
        intent.putExtra("Class", Class);
        startActivity(intent);
    }
});
iv3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
        intent.putExtra("Subject", "Chemistry");
        intent.putExtra("Class", Class);
        startActivity(intent);
    }
});
iv4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
        intent.putExtra("Subject", "Biology");
        intent.putExtra("Class", Class);
        startActivity(intent);
    }
});
iv5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject","Maths");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });
iv6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject","History");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });
iv7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject","Civics");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });
iv8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject","Geography");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });
iv9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject","Economics");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });

        }

        if(Class==11||Class==12)
        {
            iv1.setImageResource(R.drawable.e);
            iv2.setImageResource(R.drawable.p);
            iv3.setImageResource(R.drawable.c);
            iv4.setImageResource(R.drawable.b);
            iv5.setImageResource(R.drawable.m);
            iv6.setImageResource(R.drawable.gk);
            iv7.setVisibility(View.GONE);
            iv8.setVisibility(View.GONE);
            iv9.setVisibility(View.GONE);
            iv10.setVisibility(View.GONE);

            iv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject", "English");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });
            iv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject", "Physics");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });
            iv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject", "Chemistry");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });
            iv4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject", "Biology");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });
            iv5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject","Maths");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });
            iv6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                    intent.putExtra("Subject","GeneralKnowledge");
                    intent.putExtra("Class", Class);
                    startActivity(intent);
                }
            });



        }
    }

}
