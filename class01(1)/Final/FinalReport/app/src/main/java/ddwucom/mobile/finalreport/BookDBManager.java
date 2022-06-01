package ddwucom.mobile.finalreport;

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

    public ArrayList<Book> getAllBook() {
        ArrayList bookList = new ArrayList();
        SQLiteDatabase db = bookDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + bookDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(bookDBHelper.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(bookDBHelper.COL_TITLE));
            String author = cursor.getString(cursor.getColumnIndex(bookDBHelper.COL_AUTHOR));
            String publisher = cursor.getString(cursor.getColumnIndex(bookDBHelper.COL_PUBLISHER));
            String synopsis = cursor.getString(cursor.getColumnIndex(bookDBHelper.COL_SYNOPSIS));
            int price = cursor.getInt(cursor.getColumnIndex(bookDBHelper.COL_PRICE));
            bookList.add ( new Book (id, title, author, publisher, synopsis, price) );
        }

        cursor.close();
        bookDBHelper.close();
        return bookList;
    }

    public boolean addNewBook(Book newBook) {
        SQLiteDatabase db = bookDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(bookDBHelper.COL_TITLE, newBook.getTitle());
        value.put(bookDBHelper.COL_AUTHOR, newBook.getAuthor());
        value.put(bookDBHelper.COL_PUBLISHER, newBook.getPublisher());
        value.put(bookDBHelper.COL_SYNOPSIS, newBook.getSynopsis());
        value.put(bookDBHelper.COL_PRICE, newBook.getPrice());

        long count = db.insert(BookDBHelper.TABLE_NAME, null, value);

        if (count > 0 ) return true;

        return false;
    }

    public boolean modifyFood(Book book) {
        SQLiteDatabase sqLiteDatabase = bookDBHelper.getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put(BookDBHelper.COL_TITLE, book.getTitle());
        row.put(BookDBHelper.COL_AUTHOR, book.getAuthor());
        row.put(BookDBHelper.COL_PUBLISHER, book.getPublisher());
        row.put(BookDBHelper.COL_SYNOPSIS, book.getSynopsis());
        row.put(BookDBHelper.COL_PRICE, book.getPrice());

        String whereClause = BookDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(book.get_id())};

        int result = sqLiteDatabase.update(BookDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        bookDBHelper.close();

        if (result > 0) return true;
        return false;
    }

    public boolean removeBook(long id) {
            SQLiteDatabase sqLiteDatabase = bookDBHelper.getWritableDatabase();
            String whereClause = bookDBHelper.COL_ID + "=?";
            String[] whereArgs = new String[] { String.valueOf(id) };

            int result = sqLiteDatabase.delete(BookDBHelper.TABLE_NAME, whereClause, whereArgs);
            bookDBHelper.close();

            if(result > 0) return true;
            return false;
    }

    public void close() {
        if (bookDBHelper != null) bookDBHelper.close();
        if (cursor != null) cursor.close();
    };
}
