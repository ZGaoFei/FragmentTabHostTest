package com.example.zhaogaofei.fragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.zhaogaofei.fragmenttabhost.fragment.TestFragment;

/**
 * 测试Fragment在不保留活动下生命周期的调用
 *
 * 在不保留活动状态下，每当跳转到一个新页面就会将原先的页面给销毁
 * 返回原先的页面时，会重新创建，因此每次生命周期函数都会走一遍
 *
 */
public class TestActivity extends AppCompatActivity {
    private static final String TAG = "TestActivity";

    private FragmentTransaction transaction;
    private TestFragment testFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Log.e(TAG, "==onCreate==");

        initData();
    }

    private void initData() {
        testFragment = new TestFragment();

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_test, testFragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "==onStart==");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "==onStop==");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "==onDestroy==");

        transaction.remove(testFragment);
        testFragment = null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "==onPause==");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "==onResume==");
    }
}
