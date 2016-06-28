package com.tongji.android.atry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Modifyprivacy extends AppCompatActivity {
    Button btnToPassword;
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

        btnToPassword= (Button)findViewById(R.id.changePassword);
        btnToPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ToPassword(v);
            }
        });
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
