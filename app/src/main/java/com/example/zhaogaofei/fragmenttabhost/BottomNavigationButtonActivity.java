package com.example.zhaogaofei.fragmenttabhost;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaogaofei.fragmenttabhost.fragment.OneFragment;
import com.example.zhaogaofei.fragmenttabhost.fragment.ThreeFragment;
import com.example.zhaogaofei.fragmenttabhost.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 超过三个会有动画效果
 * 超过六个会崩溃
 * 通过menu来添加tab有一定的局限性
 *
 */
public class BottomNavigationButtonActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private ViewPager viewPager;

    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_button);

        initView();
        initFragment();
        initData();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.vp_navigation_button);
        navigationView = (BottomNavigationView) findViewById(R.id.bnv_box);
    }

    private void initData() {
        //设置超过三个的动画效果
//        NavigationButtonHelper.disableShiftMode(navigationView);
//        navigationView.setLayoutMode(ViewGroup.LAYOUT_MODE_CLIP_BOUNDS);//LAYOUT_MODE_OPTICAL_BOUNDS
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.getItemId();
                switch (item.getItemId()) {
                    case R.id.action_one:
                        viewPager.setCurrentItem(0, true);
                        break;
                    case R.id.action_two:
                        viewPager.setCurrentItem(1, true);
                        break;
                    case R.id.action_three:
                        viewPager.setCurrentItem(2, true);
                        break;
                    case R.id.action_four:
                        viewPager.setCurrentItem(3, true);
                        break;
                    case R.id.action_five:
                        viewPager.setCurrentItem(4, true);
                        break;
                   /* case R.id.action_six:
                        viewPager.setCurrentItem(5, true);
                        break;*/
                }
                return true;
            }
        });

        viewPager.setAdapter(new StateAdapter(getSupportFragmentManager(), fragmentList));
        viewPager.setOffscreenPageLimit(4);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navigationView.setSelectedItemId(R.id.action_one);
                        break;
                    case 1:
                        navigationView.setSelectedItemId(R.id.action_two);
                        break;
                    case 2:
                        navigationView.setSelectedItemId(R.id.action_three);
                        break;
                    case 3:
                        navigationView.setSelectedItemId(R.id.action_four);
                        break;
                    case 4:
                        navigationView.setSelectedItemId(R.id.action_five);
                        break;
                    /*case 5:
                        navigationView.setSelectedItemId(R.id.action_six);
                        break;*/
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new OneFragment());
        fragmentList.add(new TwoFragment());
        fragmentList.add(new ThreeFragment());
        fragmentList.add(new OneFragment());
        fragmentList.add(new TwoFragment());
//        fragmentList.add(new ThreeFragment());
    }

    private class MyAdapter extends FragmentPagerAdapter {

        private List<Fragment> list;

        public MyAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

    private class StateAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> list;

        public StateAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }
    }
}
