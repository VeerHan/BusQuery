package com.john.busquery.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.john.busquery.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.viewPager)
    ViewPager viewPager;
    @InjectView(R.id.tabLayout)
    TabLayout tabLayout;

    //页卡视图
    private View view1, view2, view3;
    //页卡视图标题
    private String[] titles = {"a", "b", "c"};
    //页卡视图集合
    private List<View> viewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }
}
