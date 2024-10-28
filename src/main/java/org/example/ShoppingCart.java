package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    public Map<String, Double> getItems() {
        return items;
    }

    private Map<String, Double> items = new HashMap<>();

    public  void addItem(String name, Double price){
        this.items.put(name, price);

    }
    public Double totalPrice(){
        Collection<Double> values = this.items.values();
        Double total = 0.0;
        for (Double value : values){
            total+=value;
        }
        return total;
    }
}
