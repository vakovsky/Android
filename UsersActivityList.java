package bg.tcom.c12v1gr.demo122applivation;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class UsersActivityList extends ListActivity {

    String[] usersArray = {"user1", "user2", "user3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        List<User> userArrayList = new ArrayList<>();
        for(String username:usersArray) {
            User user = new User(username, username + "@f1.bg");
            userArrayList.add(user);
        }

        //
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, usersArray));

        //
        /*ListView listView = findViewById(R.id.users_list);
        UserAdapter userAdapter = new UserAdapter(this, R.layout.main_list_row, userArrayList);
        listView.setAdapter(userAdapter);*/

    }

}
