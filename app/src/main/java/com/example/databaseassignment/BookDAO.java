package com.example.databaseassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private DBHandler dBHandler;
    private SQLiteDatabase db;

    public BookDAO(Context context) {
        dBHandler = new DBHandler(context);
    }

    public void open() throws SQLException {
        db = dBHandler.getWritableDatabase();
    }

    public void close() {
        dBHandler.close();
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<Book>();
        String selectQuery = "SELECT  * FROM " +
                DBHandler.TABLE_BOOKS;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setbookTitle(cursor.getString(1));
                book.setbookAuthor(cursor.getString(2));
                book.setBookPublisher(cursor.getString(3));
                book.setbookYear(cursor.getString(4));
                bookList.add(book);
            } while (cursor.moveToNext());
        }
        return bookList;
    }

    void addBook(Book book) {
        ContentValues values = new ContentValues();
        values.put(DBHandler.KEY_TITLE,
                book.getbookTitle());
        values.put(DBHandler.KEY_AUTHOR,
                book.getbookAuthor());
        values.put(DBHandler.KEY_PUBLISHER,
                book.getBookPublisher());
        values.put(DBHandler.KEY_YEAR,
                book.getbookYear());
        db.insert(DBHandler.TABLE_BOOKS, null, values);
    }

}
