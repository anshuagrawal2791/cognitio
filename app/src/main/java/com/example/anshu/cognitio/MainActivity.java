package com.example.anshu.cognitio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialdrawer.util.RecyclerViewCacheUtil;
import com.parse.ParseUser;

import fr.ganfra.materialspinner.MaterialSpinner;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardViewNative;

public class MainActivity extends AppCompatActivity {

    MaterialSpinner spinner;

    private static final int PROFILE_SETTING = 1;
    private AccountHeader headerResult = null;
    private Drawer result = null;
    IProfile profile;
    SharedPreferences sp ;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        ParseUser user  = ParseUser.getCurrentUser();
        // Toast.makeText(getApplicationContext(), " " + user.getEmail() + " " + user.get("name"), Toast.LENGTH_LONG);



        String[] ITEMS = {"Sixth", "Seventh", "Eighth", "Ninth", "Tenth", "Eleventh","Twelfth"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = (MaterialSpinner) findViewById(R.id.classsp);
        spinner.setAdapter(adapter);





        MaterialLargeImageCard card =
                MaterialLargeImageCard.with(MainActivity.this)
                        .setTextOverImage("English")
                        .setTitle("English")
                        .useDrawableId(R.drawable.splash)
                                //.setupSupplementalActions(R.layout.carddemo_native_material_supplemental_actions_large_icon, actions)
                        .build();
        MaterialLargeImageCard card2 =
                MaterialLargeImageCard.with(MainActivity.this)
                        .setTextOverImage("Maths").setTitle("Maths")
                        .useDrawableId(R.drawable.splash)
                                //.setupSupplementalActions(R.layout.carddemo_native_material_supplemental_actions_large_icon, actions)
                        .build();
        MaterialLargeImageCard card3 =
                MaterialLargeImageCard.with(MainActivity.this)
                        .setTextOverImage("Social Studies").setTitle("Social Studies")
                        .useDrawableId(R.drawable.splash)
                                //.setupSupplementalActions(R.layout.carddemo_native_material_supplemental_actions_large_icon, actions)
                        .build();
        MaterialLargeImageCard card4 =
                MaterialLargeImageCard.with(MainActivity.this)
                        .setTextOverImage("Science").setTitle("Science")
                        .useDrawableId(R.drawable.splash)
                                //.setupSupplementalActions(R.layout.carddemo_native_material_supplemental_actions_large_icon, actions)
                        .build();

        DrawerImageLoader.init(new AbstractDrawerImageLoader() {
            @Override
            public void set(ImageView imageView, Uri uri, Drawable placeholder) {
                Glide.with(imageView.getContext()).load(uri).placeholder(placeholder).into(imageView);
            }

            @Override
            public void cancel(ImageView imageView) {
                Glide.clear(imageView);
            }
        });



//        actions = new ArrayList<BaseSupplementalAction>();
//
//        actions = new ArrayList<BaseSupplementalAction>();
//
//        IconSupplementalAction t1 = new IconSupplementalAction(MainActivity.this, R.id.ic1);
//        t1.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
//            @Override
//            public void onClick(Card card, View view) {
//                Toast.makeText(MainActivity.this," Click on Text SHARE ",Toast.LENGTH_SHORT).show();
//            }
//        });
//        actions.add(t1);
//
//        IconSupplementalAction t2 = new IconSupplementalAction(MainActivity.this, R.id.ic2);
//        t2.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
//            @Override
//            public void onClick(Card card, View view) {
//                Toast.makeText(MainActivity.this," Click on Text LEARN ",Toast.LENGTH_SHORT).show();
//            }
//        });
//        actions.add(t2);







        card.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                if(spinner.getSelectedItemPosition()==0)
                    spinner.setError("Select a Class");
                else
                {
                    Intent intent = new Intent(MainActivity.this,TopicActivity.class);
                    intent.putExtra("Class",spinner.getSelectedItemPosition());
                    intent.putExtra("Subject",card.getTitle());
                    startActivity(intent);
                }
                Toast.makeText(MainActivity.this, card.getTitle().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        card2.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                if(spinner.getSelectedItemPosition()==0)
                    spinner.setError("Select a Class");
                else
                {
                    Intent intent = new Intent(MainActivity.this,TopicActivity.class);
                    intent.putExtra("Class",spinner.getSelectedItemPosition());
                    intent.putExtra("Subject",card.getTitle());
                    startActivity(intent);
                }
                Toast.makeText(MainActivity.this, card.getTitle().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        card3.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                if (spinner.getSelectedItemPosition() == 0)
                    spinner.setError("Select a Class");
                else {
                    Intent intent = new Intent(MainActivity.this, TopicActivity.class);
                    intent.putExtra("Class", spinner.getSelectedItemPosition());
                    intent.putExtra("Subject", card.getTitle());
                    startActivity(intent);
                }

                Toast.makeText(MainActivity.this, card.getTitle().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        card4.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                if (spinner.getSelectedItemPosition() == 0)
                    spinner.setError("Select a Class");
                else {
                    Intent intent = new Intent(MainActivity.this, TopicActivity.class);
                    intent.putExtra("Class", spinner.getSelectedItemPosition());
                    intent.putExtra("Subject", card.getTitle());
                    startActivity(intent);
                }
                Toast.makeText(MainActivity.this, card.getTitle().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        CardViewNative cardView = (CardViewNative) MainActivity.this.findViewById(R.id.carddemo_largeimage);
        cardView.setCard(card);
        CardViewNative cardView2 = (CardViewNative) MainActivity.this.findViewById(R.id.carddemo_largeimage2);
        cardView2.setCard(card2);
        CardViewNative cardView3 = (CardViewNative) MainActivity.this.findViewById(R.id.carddemo_largeimage3);
        cardView3.setCard(card3);
        CardViewNative cardView4 = (CardViewNative) MainActivity.this.findViewById(R.id.carddemo_largeimage4);
        cardView4.setCard(card4);

        String fbid =  LoginSignupActivity.id;
        if(user.getString("name")!=null&&user.getParseFile("dp").getUrl()!=null)
        { Log.e("vv", user.getString("name"));
        Log.e("vv", user.getParseFile("dp").getUrl());}

        //Log.e("vv",user.getParseFile("dp"));

        if(user.get("name")!=null&&user.getParseFile("dp")!=null)

        {
            //    profile = new ProfileDrawerItem().withName(user.get("name").toString()).withEmail(user.getUsername())
            //          .withIcon("https://avatars3.githubusercontent.com/u/1476232?v=3&s=460").withIdentifier(100);

            String name2 = (user.get("name")).toString();
            profile = new ProfileDrawerItem().withName(name2).withEmail(user.getUsername())
                    .withIcon(user.getParseFile("dp").getUrl()).withIdentifier(100);
        }
        else if(user.getParseFile("dp")!=null)
        {
            profile = new ProfileDrawerItem().withEmail(user.getUsername())
                    .withIcon(user.getParseFile("dp").getUrl()).withIdentifier(100);
        }
        else if(user.get("name")!=null) {
            profile = new ProfileDrawerItem().withName(user.getString("name")).withEmail(user.getUsername())
                    /*.withIcon(R.drawable.userdefault)*/.withIdentifier(100);
        }


            //    profile = new ProfileDrawerItem().withEmail(user.getUsername())
            //          .withIcon("https://avatars3.githubusercontent.com/u/1476232?v=3&s=460").withIdentifier(100);


        else
        {
                profile = new ProfileDrawerItem().withEmail(user.getUsername())
                        .withIdentifier(100);

            }


        headerResult=new

                AccountHeaderBuilder()

                .

                        withActivity(this)

                .

                        withHeaderBackground(R.mipmap.header)

                .

                        addProfiles(profile)

                .

                        withSavedInstance(savedInstanceState)

                .

                        build();

        result=new

                DrawerBuilder()

                .

                        withActivity(this)

                .

                        withToolbar(toolbar)

                .

                        withHasStableIds(true)

                .

                        withAccountHeader(headerResult)

                .

                        addDrawerItems(new PrimaryDrawerItem()

                                        .

                                                withName(R.string.logout)

                                        .

                                                withDescription("Logout from your account")

                                        .

                                                withIcon(R.mipmap.splash)

                                        .

                                                withIdentifier(1)

                                        .

                                                withSelectable(false),

                                new

                                        PrimaryDrawerItem()

                                        .

                                                withName(R.string.Profile)

                                        .

                                                withDescription("View and Update Your Profile")

                                        .

                                                withIcon(R.mipmap.splash)

                                        .

                                                withIdentifier(2)

                                        .

                                                withSelectable(false)

                        )
                .

                        withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                                          @Override
                                                          public boolean onItemClick (View view,int position, IDrawerItem drawerItem){
                                                              if (drawerItem != null) {
                                                                  if (drawerItem.getIdentifier() == 1) {
                                                                      ProgressDialog dialog = new ProgressDialog(MainActivity.this);
                                                                      dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                                                      dialog.setMessage("Logging Out...");
                                                                      dialog.setIndeterminate(true);
                                                                      dialog.setCanceledOnTouchOutside(false);
                                                                      dialog.show();
                                                                      ParseUser currentUser = ParseUser.getCurrentUser();
                                                                      ParseUser.logOut();
                                                                      ParseUser currentUserafterlogout = ParseUser.getCurrentUser();

                                                                      if (currentUserafterlogout == null) {
                                                                          Intent intent = new Intent(MainActivity.this, LoginSignupActivity.class);
                                                                          startActivity(intent);
                                                                          //dialog.dismiss();
                                                                          Toast.makeText(getApplicationContext(), "Successfully Logged Out", Toast.LENGTH_LONG).show();
                                                                      } else {
                                                                          //dialog.dismiss();
                                                                          Toast.makeText(getApplicationContext(), "Could Not Log Out. Please Try Again.", Toast.LENGTH_LONG).show();
                                                                      }

                                                                  }
                                                                  if (drawerItem.getIdentifier() == 2) {
                                                                      startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                                                                  }
                                                              }
                                                              return false;
                                                          }
                                                      }

                        ).

                        withSavedInstance(savedInstanceState)

                .

                        withShowDrawerOnFirstLaunch(true)

                .

                        build();

        RecyclerViewCacheUtil.getInstance().

                withCacheSize(2)

                .

                        init(result);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.logout) {
            ProgressDialog dialog = new ProgressDialog(MainActivity.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("Logging Out...");
            dialog.setIndeterminate(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
            ParseUser currentUser = ParseUser.getCurrentUser();
            ParseUser.logOut();
            ParseUser currentUserafterlogout = ParseUser.getCurrentUser();

            if (currentUserafterlogout == null) {
                Intent intent = new Intent(MainActivity.this, LoginSignupActivity.class);
                startActivity(intent);
                //dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Successfully Logged Out", Toast.LENGTH_LONG).show();
            } else {
                //dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Could Not Log Out. Please Try Again.", Toast.LENGTH_LONG).show();
            }

        }

        return super.onOptionsItemSelected(item);
    }
}
