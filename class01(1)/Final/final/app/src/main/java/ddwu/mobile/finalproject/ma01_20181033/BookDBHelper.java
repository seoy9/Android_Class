package ddwu.mobile.finalproject.ma01_20181033;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookDBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "books.db";
    public final static String TABLE_NAME = "book_table";
    public final static String COL_ID = "_id";
    public final static String COL_TITLE = "title";
    public final static String COL_AUTHOR = "author";
    public final static String COL_PUBLISHER = "publisher";
    public final static String COL_SYNOPSIS = "synopsis";
    public final static String COL_RATING = "rating";
    public BookDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_TITLE + " TEXT, " + COL_AUTHOR + " TEXT, " + COL_PUBLISHER + " TEXT, " + COL_SYNOPSIS + " TEXT, " + COL_RATING + " integer)";
        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME + " values (null, 'Matilda', 'Roald Dahl', '시공주니어', '나쁜 어른들을 향한 천재 소녀 마틸다의 통쾌한 복수!', 1);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'Wonder', 'R.J. Palacio', '책콩', '헬멧 속에 자신을 숨겼던 아이 ‘어기’가 처음 만나는 세상의 편견에 맞서며 진짜 자신을 마주하는 용기를 전하는 감동적인 이야기', 2);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'The Little Women', 'Louisa May Alcott', '더스토리', '남북전쟁 중의 미국 중산층 가정을 배경으로 약 일 년 동안 있었던 일', 3);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'Harry Potter', 'J.K. Rowling', '문학수첩', '해리포터의 이야기', 4);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'The Paper Magician', 'Charlie N. Holmberg', '이덴슬리벨', '시어니 트윌이 어딘가 미스터리한 구석이 있는 종이 마법사 에머리 세인의 견습생이 되면서 겪는 갈등과 모험, 사랑과 성장의 이야기', 5);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
