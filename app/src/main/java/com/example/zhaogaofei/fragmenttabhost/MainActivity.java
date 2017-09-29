package com.example.zhaogaofei.fragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.zhaogaofei.fragmenttabhost.fragment.OneFragment;
import com.example.zhaogaofei.fragmenttabhost.fragment.ThreeFragment;
import com.example.zhaogaofei.fragmenttabhost.fragment.TwoFragment;
import com.example.zhaogaofei.fragmenttabhost.tab.ItemTab;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {
    private FragmentTabHost fragmentTabHost;

    private ItemTab[] tabs;
    private Fragment[] fragments = new Fragment[]{new OneFragment(), new TwoFragment(), new ThreeFragment()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initTabs();
        initData();
    }

    private void initView() {
        fragmentTabHost = (FragmentTabHost) findViewById(R.id.th_main);
    }

    private void initData() {
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.fl_main);
        for (int i = 0; i < tabs.length; i++) {
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(getString(tabs[i].getTitle()));
            tabSpec.setIndicator(setIndicator(tabs[i]));//可以自定义View来设计tab的效果
            fragmentTabHost.addTab(tabSpec, fragments[i].getClass(), null);
            fragmentTabHost.getTabWidget().getChildTabViewAt(i).setBackgroundResource(R.drawable.tab_selector);
        }
//        fragmentTabHost.setBackgroundColor(Color.WHITE);
        fragmentTabHost.setCurrentTab(0);
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
//        fragmentTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
    }

    private void initTabs() {
        ItemTab tab1 = new ItemTab(R.string.tab_one, R.mipmap.ic_launcher, fragments[0]);
        ItemTab tab2 = new ItemTab(R.string.tab_two, R.mipmap.ic_launcher, fragments[1]);
        ItemTab tab3 = new ItemTab(R.string.tab_three, R.mipmap.ic_launcher, fragments[2]);

        tabs = new ItemTab[]{tab1, tab2, tab3};
    }

    private View setIndicator(ItemTab itemTab) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_tab_content, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_tab_content);
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_content);
        imageView.setImageResource(itemTab.getIcon());
        textView.setText(itemTab.getTitle());

        return view;
    }

    @Override
    public void onTabChanged(String tabId) {
        Log.e("====", "====" + tabId);

    }
}
