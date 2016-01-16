package com.example.anshu.cognitio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
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
import com.parse.ParseObject;
import com.parse.ParseUser;

import fr.ganfra.materialspinner.MaterialSpinner;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardViewNative;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    MaterialSpinner spinner;

    private static final int PROFILE_SETTING = 1;
    private AccountHeader headerResult = null;
    private Drawer result = null;
    IProfile profile;
    SharedPreferences sp ;
    SharedPreferences.Editor editor;
    ParseUser user;
    Toolbar toolbar;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.untitled,
            R.drawable.untitled,
            R.drawable.untitled
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        viewPager.setCurrentItem(1);

        user  = ParseUser.getCurrentUser();
        // Toast.makeText(getApplicationContext(), " " + user.getEmail() + " " + user.get("name"), Toast.LENGTH_LONG);


        ImageView im = (ImageView)findViewById(R.id.im);
        ImageView im1 = (ImageView)findViewById(R.id.im1);
        ImageView im2 = (ImageView)findViewById(R.id.im2);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });
im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
im2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        viewPager.setCurrentItem(0);
    }
});








    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Profile(), "Profile");
        adapter.addFragment(new Home(), "Home");
        adapter.addFragment(new Stats(), "Stats");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
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


//        if (id == R.id.logout) {
//            ProgressDialog dialog = new ProgressDialog(MainActivity.this);
//            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            dialog.setMessage("Logging Out...");
//            dialog.setIndeterminate(true);
//            dialog.setCanceledOnTouchOutside(false);
//            dialog.show();
//            ParseUser currentUser = ParseUser.getCurrentUser();
//            ParseUser.logOut();
//            ParseUser currentUserafterlogout = ParseUser.getCurrentUser();
//
//            if (currentUserafterlogout == null) {
//                Intent intent = new Intent(MainActivity.this, LoginSignupActivity.class);
//                startActivity(intent);
//                //dialog.dismiss();
//                Toast.makeText(getApplicationContext(), "Successfully Logged Out", Toast.LENGTH_LONG).show();
//            } else {
//                //dialog.dismiss();
//                Toast.makeText(getApplicationContext(), "Could Not Log Out. Please Try Again.", Toast.LENGTH_LONG).show();
//            }
//
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();


    }
}
