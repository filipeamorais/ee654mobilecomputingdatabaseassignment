package com.example.databaseassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    BookDAO bookDAO;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //loading the images
        ImageView viewDatabaseImageView = this.findViewById(R.id.viewDatabaseImageView);
        viewDatabaseImageView.setImageResource(R.drawable.database_view);
        ImageView editDatabaseImageView = this.findViewById(R.id.editDatabaseImageView);
        editDatabaseImageView.setImageResource(R.drawable.database_edit);
        ImageView deleteDatabaseImageView = this.findViewById(R.id.deleteDatabaseImageView);
        deleteDatabaseImageView.setImageResource(R.drawable.database_delete);
        //instantiate the book data access object
        bookDAO = new BookDAO(this);
//        bookDAO.open();
//        bookDAO.close();
        //load the TextView
        textViewResult = (TextView)findViewById(R.id.textViewResult);
    }

    @Override protected void onResume() {
        bookDAO.open();
        super.onResume();
    }

    @Override protected void onPause() {
        bookDAO.close();
        super.onPause();
    }

    public void showRecords(View v){
        List<Book> books = bookDAO.getAllBooks();
        String str = "";
        for (Book b : books) {
            String row = b.getId() + ": Title: " +
                    b.getbookTitle() + ", Author: " +
                    b.getbookAuthor() + ", Publisher: " +
                    b.getBookPublisher() + ", Year: " + b.getbookYear();
            str += row + "\n";
        }
        textViewResult.setText(str);
    }

    public void deleteRecords(View v){ }

    public void editRecord(View v){
        try {
            Intent intent = new Intent(MainActivity.this, EditActivity.class);
            startActivityForResult(intent, 0);
        } catch (Exception e) {/* Log error messages */}
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataSecondActivity) {
        //add record
        if (resultCode == 1) {
                Book bookToAdd = (Book) dataSecondActivity.getSerializableExtra(EditActivity.MESSAGE_ADD);
                bookDAO.open();
                bookDAO.addBook(bookToAdd);
                bookDAO.close();
            }
        }

}
