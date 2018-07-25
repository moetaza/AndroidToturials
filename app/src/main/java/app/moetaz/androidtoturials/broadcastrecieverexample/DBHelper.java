package app.moetaz.androidtoturials.broadcastrecieverexample;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static app.moetaz.androidtoturials.broadcastrecieverexample.DBContact.INCOMING_NUMBER;
import static app.moetaz.androidtoturials.broadcastrecieverexample.DBContact.TABLE_NAME;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "numberDB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE = "create table "+TABLE_NAME+
            "(id integer primary key autoincrement, "+INCOMING_NUMBER+" text);";
    private static final String DROP_TABLE =
            "drop table if exist "
                    +TABLE_NAME;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void saveNumber(String number,SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();
        contentValues.put(INCOMING_NUMBER,number);
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }

    public Cursor readNumber (SQLiteDatabase database){
        String[] projection = {"id",INCOMING_NUMBER};
        return database.query(TABLE_NAME,projection
                ,null,null,null,null,null);
    }
}

