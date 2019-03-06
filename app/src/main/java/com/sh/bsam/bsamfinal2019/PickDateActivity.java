package com.sh.bsam.bsamfinal2019;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class PickDateActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {
    private Button btnPick;
    private TextView tvResult;

    int day, month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_date);

        btnPick = (Button) findViewById(R.id.btnPick);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(PickDateActivity.this, PickDateActivity.this,year,month,day);
                datePickerDialog.show();

            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker,int i, int i1, int i2) {
        yearFinal=i;
        monthFinal=i1+1;//
        dayFinal=i2;

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(PickDateActivity.this,PickDateActivity.this
                ,hour,minute,true);
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker,int i,int i1) {
        hourFinal = i;
        monthFinal = i1;

        tvResult.setText("year:"+yearFinal+"\n"+
                "month:"+monthFinal+"\n"+
                "day:"+dayFinal+"\n"+
                "hour:"+hourFinal+"\n"+
                "minute:"+minuteFinal);

    }
}
