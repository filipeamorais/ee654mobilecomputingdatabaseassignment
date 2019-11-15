package com.example.databaseassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    BookDAO bookDAO;
    TextView textViewResult;
    EditText editTextValue;

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
        //load the TextView and EditText
        textViewResult = (TextView)findViewById(R.id.textViewResult);
        editTextValue = (EditText)findViewById(R.id.editTextValue);
    }

    @Override protected void onResume() {
        bookDAO.open();
        super.onResume();
    }

    @Override protected void onPause() {
        bookDAO.close();
        super.onPause();
    }

    public void showAllRecords(){
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

    public void deleteAllRecords(){
        bookDAO.deleteAllBooks();
        textViewResult.setText("");

    }

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


    public void clickedShow(View v){
        RadioGroup showGroup = findViewById(R.id.showGroupRadioGroup);
        int selectedItem = showGroup.getCheckedRadioButtonId();
        String argument = editTextValue.getText().toString();
        switch (selectedItem){
            case R.id.showAll:
                showAllRecords();
                break;
            case R.id.showTitle:
                showBy(DBHandler.KEY_TITLE, argument);
                break;
            case R.id.showAuthor:
                showBy(DBHandler.KEY_AUTHOR, argument);
                break;
            case R.id.showPublisher:
                showBy(DBHandler.KEY_PUBLISHER, argument);
                break;
            case R.id.showYear:
                showBy(DBHandler.KEY_YEAR, argument);
                break;
        }
    }

    public void clickedDelete(View v){
        RadioGroup deleteGroup = findViewById(R.id.deleteGroupRadioGroup);
        int selectedItem = deleteGroup.getCheckedRadioButtonId();
        String argument = editTextValue.getText().toString();
        switch (selectedItem){
            case R.id.deleteAll:
                deleteAllRecords();
                break;
            case R.id.deleteTitle:
                deleteBy(DBHandler.KEY_TITLE, argument);
                break;
            case R.id.deleteAuthor:
                deleteBy(DBHandler.KEY_AUTHOR, argument);
                break;
            case R.id.deletePublisher:
                deleteBy(DBHandler.KEY_PUBLISHER, argument);
                break;
            case R.id.deleteYear:
                deleteBy(DBHandler.KEY_YEAR, argument);
                break;
        }
    }

    public void showBy(String selection, String argument){
        List<Book> books = bookDAO.getBooks(selection, argument);
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

    public void deleteBy(String selection, String argument){
        bookDAO.deleteBooks(selection, argument);
        String str = "";
        textViewResult.setText(str);
    }

}
