/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/**
 *
 * @author Jamie
 */
public class MenuItem {
    
    private String name;
    private double price;
    
    public MenuItem(){//default constructor
        this.name = "";
        this.price = 0f;
    }
    
    public MenuItem(String name, double price){//main constructor
        this.name = name;
        this.price = price;
    }
    //getters and setters
    public double getPrice(){
        return this.price;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setName(String name){
        this.name = name;
    }
}
