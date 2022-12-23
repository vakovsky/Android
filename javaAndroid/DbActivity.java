package bg.tcom.c12v1gr.demo122applivation;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        DBPref pref = new DBPref(getApplicationContext());

        pref.addRecord("1234", "user1");

        Cursor c = pref.select();
        StringBuilder b = new StringBuilder();
        if(c.moveToFirst()) {
            do {
                b.append(c.getString(c.getColumnIndex("val")));
                b.append(c.getString(c.getColumnIndex("user")));
                b.append(" , ");
            } while (c.moveToNext());
        }
        String str = b.toString();
    }
}
