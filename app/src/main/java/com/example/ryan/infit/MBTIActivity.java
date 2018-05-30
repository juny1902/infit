package com.example.ryan.infit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.Toast;

public class MBTIActivity extends AppCompatActivity {
    TabHost MBTI_Tab;
    Button finish_test;
    int[] MBTI_Counts;
    RadioButton[] radio_E, radio_I, radio_S, radio_N, radio_T, radio_F, radio_J, radio_P;
    int[] radio_E_id = {R.id.radio_1_A, R.id.radio_2_A, R.id.radio_3_A, R.id.radio_4_A, R.id.radio_5_A, R.id.radio_6_A, R.id.radio_7_A, R.id.radio_8_A, R.id.radio_9_A};
    int[] radio_I_id = {R.id.radio_1_B, R.id.radio_2_B, R.id.radio_3_B, R.id.radio_4_B, R.id.radio_5_B, R.id.radio_6_B, R.id.radio_7_B, R.id.radio_8_B, R.id.radio_9_B};
    int[] radio_S_id = {R.id.radio_10_A, R.id.radio_11_A, R.id.radio_12_A, R.id.radio_13_A, R.id.radio_14_A, R.id.radio_15_A, R.id.radio_16_A, R.id.radio_17_A, R.id.radio_18_A};
    int[] radio_N_id = {R.id.radio_10_B, R.id.radio_11_B, R.id.radio_12_B, R.id.radio_13_B, R.id.radio_14_B, R.id.radio_15_B, R.id.radio_16_B, R.id.radio_17_B, R.id.radio_18_B};
    int[] radio_T_id = {R.id.radio_19_A, R.id.radio_20_A, R.id.radio_21_A, R.id.radio_22_A, R.id.radio_23_A, R.id.radio_24_A, R.id.radio_25_A, R.id.radio_26_A, R.id.radio_27_A};
    int[] radio_F_id = {R.id.radio_19_B, R.id.radio_20_B, R.id.radio_21_B, R.id.radio_22_B, R.id.radio_23_B, R.id.radio_24_B, R.id.radio_25_B, R.id.radio_26_B, R.id.radio_27_B};
    int[] radio_J_id = {R.id.radio_28_A, R.id.radio_29_A, R.id.radio_30_A, R.id.radio_31_A, R.id.radio_32_A, R.id.radio_33_A, R.id.radio_34_A, R.id.radio_35_A, R.id.radio_36_A};
    int[] radio_P_id = {R.id.radio_28_B, R.id.radio_29_B, R.id.radio_30_B, R.id.radio_31_B, R.id.radio_32_B, R.id.radio_33_B, R.id.radio_34_B, R.id.radio_35_B, R.id.radio_36_B};

    int countRadio(RadioButton[] r) {
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            if (r[i].isChecked()) cnt++;
        }
        return cnt;
    }

    int[] getMBTIResult() {
        int cnt_E, cnt_I, cnt_S, cnt_N, cnt_T, cnt_F, cnt_J, cnt_P;
        cnt_E = countRadio(radio_E);
        cnt_I = countRadio(radio_I);
        cnt_S = countRadio(radio_S);
        cnt_N = countRadio(radio_N);
        cnt_T = countRadio(radio_T);
        cnt_F = countRadio(radio_F);
        cnt_J = countRadio(radio_J);
        cnt_P = countRadio(radio_P);
        int ret[] = {cnt_E, cnt_I, cnt_S, cnt_N, cnt_T, cnt_F, cnt_J, cnt_P};
        return ret;
    }

    String getMBTItext(){
        String ret="";
        if(MBTI_Counts[0] > MBTI_Counts[1]){
            ret = ret + "E";
        }else{
            ret = ret + "I";
        }
        if(MBTI_Counts[2] > MBTI_Counts[3]){
            ret = ret + "S";
        }else{
            ret = ret + "N";
        }
        if(MBTI_Counts[4] > MBTI_Counts[5]){
            ret = ret + "T";
        }else{
            ret = ret + "F";
        }
        if(MBTI_Counts[6] > MBTI_Counts[7]){
            ret = ret + "J";
        }else{
            ret = ret + "P";
        }
        return ret;
    }

    boolean isAllChecked() {
        int sum = 0;
        int[] ret = getMBTIResult();
        MBTI_Counts = ret;
        for (int i = 0; i < 8; i++) {
            sum += ret[i];
        }
        if (sum == 36) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbti);
        radio_E = new RadioButton[9];
        radio_I = new RadioButton[9];
        radio_S = new RadioButton[9];
        radio_N = new RadioButton[9];
        radio_T = new RadioButton[9];
        radio_F = new RadioButton[9];
        radio_J = new RadioButton[9];
        radio_P = new RadioButton[9];

        for (int i = 0; i < 9; i++) {
            radio_E[i] = findViewById(radio_E_id[i]);
            radio_I[i] = findViewById(radio_I_id[i]);
            radio_S[i] = findViewById(radio_S_id[i]);
            radio_N[i] = findViewById(radio_N_id[i]);
            radio_T[i] = findViewById(radio_T_id[i]);
            radio_F[i] = findViewById(radio_F_id[i]);
            radio_J[i] = findViewById(radio_J_id[i]);
            radio_P[i] = findViewById(radio_P_id[i]);
        }

        MBTI_Tab = findViewById(R.id.MBTI_TAB);
        MBTI_Tab.setup();

        finish_test = findViewById(R.id.btn_finish);


        TabHost.TabSpec tab1 = MBTI_Tab.newTabSpec("1").setContent(R.id.tab1).setIndicator("1");
        TabHost.TabSpec tab2 = MBTI_Tab.newTabSpec("2").setContent(R.id.tab2).setIndicator("2");
        TabHost.TabSpec tab3 = MBTI_Tab.newTabSpec("3").setContent(R.id.tab3).setIndicator("3");
        TabHost.TabSpec tab4 = MBTI_Tab.newTabSpec("4").setContent(R.id.tab4).setIndicator("4");
        MBTI_Tab.addTab(tab1);
        MBTI_Tab.addTab(tab2);
        MBTI_Tab.addTab(tab3);
        MBTI_Tab.addTab(tab4);
        finish_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAllChecked()) {
                    Toast.makeText(getApplicationContext(), String.format("당신은 %s 입니다 !",getMBTItext()), Toast.LENGTH_SHORT).show();
                    Intent result_intent = new Intent(getApplicationContext(), MBTIResultActivity.class);
                    result_intent.putExtra("CountMBTI",getMBTIResult());
                    result_intent.putExtra("StringMBTI",getMBTItext());
                    startActivity(result_intent);
                } else {
                    Toast.makeText(getApplicationContext(), "모든 문항에 응답해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
