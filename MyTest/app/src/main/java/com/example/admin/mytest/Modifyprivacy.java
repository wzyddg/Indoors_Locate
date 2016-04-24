package com.example.admin.mytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Modifyprivacy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifyprivacy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarmodifyprivacy);
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
        }else{
            System.out.println("no toolbar found");
        }
    }
    public void ToPassword(View view)
    {
        Intent intent = new Intent(Modifyprivacy.this, ModifypasswordActivity.class);
        startActivity(intent);
    }
    public void BacktoMain(View view)
    {
        Intent intent = new Intent(Modifyprivacy.this, MainActivity.class);
        startActivity(intent);
    }
}
