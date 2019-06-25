package com.example.pay;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class PerformanceActiity extends AppCompatActivity {

    ListView perItems, learnItems, orgItems, cusItems;
    private ArrayAdapter perItemAdapter, learnItemAdapter, cusItemAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance_actiity);

        perItems = (ListView) findViewById(R.id.lvPerItems);
        learnItems = (ListView) findViewById(R.id.lvLearnItems);
        orgItems = (ListView) findViewById(R.id.lvOrgItems);
        cusItems = (ListView) findViewById(R.id.lvCusItems);


        ArrayList<String> perNames = new ArrayList<>();
        perNames.add("Increase profitability");
        perNames.add("Improve HR workforce efficiancy \n" +
                     "through automation");
        perNames.add("Increase profitability");
        perNames.add("Increase profitability");

        ArrayList<String> learnNames = new ArrayList<>();
        learnNames.add("Increase profitability");
        learnNames.add("Increase profitability");
        learnNames.add("Increase profitability");
        learnNames.add("Increase profitability");

        ArrayList<String> cusNames = new ArrayList<>();
        cusNames.add("Provide learning materials to all");
        cusNames.add("Teach profitability");
        cusNames.add("Increase profitability");
        cusNames.add("Increase profitability");


        perItemAdapter = new ArrayAdapter(this,R.layout.performance_list_view,R.id.tvPerList,perNames);
        perItems.setAdapter(perItemAdapter);


//        perItemAdapter = new ArrayAdapter(this,R.layout.performance_list_view,R.id.tvPerList,perNames);
//        perItems.setAdapter(perItemAdapter);

        learnItemAdapter = new ArrayAdapter(this,R.layout.performance_list_view,R.id.tvPerList,learnNames);
        learnItems.setAdapter(learnItemAdapter);
        orgItems.setAdapter(learnItemAdapter);

        cusItemAdapter = new ArrayAdapter(this,R.layout.performance_list_view,R.id.tvPerList,cusNames);
        cusItems.setAdapter(cusItemAdapter);

    }
}
