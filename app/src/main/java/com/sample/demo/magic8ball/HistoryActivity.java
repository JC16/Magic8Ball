package com.sample.demo.magic8ball;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ChenYiTai on 4/18/16.
 */
public class HistoryActivity extends ListActivity {

    private ArrayList<QuestionResponseModel> historyArray;
    private ListView listView;

    private HistoryAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listView = (ListView)findViewById(android.R.id.list);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        this.historyArray = new ArrayList<QuestionResponseModel>();
        if(null!=intent) {
        this.historyArray = (ArrayList<QuestionResponseModel>)intent.getSerializableExtra("historyArray");
        }
        //historyArray.
        //Log.v("testing", "thisishistoyarray"+historyArray.size());

        adapter = new HistoryAdapter(this,historyArray);
        listView.setAdapter(adapter);
    }

}
