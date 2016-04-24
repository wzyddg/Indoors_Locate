package com.example.admin.mytest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTheme(R.style.AppTheme);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }else{
            System.out.println("no toolbar found");
        }
        }
    public void ToPassword(View view)
    {
        Intent intent = new Intent(MainActivity.this, ModifypasswordActivity.class);
        startActivity(intent);
    }
    public void ToNikename(View view)
    {
        Intent intent = new Intent(MainActivity.this, Modifynikename.class);
        startActivity(intent);
    }
    public void ToGender(View view)
    {
        Intent intent = new Intent(MainActivity.this, Modifygender.class);
        startActivity(intent);
    }
    public void ToInterest(View view)
    {
        Intent intent = new Intent(MainActivity.this, ModifyInterest.class);
        startActivity(intent);
    }
    public void ToPhoneNum(View view)
    {
        Intent intent = new Intent(MainActivity.this, Modifyphonenumber.class);
        startActivity(intent);
    }
    public void ToMail(View view)
    {
        Intent intent = new Intent(MainActivity.this, Modifymail.class);
        startActivity(intent);
    }
    public void ToPrivacy(View view)
    {
        Intent intent = new Intent(MainActivity.this, Modifyprivacy.class);
        startActivity(intent);
    }
}
