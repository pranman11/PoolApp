package com.myapp.pranavmanglani.mapsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final LinearLayout favouritesLayout= (LinearLayout) findViewById(R.id.favourites);
        favouritesLayout.setVisibility(View.INVISIBLE);
        favouritesLayout.setAlpha(0f);
        final EditText sourceText= (EditText) findViewById(R.id.source);
        final EditText destinationText= (EditText) findViewById(R.id.destination);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageButton ib = (ImageButton) findViewById(R.id.favouritesButton);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(favouritesLayout.getAlpha()==0f) {
//                Toast.makeText(MainActivity.this, "Working", Toast.LENGTH_SHORT).show();

                    // Prepare the View for the animation
                    favouritesLayout.setVisibility(View.VISIBLE);
                    favouritesLayout.setAlpha(0.0f);

                    // Start the animation
                    favouritesLayout.animate().translationX(-25f).alpha(1.0f);
                    sourceText.animate().alpha(0f);
                    destinationText.animate().alpha(0f);
                }
                else{
                    favouritesLayout.animate().translationX(25f).alpha(0f);
                    sourceText.animate().alpha(1f);
                    destinationText.animate().alpha(1f);
                }
            }
        });
        final int[] isModeClicked = {0};
        ImageButton carBtn= (ImageButton) findViewById(R.id.carImgBtn);
        final HorizontalScrollView modesScrollView= (HorizontalScrollView) findViewById(R.id.horizontalScrollView);
        final ImageButton favBtn= (ImageButton) findViewById(R.id.favouritesButton);
        final FrameLayout carFrame= (FrameLayout) findViewById(R.id.carFrame);
        carBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isModeClicked[0]==0) {
                    favBtn.animate().translationYBy(-300f).alpha(0f);
                    modesScrollView.animate().translationYBy(-300f);
                    carFrame.animate().alpha(1f);
                    isModeClicked[0] =1;
                }
                else{
                    favBtn.animate().translationYBy(300f).alpha(1f);
                    modesScrollView.animate().translationYBy(300f);
                    carFrame.animate().alpha(0f);
                    isModeClicked[0]=0;
                }
            }
        });
        ImageButton taxiBtn= (ImageButton) findViewById(R.id.taxiImgBtn);
        final LinearLayout taxiFrame= (LinearLayout) findViewById(R.id.taxiFrame);
        taxiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isModeClicked[0]==0) {
                    favBtn.animate().translationYBy(-300f).alpha(0f);
                    modesScrollView.animate().translationYBy(-300f);
                    taxiFrame.animate().alpha(1f);
                    isModeClicked[0]=1;
                }
                else{
                    favBtn.animate().translationYBy(300f).alpha(1f);
                    modesScrollView.animate().translationYBy(300f);
                    taxiFrame.animate().alpha(0f);
                    isModeClicked[0]=0;
                }
            }
        });

        ImageButton busBtn= (ImageButton) findViewById(R.id.busImgBtn);
        final FrameLayout busFrame= (FrameLayout) findViewById(R.id.busFrame);
        busBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isModeClicked[0]==0) {
                    favBtn.animate().translationYBy(-300f).alpha(0f);
                    modesScrollView.animate().translationYBy(-300f);
                    busFrame.animate().alpha(1f);
                    isModeClicked[0]=1;
                }
                else{
                    favBtn.animate().translationYBy(300f).alpha(1f);
                    modesScrollView.animate().translationYBy(300f);
                    busFrame.animate().alpha(0f);
                    isModeClicked[0]=0;
                }
            }
        });

        ImageButton trainBtn= (ImageButton) findViewById(R.id.trainImgBtn);
        final FrameLayout trainFrame= (FrameLayout) findViewById(R.id.trainFrame);
        trainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isModeClicked[0]==0) {
                    favBtn.animate().translationYBy(-300f).alpha(0f);
                    modesScrollView.animate().translationYBy(-300f);
                    trainFrame.animate().alpha(1f);
                    isModeClicked[0]=1;
                }
                else{
                    favBtn.animate().translationYBy(300f).alpha(1f);
                    modesScrollView.animate().translationYBy(300f);
                    trainFrame.animate().alpha(0f);
                    isModeClicked[0]=0;
                }
            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_connections) {
            Intent intentConnect=new Intent(this,ConnectionsActivity.class);
            startActivity(intentConnect);
        } else if (id == R.id.nav_groups) {
            Intent intentGroups=new Intent(this,GroupsActivity.class);
            startActivity(intentGroups);

        } else if (id == R.id.nav_preferences) {
            Intent intentPrefer=new Intent(this,PreferencesActivity.class);
            startActivity(intentPrefer);

        } else if (id == R.id.nav_manage) {

        }  else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng mumbai = new LatLng(19.0760, 72.8777);
        mMap.addMarker(new MarkerOptions().position(mumbai).title("Marker in Mumbai"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mumbai));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13));
    }

}
