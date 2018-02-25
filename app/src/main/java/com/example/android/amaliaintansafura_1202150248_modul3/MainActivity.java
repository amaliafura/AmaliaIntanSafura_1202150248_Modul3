package com.example.android.amaliaintansafura_1202150248_modul3;

import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Member variables
    private RecyclerView mRecyclerView;
    private ArrayList<Mineral> mMineralData;
    private MineralAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Welcome to SUMMER DRINK", Toast.LENGTH_LONG).show();

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //agar dapat mendukung dalam orientasi lanscape
        int gridColumn = getResources().getInteger(R.integer.gridcolumn_count);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumn));

        //Initialize the ArrayLIst that will contain the data
        mMineralData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new MineralAdapter(this, mMineralData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();
    }

    private void initializeData () {
            //Get the resources from the XML file
            String[] mineralList = getResources().getStringArray(R.array.mineral_titles);
            String[] mineralInfo = getResources().getStringArray(R.array.mineral_info);
            TypedArray mineralImageResources = getResources().obtainTypedArray(R.array.mineral_images);

            //Clear the existing data (to avoid duplication)
            mMineralData.clear();

            for (int i = 0; i < mineralList.length; i++) {
                mMineralData.add(new Mineral(mineralList[i], mineralInfo[i],
                        mineralImageResources.getResourceId(i, 0)));
            }
            //Create the ArrayList of Sports objects with the titles and information about each sport

           mineralImageResources.recycle();

            //Notify the adapter of the change
            mAdapter.notifyDataSetChanged();

        }
    }
