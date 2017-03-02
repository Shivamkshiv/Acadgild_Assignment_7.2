package mr_auspicious.shivam_kr_shiv.com.sqlite1.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by shivam on 01-03-2017.
 */

//Contract Class
public final class Books_Contract  {

    public Books_Contract() {
    }

    static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.Book_Title + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;


    public static class FeedEntry implements BaseColumns {

        public static final String TABLE_NAME = "Books";

        public static final String Book_Title = "title";


    }

}
