/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;
import java.util.*;
/**
 *
 * @author Jamie
 */
public class Order{

    private double totalPrice;
    private String orderType;
    private Restaurant restaurant;
    private ArrayList<MenuItem> items = new ArrayList<>();

    public Order(Restaurant restaurant, String orderType){
        this.totalPrice = 0;
        this.restaurant = restaurant;
        this.orderType = orderType;
    }

    public void addItem(MenuItem item){
        if(item != null){//checking that item in parameter is not null since getItemByName method in Restaurant class returns null if specified item name is not found in restaurant's menu
            items.add(item);
            totalPrice += item.getPrice();
            notifyRestaurant(item.getPrice());
        }
    }

    public void notifyRestaurant(double tempPrice) {
        restaurant.update(tempPrice);
    }

    public boolean checkEmpty(){
        return items.isEmpty();
    }

    public double getPrice(){
        return totalPrice;
    }

    public Restaurant getRestaurant(){
        return restaurant;
    }
}