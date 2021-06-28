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
public class Restaurant{

    private String name, type;
    private ArrayList<MenuItem> menu = new ArrayList<>();
    private double totalRevenue;

    public Restaurant(){//default constructor
        this.name = "";
        this.type = "";
        this.totalRevenue = 0;
    }

    public Restaurant(String name, String type){//main constructor
        this.name = name;
        this.type = type;
        this.totalRevenue = 0;
    }
    //getters and setters
    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public double getTotalRevenue(){
        return this.totalRevenue;
    }

    public void addItem(String name, double price){//add an item to the restaurant's menu
        if(this.getItemByName(name) == null){
            menu.add(new MenuItem(name, price));
        }else{
            System.out.println("Item with that name already exists in this restaurant's menu");
        }
    }

    public void update(double cost) {
        totalRevenue += cost;
    }

    public MenuItem getItemByName(String name){//search for an item from the menu by name
        for(MenuItem menuItem : menu){
            if(menuItem.getName().equals(name)){
                return menuItem;
            }
        }
        return null;
    }

    public boolean checkMenuEmpty(){
        return menu.isEmpty();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setType(String type){
        this.type = type;
    }

    public boolean checkOrderType(String orderType){
        return this.getType().equals(orderType) || this.getType().equals("both");
    }

}