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
    private static final String VIGK = "vigk";

    private static final String VIIENGLISH = "viienglish";
    private static final String VIIMATHS = "viimaths";
    private static final String VIISCIENCE = "viiscience";
    private static final String VIISSC = "viissc";
    private static final String VIIGK = "viigk";

    private static final String VIIIENGLISH = "viiienglish";
    private static final String VIIIMATHS = "viiimaths";
    //  private static final String VIIISCIENCE = "viiiscience";
    // private static final String VIIISSC = "viiissc";
    private static final String VIIIPHYSICS = "viiiphysics";
    private static final String VIIICHEM = "viiichem";
    private static final String VIIIBIO = "viiibio";
    private static final String VIIIHISTORY = "viiihistory";
    private static final String VIIICIVIC = "viiicivic";
    private static final String VIIIGEO = "viiigeo";
    private static final String VIIIECO = "viiieco";
    private static final String VIIIGK = "viiigl";

    private static final String IXENGLISH = "ixenglish";
    private static final String IXMATHS = "ixmaths";
    // private static final String IXSCIENCE = "ixscience";
    // private static final String IXSSC = "ixssc";
    private static final String IXPHYSICS = "ixphysics";
    private static final String IXCHEM = "ixchem";
    private static final String IXBIO = "ixbio";
    private static final String IXHISTORY = "ixhistory";
    private static final String IXCIVIC = "ixcivic";
    private static final String IXGEO = "ixgeo";
    private static final String IXECO = "ixeco";
    private static final String IXGK = "ixgk";

    private static final String XENGLISH = "xenglish";
    private static final String XMATHS = "xmaths";
    //   private static final String XSCIENCE = "xscience";
    //  private static final String XSSC = "xssc";
    private static final String XPHYSICS = "xphysics";
    private static final String XCHEM = "xchem";
    private static final String XBIO = "xbio";
    private static final String XHISTORY = "xhistory";
    private static final String XCIVIC = "xcivic";
    private static final String XGEO = "xgeo";
    private static final String XECO = "xeco";
    private static final String XGK = "xgk";

    private static final String XIENGLISH = "xienglish";
    private static final String XIMATHS = "ximaths";
    //  private static final String XISCIENCE = "xiscience";
    //  private static final String XISSC = "xissc";
    private static final String XIPHYSICS = "xiphysics";
    private static final String XICHEM = "xichem";
    private static final String XIBIO = "xibio";
    private static final String XIGK = "xigk";

    private static final String XIIENGLISH = "xiienglish";
    private static final String XIIMATHS = "xiimaths";
    //  private static final String XIISCIENCE = "xiiscience";
    //  private static final String XIISSC = "xiissc";
    private static final String XIIPHYSICS = "xiiphysics";
    private static final String XIICHEM = "xiichem";
    private static final String XIIBIO = "xiibio";
    private static final String XIIGK = "xiigk";

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

     /*   String query = "CREATE TABLE " + TABLE_PLAYED + "("
                + VIENGLISH + " TEXT,"+ VIMATHS + " TEXT" + VISCIENCE + " TEXT," + VISSC + " TEXT,"
                + VIIENGLISH + " TEXT," + VIIMATHS + " TEXT," + VIISCIENCE + " TEXT," + VIISSC + " TEXT,"
                + VIIIENGLISH + " TEXT," + VIIIMATHS + " TEXT," + VIIISCIENCE + " TEXT," + VIIISSC + " TEXT,"
                + IXENGLISH + " TEXT," + IXMATHS + " TEXT," + IXSCIENCE + " TEXT," + IXSSC + " TEXT,"
                + XENGLISH + " TEXT," + XMATHS + " TEXT," + XSCIENCE + " TEXT," + XSSC + " TEXT,"
                + XIENGLISH + " TEXT," + XIMATHS + " TEXT," + XISCIENCE + " TEXT," + XISSC + " TEXT,"
                + XIIENGLISH + " TEXT," + XIIMATHS + " TEXT," + XIISCIENCE + " TEXT," + XIISSC + " TEXT"+")";
       */
        String query = "CREATE TABLE " + TABLE_PLAYED + "("
                + VIENGLISH + " TEXT,"+ VIMATHS + " TEXT" + VISCIENCE + " TEXT," + VISSC + " TEXT," + VIGK + " TEXT,"
                + VIIENGLISH + " TEXT," + VIIMATHS + " TEXT," + VIISCIENCE + " TEXT," + VIISSC + " TEXT," + VIIGK + " TEXT,"
                + VIIIENGLISH + " TEXT," + VIIIMATHS + " TEXT," + VIIIPHYSICS + " TEXT," + VIIICHEM + " TEXT,"
                + VIIIBIO + " TEXT,"+ VIIIHISTORY + " TEXT,"+ VIIICIVIC + " TEXT,"+ VIIIGEO + " TEXT,"+ VIIIECO + " TEXT,"
                + VIIIGK + " TEXT,"
                + IXENGLISH + " TEXT," + IXMATHS + " TEXT," + IXPHYSICS + " TEXT," + IXCHEM + " TEXT,"
                + IXBIO + " TEXT,"+ IXHISTORY + " TEXT,"+ IXCIVIC + " TEXT,"+ IXGEO + " TEXT,"+ IXECO + " TEXT,"
                + IXGK + " TEXT,"
                + XENGLISH + " TEXT," + XMATHS + " TEXT," + XPHYSICS + " TEXT," + XCHEM + " TEXT,"
                + XBIO + " TEXT,"+ XHISTORY + " TEXT,"+ XCIVIC + " TEXT,"+ XGEO + " TEXT,"+ XECO + " TEXT,"
                + XGK + " TEXT,"
                + XIENGLISH + " TEXT," + XIMATHS + " TEXT," + XIPHYSICS + " TEXT," + XICHEM + " TEXT,"
                + XIBIO + " TEXT," + XIGK + " TEXT,"
                + XIIENGLISH + " TEXT," + XIIMATHS + " TEXT," + XIIPHYSICS + " TEXT," + XIICHEM + " TEXT,"
                + XIIBIO + " TEXT," + XIIGK + " TEXT"+")";

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
/* public void addtoviiiscience(ArrayList<String> played)
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
*/

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
/* public void addtoviiissc(ArrayList<String> played)
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
    */

    public void addtoviiiphysics(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIIPHYSICS,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiiphysics()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIIPHYSICS)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoixphysics(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(IXPHYSICS,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromixphysics()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(IXPHYSICS)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxphysics(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XPHYSICS,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxphysics()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XPHYSICS)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxiphysics(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIPHYSICS,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxiphysics()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIPHYSICS)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxiiphysics(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIIPHYSICS,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxiiphysics()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIIPHYSICS)));

            } while (cursor.moveToNext());
        }
        return played;
    }

    public void addtoviiichem(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIICHEM,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiichem()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIICHEM)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoixchem(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(IXCHEM,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromixchem()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(IXCHEM)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxchem(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XCHEM,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxchem()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XCHEM)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxichem(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XICHEM,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxichem()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XICHEM)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxiichem(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIICHEM,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxiichem()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIICHEM)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoviiibio(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIIBIO,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiibio()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIIBIO)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoixbio(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(IXBIO,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromixbio()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(IXBIO)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxbio(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XBIO,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxbio()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XBIO)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxibio(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIBIO,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxibio()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIBIO)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxiibio(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIIBIO,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxiibio()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIIBIO)));

            } while (cursor.moveToNext());
        }
        return played;
    }


    public void addtovigk(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIGK,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromvigk()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIGK)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoviigk(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIGK,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviigk()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIGK)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoviiigk(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIIGK,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiigk()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIIGK)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoixgk(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(IXGK,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromixgk()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(IXGK)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxgk(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XGK,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxgk()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XGK)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxigk(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIGK,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxigk()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIGK)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxiigk(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XIIGK,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxiigk()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XIIGK)));

            } while (cursor.moveToNext());
        }
        return played;
    }

    public void addtoviiicivic(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIICIVIC,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiicivic()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIICIVIC)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoixcivic(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(IXCIVIC,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromixcivic()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(IXCIVIC)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxcivic(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XCIVIC,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxcivic() {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XCIVIC)));

            } while (cursor.moveToNext());
        }
        return played;
    }

    public void addtoviiigeo(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIIGEO,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiigeo()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIIGEO)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoixgeo(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(IXGEO,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromixgeo()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(IXGEO)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxgeo(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XGEO,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxgeo() {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XGEO)));

            } while (cursor.moveToNext());
        }
        return played;
    }

    public void addtoviiieco(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIIECO,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiieco()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIIECO)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoixeco(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(IXECO,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromixeco()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(IXECO)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxeco(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XECO,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxeco() {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XECO)));

            } while (cursor.moveToNext());
        }
        return played;
    }

    public void addtoviiihistory(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(VIIIHISTORY,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromviiihistory()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(VIIIHISTORY)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoixhistory(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(IXHISTORY,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromixhistory()
    {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(IXHISTORY)));

            } while (cursor.moveToNext());
        }
        return played;
    }
    public void addtoxhistory(ArrayList<String> played)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        while(!played.isEmpty())
        {
            values.put(XHISTORY,played.get(0));
            db.insert(TABLE_PLAYED, null, values);
            played.remove(0);
        }
        db.close();

    }
    public ArrayList<String> getfromxhistory() {
        ArrayList<String> played = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PLAYED;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                played.add(cursor.getString(cursor.getColumnIndex(XHISTORY)));

            } while (cursor.moveToNext());
        }
        return played;
    }
}