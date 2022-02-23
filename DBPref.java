package bg.tcom.c12v1gr.demo122applivation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class DBPref extends DBHelper{
    public DBPref(Context context) {
        super(context);
    }
    public void addRecord(String val, String user)
    {
        open();
        ContentValues cv = new ContentValues();
        cv.put("val", val);
        cv.put("user", user);
        //.....
        this.db.insert("preferences", null, cv);
    }
    public void delete()
    {
        open();
        this.db.delete("preferences", "", null);
    }
    public void update(String val, String user)
    {
        open();
        ContentValues cv = new ContentValues();
        cv.put("val", val);
        cv.put("user", user);
        this.db.update("", cv, "", null);
    }
    public Cursor select() {
        open();
        return this.db.query("preferences",new String[]{"val","user"}, null, null, null, null, null);
    }
}
