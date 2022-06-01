package ddwucom.mobile.report01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactDBHelper extends SQLiteOpenHelper {
	
	private final static String DB_NAME = "contact_db"; 
	public final static String TABLE_NAME = "contact_table";
	public final static String COL_ID = "_id";
    public final static String COL_TITLE = "title";
    public final static String COL_DATE = "date";
    public final static String COL_REVIEW = "review";

	public ContactDBHelper(Context context) {
		super(context, DB_NAME, null, 1);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table " + TABLE_NAME + " ( " + COL_ID + " integer primary key autoincrement,"
				+ COL_TITLE + " TEXT, " + COL_DATE + " TEXT, " + COL_REVIEW + " TEXT);");
	
//		샘플 데이터
		db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (null, '마루 밑 아리에티', '9월 6일', '아리에티 너무 멋있고 귀엽다');");
		db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (null, '바다가 들린다', '9월 18일', '와... 내 볼이 더 아프다...');");
		db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (null, '어쩌다 로맨스', '9월 25일', '첫 로코 도전');");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table " + TABLE_NAME);
        onCreate(db);
	}

}
