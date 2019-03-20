package com.sh.bsam.bsamfinal2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AllDatesList extends AppCompatActivity {
    ListView listL;

    String[]listviewitems=new String[]{
            "One","Two","Three","Four","Five","Six","Seven"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_dates_list);

        listL=(ListView)findViewById(R.id.listL);

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,android.R.id.text1,listviewitems);
        listL.setAdapter(adapter);
        listL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Templistview=listviewitems[position].toString();
                Intent intent=new Intent(AllDatesList.this,informationActivity.class);
                intent.putExtra("Listviewclickvalue",Templistview);
                startActivity(intent);
            }
        });








    }
}
