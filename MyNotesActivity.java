package com.example.manny.mynotes;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.manny.mynotes.model.model;

public class MyNotesActivity extends AppCompatActivity {
    private ContentValues cv;
    private model mModel;
    private SQLiteDatabase mDatabase;
    private SimpleCursorAdapter mAdapter;
    ListView listView;
    String mMsgId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);
        mModel = new model(this);
        mDatabase = mModel.getWritableDatabase();

       // mDatabase.insert(model.TABLE_NAME, null, addContent("สอบfinal", "android", "*"));
       // mDatabase.insert(model.TABLE_NAME, null, addContent("สอบmidterm", "android", ""));
        Cursor cursor = readAllData();
       // Log.i("count data 5555 = ", String.valueOf(cursor.getCount()));
        mAdapter = new SimpleCursorAdapter(this, R.layout.note, cursor,
                new String[]{model.COL_LIKE, model.COL_SUBJECT},
                new int[]{R.id.text_star, R.id.text_subject});
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMsgId = String.valueOf(id);

                Intent i = new Intent(MyNotesActivity.this, ShowActivity.class);
                i.putExtra("id", mMsgId);
                startActivity(i);
            }
        });


    }

    private Cursor readAllData() {
        String[] columns = {
                model.COL_ID, model.COL_SUBJECT, model.COL_CONTENT, model.COL_LIKE
        };
        //Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+ model.TABLE_NAME  ,null);
        Cursor cursor = mDatabase.query(model.TABLE_NAME, columns, null, null, null, null, null);
        return cursor;
    }

    public ContentValues addContent(String msgName, String msgContent, String msgLike) {
        ContentValues cv = new ContentValues();
        cv.put(model.COL_SUBJECT, msgName);
        cv.put(model.COL_CONTENT, msgContent);
        cv.put(model.COL_LIKE, msgLike);
        return cv;
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_call) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

