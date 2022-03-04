package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends Activity {
    TextView textView;
    EditText editTextNumber1;
    EditText editTextNumber2;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text1);
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        button1 = findViewById(R.id.button1);
        textView.setText(String.valueOf(0));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = 0;
                a = Integer.parseInt(editTextNumber1.getText().toString());
                int b = 0;
                b = Integer.parseInt(editTextNumber2.getText().toString());
                Intent intent = new Intent(MainActivity.this, SecActivity.class);
                int rc = 10;
                intent.putExtra("key1",a);
                intent.putExtra("key2",b);
                startActivityForResult(intent, rc); //startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int val3 = data.getIntExtra("key3", 0);
        textView.setText(String.valueOf(val3));
    }
}
