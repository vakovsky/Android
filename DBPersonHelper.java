package bg.tcom.c12v1gr.demo122applivation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBPersonHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "persondb.sqlite";
    static final int DB_CURRENT_VERSION = 1;
    protected SQLiteDatabase db;

    public DBPersonHelper(Context context) {
        super(context, DB_NAME, null, DB_CURRENT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users (_id integer primary key autoincrement, user text not null, pass text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void open() {
        db = getWritableDatabase();
    }

    public void close() {
        db.close();
    }
}
