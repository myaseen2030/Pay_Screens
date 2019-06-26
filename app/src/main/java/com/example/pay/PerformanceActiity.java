package com.example.pay;


import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.pay.Adapter.FinanceAdapter;
import com.example.pay.Model.User;

import java.util.ArrayList;

public class PerformanceActiity extends AppCompatActivity {

    ListView perItems, learnItems, orgItems, cusItems;
    ArrayList<User> perNames;
    FinanceAdapter perItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance_actiity);

        //create User Object
        User item1 = new User("Increase profitability","120.00");
        User item2 = new User("Improve HR workforce efficiancy \n"+ "through automation","120.00");
        User item3 = new User("Increase profitability","120.00");
        User item4 = new User("Increase profitability","120.00");

        User learnItem1 = new User("Increase profitability","120.00");
        User learnItem2 = new User("Increase profitability","120.00");
        User learnItem3 = new User("Increase profitability","120.00");
        User learnItem4 = new User("Increase profitability","120.00");

        User cusItem1 = new User("Provide learning materials to all","120.00");
        User cusItem2 = new User("Teach profitability","120.00");
        User cusItem3 = new User("Increase profitability","120.00");
        User cusItem4 = new User("Increase profitability","120.00");

        perItems = (ListView) findViewById(R.id.lvPerItems);
        learnItems = (ListView) findViewById(R.id.lvLearnItems);
        orgItems = (ListView) findViewById(R.id.lvOrgItems);
        cusItems = (ListView) findViewById(R.id.lvCusItems);


        perNames = new ArrayList<>();
        perNames.add(item1);
        perNames.add(item2);
        perNames.add(item3);
        perNames.add(item4);

        ArrayList<User> learnNames = new ArrayList<>();
        learnNames.add(learnItem1);
        learnNames.add(learnItem2);
        learnNames.add(learnItem3);
        learnNames.add(learnItem4);

        ArrayList<User> cusNames = new ArrayList<>();
        cusNames.add(cusItem1);
        cusNames.add(cusItem2);
        cusNames.add(cusItem3);
        cusNames.add(cusItem4);

        perItemAdapter = new FinanceAdapter(this,R.layout.performance_list_view,perNames);
        perItems.setAdapter(perItemAdapter);

        FinanceAdapter learnItemAdapter = new FinanceAdapter(this,R.layout.performance_list_view,learnNames);
        learnItems.setAdapter(learnItemAdapter);
        orgItems.setAdapter(learnItemAdapter);

        FinanceAdapter cusItemAdapter = new FinanceAdapter(this,R.layout.performance_list_view,cusNames);
        cusItems.setAdapter(cusItemAdapter);
    }
}
