package com.example.ryan.infit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

public class ConceptActivity extends AppCompatActivity {
    MBTI person;
    TextView tv_1st, tv_2nd, tv_3rd;
    int[] places_t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept);
        tv_1st = findViewById(R.id.tv_place_1st);
        tv_2nd = findViewById(R.id.tv_place_2nd);
        tv_3rd = findViewById(R.id.tv_place_3rd);

        SharedPreferences sPrefs = getSharedPreferences("MBTIResult", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sPrefs.getString("MBTIPerson", "");

        int style_1 = sPrefs.getInt("1stStyle", 1);
        int style_2 = sPrefs.getInt("2ndStyle", 2);
        int style_3 = sPrefs.getInt("3rdStyle", 3);

        places_t = new int[]{
                style_1, style_2, style_3
        };

        person = gson.fromJson(json, MBTI.class);


        tv_1st.setText(Style_Info.Styles[places_t[0]] + " 인테리어");
        tv_2nd.setText(Style_Info.Styles[places_t[1]] + " 인테리어");
        tv_3rd.setText(Style_Info.Styles[places_t[2]] + " 인테리어");

    }
    public void onClickLayout(View v) {
        switch (v.getId()) {
            case R.id.layout_1st:
                Intent ConceptRoom_intent1 = new Intent(getApplicationContext(), ConceptRoomActivity.class);
                ConceptRoom_intent1.putExtra("style_index", places_t[0]);
                ConceptRoom_intent1.putExtra("person", person);
                startActivity(ConceptRoom_intent1);
                break;
            case R.id.layout_2nd:
                Intent ConceptRoom_intent2 = new Intent(getApplicationContext(), ConceptRoomActivity.class);
                ConceptRoom_intent2.putExtra("style_index", places_t[1]);
                ConceptRoom_intent2.putExtra("person", person);
                startActivity(ConceptRoom_intent2);
                break;
            case R.id.layout_3rd:
                Intent ConceptRoom_intent3 = new Intent(getApplicationContext(), ConceptRoomActivity.class);
                ConceptRoom_intent3.putExtra("style_index", places_t[2]);
                ConceptRoom_intent3.putExtra("person", person);
                startActivity(ConceptRoom_intent3);
                break;
        }

    }
}

