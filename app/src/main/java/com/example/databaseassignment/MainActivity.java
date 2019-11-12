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

        textViewResult = (TextView)findViewById(R.id.textViewResult);
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
    }

    public void deleteRecords(View v){ }

    public void editRecord(View v){
        try {
            Intent intent = new Intent(MainActivity.this, EditActivity.class);
            startActivityForResult(intent, 0);
        } catch (Exception e) {/* Log error messages */}
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (resultCode == 1) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.
                textViewResult.setText(data.getStringExtra(EditActivity.MESSAGE_ADD));
                // Do something with the contact here (bigger example below)
            }
        }

}
