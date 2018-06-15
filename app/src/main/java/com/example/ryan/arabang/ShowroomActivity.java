package com.example.ryan.arabang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ShowroomActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    SharedPreferences sPrefs;
    ImageView im_mbti_character;
    TextView tv_drawer_mbti, tv_drawer_type;
    String[] links;
    MBTI person;
    Gson gson;
    String json;
    int curStyle;
    ArrayList[] selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showroom);
        setTitle("인테리어 구경하기");
        curStyle = 1;
        selection = Furnitures.BED_MIPMAPS;
        links = Furnitures.BED_LINKS;
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);
        GridLayoutManager gManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        ArrayList curStyleImages = selection[curStyle - 1];
        CustomAdapter customAdapter = new CustomAdapter(ShowroomActivity.this, Furnitures.names, curStyleImages,links[curStyle-1]);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.showroom, menu);

        sPrefs = getSharedPreferences("MBTIResult", MODE_PRIVATE);
        gson = new Gson();
        json = sPrefs.getString("MBTIPerson", "");

        tv_drawer_mbti = findViewById(R.id.drawer_mbti);
        tv_drawer_type = findViewById(R.id.drawer_type);
        im_mbti_character = findViewById(R.id.drawer_image);

        if (json != "") {
            person = gson.fromJson(json, MBTI.class);

            tv_drawer_mbti.setText(person.getMBTI_Result_4words());
            tv_drawer_type.setText(person.getMBTI_character_text());

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
            im_mbti_character.setImageDrawable(getDrawable(R.mipmap.home_character_none));
            tv_drawer_mbti.setText("검사 결과가 없습니다");
            tv_drawer_type.setText("홈으로 돌아가 검사를 시작해주세요");
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.btn_draw_1) {
            curStyle = 1;
        } else if (id == R.id.btn_draw_2) {
            curStyle = 2;
        } else if (id == R.id.btn_draw_3) {
            curStyle = 3;
        } else if (id == R.id.btn_draw_4) {
            curStyle = 4;
        } else if (id == R.id.btn_draw_5) {
            curStyle = 5;
        } else if (id == R.id.btn_draw_6) {
            curStyle = 6;
        } else if (id == R.id.btn_draw_my_info) {
            Intent my_info = new Intent(getApplicationContext(), MyInfoActivity.class);
            startActivity(my_info);
        } else if (id == R.id.btn_go_room_sample) {
            Intent room_sample = new Intent(getApplicationContext(), RoomSample.class);
            room_sample.putExtra("VISIBILITY_SHOWROOM", false);
            startActivity(room_sample);
        } else if (id == R.id.btn_go_concept_description) {
            Intent concept = new Intent(getApplicationContext(), StyleInfoActivity.class);
            startActivity(concept);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        onResume();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.im_btn_tab_1:
                selection = Furnitures.BED_MIPMAPS; // 전체 (ROOM)
                links = Furnitures.BED_LINKS;
                break;
            case R.id.im_btn_tab_2:
                selection = Furnitures.ROOM_MIPMAPS; //
                links = Furnitures.ROOM_LINKS;
                break;
            case R.id.im_btn_tab_3:
                selection = Furnitures.KITCHEN_MIPMAPS;
                links = Furnitures.KITCHEN_LINKS;
                break;
            case R.id.im_btn_tab_4:
                selection = Furnitures.BATH_MIPMAPS;
                links = Furnitures.BATH_LINKS;
                break;
            case R.id.im_btn_tab_5:
                links = Furnitures.OFFICE_LINKS;
                selection = Furnitures.OFFICE_MIPMAPS;
                break;
            default:
                links = Furnitures.BED_LINKS;
                selection = Furnitures.BED_MIPMAPS;
        }
        onResume();
    }
}
