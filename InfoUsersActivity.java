package bg.tcom.c12v1gr.demo122applivation;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InfoUsersActivity extends ListActivity {
    EditText etUsername;
    EditText etEmail;
    TextView tvUsersInfo;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_users);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        tvUsersInfo = findViewById(R.id.usersinfo);

        bt1 = findViewById(R.id.button1);

        DBInfoUsers infoUsers = new DBInfoUsers(getApplicationContext());

        Cursor c = infoUsers.select();

        StringBuilder b = new StringBuilder();
        if(c.moveToFirst()) {
            do {
                b.append(c.getString(c.getColumnIndex("user")));
                b.append(c.getString(c.getColumnIndex("email")));
                b.append(" , ");
            } while (c.moveToNext());
        }
        String str = b.toString();
        tvUsersInfo.setText(str);

        List<String> usersArray = new ArrayList<>();

        if(c.moveToFirst()) {
            do {
                b.append(c.getString(c.getColumnIndex("user")));
                b.append(c.getString(c.getColumnIndex("email")));
                b.append(" , ");
                usersArray.add(c.getString(c.getColumnIndex("user")) + " "
                        +c.getString(c.getColumnIndex("email")));
            } while (c.moveToNext());
        }


        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, usersArray));

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                infoUsers.insert(username, email);

                Toast.makeText(InfoUsersActivity.this, "Insert OK", Toast.LENGTH_LONG).show();
            }
        });
    }
}
