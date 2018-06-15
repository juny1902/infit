package com.example.ryan.infit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ConceptRoomActivity extends AppCompatActivity {
    TextView tv_style, tv_style_description;
    ImageView img_concept_room;
    Button btn_go_shopping;
    ImageButton btn_back;
    int idx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept_room);

        Intent intent_prev = getIntent();
        MBTI person = (MBTI) intent_prev.getSerializableExtra("person");
        final int style_index = intent_prev.getIntExtra("style_index", 0);
        tv_style = findViewById(R.id.tv_style);
        tv_style_description = findViewById(R.id.tv_style_description);
        img_concept_room = findViewById(R.id.img_concept_room);
        btn_go_shopping = findViewById(R.id.btn_go_shopping);
        btn_back = findViewById(R.id.go_back_from_concept_room);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_go_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RoomSample.class);
                intent.putExtra("style", style_index);
                startActivity(intent);
            }
        });


        tv_style.setText(Style_Info.Styles[style_index] + " 인테리어");

        tv_style_description.setText("  " + Style_Info.Styles_description[style_index]);

        img_concept_room.setImageDrawable(getDrawable(Style_Info.index_to_cloud[style_index]));

    }
}
