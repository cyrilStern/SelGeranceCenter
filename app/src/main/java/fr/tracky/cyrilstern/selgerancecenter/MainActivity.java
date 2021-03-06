package fr.tracky.cyrilstern.selgerancecenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import fr.tracky.cyrilstern.selgerancecenter.entities.FactoryType;
import fr.tracky.cyrilstern.selgerancecenter.services.Util;
import fr.tracky.cyrilstern.selgerancecenter.viewAdaptateur.CardAdaptateur;
import fr.tracky.cyrilstern.selgerancecenter.viewAdaptateur.CardApplication;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Inject
    Util util;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                getString(R.string.LOGIN_FILE), Context.MODE_PRIVATE);
        if(!sharedPref.contains("LOGIN")){
            Intent intentFilter = new Intent(this,LoginActivity.class);
            startActivities(new Intent[]{intentFilter});
        }
        //this.getSharedPreferences("fr.tracky.cyrilstern.selgerancecenter.LOGIN_FILE", 0).edit().clear().apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MainApplication.app.getDaggerMainApplication_mainComponent().inject(this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view_card_application);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        CardApplication cardApplication = new CardApplication(R.color.Blue400, "call the center", FactoryType.PHONE_CALL.getActivityName(), R.color.Blue900, "take a photo", FactoryType.SMS_SEND.getActivityName());
        CardApplication cardApplication2 = new CardApplication(R.color.Blue500, "declare sinister", FactoryType.ACCOUNT_CONSULTATION.getActivityName(), R.color.Blue700, "lanch", FactoryType.ACCOUNT_CONSULTATION.getActivityName());
        CardApplication cardApplication3 = new CardApplication(R.color.Blue500, "send sms", FactoryType.ACCOUNT_CONSULTATION.getActivityName(), R.color.Blue700, "dame", FactoryType.ACCOUNT_CONSULTATION.getActivityName());
        CardApplication cardApplication4 = new CardApplication(R.color.Blue900, "contrats", FactoryType.ACCOUNT_CONSULTATION.getActivityName(), R.color.Blue700, "blanche", FactoryType.ACCOUNT_CONSULTATION.getActivityName());

        List<CardApplication> listCard = new ArrayList<>();
        listCard.add(cardApplication);
        listCard.add(cardApplication2);
        listCard.add(cardApplication3);
        listCard.add(cardApplication4);

        // specify an adapter (see also next example)
        mAdapter = new CardAdaptateur(listCard, this);
        mRecyclerView.setAdapter(mAdapter);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
