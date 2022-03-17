package bg.tcom.c12v1gr.demo122applivation;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class InfoUsersActivity extends ListActivity {
    EditText etUsername;
    EditText etEmail;
    TextView tvUsersInfo;
    Button bt1;
    List<String> usersArray;
    DBInfoUsers infoUsers;
    protected void setList()
    {
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

        usersArray = new ArrayList<>();

        if(c.moveToFirst()) {
            do {
                usersArray.add(c.getString(c.getColumnIndex("user")) + " "
                        + c.getString(c.getColumnIndex("email")) + "|"
                        + c.getString(c.getColumnIndex("_id"))
                );
            } while (c.moveToNext());
        }

        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, usersArray));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_users);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        tvUsersInfo = findViewById(R.id.usersinfo);

        bt1 = findViewById(R.id.button1);

        infoUsers = new DBInfoUsers(getApplicationContext());

        this.setList();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                infoUsers.insert(username, email);
                setList(); //
                Toast.makeText(InfoUsersActivity.this, "Insert OK", Toast.LENGTH_LONG).show();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String idstr = usersArray.get(position);
        int p = idstr.indexOf("|");
        idstr = idstr.substring(p + 1);
        Toast.makeText(this, idstr, Toast.LENGTH_LONG).show();
        
        //insert like
        //DBLikes dbLikes = new DBLikes(getApplicationContext());
        //dbLikes.insert(idstr);
        
        //update user
        //infoUsers.update(idstr, "123", "456@");
        
        //delete user
        infoUsers.delete(idstr);
        this.setList();
    }
}
