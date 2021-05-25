package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.screens.adapters.ConnectDiscoonectRecyclerViewAdapter;
import com.example.screens.adapters.MyListAdapter;

public class ConnectDisconnectActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ConnectDiscoonectRecyclerViewAdapter connectDiscoonectRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_disconnect);

        initComponent();
        initListener();
        setAdapter();
    }

    private void initListener() {
    }

    private void initComponent() {
        recyclerView = findViewById(R.id.connect_disconnect_activity_recyclerview);
    }

    private void setAdapter() {
        connectDiscoonectRecyclerViewAdapter = new ConnectDiscoonectRecyclerViewAdapter();
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(connectDiscoonectRecyclerViewAdapter);

//
//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
//        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}