package com.erostamas.csu;

public class Item {
    Item(String name, String quantity){
        this._name = name;
        this._quantity = quantity;
    }

    public String getName() {
        return _name;
    }

    public String getQuantity() {
        return _quantity;
    }

    public void setQuantity(String quantity) {
        _quantity = quantity;
    }
    private String _name;
    private String _quantity;
}
