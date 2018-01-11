package com.sheygam.masa_2017_g2_11_01_18_part2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MultiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        Intent intent = getIntent();
        if(intent.getAction().equals("telran.second.activity.action")){
            Toast.makeText(this, "Was started with second action", Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals("telran.multi.activity.action")){
            Toast.makeText(this, "Was started with multi action", Toast.LENGTH_SHORT).show();
        }
    }
}
