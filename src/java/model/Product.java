/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author memft
 */
public class Product {

    
    
    String itemId;
    String itemName;
    int itemStock;
    float itemPrice;
    String itemImg;
    String itemDes;
    
    public Product() {
    
}
    public Product(String itemId, String itemName, int itemStock, float itemPrice, String itemImg, String itemDes) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemStock = itemStock;
        this.itemPrice = itemPrice;
        this.itemImg = itemImg;
        this.itemDes = itemDes;
    }
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemDes() {
        return itemDes;
    }

    public void setItemDes(String itemDes) {
        this.itemDes = itemDes;
    }
    
}
