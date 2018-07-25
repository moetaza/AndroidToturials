package app.moetaz.androidtoturials.broadcastrecieverexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import app.moetaz.androidtoturials.R;

public class Main4Activity extends AppCompatActivity {

    TextView textView;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<IncomingNumber> list = new ArrayList<>();
    RecycerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textView = findViewById(R.id.emptytxt);
        recyclerView = findViewById(R.id.recyclerview);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecycerAdapter(list);
        recyclerView.setAdapter(adapter);

        readDB();

    }

    private void readDB (){
        list.clear();
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = dbHelper.readNumber(database);

        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                String number;
                int id;
                number = cursor.getString(cursor.getColumnIndex(DBContact.INCOMING_NUMBER));
                id = cursor.getInt(cursor.getColumnIndex("id"));

                list.add(new IncomingNumber(id,number));
            }
            cursor.close();
            dbHelper.close();
            adapter.notifyDataSetChanged();
            recyclerView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        }

    }
}
