package com.example.ryan.infit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_go_about;
    Button btn_go_test;
    Button btn_go_myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent loading = new Intent(getApplicationContext(), StartUpActivity.class);
        startActivity(loading);
        btn_go_about = findViewById(R.id.btn_about_us);
        btn_go_test = findViewById(R.id.btn_start_test);
        btn_go_myInfo = findViewById(R.id.btn_my_info);
        btn_go_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about_intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(about_intent);
            }
        });
        btn_go_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start_mbti_intent = new Intent(getApplicationContext(), IntroMBTIActivity.class);
                startActivity(start_mbti_intent);
            }
        });
        btn_go_myInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInfo_intent = new Intent(getApplicationContext(), MyInfoActivity.class);
                startActivity(myInfo_intent);
            }
        });
    }
}
