package com.example.admin.mytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Modifygender extends AppCompatActivity {
    public static RadioGroup radioGroup;
    public static RadioButton radioMale,radioFemale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifygender);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarmodifygender);
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
        }else{
            System.out.println("no toolbar found");
        }
    }
    public void onClickListenerButton(){
        radioGroup = (RadioGroup)findViewById(R.id.genderGroup);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.accept) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void BacktoMain(View view)
    {
        Intent intent = new Intent(Modifygender.this, MainActivity.class);
        startActivity(intent);
    }
}
