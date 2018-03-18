package com.myapp.pranavmanglani.mapsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] groupsString = {"None", "Group_name_1", "Group_name_2", "Group_name_3"};

        Spinner groupsSpinner = (Spinner) findViewById(R.id.groupsSpinner);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(PreferencesActivity.this, android.R.layout.simple_list_item_1, groupsString);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        groupsSpinner.setAdapter(arrayAdapter);
    }
}
