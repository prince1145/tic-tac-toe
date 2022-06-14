package com.example.tictactoeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    Button button;
    EditText person1;
    EditText person2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        person1 = findViewById(R.id.editTextTextPersonName);
        person2 = findViewById(R.id.editTextTextPersonName2);

    }

    public void jj(View view){
        String Player1Name = person1.getText().toString();
        String Player2Name = person2.getText().toString();
        Intent intent = new Intent(MainActivity3.this,MainActivity.class);
        intent.putExtra("person name",new String[]{Player1Name,Player2Name});

        startActivity(intent);
    }
}