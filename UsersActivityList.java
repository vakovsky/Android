package bg.tcom.c12v1gr.demo122applivation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//public class UsersActivityList extends ListActivity {
public class UsersActivityList extends Activity {

    String[] usersArray = {"user1", "user2", "user3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        List<User> userArrayList = new ArrayList<>();
        int i = 1;
        for(String username:usersArray) {
            User user = new User(username, username + "@f1.bg", String.valueOf(i));
            userArrayList.add(user);
            i++;
        }

        //
        //this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, usersArray));

        //
        ListView listView = findViewById(R.id.users_list);
        UserAdapter userAdapter = new UserAdapter(this, R.layout.main_list_row, userArrayList);
        listView.setAdapter(userAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(UsersActivityList.this,
                        userArrayList.get(position).getUserName() + " - " +
                                String.valueOf(userArrayList.get(position).geteMail()) + " - " +
                                String.valueOf(userArrayList.get(position).getId())
                        , Toast.LENGTH_LONG).show();
            }
        });

    }

}
