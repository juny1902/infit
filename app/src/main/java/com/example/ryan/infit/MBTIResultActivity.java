package com.example.ryan.infit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

public class MBTIResultActivity extends AppCompatActivity {

    int[] int_MBTI_Result;
    TextView tv_title_result;
    TextView tv_MBTI_string;
    TextView tv_MBTI_Result;
    Button btn_go_concept;
    ProgressBar[] prog_array;
    int[] prog_IDs = {R.id.progress_E, R.id.progress_I, R.id.progress_S, R.id.progress_N, R.id.progress_T, R.id.progress_F, R.id.progress_J, R.id.progress_P};

    MBTI person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtiresult);
        prog_array = new ProgressBar[8];
        tv_MBTI_string = findViewById(R.id.tv_type_result);
        tv_MBTI_Result = findViewById(R.id.tv_MBTI_result);
        tv_title_result = findViewById(R.id.tv_title_result);
        btn_go_concept = findViewById(R.id.btn_go_concept);


        SharedPreferences sPrefs = getSharedPreferences("MBTIResult",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sPrefs.getString("MBTIPerson","");
        person = gson.fromJson(json,MBTI.class);

        String mbti_result_string = person.getMBTI_Result_4words();
        int_MBTI_Result = person.getMBTI_Counts();

        for (int i = 0; i < 8; i++) {
            prog_array[i] = findViewById(prog_IDs[i]);
            prog_array[i].setProgress(int_MBTI_Result[i]);
        }
        for (int i = 0; i < 4; i++) {
            switch (mbti_result_string.charAt(i)) {
                case 'E':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI.MBTI_Results[0]);
                    break;
                case 'I':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI.MBTI_Results[1]);
                    break;
                case 'S':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI.MBTI_Results[2]);
                    break;
                case 'N':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI.MBTI_Results[3]);
                    break;
                case 'T':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI.MBTI_Results[4]);
                    break;
                case 'F':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI.MBTI_Results[5]);
                    break;
                case 'J':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI.MBTI_Results[6]);
                    break;
                case 'P':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI.MBTI_Results[7]);
                    break;
            }
            tv_MBTI_Result.setText(tv_MBTI_Result.getText() + "\n");

        }
        tv_MBTI_string.setText(tv_MBTI_string.getText() + mbti_result_string);
        tv_title_result.setText(person.getMBTI_character_text());

        btn_go_concept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent concept_intent = new Intent(getApplicationContext(),ConceptActivity.class);
                concept_intent.putExtra("person",person);
                startActivity(concept_intent);
            }
        });
    }
}
