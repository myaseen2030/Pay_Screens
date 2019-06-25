package com.example.pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HouseRentActivity extends AppCompatActivity {


    Button editRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_rent);

        editRequest = (Button) findViewById(R.id.btnEditRequest);
        editRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HouseRentActivity.this,PerspectivesActivity.class);
                startActivity(intent);
            }
        });
    }
}
