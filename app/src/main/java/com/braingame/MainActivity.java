package com.braingame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_easylevel, btn_mediumlevel, btn_hardlevel, btn_view_high_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_easylevel = findViewById(R.id.btn_easy_level);
        btn_mediumlevel = findViewById(R.id.btn_medium_level);
        btn_hardlevel = findViewById(R.id.btn_hard_level);
        btn_view_high_score = findViewById(R.id.btn_view_high_score);

        btn_easylevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Easylevel.class);
                startActivity(i);
            }
        });

        btn_mediumlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, MediumLevel.class);
                startActivity(i);
            }
        });
        btn_hardlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, HardLevel.class);
                startActivity(i);

            }
        });

    }
}
