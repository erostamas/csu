package com.erostamas.csu;

import android.content.Context;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private ArrayList<Item> _itemContainer;
    private LayoutInflater layoutInflater;
    private CollectItemsActivity _collectItemsActivity;

    // data is passed into the constructor
    public ItemsRecyclerViewAdapter(Context context, ArrayList<Item> itemContainer, CollectItemsActivity collectItemsActivity) {
        this.layoutInflater = LayoutInflater.from(context);
        this._itemContainer = itemContainer;
        this._collectItemsActivity = collectItemsActivity;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view, _itemContainer, _collectItemsActivity, this);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        //holder.rootView.setBackgroundColor(Color.rgb(_favouritesContainer.get(position)._red , _favouritesContainer.get(position)._green,  _favouritesContainer.get(position)._blue));
        holder.position = position;
        TextView name = (TextView) holder.rootView.findViewById(R.id.item_name);
        name.setText(_itemContainer.get(position).getName());
        TextView code = (TextView) holder.rootView.findViewById(R.id.item_code);
        code.setText(_itemContainer.get(position).getCode());
        TextView quantity = (TextView) holder.rootView.findViewById(R.id.item_quantity);
        quantity.setText(_itemContainer.get(position).getQuantity());
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return _itemContainer.size();
    }

    // convenience method for getting data at click position
    public Item getItem(int id) {
        return _itemContainer.get(id);
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
