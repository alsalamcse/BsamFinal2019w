package com.sh.bsam.bsamfinal2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class informationActivity extends AppCompatActivity {

    TextView tvToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        tvToast=(TextView)findViewById(R.id.tvToast);

        String Tempholder=getIntent().getStringExtra("Listviewclickvalue");

        tvToast.setText(Tempholder);
    }
}
