package com.example.ryan.infit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.ryan.infit.MBTI_mentions;

public class MBTIResultActivity extends AppCompatActivity {

    int[] int_MBTI_Result;
    TextView tv_MBTI_string;
    TextView tv_MBTI_Result;

    ProgressBar[] prog_array;
    int[] prog_IDs = {R.id.progress_E, R.id.progress_I, R.id.progress_S, R.id.progress_N, R.id.progress_T, R.id.progress_F, R.id.progress_J,R.id.progress_P};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtiresult);
        prog_array = new ProgressBar[8];
        tv_MBTI_string =findViewById(R.id.tv_MBTI_string);
        tv_MBTI_Result = findViewById(R.id.tv_MBTI_result);
        Intent mbti_intent = getIntent();
        String mbti_result_string = mbti_intent.getStringExtra("StringMBTI");
        int_MBTI_Result = mbti_intent.getIntArrayExtra("CountMBTI");

        for(int i=0; i<8; i++) {
            prog_array[i] = findViewById(prog_IDs[i]);
            prog_array[i].setProgress(int_MBTI_Result[i]);
        }
        for(int i=0; i<4; i++){
            switch(mbti_result_string.charAt(i))
            {
                case 'E':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI_mentions.MBTI_Results[0]);
                    break;
                case 'I':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI_mentions.MBTI_Results[1]);
                    break;
                case 'S':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI_mentions.MBTI_Results[2]);
                    break;
                case 'N':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI_mentions.MBTI_Results[3]);
                    break;
                case 'T':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI_mentions.MBTI_Results[4]);
                    break;
                case 'F':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI_mentions.MBTI_Results[5]);
                    break;
                case 'J':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI_mentions.MBTI_Results[6]);
                    break;
                case 'P':
                    tv_MBTI_Result.setText(tv_MBTI_Result.getText() + MBTI_mentions.MBTI_Results[7]);
                    break;
            }
            tv_MBTI_Result.setText(tv_MBTI_Result.getText() + "\n");

        }
        tv_MBTI_string.setText(tv_MBTI_string.getText() + mbti_result_string);
    }
}
