package com.sh.bsam.bsamfinal2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class TodayActivity extends AppCompatActivity {
    private ImageButton ibPre,ibNext;
    private TextView tvDay;
    private ListView lstTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        ibNext = (ImageButton) findViewById(R.id.ibNext);
        ibPre = (ImageButton) findViewById(R.id.ibPre);
        tvDay = (TextView) findViewById(R.id.tvDay);
        lstTurn = (ListView) findViewById(R.id.lstTurn);

    }
}
