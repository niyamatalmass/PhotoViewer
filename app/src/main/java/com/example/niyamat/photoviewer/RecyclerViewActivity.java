package com.example.niyamat.photoviewer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<String> images = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    CustomRecyclerViewAdapter mCustomRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Photo");
        getWidgets();
        initializeImages();
        getLayoutManagerRequest();

    }

    private void getLayoutManagerRequest() {
        if (getIntent().getStringExtra(Constant.LAYOUT_MANAGER).equals(Constant.STAGGERED_LAYOUT_MANAGER)) {
            setStaggeredGridLayoutManager();
            setAdapter();
        } else if (getIntent().getStringExtra(Constant.LAYOUT_MANAGER).equals(Constant.GRID_LAYOUT_MANAGER)) {
            setGridLayoutManager();
            setAdapter();
        } else if (getIntent().getStringExtra(Constant.LAYOUT_MANAGER).equals(Constant.LINEAR_LAYOUT_MANAGER)) {
            setLinearLayoutManager();
            setAdapter();
        }
        
    }

    private void setStaggeredGridLayoutManager() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mCustomRecyclerViewAdapter = new StaggeredGridLayoutAdapter(this, images);
    }
    private void setGridLayoutManager() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mCustomRecyclerViewAdapter = new GridLayoutAdapter(this, images);
    }
    private void setLinearLayoutManager() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mCustomRecyclerViewAdapter = new LinearLayoutAdapter(this, images);
    }
    private void setAdapter() {
        mRecyclerView.setAdapter(mCustomRecyclerViewAdapter);
    }



    private void initializeImages() {
        images = new ArrayList<>();
        for (int i = 0; i < Constant.IMAGES.length; i++) {
            images.add(Constant.IMAGES[i]);
        }
    }

    private void getWidgets() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

}
