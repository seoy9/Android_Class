package ddwucom.mobile.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BookDBHelper extends SQLiteOpenHelper {
    final static String TAG = "FoodDBHelper";

    final static String DB_NAME = "foods.db";
    public final static String TABLE_NAME = "food_table";

    public final static String COL_ID = "_id";
    public final static String COL_TITLE = "title";
    public final static String COL_AUTHOR = "author";
    public final static String COL_PUBLISHER = "publisher";
    public final static String COL_SYNOPSIS = "synopsis";
    public final static String COL_PRICE = "price";

    public BookDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "
                + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_TITLE + " TEXT, " + COL_AUTHOR + " TEXT, " + COL_PUBLISHER + " TEXT, " + COL_SYNOPSIS + " TEXT, " + COL_PRICE + " TEXT)";
        Log.d(TAG, sql);
        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME + " values (null, '제목1', '저자1', '출판사1', '내용요약1');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '제목2', '저자2', '출판사2', '내용요약2');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '제목3', '저자3', '출판사3', '내용요약3');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}


