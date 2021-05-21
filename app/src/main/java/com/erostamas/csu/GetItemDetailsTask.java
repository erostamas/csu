package com.erostamas.csu;

import android.os.AsyncTask;
import android.widget.Button;

public class GetItemDetailsTask extends AsyncTask<String,String,String> {
    private String _code;
    private Button _button;

    GetItemDetailsTask(String code) {
        this._code = code;
    }
    @Override
    protected String doInBackground(String... params) {
        return Requests.getRequest("http://192.168.1.148:5000/codes/" + this._code);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        CollectItemsActivity._items.add(new Item(s, _code,"1"));
        CollectItemsActivity._itemsRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
