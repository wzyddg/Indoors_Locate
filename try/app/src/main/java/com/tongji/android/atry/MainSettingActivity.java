package com.tongji.android.atry;

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
import android.widget.Button;

public class MainSettingActivity extends AppCompatActivity {
    Button btnToNikeName;
    Button btnToGender;
    Button btnToInterest;
    Button btnToPhonenum;
    Button btnToMail;
    Button btnToprivicy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingmain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTheme(R.style.AppTheme_NoActionBar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setHomeButtonEnabled(true);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        } else {
            System.out.println("no toolbar found");
        }

        btnToNikeName= (Button)findViewById(R.id.changeName);
        btnToNikeName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ToNikename(v);
            }
        });
        btnToGender= (Button)findViewById(R.id.changeGender);
        btnToGender.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ToGender(v);
            }
        });
        btnToInterest= (Button)findViewById(R.id.changeInterest);
        btnToInterest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ToInterest(v);
            }
        });
        btnToPhonenum= (Button)findViewById(R.id.changePhoneNum);
        btnToPhonenum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ToPhoneNum(v);
            }
        });
        btnToMail= (Button)findViewById(R.id.mail);
        btnToMail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ToMail(v);
            }
        });
        btnToprivicy= (Button)findViewById(R.id.changeprivacy);
        btnToprivicy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ToPrivacy(v);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            Intent intent = new Intent(MainSettingActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void ToPassword(View view)
    {
        Intent intent = new Intent(MainSettingActivity.this, ModifypasswordActivity.class);
        startActivity(intent);
    }
    public void ToNikename(View view)
    {
        Intent intent = new Intent(MainSettingActivity.this, Modifynikename.class);
        startActivity(intent);
    }
    public void ToGender(View view)
    {
        Intent intent = new Intent(MainSettingActivity.this, Modifygender.class);
        startActivity(intent);
    }
    public void ToInterest(View view)
    {
        Intent intent = new Intent(MainSettingActivity.this, ModifyInterest.class);
        startActivity(intent);
    }
    public void ToPhoneNum(View view)
    {
        Intent intent = new Intent(MainSettingActivity.this, Modifyphonenumber.class);
        startActivity(intent);
    }
    public void ToMail(View view)
    {
        Intent intent = new Intent(MainSettingActivity.this, Modifymail.class);
        startActivity(intent);
    }
    public void ToPrivacy(View view)
    {
        Intent intent = new Intent(MainSettingActivity.this, Modifyprivacy.class);
        startActivity(intent);
    }


}
