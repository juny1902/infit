package com.example.ryan.arabang;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class RoomSample extends AppCompatActivity {
    int curStyle;
    private TabLayout tabLayout;
    ImageButton btn_go_back_from_room, btn_go_shop_from_room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_sample);

        tabLayout = findViewById(R.id.tab_layout);
        btn_go_back_from_room = findViewById(R.id.go_back_from_room);
        btn_go_shop_from_room = findViewById(R.id.go_shop_from_room);
        Intent intent2 = getIntent();
        boolean v_showroom = intent2.getBooleanExtra("VISIBILITY_SHOWROOM",true);
        if(v_showroom){
            btn_go_shop_from_room.setVisibility(ImageButton.VISIBLE);
        }else{
            btn_go_shop_from_room.setVisibility(ImageButton.INVISIBLE);
        }
        btn_go_shop_from_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShowroomActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_SINGLE_TOP
                        | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                startActivity(intent);
                finish();
            }
        });
        btn_go_back_from_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent(); // Intent from previous intent.
        int idx = intent.getIntExtra("style", 2);
        switch (idx) {
            case 2:
                curStyle = 1;
                break;
            case 1:
                curStyle = 2;
                break;
            case 6:
                curStyle = 3;
                break;
            case 7:
                curStyle = 4;
                break;
            case 3:
                curStyle = 5;
                break;
            case 0:
                curStyle = 6;
                break;
            default:
                curStyle = 1;
        }

        tabLayout.addTab(tabLayout.newTab().setText("미니멀"));
        tabLayout.addTab(tabLayout.newTab().setText("클래식"));
        tabLayout.addTab(tabLayout.newTab().setText("엘레강스"));
        tabLayout.addTab(tabLayout.newTab().setText("모던"));
        tabLayout.addTab(tabLayout.newTab().setText("하이테크"));
        tabLayout.addTab(tabLayout.newTab().setText("로맨틱"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        View root = tabLayout.getChildAt(0);
        if (root instanceof LinearLayout) {
            ((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(getResources().getColor(R.color.colorBgDark, getTheme()));
            drawable.setSize(2, 1);
            ((LinearLayout) root).setDividerPadding(20);
            ((LinearLayout) root).setDividerDrawable(drawable);
        }
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent, getTheme()));
        tabLayout.getTabAt(curStyle - 1).select();
        onResume();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        curStyle = 1;
                        break;
                    case 1:
                        curStyle = 2;
                        break;
                    case 2:
                        curStyle = 3;
                        break;
                    case 3:
                        curStyle = 4;
                        break;
                    case 4:
                        curStyle = 5;
                        break;
                    case 5:
                        curStyle = 6;
                        break;
                    default:
                        curStyle = 1;

                }
                onResume();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        // get the reference of RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        // set a StaggeredGridLayoutManager with 3 number of columns and vertical orientation
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        ArrayList curStyleImages;
        switch (curStyle) {
            case 1:
                curStyleImages = Style_Info.minimal_rooms;
                break;
            case 2:
                curStyleImages = Style_Info.classic_rooms;
                break;
            case 3:
                curStyleImages = Style_Info.elegance_rooms;
                break;
            case 4:
                curStyleImages = Style_Info.modern_rooms;
                break;
            case 5:
                curStyleImages = Style_Info.hightech_rooms;
                break;
            case 6:
                curStyleImages = Style_Info.romantic_rooms;
                break;
            default:
                curStyleImages = Style_Info.classic_rooms;

        }
        VariableAdapter customAdapter = new VariableAdapter(RoomSample.this, Style_Info.roomNames, curStyleImages);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }
}
