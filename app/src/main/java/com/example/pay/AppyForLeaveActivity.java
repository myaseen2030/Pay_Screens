package com.example.pay;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.Calendar;

public class AppyForLeaveActivity extends AppCompatActivity {


    EditText leave_start_date;
    Calendar c;
    DatePickerDialog dpd;
    Button leave_doc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appy_for_leave);

        leave_doc = (Button) findViewById(R.id.btnMainLeave);

        leave_start_date = (EditText) findViewById(R.id.tvLeaveSD);
        leave_start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c= Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(AppyForLeaveActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        leave_start_date.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                },
                        day,month,year
                );
                dpd.show();
            }
        });

        leave_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppyForLeaveActivity.this,ReasonLeaveActivity.class);
                startActivity(intent);

            }
        });
    }


}
