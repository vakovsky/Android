package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SecActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
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
