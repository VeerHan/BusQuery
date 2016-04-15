package com.john.busquery.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.john.busquery.R;
import com.john.busquery.adapter.MyFragmentPagerAdapter;
import com.john.busquery.fragment.LineFragment;
import com.john.busquery.fragment.StationFragment;
import com.john.busquery.fragment.SwitchFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.viewPager)
    ViewPager viewPager;
    @InjectView(R.id.tabLayout)
    TabLayout tabLayout;

    private String[] titles = {"线路", "换乘", "站点"};
    private List<Fragment> fragmentList = new ArrayList<>();
    private MyFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        fragmentList.add(new LineFragment());
        fragmentList.add(new SwitchFragment());
        fragmentList.add(new StationFragment());
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), titles, fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
