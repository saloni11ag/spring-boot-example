package com.example.demo;


public class ItemDocument {


    private int itemId;

    private String itemName;

    private String itemDescription;

    private double itemPrice;

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
