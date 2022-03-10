package bg.tcom.c12v1gr.demo122applivation;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InfoUsersActivity extends Activity {
    EditText etUsername;
    EditText etPassword;
    TextView tvUsersInfo;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_users);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvUsersInfo = findViewById(R.id.usersinfo);

        bt1 = findViewById(R.id.button1);

        DBInfoUsers infoUsers = new DBInfoUsers(getApplicationContext());

        Cursor c = infoUsers.select();

        StringBuilder b = new StringBuilder();
        if(c.moveToFirst()) {
            do {
                b.append(c.getString(c.getColumnIndex("user")));
                b.append(c.getString(c.getColumnIndex("pass")));
                b.append(" , ");
            } while (c.moveToNext());
        }
        String str = b.toString();
        tvUsersInfo.setText(str);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                infoUsers.insert(username, password);

                Toast.makeText(InfoUsersActivity.this, "Insert OK", Toast.LENGTH_LONG).show();
            }
        });
    }
}
