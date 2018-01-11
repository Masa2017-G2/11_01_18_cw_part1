package com.sheygam.masa_2017_g2_11_01_18_part2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_second_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("telran.second.activity.action");
                        startActivity(intent);
                    }
                });

        findViewById(R.id.start_multi_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("telran.multi.activity.action");
                        startActivity(intent);
                    }
                });

        findViewById(R.id.open_link_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        Uri uri = Uri.parse("test://google.com");
                        intent.setData(uri);
                        Intent chooser = Intent.createChooser(intent,"Choice app");
                        startActivity(chooser);
                    }
                });

        findViewById(R.id.save_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        save();
                    }
                });

        findViewById(R.id.load_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        load();
                    }
                });
    }

    public void save(){
        SharedPreferences sharedPreferences = getSharedPreferences("SAVE",MODE_PRIVATE);
        String str = "User " + System.currentTimeMillis();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("VALUE",str);
        editor.commit();
    }

    public void load(){
        SharedPreferences sharedPreferences = getSharedPreferences("SAVE",MODE_PRIVATE);
        String str = sharedPreferences.getString("VALUE","empty");
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
