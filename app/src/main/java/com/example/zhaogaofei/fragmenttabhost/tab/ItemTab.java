package com.example.zhaogaofei.fragmenttabhost.tab;


import android.support.v4.app.Fragment;

public class ItemTab {
    private int title;
    private int icon;
    private Fragment fragment;

    public ItemTab(int title, int icon, Fragment fragment) {
        this.title = title;
        this.icon = icon;
        this.fragment = fragment;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
