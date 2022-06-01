package ddwu.mobile.finalproject.ma01_20181033;

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
        Cursor cursor = db.rawQuery("SELECT * FROM " + BookDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(BookDBHelper.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(BookDBHelper.COL_TITLE));
            String author = cursor.getString(cursor.getColumnIndex(BookDBHelper.COL_AUTHOR));
            String publisher = cursor.getString(cursor.getColumnIndex(BookDBHelper.COL_PUBLISHER));
            String synopsis = cursor.getString(cursor.getColumnIndex(BookDBHelper.COL_SYNOPSIS));
            int rating = cursor.getInt(cursor.getColumnIndex(BookDBHelper.COL_RATING));
            bookList.add( new Book(id, title, author, publisher, synopsis, rating) );
        }

        cursor.close();
        bookDBHelper.close();
        return bookList;
    }

    public boolean addNewBook(Book newBook) {
        SQLiteDatabase db = bookDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(BookDBHelper.COL_TITLE, newBook.getTitle());
        value.put(BookDBHelper.COL_AUTHOR, newBook.getAuthor());
        value.put(BookDBHelper.COL_PUBLISHER, newBook.getPublisher());
        value.put(BookDBHelper.COL_SYNOPSIS, newBook.getSynopsis());
        value.put(BookDBHelper.COL_RATING, newBook.getRating());

        long count = db.insert(BookDBHelper.TABLE_NAME, null, value);

        if(count > 0) return true;
        return false;
    }

    public boolean modifyBook(Book book) {
        SQLiteDatabase db = bookDBHelper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(BookDBHelper.COL_TITLE, book.getTitle());
        row.put(BookDBHelper.COL_AUTHOR, book.getAuthor());
        row.put(BookDBHelper.COL_PUBLISHER, book.getPublisher());
        row.put(BookDBHelper.COL_SYNOPSIS, book.getSynopsis());
        row.put(BookDBHelper.COL_RATING, book.getRating());

        String whereClause = BookDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(book.get_id()) };

        int result = db.update(BookDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        bookDBHelper.close();

        if(result > 0) return true;
        return false;
    }

    public boolean removeBook(long id) {
        SQLiteDatabase db = bookDBHelper.getWritableDatabase();
        String whereClause = BookDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };

        int result = db.delete(BookDBHelper.TABLE_NAME, whereClause, whereArgs);

        if(result > 0) return true;
        return false;
    }

    public ArrayList<Book> getBookByTitle(String title) {
        SQLiteDatabase db = bookDBHelper.getReadableDatabase();
        String[] colums = {};
        String selection = "title=?";
        String[] selectArgs = new String[] {title};
        ArrayList<Book> selectBookList = new ArrayList<Book>();

        Cursor cursor = db.query(BookDBHelper.TABLE_NAME, colums, selection, selectArgs,
                null, null, null, null);

        while(cursor.moveToNext()) {
            String author = cursor.getString(cursor.getColumnIndex("author"));
            String publisher = cursor.getString(cursor.getColumnIndex("publisher"));
            String synopsis = cursor.getString(cursor.getColumnIndex("synopsis"));
            int rating = cursor.getInt(cursor.getColumnIndex("rating"));
            selectBookList.add( new Book(title, author, publisher, synopsis, rating) );
        }
        cursor.close();
        return selectBookList;
    }

    public ArrayList<Book> getBookByAuthor(String author) {
        SQLiteDatabase db = bookDBHelper.getReadableDatabase();
        String[] colums = {};
        String selection = "author=?";
        String[] selectArgs = new String[] {author};
        ArrayList<Book> selectBookList = new ArrayList<Book>();

        Cursor cursor = db.query(BookDBHelper.TABLE_NAME, colums, selection, selectArgs,
                null, null, null, null);

        while(cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String publisher = cursor.getString(cursor.getColumnIndex("publisher"));
            String synopsis = cursor.getString(cursor.getColumnIndex("synopsis"));
            int rating = cursor.getInt(cursor.getColumnIndex("rating"));
            selectBookList.add( new Book(title, author, publisher, synopsis, rating) );
        }
        cursor.close();
        return selectBookList;
    }
}
