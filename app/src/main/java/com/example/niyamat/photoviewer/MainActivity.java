package com.example.niyamat.photoviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnMainStaggeredGridLayout;
    private Button mBtnMainGridLayout;
    private Button mBtnMainLinearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getWidgets();
        bindWidgetsWithEvents();


    }

    private void bindWidgetsWithEvents() {
        mBtnMainStaggeredGridLayout.setOnClickListener(this);
        mBtnMainGridLayout.setOnClickListener(this);
        mBtnMainLinearLayout.setOnClickListener(this);
    }

    private void getWidgets() {
        mBtnMainStaggeredGridLayout = (Button) findViewById(R.id.btnMainStaggeredGridLayout);
        mBtnMainGridLayout = (Button) findViewById(R.id.btnMainGridLayout);
        mBtnMainLinearLayout = (Button) findViewById(R.id.btnMainLinearLayout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        if (v.getId() == R.id.btnMainStaggeredGridLayout) {
            intent.putExtra(Constant.LAYOUT_MANAGER, Constant.STAGGERED_LAYOUT_MANAGER);
        } else if (v.getId() == R.id.btnMainGridLayout) {
            intent.putExtra(Constant.LAYOUT_MANAGER, Constant.GRID_LAYOUT_MANAGER);
        } else if (v.getId() == R.id.btnMainLinearLayout) {
            intent.putExtra(Constant.LAYOUT_MANAGER, Constant.LINEAR_LAYOUT_MANAGER);
        }
        startActivity(intent);
    }
}
