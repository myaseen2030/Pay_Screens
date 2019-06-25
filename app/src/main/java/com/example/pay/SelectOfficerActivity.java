package com.example.pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectOfficerActivity extends AppCompatActivity {

    ListView listView,listViewItem;
    EditText search;
    private ArrayAdapter adapter, itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_officer);

        listViewItem = (ListView) findViewById(R.id.lvItems);
        listView = (ListView) findViewById(R.id.lvSearch);
        search = (EditText) findViewById(R.id.etSearch);

        Button leaveAll;

        ArrayList<String> names = new ArrayList<>();
        names.add("Damilola Adepoju");
        names.add("Demola Oloyede");
        names.add("Derionla White");
        names.add("Taiwo Olaoluwa");

        leaveAll = (Button) findViewById(R.id.tvLeaveAll);

        itemAdapter = new ArrayAdapter(this,R.layout.list_items_visible,R.id.tvList,names);
        listViewItem.setAdapter(itemAdapter);

        adapter = new ArrayAdapter(this,R.layout.list_items_layout,R.id.tvList,names);
        listView.setAdapter(adapter);

                search.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        listView.setVisibility(View.VISIBLE);
                        (SelectOfficerActivity.this).adapter.getFilter().filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
        listView.setVisibility(View.GONE);

        leaveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectOfficerActivity.this,AnnualLeaveActivity.class);
                startActivity(intent);
            }
        });
    }
}
