package com.example.ryan.infit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TypeActivity extends AppCompatActivity {
    TextView tv_type_title, tv_type_description;
    ImageView im_mbti_character;
    Button btn_goNext;
    MBTI person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        Intent i = getIntent();
        person = (MBTI) i.getSerializableExtra("person");
        tv_type_title = findViewById(R.id.tv_type_title);
        tv_type_description = findViewById(R.id.tv_type_description);
        btn_goNext = findViewById(R.id.btn_go_mbti_detailed);
        im_mbti_character = findViewById(R.id.im_type_character);

        tv_type_title.setText(person.getMBTI_character_text() + "!");
        tv_type_description.setText(person.getMBTI_character_description());

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
                im_mbti_character.setImageDrawable(getDrawable(R.drawable.ic_launcher_background));
                break;
        }

        btn_goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mbti_detailed = new Intent(getApplicationContext(), MBTIResultActivity.class);
                mbti_detailed.putExtra("person", person);
                startActivity(mbti_detailed);
            }
        });
    }
}
