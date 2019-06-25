package com.example.pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PerspectivesActivity extends AppCompatActivity {

    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perspectives);

        update = (Button) findViewById(R.id.btnUpdateScore);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerspectivesActivity.this,PerformanceActiity.class);
                startActivity(intent);
            }
        });
    }
}
