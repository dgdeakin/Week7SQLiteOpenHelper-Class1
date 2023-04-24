package com.application.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.application.myapplication.sqlitehelper.DatabaseHelper;
import com.application.myapplication.sqlitehelper.Student;

public class SignUpActivity extends AppCompatActivity {


    EditText userName, password;

    DatabaseHelper databaseHelper;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userName = findViewById(R.id.editTextText2);
        password = findViewById(R.id.editTextTextPassword2);

        databaseHelper = new DatabaseHelper(this);


        button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName1 = userName.getText().toString();
                String userPassword1 = password.getText().toString();
                    long result = databaseHelper.insertStudent(new Student(userName1, userPassword1));
                    if(result > 0){

                        Toast.makeText(SignUpActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(SignUpActivity.this, "Registration Error!", Toast.LENGTH_SHORT).show();

                    }
                }

        });

    }
}