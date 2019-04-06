package com.example.myplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.show_map_item) {
            Toast.makeText(this, "Show_Map", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.about_item) {
            Intent i =new Intent(this,About.class);
            startActivity(i);
        }else if(id == R.id.my_places_item) {
            Toast.makeText(this, "My Places", Toast.LENGTH_SHORT).show();
            Intent i =new Intent(this,MyPlacesList.class );
            startActivity(i);
        }
        else if(id == R.id.new_place_item) {
            Toast.makeText(this, "New Place", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }
}