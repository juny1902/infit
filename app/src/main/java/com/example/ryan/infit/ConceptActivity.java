package com.example.ryan.infit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

public class ConceptActivity extends AppCompatActivity {
    Button btn_1st, btn_2nd, btn_3rd;
    ImageView im_1st, im_2nd, im_3rd;
    MBTI person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept);
        Intent prev_intent = getIntent();
        btn_1st = findViewById(R.id.btn_1st);
        btn_2nd = findViewById(R.id.btn_2nd);
        btn_3rd = findViewById(R.id.btn_3rd);
        im_1st = findViewById(R.id.img_1st);
        im_2nd = findViewById(R.id.img_2nd);
        im_3rd = findViewById(R.id.img_3rd);
        person = (MBTI) prev_intent.getSerializableExtra("person");

        switch (person.getMBTI_Result_4words().substring(0, 3)) {
            case "EST":
                btn_1st.setText("1st. 클래식");
                btn_2nd.setText("2nd. 모던");
                btn_3rd.setText("3rd. 앤티크");
                im_1st.setImageDrawable(getDrawable(R.mipmap.trophy_1st));
                im_2nd.setImageDrawable(getDrawable(R.mipmap.trophy_2nd));
                im_3rd.setImageDrawable(getDrawable(R.mipmap.trophy_3rd));
                break;
            case "ESF":
                btn_1st.setText("1st. 클래식");
                btn_2nd.setText("2nd. 모던");
                btn_3rd.setText("3rd. 앤티크");
                im_1st.setImageDrawable(getDrawable(R.mipmap.trophy_1st));
                im_2nd.setImageDrawable(getDrawable(R.mipmap.trophy_2nd));
                im_3rd.setImageDrawable(getDrawable(R.mipmap.trophy_3rd));
                break;
            case "ENT":
                break;
            case "ENF":
                break;
            case "IST":
                break;
            case "ISF":
                break;
            case "INT":
                break;
            case "INF":
                break;
            default:

        }
    }
}
}
