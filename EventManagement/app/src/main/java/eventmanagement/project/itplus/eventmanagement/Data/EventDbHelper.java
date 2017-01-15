package eventmanagement.project.itplus.eventmanagement.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import eventmanagement.project.itplus.eventmanagement.Model.Category;

/**
 * Created by Dat UET on 1/15/2017.
 */

public class EventDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "eventmanagement.db";

    public static final int DATABASE_VERSION = 1;

    public EventDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS "
                + Contract.CategoryEntry.TABLE_NAME + " ( "
                + Contract.CategoryEntry.ID + " INTEGER PRIMARY KEY NOT NULL, "
                + Contract.CategoryEntry.NAME + " TEXT NOT NULL, "
                + Contract.CategoryEntry.IMAGE + " TEXT NOT NULL );";
        sqLiteDatabase.execSQL(SQL_CREATE_CATEGORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertCategory(Category category) {
        long id = -1;
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(Contract.CategoryEntry.ID, category.getCategoryID());
            contentValues.put(Contract.CategoryEntry.NAME, category.getName());
            contentValues.put(Contract.CategoryEntry.IMAGE, category.getImage());

            id = db.insert(Contract.CategoryEntry.TABLE_NAME, "", contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }

        return id;
    }

    public void addCategoryToArraylist(ArrayList<Category> categories) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                Contract.CategoryEntry.ID,
                Contract.CategoryEntry.NAME,
                Contract.CategoryEntry.IMAGE
        };
        Cursor cursor = db.query(
                Contract.CategoryEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        try {
            while (cursor.moveToNext()) {
                Category category = new Category();
                category.setCategoryID(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Contract.CategoryEntry.ID))));
                category.setName(cursor.getString(cursor.getColumnIndex(Contract.CategoryEntry.NAME)));
                category.setImage(cursor.getString(cursor.getColumnIndex(Contract.CategoryEntry.IMAGE)));
                categories.add(category);
            }

        } finally {
            cursor.close();
        }
    }

    public boolean checkEmptyCategory() {
        boolean empty = true;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT (*) FROM " + Contract.CategoryEntry.TABLE_NAME, null);
        if (cursor != null && cursor.moveToFirst()) {
            empty = (cursor.getInt(0) == 0);
        }
        cursor.close();
        return empty;
    }
}
