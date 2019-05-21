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

import java.util.Calendar;

public class PickDateActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {
    private Button btnPick,btnSend;
    private TextView tvResult;
    //private FirebaseAuth auth;
  //  private FirebaseUser firebaseUser;
   // DatabaseReference reference;
   // private TaskAdapter taskAdapter;




    int day, month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_date);

        btnPick = (Button) findViewById(R.id.btnPick);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnSend = (Button) findViewById(R.id.btnSend);
       // getUser();








        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  if (tvResult.getText().toString() != null){
                 //   Intent i = new Intent(getApplicationContext() , AllDatesList.class);
                  //  i.putExtra("Date" , tvResult.getText().toString());
                  //  i.putExtra("UserName"  , firebaseUser.getDisplayName());
                    //startActivity(i);
               // taskAdapter=new TaskAdapter(getApplicationContext(),R.layout.task_item);
               // Intent intent=new Intent(PickDateActivity.this,informationActivity.class);
               // intent.putExtra("userName",taskAdapter.getItem().getName());
              //  startActivity(intent);


            }
        });

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
  //  private void getUser(){
      //  reference = FirebaseDatabase.getInstance().getReference();
      //  String Email=auth.getCurrentUser().getEmail();

       // reference.child("user").child(Email.replace('.','*')).addValueEventListener(new ValueEventListener() {
          //  @Override
           // public void onDataChange( DataSnapshot dataSnapshot) {
            //    taskAdapter.clear();
              //  for (DataSnapshot d : dataSnapshot.getChildren()){
                //    MyProfile Mp = d.getValue(MyProfile.class);
                //    taskAdapter.add(Mp);
              //  }
           // }

          //  @Override
         //   public void onCancelled( DatabaseError databaseError) {
         //       Toast.makeText(PickDateActivity.this,"onCancelled",Toast.LENGTH_SHORT).show();

         //   }
     //   });
  //  }





      @Override
       public void onDateSet(DatePicker datePicker,int i, int i1, int i2) {
        yearFinal=i;
        monthFinal=i1+1;// i1+1 becawse the android return 11 monthes
          dayFinal=i2;

          Calendar c = Calendar.getInstance();
          hour = c.get(Calendar.HOUR_OF_DAY);
          minute = c.get(Calendar.MINUTE);

           TimePickerDialog timePickerDialog = new TimePickerDialog(PickDateActivity.this,PickDateActivity.this,hour,minute,true);
           timePickerDialog.show();
   }

    @Override
    public void onTimeSet(TimePicker timePicker,int i,int i1) {
        hourFinal = i;
        minuteFinal = i1;

        tvResult.setText("year:"+yearFinal+"\n"+
                "month:"+monthFinal+"\n"+
                "day:"+dayFinal+"\n"+
                "hour:"+hourFinal+"\n"+
                "minute:"+minuteFinal);

    }

}
