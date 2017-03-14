package com.viralandroid.receipe;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
 
public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "favoritesManager";
 
    // Contacts table name
    private static final String TABLE_FAVORITES = "favorites";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "title";
    private static final String KEY_SCRIPT = "script";
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_FAVORITES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_SCRIPT + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITES);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new contact
    void addFavorites(Products products) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_ID, products.id);
        values.put(KEY_NAME, products.getTitle()); // Contact Name
        values.put(KEY_SCRIPT, products.getScript()); // Contact Phone
 
        // Inserting Row
        db.insert(TABLE_FAVORITES, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
 
    // Getting single contact
    boolean getFavorites(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_FAVORITES, new String[] { KEY_ID,
                KEY_NAME, KEY_SCRIPT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            if(cursor.getCount()>0)
                return true;
        }

 

        // return contact
        return false;
    }
 
    // Getting All Contacts
    public List<Products> getAllFavorites() {
        List<Products> favoritesList = new ArrayList<Products>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FAVORITES;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Products products = new Products();
                products.setID(Integer.parseInt(cursor.getString(0)));
                products.setTitle(cursor.getString(1));
                products.setScript(cursor.getString(2));
                // Adding contact to list
                favoritesList.add(products);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return favoritesList;
    }
 
    // Updating single contact
    public int updateFavorites(Products products) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, products.getTitle());
        values.put(KEY_SCRIPT, products.getScript());
 
        // updating row
        return db.update(TABLE_FAVORITES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(products.getID()) });
    }
 
    // Deleting single contact
    public void deleteFavorites(Products products) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FAVORITES, KEY_ID + " = ?",
                new String[] { products.id });
        db.close();
    }
 
    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_FAVORITES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
 
}