package com.example.pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReasonLeaveActivity extends AppCompatActivity {

    Button reasonLeave;
    Button pickFile1,pickFile2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason_leave);

        reasonLeave = (Button) findViewById(R.id.btnReasonLeave);
        pickFile1 = (Button) findViewById(R.id.btnAttach1);
        pickFile2 = (Button) findViewById(R.id.btnAttach2);


        reasonLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReasonLeaveActivity.this,SelectOfficerActivity.class);
                startActivity(intent);
            }
        });

        pickFile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile();
            }
        });

        pickFile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile();
            }
        });


    }

    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"), 17);
    }
}
