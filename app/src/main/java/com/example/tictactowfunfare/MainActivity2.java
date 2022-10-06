package com.example.tictactowfunfare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
    public void cc(View view){
        button = (Button) findViewById(R.id.button23);
        Toast.makeText(this, "fuck", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(MainActivity2.this,MainActivity3.class);
        startActivity(intent1);
    }
}