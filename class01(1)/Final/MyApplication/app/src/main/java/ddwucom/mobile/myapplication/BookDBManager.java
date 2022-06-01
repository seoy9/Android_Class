package ddwucom.mobile.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BookDBManager {

    BookDBHelper bookDBHelper = null;
    Cursor cursor = null;

    public BookDBManager(Context context) {
        bookDBHelper = new BookDBHelper(context);
    }

//    DB의 모든 food를 반환
    public ArrayList<Book> getAllFood() {
        ArrayList foodList = new ArrayList();
        SQLiteDatabase db = bookDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + BookDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(BookDBHelper.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(BookDBHelper.COL_TITLE));
            String author = cursor.getString(cursor.getColumnIndex(BookDBHelper.COL_AUTHOR));
            String publisher = cursor.getString(cursor.getColumnIndex(BookDBHelper.COL_AUTHOR));
            String synopsis = cursor.getString(cursor.getColumnIndex(BookDBHelper.COL_AUTHOR));
            foodList.add ( new Book(id, title, author, publisher, synopsis) );
        }

        cursor.close();
        bookDBHelper.close();
        return foodList;
    }

//    DB 에 새로운 food 추가
    public boolean addNewFood(Book newBook) {
        SQLiteDatabase db = bookDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(BookDBHelper.COL_TITLE, newBook.getTitle());
        value.put(BookDBHelper.COL_AUTHOR, newBook.getAuthor());
        value.put(BookDBHelper.COL_PUBLISHER, newBook.getPublisher());
        value.put(BookDBHelper.COL_SYNOPSIS, newBook.getSynopsis());

//      insert 메소드를 사용할 경우 데이터 삽입이 정상적으로 이루어질 경우 1 이상, 이상이 있을 경우 0 반환 확인 가능
        long count = db.insert(BookDBHelper.TABLE_NAME, null, value);

        if (count > 0 ) return true;

        return false;
    }

//    _id 를 기준으로 food 의 이름과 nation 변경
    public boolean modifyBook(Book book) {
        SQLiteDatabase sqLiteDatabase = bookDBHelper.getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put(BookDBHelper.COL_TITLE, book.getTitle());
        row.put(BookDBHelper.COL_AUTHOR, book.getAuthor());
        row.put(BookDBHelper.COL_PUBLISHER, book.getPublisher());
        row.put(BookDBHelper.COL_SYNOPSIS, book.getSynopsis());

        String whereClause = BookDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(book.get_id()) };

        int result = sqLiteDatabase.update(BookDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        bookDBHelper.close();

        if (result > 0 ) return true;
        return false;
    }

//    _id 를 기준으로 DB에서 food 삭제
    public boolean removeFood(long id) {
        SQLiteDatabase sqLiteDatabase = bookDBHelper.getWritableDatabase();
        String whereClause = bookDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        int result = sqLiteDatabase.delete(BookDBHelper.TABLE_NAME, whereClause, whereArgs);
        bookDBHelper.close();
        if(result > 0) return true;
        return false;
    }

//    나라 이름으로 DB 검색
    public ArrayList<Book> getFoodsByNation(String nation) {

        return null;
    }

//    음식 이름으로 DB 검색
    public ArrayList<Book> getFoodByName(String foodName) {
        return null;
    }

//    id 로 DB 검색
    public Book getFoodById(long id) {

        return  null;
    }

//    close 수행
    public void close() {
        if (bookDBHelper != null) bookDBHelper.close();
        if (cursor != null) cursor.close();
    };
}
