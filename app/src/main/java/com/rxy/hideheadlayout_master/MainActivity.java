package com.rxy.hideheadlayout_master;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageButton;

import com.rxy.hideheadlayout_master.adapter.RecyclerViewAdapter;
import com.rxy.hideheadlayout_master.base.ControlScrollListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Toolbar _toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycleView();
        initToolBar();
    }

    private void initToolBar() {
        _toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(_toolbar);
        _toolbar.setTitle(getString(R.string.app_name));
        _toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }

    private void initRecycleView() {
        RecyclerView _recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter _adapter = new RecyclerViewAdapter(getItemList());
        _recyclerView.setAdapter(_adapter);
        _recyclerView.setOnScrollListener(new ControlScrollListener() {
            @Override
            public void onHide() {
                hideViews();
            }

            @Override
            public void onShow() {
                showViews();
            }

            private void hideViews() {
                _toolbar.animate().translationY(-_toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
            }

            private void showViews() {
                _toolbar.animate().translationY(0).setInterpolator(new AccelerateInterpolator(2));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public List<String> getItemList() {
        List<String> mItemList = new ArrayList<>();
        String item = "child_item";
        for (int i = 0; i < 15; i++) {
            mItemList.add(item + i);
        }
        return mItemList;
    }
}
