package com.example.ryan.infit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    Button btn_go_about;
    Button btn_go_test;
    Button btn_go_myInfo;
    ImageView im_mbti_character;
    MBTI person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent help = new Intent(getApplicationContext(), First_Help_Activity.class);
        startActivity(help);
        btn_go_about = findViewById(R.id.btn_about_us);
        btn_go_test = findViewById(R.id.btn_start_test);
        btn_go_myInfo = findViewById(R.id.btn_my_info);
        im_mbti_character = findViewById(R.id.imageView_user_character);


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

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sPrefs = getSharedPreferences("MBTIResult", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sPrefs.getString("MBTIPerson", "");
        if (json != "") {
            person = gson.fromJson(json, MBTI.class);
            switch (person.getMBTI_Result_4words()) {
                case "INTJ":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_intj));
                    break;
                case "INTP":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_intp));
                    break;
                case "ENTJ":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_entj));
                    break;
                case "ENTP":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_entp));
                    break;
                case "INFJ":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_infj));
                    break;
                case "INFP":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_infp));
                    break;
                case "ENFJ":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_enfj));
                    break;
                case "ENFP":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_enfp));
                    break;
                case "ISTJ":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_istj));
                    break;
                case "ISFJ":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_isfj));
                    break;
                case "ESTJ":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_estj));
                    break;
                case "ESFJ":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_esfj));
                    break;
                case "ISTP":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_istp));
                    break;
                case "ISFP":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_isfp));
                    break;
                case "ESTP":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_estp));
                    break;
                case "ESFP":
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.chara_esfp));
                    break;
                default:
                    im_mbti_character.setImageDrawable(getDrawable(R.mipmap.home_character_none));
                    break;
            }
        } else {
            im_mbti_character.setImageDrawable(getDrawable(R.mipmap.home_character_none));
        }
    }
}
