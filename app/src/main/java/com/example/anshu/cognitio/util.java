package com.example.anshu.cognitio;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

/**
 * Created by user on 12/13/2015.
 */
public class util {
    public static byte[] getbytearray(Bitmap bm){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

}