package com.application.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.application.myapplication.sqlitehelper.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    Button loginButton, signUpButton;
    EditText userName, password;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextTextPassword);

       loginButton = findViewById(R.id.button);
       signUpButton = findViewById(R.id.button2);

       databaseHelper = new DatabaseHelper(this);


       loginButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               boolean result = databaseHelper.getStudents(
                       userName.getText().toString(),
                       password.getText().toString()
               );

               if(result == true){
                   Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_LONG).show();
               }
               else {
                   Toast.makeText(MainActivity.this, "Student Doesn't Exist", Toast.LENGTH_LONG).show();
               }

           }
       });


       signUpButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               startActivity(new Intent(MainActivity.this, SignUpActivity.class));

           }
       });
    }

}