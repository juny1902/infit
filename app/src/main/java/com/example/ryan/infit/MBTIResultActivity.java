package com.example.ryan.infit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MBTIResultActivity extends AppCompatActivity {
    TextView tv_MBTI_Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtiresult);
        tv_MBTI_Result = findViewById(R.id.tv_MBTI_string);
        Intent mbti_intent = getIntent();
        String mbti_result_string = mbti_intent.getStringExtra("StringMBTI");
        tv_MBTI_Result.setText(tv_MBTI_Result.getText() + mbti_result_string);
    }
}
