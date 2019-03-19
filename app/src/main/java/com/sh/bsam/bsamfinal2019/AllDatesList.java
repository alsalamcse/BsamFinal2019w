package com.sh.bsam.bsamfinal2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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








    }
}
