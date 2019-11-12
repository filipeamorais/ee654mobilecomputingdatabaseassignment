package com.example.databaseassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    BookDAO bookDAO;

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
}
