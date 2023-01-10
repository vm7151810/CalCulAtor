package com.example.calculator;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    EditText calculation, result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        final databaseHelper helper = new databaseHelper(this);
        calculation=findViewById(R.id.calc);
        result= findViewById(R.id.result);
        result.getText();
        calculation.getText();
        helper.insert(calculation.toString() + " = " + result.toString());
    }

}