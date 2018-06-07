package com.example.ryan.infit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;

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
        btn_1st = findViewById(R.id.btn_1st);
        btn_2nd = findViewById(R.id.btn_2nd);
        btn_3rd = findViewById(R.id.btn_3rd);
        im_1st = findViewById(R.id.img_1st);
        im_2nd = findViewById(R.id.img_2nd);
        im_3rd = findViewById(R.id.img_3rd);

        SharedPreferences sPrefs = getSharedPreferences("MBTIResult", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sPrefs.getString("MBTIPerson", "");
        int style_1 = sPrefs.getInt("1stStyle", 1);
        int style_2 = sPrefs.getInt("2ndStyle", 2);
        int style_3 = sPrefs.getInt("3rdStyle", 3);
        final int[] places_t = {
                style_1, style_2, style_3
        };
        person = gson.fromJson(json, MBTI.class);


        btn_1st.setText(Style_Info.Styles[places_t[0]]);
        btn_2nd.setText(Style_Info.Styles[places_t[1]]);
        btn_3rd.setText(Style_Info.Styles[places_t[2]]);

        btn_1st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ConceptRoom_intent = new Intent(getApplicationContext(), ConceptRoomActivity.class);
                ConceptRoom_intent.putExtra("style_index", places_t[0]);
                ConceptRoom_intent.putExtra("person", person);
                startActivity(ConceptRoom_intent);
            }
        });
        btn_2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ConceptRoom_intent = new Intent(getApplicationContext(), ConceptRoomActivity.class);
                ConceptRoom_intent.putExtra("style_index", places_t[1]);
                ConceptRoom_intent.putExtra("person", person);
                startActivity(ConceptRoom_intent);
            }
        });
        btn_3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ConceptRoom_intent = new Intent(getApplicationContext(), ConceptRoomActivity.class);
                ConceptRoom_intent.putExtra("style_index", places_t[2]);
                ConceptRoom_intent.putExtra("person", person);
                startActivity(ConceptRoom_intent);
            }
        });
        im_1st.setImageDrawable(getDrawable(Style_Info.index_to_id[places_t[0]]));
        im_2nd.setImageDrawable(getDrawable(Style_Info.index_to_id[places_t[1]]));
        im_3rd.setImageDrawable(getDrawable(Style_Info.index_to_id[places_t[2]]));
    }
}

