package com.example.manny.mynotes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.manny.mynotes.model.model;

public class ShowActivity extends AppCompatActivity {
    private model mModel;
    private SQLiteDatabase mDatabase;
    String mMsgId;
    private SimpleCursorAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent i = getIntent();
        mMsgId = i.getStringExtra("id");
        Log.i("Id",mMsgId);
        mModel = new model(this);
        mDatabase = mModel.getWritableDatabase();
        Cursor cursor = readAllData();
        mAdapter = new SimpleCursorAdapter(this, R.layout.content_row, cursor,
                new String[]{model.COL_SUBJECT, model.COL_CONTENT,model.COL_LIKE},
                new int[]{R.id.textView ,R.id.textView2,R.id.imageView});
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(mAdapter);


    }
    private Cursor readAllData(){
        String[] columns = {
                model.COL_ID,model.COL_SUBJECT,model.COL_CONTENT,model.COL_LIKE
        } ;
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+ model.TABLE_NAME+ " WHERE "+model.COL_ID + " =? "  ,new String[]{mMsgId});

        return cursor;
    }
}
