package com.brainyoung.ryan.arabang;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class StyleInfoActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TextView tv_style;
    TextView tv_style_description;
    ImageView img_concept_room;
    ImageButton go_back;
    ScrollView scrollView;
    int style_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_info);
        style_index=7;
        scrollView = findViewById(R.id.scroll_style_info);
        tv_style = findViewById(R.id.tv_style_info);
        tv_style_description = findViewById(R.id.tv_style_description_info);
        img_concept_room = findViewById(R.id.img_style_info);
        go_back = findViewById(R.id.go_back_from_style_info);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabLayout = findViewById(R.id.style_info_tab);
        tabLayout.addTab(tabLayout.newTab().setText("미니멀"));
        tabLayout.addTab(tabLayout.newTab().setText("클래식"));
        tabLayout.addTab(tabLayout.newTab().setText("엘레강스"));
        tabLayout.addTab(tabLayout.newTab().setText("모던"));
        tabLayout.addTab(tabLayout.newTab().setText("하이테크"));
        tabLayout.addTab(tabLayout.newTab().setText("로맨틱"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary, getTheme()));
        tabLayout.getTabAt(0).select();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        style_index = 7;
                        break;
                    case 1:
                        style_index = 2;
                        break;
                    case 2:
                        style_index = 4;
                        break;
                    case 3:
                        style_index = 6;
                        break;
                    case 4:
                        style_index = 3;
                        break;
                    case 5:
                        style_index = 0;
                        break;
                    default:
                        style_index = 1;

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
        tv_style.setText(Style_Info.Styles[style_index] + " 인테리어");

        tv_style_description.setText("  " + Style_Info.Styles_description[style_index]);

        img_concept_room.setImageDrawable(getDrawable(Style_Info.index_to_cloud[style_index]));

        scrollView.scrollTo(0,0);
    }
}
