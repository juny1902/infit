package com.example.ryan.infit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class IntroMBTIActivity extends AppCompatActivity {
    Button btn_go_mbti_1st_page;
    RadioButton rd_male, rd_female;
    EditText ed_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_mbti);
        btn_go_mbti_1st_page = findViewById(R.id.btn_start_test2);

        rd_male = findViewById(R.id.radio_male);
        rd_female = findViewById(R.id.radio_female);
        ed_age = findViewById(R.id.ed_age);
        btn_go_mbti_1st_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((rd_male.isChecked() && rd_female.isChecked()) || ed_age.getText().toString().isEmpty()) {
                    Toast.makeText(IntroMBTIActivity.this, "나이와 성별을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    MBTI person = new MBTI();
                    person.setAge(Integer.parseInt(ed_age.getText().toString()));
                    if(rd_male.isChecked())
                    {
                        person.setSex(false); // False : Male, True : Female
                    }else{
                        person.setSex(true);
                    }
                    Intent mbti_test_page = new Intent(getApplicationContext(), MBTIActivity.class);
                    mbti_test_page.putExtra("person",person);
                    startActivity(mbti_test_page);
                }
            }
        });
    }
}
