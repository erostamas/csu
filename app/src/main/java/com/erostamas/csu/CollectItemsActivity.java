package com.erostamas.csu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CollectItemsActivity extends AppCompatActivity implements ItemsRecyclerViewAdapter.ItemClickListener, View.OnClickListener{
    public static ArrayList<Item> _items = new ArrayList<>();
    public static ItemsRecyclerViewAdapter _itemsRecyclerViewAdapter;

    public ArrayList<Item> getItems() {
        return _items;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_items);
        findViewById(R.id.add_item).setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.itemlist);

        int numberOfColumns = 1;
        GridLayoutManager layoutManager = new GridLayoutManager(this, numberOfColumns);
        recyclerView.setLayoutManager(layoutManager);
        _itemsRecyclerViewAdapter = new ItemsRecyclerViewAdapter(getApplicationContext(), _items, this);
        recyclerView.setAdapter(_itemsRecyclerViewAdapter);
        registerForContextMenu(recyclerView);

        //_items.add(new Item("x", "y"));
        //_items.add(new Item("y", "z"));
        _itemsRecyclerViewAdapter.notifyDataSetChanged();


        /*
        ImageButton fab = (ImageButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DisplaySegmentsActivity.this, AddSegmentActivity.class);
                intent.putExtra(CURVE_NAME, _curveName);
                startActivity(intent);
            }
        });
         */
    }

    @Override
    public void onItemClick(View view, int position) {
        //Item item = _itemsRecyclerViewAdapter.getItem(position);
        //CommandSender.setColor(getActivity(), item._red, item._green, item._blue);
        //Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_item:
                ScannedBarcodeActivity._detected = false;
                startActivity(new Intent(this, ScannedBarcodeActivity.class));
                break;
        }

    }
}
