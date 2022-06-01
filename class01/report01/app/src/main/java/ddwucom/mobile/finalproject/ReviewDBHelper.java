package ddwucom.mobile.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReviewDBHelper extends SQLiteOpenHelper {
	
	private final static String DB_NAME = "review_db";
	public final static String TABLE_NAME = "review_table";
	public final static String COL_ID = "_id";
    public final static String COL_TITLE = "title";
    public final static String COL_DATE = "date";
	public final static String COL_GENRE = "genre";
	public final static String COL_TOGETHER = "together";
	public final static String COL_RATING = "rating";
    public final static String COL_MEMO = "memo";
    public final static String COL_IMAGELINK = "imagelink";
    public final static String COL_IMAGEFILENAME = "imagefilename";

	public ReviewDBHelper(Context context) {
		super(context, DB_NAME, null, 1);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String createSql = "create table " + TABLE_NAME + " ( " + COL_ID + " integer primary key autoincrement, "
				+ COL_TITLE + " TEXT, " + COL_DATE + " TEXT, " + COL_GENRE + " TEXT, " + COL_TOGETHER + " TEXT, " + COL_RATING + " integer, " + COL_MEMO + " TEXT, " + COL_IMAGELINK + " TEXT, " + COL_IMAGEFILENAME + " TEXT);";

		//db.execSQL("create table " + TABLE_NAME + " ( " + COL_ID + " integer primary key autoincrement,"
				//+ COL_TITLE + " TEXT, " + COL_DATE + " TEXT, " + COL_GENRE + " TEXT, " + COL_TOGETHER + " TEXT, " + COL_RATING + " integer, " + COL_MEMO + " TEXT);");

		db.execSQL(createSql);

//		샘플 데이터
		//db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (null, '마루 밑 아리에티', '2020.09.06', '애니메이션', '양갱이', 5, '아리에티 너무 멋있고 귀엽다', '', '');");
		//db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (null, '바다가 들린다', '2020.09.18', '애니메이션', '덤보', 4, '와... 내 볼이 더 아프다...', '', '');");
		//db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (null, '어쩌다 로맨스', '2020.09.25', '로맨스', '찰떡', 3, '첫 로코 도전', '', '');");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table " + TABLE_NAME);
        onCreate(db);
	}

}
