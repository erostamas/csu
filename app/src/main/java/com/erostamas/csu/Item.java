package com.erostamas.csu;

public class Item {
    Item(String name, String code, String quantity){
        this._name = name;
        this._quantity = quantity;
        this._code = code;
    }

    public String getName() {
        return _name;
    }

    public String getCode() {
        return _code;
    }

    public String getQuantity() {
        return _quantity;
    }

    public void setQuantity(String quantity) {
        _quantity = quantity;
    }
    private String _name;
    private String _code;
    private String _quantity;
}
