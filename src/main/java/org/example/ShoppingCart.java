package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    public Map<String, Double> getItems() {
        return items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    private Double totalPrice = 0.0;

    private Map<String, Double> items = new HashMap<>();

    public  void addItem(String name, Double price){
        this.items.put(name, price);

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
}
