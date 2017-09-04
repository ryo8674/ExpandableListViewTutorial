package com.example.peter.expandablelistviewtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.simple_btn).setOnClickListener(this);
        findViewById(R.id.custom_btn).setOnClickListener(this);
        
    }


    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.simple_btn:
                intent = new Intent(MainActivity.this, SimpleExpandableListAdapterActivity.class);
                break;
            case R.id.custom_btn:
                intent = new Intent(MainActivity.this, CustomExpandableActivity.class);
                break;
        }
        startActivity(intent);
    }
}
