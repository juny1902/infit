package com.example.ryan.infit;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyInfoActivity extends AppCompatActivity {
    int[] int_MBTI_Result;
    ImageButton btn_back;
    File imagePath;
    ImageView im_mbti_character;
    TextView my_room_type, style_1st, style_2nd, style_3rd;
    Button btn_reset, btn_myinfo;
    MBTI person;
    ProgressBar[] prog_array;
    int[] prog_IDs = {R.id.aprogress_E, R.id.aprogress_I, R.id.aprogress_S, R.id.aprogress_N, R.id.aprogress_T, R.id.aprogress_F, R.id.aprogress_J, R.id.aprogress_P};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        btn_reset = findViewById(R.id.btn_reset);
        btn_back = findViewById(R.id.btn_back_from_myinfo);
        btn_myinfo = findViewById(R.id.btn_share_my_info);
        im_mbti_character = findViewById(R.id.im_myroom_chara);
        my_room_type = findViewById(R.id.tv_myroom_type);

        style_1st = findViewById(R.id.tv_myroom_1st);
        style_2nd = findViewById(R.id.tv_myroom_2nd);
        style_3rd = findViewById(R.id.tv_myroom_3rd);

        prog_array = new ProgressBar[8];

        SharedPreferences sPrefs = getSharedPreferences("MBTIResult", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sPrefs.getString("MBTIPerson", null);

        int style_1 = sPrefs.getInt("1stStyle", -999); // -999 When null.
        int style_2 = sPrefs.getInt("2ndStyle", -999);
        int style_3 = sPrefs.getInt("3rdStyle", -999);

        if (json != null) {
            if (style_1 != -999 && style_2 != -999 && style_3 != -999) {
                style_1st.setText(Style_Info.Styles[style_1]);
                style_2nd.setText(Style_Info.Styles[style_2]);
                style_3rd.setText(Style_Info.Styles[style_3]);
            } else {
                style_1st.setText("-");
                style_2nd.setText("-");
                style_3rd.setText("-");
            }
            person = gson.fromJson(json, MBTI.class);
            int_MBTI_Result = person.getMBTI_Counts();
            for (int i = 0; i < 8; i++) {
                prog_array[i] = findViewById(prog_IDs[i]);
                prog_array[i].setProgress(int_MBTI_Result[i]);
            }
            my_room_type.setText("당신은 " + person.getMBTI_Result_4words() + "\n" + person.getMBTI_character_text() + "!");
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
            Toast.makeText(getApplicationContext(), "비어있습니다.", Toast.LENGTH_SHORT);
            im_mbti_character.setImageDrawable(getDrawable(R.mipmap.home_character_none));
            for (int i = 0; i < 8; i++) {
                prog_array[i] = findViewById(prog_IDs[i]);
                prog_array[i].setProgress(0);
            }
            person = null;
        }


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSharedPreferences("MBTIResult", MODE_PRIVATE).edit().clear().apply();
                finish();
            }
        });

        btn_myinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestAppPermissions();
                Bitmap bitmap = takeScreenshot();
                saveBitmap(bitmap);
                shareIt();
            }
        });

    }

    public Bitmap takeScreenshot() {
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();
    }

    public void saveBitmap(Bitmap bitmap) {
        imagePath = new File(Environment.getExternalStorageDirectory() + "/screenshot.png");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }

    private void shareIt() {
        Uri uri = FileProvider.getUriForFile(getApplicationContext(), "com.bignerdranch.android.test.fileprovider", imagePath);
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("image/*");
        String shareBody = "나의 성향에 딱 알맞은 인테리어.";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "알아방");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);

        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
    int REQUEST_WRITE_STORAGE_REQUEST_CODE = 1;
    private void requestAppPermissions() {
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        if (hasReadPermissions() && hasWritePermissions()) {
            return;
        }

        ActivityCompat.requestPermissions(this,
                new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, REQUEST_WRITE_STORAGE_REQUEST_CODE); // your request code
    }
    private boolean hasReadPermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    private boolean hasWritePermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

}
