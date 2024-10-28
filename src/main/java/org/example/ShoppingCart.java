package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Double totalPrice = 0.0;

    private Map<String, Double> items = new HashMap<>();

    public  void addItem(String name, Double price){
        if (price <=0){
            System.out.println("Product should have the price greater than zero");
        }else {
            this.items.put(name, price);
        }


    }
    public void totalPrice(){
        Collection<Double> values = this.items.values();

        for (Double value : values){
            totalPrice+=value;
        }

    }
    public void applyDiscount(Double percentage){
        totalPrice = totalPrice - totalPrice*percentage;
    }
    public Map<String, Double> getItems() {
        return items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

}
