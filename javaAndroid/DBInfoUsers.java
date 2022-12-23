package bg.tcom.c12v1gr.demo122applivation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class DBInfoUsers  extends DBPersonHelper{
    public DBInfoUsers(Context context) {
        super(context);
    }

    public void insert(String user, String email) {
        open();
        ContentValues cv = new ContentValues();
        cv.put("user", user);
        cv.put("email", email);
        //...
        this.db.insert("users", null, cv);
    }

    public Cursor select() {
        open();
        return this.db.query("users",new String[]{"user","email"}, null, null, null, null, null);
    }
}
