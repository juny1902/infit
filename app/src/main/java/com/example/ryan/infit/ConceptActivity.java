package com.example.ryan.infit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ConceptActivity extends AppCompatActivity {
    Button btn_1st, btn_2nd, btn_3rd;
    ImageView im_1st, im_2nd, im_3rd;
    MBTI person;
    int[] img_interior_styles = {
            R.mipmap.elegance_sized_600,
            R.mipmap.minimal_sized_600,
            R.mipmap.romantic_sized_600,
            R.mipmap.hightech_sized_600,
            R.mipmap.romantic_sized_600,
            R.mipmap.classic_sized_600,
            R.mipmap.classic_sized_600,
            R.mipmap.modern_sized_600
    };

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
        int[] places;
        switch (person.getMBTI_Result_4words()) {
            case "ESTJ":
                places = Style_Info.Style_Places[0];
                break;
            case "ESTP":
                places = Style_Info.Style_Places[1];
                break;
            case "ESFP":
                places = Style_Info.Style_Places[2];
                break;
            case "ESFJ":
                places = Style_Info.Style_Places[3];
                break;
            case "ENTJ":
                places = Style_Info.Style_Places[4];
                break;
            case "ENTP":
                places = Style_Info.Style_Places[5];
                break;
            case "ENFJ":
                places = Style_Info.Style_Places[6];
                break;
            case "ENFP":
                places = Style_Info.Style_Places[7];
                break;
            case "ISTJ":
                places = Style_Info.Style_Places[8];
                break;
            case "ISTP":
                places = Style_Info.Style_Places[9];
                break;
            case "ISFJ":
                places = Style_Info.Style_Places[10];
                break;
            case "ISFP":
                places = Style_Info.Style_Places[11];
                break;
            case "INTJ":
                places = Style_Info.Style_Places[12];
                break;
            case "INTP":
                places = Style_Info.Style_Places[13];
                break;
            case "INFJ":
                places = Style_Info.Style_Places[14];
                break;
            case "INFP":
                places = Style_Info.Style_Places[15];
                break;
            default:
                places = Style_Info.Style_Places[0];
        }

        final int[] places_t = places;

        btn_1st.setText(Style_Info.Styles[places_t[0]]);
        btn_2nd.setText(Style_Info.Styles[places_t[1]]);
        btn_3rd.setText(Style_Info.Styles[places_t[2]]);

        btn_1st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ConceptRoom_intent = new Intent(getApplicationContext(),ConceptRoomActivity.class);
                ConceptRoom_intent.putExtra("style_index",places_t[0]);
                ConceptRoom_intent.putExtra("person",person);
                startActivity(ConceptRoom_intent);
            }
        });
        btn_2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ConceptRoom_intent = new Intent(getApplicationContext(),ConceptRoomActivity.class);
                ConceptRoom_intent.putExtra("style_index",places_t[1]);
                ConceptRoom_intent.putExtra("person",person);
                startActivity(ConceptRoom_intent);
            }
        });
        btn_3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ConceptRoom_intent = new Intent(getApplicationContext(),ConceptRoomActivity.class);
                ConceptRoom_intent.putExtra("style_index",places_t[2]);
                ConceptRoom_intent.putExtra("person",person);
                startActivity(ConceptRoom_intent);
            }
        });
        im_1st.setImageDrawable(getDrawable(Style_Info.index_to_id[places[0]]));
        im_2nd.setImageDrawable(getDrawable(Style_Info.index_to_id[places[1]]));
        im_3rd.setImageDrawable(getDrawable(Style_Info.index_to_id[places[2]]));
    }
}

