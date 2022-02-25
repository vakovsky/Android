package com.example.myapplication;

import android.content.Intent;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, MainActivitySec.class);

        //this.startActivity(intent);
        intent.putExtra("key1",23);
        //intent.putExtra("key2",14);
        this.startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int val3 = data.getIntExtra("key3", 0);
        //TextView textView = findViewById(R.id.text1);
        //textView.setText(String.valueOf(val3));
    }
}
