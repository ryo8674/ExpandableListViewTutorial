package com.example.peter.expandablelistviewtutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

public class CustomExpandableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.list_custom);
        CustomAdapter adapter = new CustomAdapter(this);
        expandableListView.setAdapter(adapter);

    }
}
