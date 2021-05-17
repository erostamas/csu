package com.erostamas.csu;


import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public RelativeLayout rootView;
    public int position;
    private ItemsRecyclerViewAdapter.ItemClickListener _itemClickListener;
    private ItemsRecyclerViewAdapter _adapter;
    private ArrayList<Item> _itemContainer;

    ItemViewHolder(View itemView, ArrayList<Item> itemContainer, ItemsRecyclerViewAdapter.ItemClickListener itemClickListener, ItemsRecyclerViewAdapter adapter) {
        super(itemView);
        _itemContainer = itemContainer;
        _itemClickListener = itemClickListener;
        _adapter = adapter;
        rootView = (RelativeLayout)itemView.findViewById(R.id.item_root_layout);
        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(mOnCreateContextMenuListener);
    }

    @Override
    public void onClick(View view) {
        if (_itemClickListener != null) _itemClickListener.onItemClick(view, getAdapterPosition());
    }

    private final View.OnCreateContextMenuListener mOnCreateContextMenuListener = new View.OnCreateContextMenuListener() {
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            if (_itemContainer!= null) {
                MenuItem myActionItem = menu.add("Delete");
                myActionItem.setOnMenuItemClickListener(mOnMyActionClickListener);
            }
        }
    };

    private final MenuItem.OnMenuItemClickListener mOnMyActionClickListener = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            //FavouritesFragment.favourites.remove(position);
            _adapter.notifyDataSetChanged();
            return true;
        }
    };
}
