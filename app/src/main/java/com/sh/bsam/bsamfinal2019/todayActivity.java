package com.sh.bsam.bsamfinal2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.sh.bsam.bsamfinal2019.classes.Settings;

public class todayActivity extends AppCompatActivity {
    private ImageButton ibPre,ibNext,ibSettings;
    private TextView tvDay;
    private ListView lstTurn;

    String[] Names = new String[]{"order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order","order"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        ibNext = (ImageButton) findViewById(R.id.ibNext);
        ibPre = (ImageButton) findViewById(R.id.ibPre);
        tvDay = (TextView) findViewById(R.id.tvDay);
        lstTurn = (ListView) findViewById(R.id.lstTurn);
        ibSettings = (ImageButton) findViewById(R.id.ipSettings);
        lstTurn = (ListView) findViewById(R.id.lstTurn);

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,android.R.id.text1,Names);
        lstTurn.setAdapter(adapter);
        lstTurn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String Templistview=Names[position].toString();
                Intent intent=new Intent(todayActivity.this,OrderActivity.class);
                intent.putExtra("Listviewclickvalue",Templistview);
                startActivity(intent);
            }
        });


        ibSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

        ibNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ibPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
