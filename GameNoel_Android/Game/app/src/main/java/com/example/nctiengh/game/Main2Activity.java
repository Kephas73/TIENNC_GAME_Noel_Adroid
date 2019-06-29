package com.example.nctiengh.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void  mo()
    {
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
