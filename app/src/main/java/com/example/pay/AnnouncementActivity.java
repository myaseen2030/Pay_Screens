package com.example.pay;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class AnnouncementActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    private Ann1Fragment ann1Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        ann1Fragment = new Ann1Fragment();

        frameLayout = (FrameLayout) findViewById(R.id.main_frame);
        setFragment(ann1Fragment);


    }

    private void setFragment(Ann1Fragment ann1Fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,ann1Fragment);
        fragmentTransaction.commit();
    }


}
