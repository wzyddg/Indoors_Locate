package com.example.admin.mytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Modifynikename extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifynikename);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarmodifynikename);
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
        }else{
            System.out.println("no toolbar found");
        }
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
        Intent intent = new Intent(Modifynikename.this, MainActivity.class);
        startActivity(intent);
    }
}
