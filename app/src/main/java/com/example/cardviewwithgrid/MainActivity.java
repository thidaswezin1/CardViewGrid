package com.example.cardviewwithgrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    private List<RecyclerViewItem> carItemList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeCarItemList();

        // Create the recyclerview.
        RecyclerView carRecyclerView = (RecyclerView)findViewById(R.id.card_view_recycler_list);
        // Create the grid layout manager with 2 columns.
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        // Set layout manager.
        carRecyclerView.setLayoutManager(gridLayoutManager);

        // Create car recycler view data adapter with car item list.
        RecyclerViewDataAdapter carDataAdapter = new RecyclerViewDataAdapter(carItemList);
        // Set data adapter.
        carRecyclerView.setAdapter(carDataAdapter);

    }

    /* Initialise car items in list. */
    private void initializeCarItemList()
    {
        if(carItemList == null)
        {
            carItemList = new ArrayList<RecyclerViewItem>();
            carItemList.add(new RecyclerViewItem("Audi", R.drawable.cupcake));
            carItemList.add(new RecyclerViewItem("BMW", R.drawable.donut));
            carItemList.add(new RecyclerViewItem("Benz", R.drawable.eclair));
            carItemList.add(new RecyclerViewItem("Jeep", R.drawable.froyo));
            carItemList.add(new RecyclerViewItem("Land Rover", R.drawable.gingerbread));
            carItemList.add(new RecyclerViewItem("Future", R.drawable.honeycomb));
        }
    }
}
