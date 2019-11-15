package com.example.databaseassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    public final static String MESSAGE_ADD = "INSERT";
    EditText id, title, author, publisher, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        id = (EditText)findViewById(R.id.editTextId);
        title = (EditText)findViewById(R.id.editTextTitle);
        author = (EditText)findViewById(R.id.editTextAuthor);
        publisher = (EditText)findViewById(R.id.editTextPublisher);
        year = (EditText)findViewById(R.id.editTextYear);
    }

    public void insertCommand(View v) {
        Intent intentWithResult = new Intent();
        intentWithResult.putExtra(MESSAGE_ADD, createBookObj());
        setResult(1, intentWithResult);
        finish();
    }

    public void updateCommand(View v) {
        Intent intentWithResult = new Intent();
        intentWithResult.putExtra(MESSAGE_ADD, createBookObj());
        setResult(2, intentWithResult);
        finish();
    }

    public void goBack(View v) {}

    public Book createBookObj() {
        int stringId = Integer.parseInt(id.getText().toString());
        String stringTitle = title.getText().toString();
        String stringAuthor = author.getText().toString();
        String stringPublisher = publisher.getText().toString();
        String stringYear = year.getText().toString();

        Book filledBook = new Book(stringId, stringTitle, stringAuthor, stringPublisher, stringYear);

        return filledBook;
    }
}
