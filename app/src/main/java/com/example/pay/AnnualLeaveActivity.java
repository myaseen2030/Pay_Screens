package com.example.pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnnualLeaveActivity extends AppCompatActivity {

    Button pending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annual_leave);

        pending = (Button) findViewById(R.id.btnPending);

        pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnnualLeaveActivity.this,HouseRentActivity.class);
                startActivity(intent);
            }
        });
    }

}
