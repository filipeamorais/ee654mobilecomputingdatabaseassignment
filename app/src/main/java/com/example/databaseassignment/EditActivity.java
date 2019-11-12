package com.example.databaseassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    public final static String MESSAGE_ADD = "INSERT";
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        id = (EditText)findViewById(R.id.editTextId);
    }

    public void addRecord(View v) {
        Intent intentWithResult = new Intent();
        intentWithResult.putExtra(MESSAGE_ADD, id.getText().toString());
        setResult(1, intentWithResult);
        finish();
    }

    public void updateRecord (View v) {}

    public void goBack(View v) {}
}
