package com.example.anshu.cognitio;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.ParseUser;

import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private Bitmap Image= null;

    private static final int GALLERY = 1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        if(findViewById(R.id.dpfragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
            PictureFragment pictureFragment = new PictureFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.dpfragment_container,pictureFragment).commit();

        }
        ParseUser user = ParseUser.getCurrentUser();
        Button update_dp = (Button) findViewById(R.id.update_dp);
        if(user!=null){
            update_dp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(Image!=null){
                        Image.recycle();
                    }
                    else {
                   /*     Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                    */
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
                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(),
                    "User not logged in",
                    Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY && resultCode!=0){
         /*   Bundle extras = data.getExtras();
            if(extras!=null){
                Bitmap imagebitmap = (Bitmap) extras.get("data");
                ImageView imageView = (ImageView) findViewById(R.id.dp);
                imageView.setImageBitmap(imagebitmap);
            }
            else{
                Log.d("mayank","empty bundle");
            }
*/
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            imageView = (ImageView) findViewById(R.id.dp);
            if(cursor!=null && imageView.getDrawable()==null){
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();


                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

            }
            else {
                Log.d("mayank","null cursor");
            }



        }
    }
}