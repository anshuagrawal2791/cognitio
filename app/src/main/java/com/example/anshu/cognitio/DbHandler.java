package com.example.anshu.cognitio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by anshu on 11/12/15.
 */
public class DbHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME = "User";
    private static final String TABLE_PLAYED = "Played";
    private static final String VIENGLISH = "vienglish";
    private static final String VIMATHS = "vimaths";
    private static final String VISCIENCE = "viscience";
    private static final String VISSC = "vissc";
private static final String VIIENGLISH = "viienglish";
    private static final String VIIMATHS = "viimaths";
    private static final String VIISCIENCE = "viiscience";
    private static final String VIISSC = "viissc";
private static final String VIIIENGLISH = "viiienglish";
    private static final String VIIIMATHS = "viiimaths";
    private static final String VIIISCIENCE = "viiiscience";
    private static final String VIIISSC = "viiissc";
private static final String IXENGLISH = "ixenglish";
    private static final String IXMATHS = "ixmaths";
    private static final String IXSCIENCE = "ixscience";
    private static final String IXSSC = "ixssc";
private static final String XENGLISH = "xenglish";
    private static final String XMATHS = "xmaths";
    private static final String XSCIENCE = "xscience";
    private static final String XSSC = "xssc";
private static final String XIENGLISH = "xienglish";
    private static final String XIMATHS = "ximaths";
    private static final String XISCIENCE = "xiscience";
    private static final String XISSC = "xissc";
private static final String XIIENGLISH = "xiienglish";
    private static final String XIIMATHS = "xiimaths";
    private static final String XIISCIENCE = "xiiscience";
    private static final String XIISSC = "xiissc";
    private static DbHandler sInstance;

    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DbHandler getInstance(Context context) {


        if (sInstance == null) {
            sInstance = new DbHandler(context.getApplicationContext());
        }
        return sInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_PLAYED + "("
                + VIENGLISH + " TEXT,"+ VIMATHS + " TEXT" + VISCIENCE + " TEXT," + VISSC + " TEXT,"
                + VIIENGLISH + " TEXT," + VIIMATHS + " TEXT," + VIISCIENCE + " TEXT," + VIISSC + " TEXT,"
                + VIIIENGLISH + " TEXT," + VIIIMATHS + " TEXT," + VIIISCIENCE + " TEXT," + VIIISSC + " TEXT,"
                + IXENGLISH + " TEXT," + IXMATHS + " TEXT," + IXSCIENCE + " TEXT," + IXSSC + " TEXT,"
                + XENGLISH + " TEXT," + XMATHS + " TEXT," + XSCIENCE + " TEXT," + XSSC + " TEXT,"
                + XIENGLISH + " TEXT," + XIMATHS + " TEXT," + XISCIENCE + " TEXT," + XISSC + " TEXT,"
                + XIIENGLISH + " TEXT," + XIIMATHS + " TEXT," + XIISCIENCE + " TEXT," + XIISSC + " TEXT"+")";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addtovienglish(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIENGLISH,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromvienglish()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIENGLISH)));

            } while (cursor.moveToNext());
        }
        return played;
    }
 public void addtoviienglish(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIENGLISH,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviienglish()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIENGLISH)));

            } while (cursor.moveToNext());
        }
        return played;
    }
 public void addtoviiienglish(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIIENGLISH,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiienglish()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIIENGLISH)));

            } while (cursor.moveToNext());
        }
        return played;
    }
 public void addtoixenglish(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(IXENGLISH,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromixenglish()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(IXENGLISH)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxenglish(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XENGLISH,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxenglish()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XENGLISH)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxienglish(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIENGLISH,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxienglish()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIENGLISH)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxiienglish(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIIENGLISH,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxiienglish()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIIENGLISH)));

            } while (cursor.moveToNext());
        }
        return played;
    }



public void addtovimaths(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIMATHS,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromvimaths()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIMATHS)));

            } while (cursor.moveToNext());
        }
        return played;
    }
 public void addtoviimaths(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIMATHS,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviimaths()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIMATHS)));

            } while (cursor.moveToNext());
        }
        return played;
    }
 public void addtoviiimaths(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIIMATHS,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiimaths()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIIMATHS)));

            } while (cursor.moveToNext());
        }
        return played;
    }
 public void addtoixmaths(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(IXMATHS,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromixmaths()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(IXMATHS)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxmaths(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XMATHS,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxmaths()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XMATHS)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoximaths(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIMATHS,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromximaths()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIMATHS)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxiimaths(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIIMATHS,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxiimaths()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIIMATHS)));

            } while (cursor.moveToNext());
        }
        return played;
    }


public void addtoviscience(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VISCIENCE,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviscience()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VISCIENCE)));

            } while (cursor.moveToNext());
        }
        return played;
    }
 public void addtoviiscience(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIISCIENCE,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiscience()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIISCIENCE)));

            } while (cursor.moveToNext());
        }
        return played;
    }
 public void addtoviiiscience(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIISCIENCE,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiiscience()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIISCIENCE)));

            } while (cursor.moveToNext());
        }
        return played;
    }
 public void addtoixscience(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(IXSCIENCE,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromixscience()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(IXSCIENCE)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxscience(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XSCIENCE,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxscience()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XSCIENCE)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxiscience(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XISCIENCE,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxiscience()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XISCIENCE)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxiiscience(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIISCIENCE,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxiiscience()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIISCIENCE)));

            } while (cursor.moveToNext());
        }
        return played;
    }


public void addtovissc(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VISSC,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromvissc()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VISSC)));

            } while (cursor.moveToNext());
        }
        return played;
    }
 public void addtoviissc(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIISSC,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviissc()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIISSC)));

            } while (cursor.moveToNext());
        }
        return played;
    }
 public void addtoviiissc(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIISSC,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiissc()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIISSC)));

            } while (cursor.moveToNext());
        }
        return played;
    }
 public void addtoixssc(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(IXSSC,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromixssc()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(IXSSC)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxssc(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XSSC,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxssc()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XSSC)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxissc(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XISSC,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxissc()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XISSC)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxiissc(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIISSC,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxiissc()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIISSC)));

            } while (cursor.moveToNext());
        }
        return played;
    }




}
