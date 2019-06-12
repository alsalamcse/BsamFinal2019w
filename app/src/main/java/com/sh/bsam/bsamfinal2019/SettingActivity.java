package com.sh.bsam.bsamfinal2019;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sh.bsam.bsamfinal2019.classes.Settings;

public class SettingActivity extends AppCompatActivity {
    private TextInputEditText tilstartH,tilEndH,tilTime4Person;
    private CheckBox chSunday,chMonday,chTuesday,chWednesday,chThursday,chFriday,chSaturday;
    private TextView tvActive;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        tilstartH = (TextInputEditText) findViewById(R.id.tilStartH);
        tilEndH = (TextInputEditText) findViewById(R.id.tilEndH);
        tilTime4Person = (TextInputEditText) findViewById(R.id.tilTime4Person);
        chSunday = (CheckBox) findViewById(R.id.chSunday);
        chMonday = (CheckBox) findViewById(R.id.chWednesday);
        chTuesday= (CheckBox) findViewById(R.id.chMonday);
        chWednesday = (CheckBox) findViewById(R.id.chTuesday);
        chThursday = (CheckBox) findViewById(R.id.chFriday);
        chFriday = (CheckBox) findViewById(R.id.chFriday);
        chSaturday = (CheckBox) findViewById(R.id.chSaturday);
        btnSave = (Button) findViewById(R.id.btnSave);
        tvActive = (TextView) findViewById(R.id.tvActive);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHandler();
            }
        });
    }
    private void DataHandler() {
        boolean isok = true;
        Settings S = new Settings();

        String startHour = tilstartH.getText().toString();
        String endHour = tilEndH.getText().toString();
        String time4person = tilTime4Person.getText().toString();

        if (isok)
        {

            S.setOpenHour(Integer.parseInt(startHour));
            S.setEndHour(Integer.parseInt(endHour));
            S.setTime4person(Integer.parseInt(time4person));

            S.setSunday(chSunday.isChecked());
            S.setMonday(chMonday.isChecked());
            S.setTuesday(chTuesday.isChecked());
            S.setWednesday(chWednesday.isChecked());
            S.setThursday(chThursday.isChecked());
            S.setFriday(chFriday.isChecked());
            S.setSaturday(chSaturday.isChecked());

            //get user email to set is as the owner of this task
            FirebaseAuth auth = FirebaseAuth.getInstance();
// to get the database root reference
            DatabaseReference reference= FirebaseDatabase.getInstance().getReference();

            //to get uid(universal id)


            reference.child(auth.getUid()).child("setting").setValue(S).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(getBaseContext(), "setting Successful", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(), "setting Faild", Toast.LENGTH_LONG).show();

                    }
                }
            });

        }


    }
}
