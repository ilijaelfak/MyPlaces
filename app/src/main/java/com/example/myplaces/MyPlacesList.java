package com.example.myplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyPlacesList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_places_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        ListView myPlacesList= (ListView)findViewById(R.id.my_places_list);
        myPlacesList.setAdapter(new ArrayAdapter<MyPlace>(this ,android.R.layout.simple_list_item_1,MyPlacesData.getInstance().getMyPlaces()));

        myPlacesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Bundle positionBundle= new Bundle();
                positionBundle.putInt("position",i);
                Intent intent=new Intent(MyPlacesList.this,ViewMyPlacesActivity.class);
                intent.putExtras(positionBundle);
                startActivity(intent);
            }



        });
   /* MyPlacesList.setOnCreateContextMenuListener(new View.onCreateContextMenuListener)*/

        }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo){
        AdapterView.AdapterContextMenuInfo info  =(AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        MyPlace place = MyPlacesData.getInstance().getPlace(info.position);
        contextMenu.setHeaderTitle(place.getName());
        contextMenu.add(0,1,1,"View Place");
        contextMenu.add(0,2,2,"Edit Place");

    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        Bundle positionBundle = new Bundle();
        positionBundle.putInt("position",info.position);
        Intent i =null;
        if(item.getItemId()==1)
        {
            i=new Intent(this, ViewMyPlacesActivity.class);
            i.putExtras(positionBundle);
            startActivity(i);
        }
        else if(item.getItemId()==2)
        {
            i=new Intent(this, EditMyPlaceActivity.class);
            i.putExtras(positionBundle);
            startActivity(i);
        }
        return super.onContextItemSelected(item);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_my_places_list, menu);
        return true;
    }
    static int NEW_PLACE=1;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.show_map_item) {
            Toast.makeText(this, "Show Map", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.new_place_item) {
            Intent i =new Intent(this,EditMyPlaceActivity.class);
            startActivityForResult(i,NEW_PLACE);
        } else if (id == R.id.about_item) {
            Intent i = new Intent(this, About.class
            );
            startActivity(i);
        } else if(id==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }



}
