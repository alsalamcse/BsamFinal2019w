package com.sh.bsam.bsamfinal2019;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {
    private TextInputLayout tilstartH,tilEndH,tilTime4Person;
    private CheckBox checkBox,checkBox7,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6;
    private TextView tvActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        tilstartH = (TextInputLayout) findViewById(R.id.tilStartH);
        tilEndH = (TextInputLayout) findViewById(R.id.tilEndH);
        tilTime4Person = (TextInputLayout) findViewById(R.id.tilTime4Person);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        checkBox2= (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
    }
}
