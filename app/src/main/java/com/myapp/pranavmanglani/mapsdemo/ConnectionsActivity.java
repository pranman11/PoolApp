package com.myapp.pranavmanglani.mapsdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ConnectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connections);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button contactsButton= (Button) findViewById(R.id.contactsAddButton);
        contactsButton.setAlpha(0f);
        final Button facebookButton= (Button) findViewById(R.id.facebookAddButton);
        facebookButton.setAlpha(0f);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contactsButton.getAlpha()==0f) {
                    facebookButton.animate().translationX(-25f).alpha(1f);
                    contactsButton.animate().translationX(-25f).alpha(1f);
                    fab.animate().rotationBy(45);
                }
                else{
                    facebookButton.animate().translationX(25f).alpha(0f);
                    contactsButton.animate().translationX(25f).alpha(0f);
                    fab.animate().rotationBy(45);

                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String []userStrings=new String[5];

        userStrings= getResources().getStringArray(R.array.users);

        // Construct the data source
        ArrayList<User> arrayOfUsers = new ArrayList<User>(5);
        for(int i=0;i<5;i++){
            User user=new User(userStrings[i],"Contact no: "+"9"+i*2+"*******"+i+3);
            arrayOfUsers.add(user);
        }
// Create the adapter to convert the array to views
        UserAdapter adapter = new UserAdapter(this, arrayOfUsers);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

//        ListView userList= (ListView) findViewById(R.id.listView);
//
//        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(ConnectionsActivity.this,android.R.layout.simple_list_item_1,userStrings);
//        userList.setAdapter(arrayAdapter);


    }

}
