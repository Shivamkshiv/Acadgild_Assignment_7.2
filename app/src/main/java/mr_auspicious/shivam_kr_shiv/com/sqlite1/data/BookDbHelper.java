package mr_auspicious.shivam_kr_shiv.com.sqlite1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static android.R.attr.version;
import static mr_auspicious.shivam_kr_shiv.com.sqlite1.data.Books_Contract.FeedEntry.Book_Title;
import static mr_auspicious.shivam_kr_shiv.com.sqlite1.data.Books_Contract.FeedEntry.TABLE_NAME;
import static mr_auspicious.shivam_kr_shiv.com.sqlite1.data.Books_Contract.SQL_CREATE_ENTRIES;
import static mr_auspicious.shivam_kr_shiv.com.sqlite1.data.Books_Contract.SQL_DELETE_ENTRIES;

/**
 * Created by shivam on 01-03-2017.
 */

public class BookDbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BookReader.db";


    public BookDbHelper(Context context) { //Constructor
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES); //Executing the sql create enties method define in the contract classes.
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public long createBook(Book book){ //Adding the values

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Book_Title,book.getBook_Tilte());

       long id = db.insert(TABLE_NAME,null,contentValues);

        return id;

    }

    public List<Book> getBooks(){

        List<Book> books = new LinkedList<>();

        //Select Book Query
        String query = "SELECT * FROM " +TABLE_NAME;

        //Getting the database reference..
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        Book book = null;
        if(cursor.moveToFirst()){
            do{
                book = new Book();
                book.setBook_Tilte(cursor.getString(1));

                books.add(book);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return books; //Getting list of data..
    }

}
