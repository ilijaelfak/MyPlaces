package com.example.myplaces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditMyPlaceActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my_place);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final Button finishedButton=(Button) findViewById(R.id.editmyplace_finished_button);
        finishedButton.setOnClickListener(this);
        finishedButton.setEnabled(false);


        Button cancelButton=(Button) findViewById(R.id.editmyplace_cancel_button);
        cancelButton.setOnClickListener(this);

       EditText nameEditText=(EditText)findViewById(R.id.editmyplace_name_edit);
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                finishedButton.setEnabled(s.length()>0);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_my_place, menu);
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

            Intent i =new Intent(this,MyPlacesList.class );
            startActivity(i);

        } else if(id==android.R.id.home){
            finish();

        }


        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.editmyplace_finished_button:{
                EditText etName = (EditText)findViewById(R.id.editmyplace_name_edit);
                String nme = etName.getText().toString();

                EditText etDesc = (EditText)findViewById(R.id.editmyplace_description_edit);
                String desc = etDesc.getText().toString();

                MyPlace place = new MyPlace(nme,desc);
                MyPlacesData.getInstance().addNewPlace(place);
                setResult(Activity.RESULT_OK);
                finish();
                break;
            }
            case R.id.editmyplace_cancel_button:{
                setResult(Activity.RESULT_CANCELED);
                finish();
                break;
            }
        }
    }

}
