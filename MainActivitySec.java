package com.example.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivitySec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sec);
        Intent intent = getIntent();
        int val1 = intent. getIntExtra("key1", 0);
        int val2 = intent. getIntExtra("key2", 0);
        int c = val1 * val2;
        Intent resultIntent = new Intent();
        resultIntent.putExtra("key3", c);
        setResult(10, resultIntent);
        finish();
    }
}
