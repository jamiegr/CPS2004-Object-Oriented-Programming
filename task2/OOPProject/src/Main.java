/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author Jamie
 */
public class Main {
    
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        File file;
        BufferedReader reader = null;
        System.out.println("Insert file address");
        String address = in.nextLine();
        boolean fileFound;
        try {
            file = new File(address);
            reader = new BufferedReader(new FileReader(file));
            fileFound = true;
        } catch (FileNotFoundException fnfe) {
            System.out.println("File address not found, default file will be used instead");
            fileFound = false;
        }
        if(fileFound == false){
            try{
                file = new File("oop-java-example.txt");
                reader = new BufferedReader(new FileReader(file));
            }catch(FileNotFoundException fnfe){
                System.out.println("Default file not found, possibly renamed, moved or deleted");
                return;
            }
        }
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        ArrayList<OrderList> orderLists = new ArrayList<>();
        StringTokenizer strtok;//used to split commands into tokens
        String currentLine, currentToken, parameter1, parameter2;//used to store current line, token and parameters for commands which accept them respectively
        double tempPrice;//will store price parsed from string when adding item to a menu
        Restaurant tempRestaurant = null, tempOrderRestaurant;//tempRestaurant is used for creating new restaurant, tempOrderRestaurant is used for creating an order linked to a particular restaurant
        Order tempOrder = null;
        OrderList tempOrderList = null;
        try {
            while((currentLine = reader.readLine()) != null){
                if(currentLine.length() > 0){
                    strtok = new StringTokenizer(currentLine, " ");
                    currentToken = strtok.nextToken();//get first word in the line (should be the command)
                    switch (currentToken) {
                        case "BeginRestaurant":
                            if(tempRestaurant != null){
                                System.out.println("Please use 'EndRestaurant' command before beginning new restaurant");
                            }else if(strtok.countTokens() != 2){
                                System.out.println("Invalid 'BeginRestaurant' command format");
                            }else{
                                parameter1 = strtok.nextToken();
                                parameter2 = strtok.nextToken();
                                if(parameter2.equals("delivery") || parameter2.equals("takeaway") || parameter2.equals("both")){
                                    if(getRestaurantByName(parameter1, restaurants) == null){
                                        tempRestaurant = new Restaurant(parameter1, parameter2);
                                        System.out.println("BeginRestaurant executed successfully");
                                    }else{
                                        System.out.println("Restaurant with that name already exists");
                                    }
                                }else{
                                    System.out.println("Invalid second parameter");
                                }
                            }
                            break;
                        case "Item":
                            if(tempRestaurant == null){
                                System.out.println("Please use 'BeginRestaurant' command before adding an item to a menu");
                            }else if(strtok.countTokens() != 2){
                                System.out.println("Invalid 'Item' command format");
                            }else{
                                parameter1 = strtok.nextToken();
                                parameter2 = strtok.nextToken();
                                try{
                                    tempPrice = Math.round(Double.parseDouble(parameter2)) * 100.0 / 100.0;
                                }catch(NumberFormatException nfe){
                                    tempPrice = -1f;
                                }
                                if(tempPrice > 0){
                                    tempRestaurant.addItem(parameter1, Math.round(Double.parseDouble(parameter2)) * 100.0 / 100.0);
                                    System.out.println("Item added to menu successfully");
                                }else{
                                    System.out.println("Invalid item price");
                                }
                            }
                            break;
                        case "EndRestaurant":
                            if(tempRestaurant == null){
                                System.out.println("Please use 'BeginRestaurant' command before beginning new restaurant");
                            }else if(tempRestaurant.checkMenuEmpty()){
                                System.out.println("Please add at least one item to the restaurant's menu");
                            }else{
                                restaurants.add(tempRestaurant);
                                System.out.println("Restaurant added successfully");
                                tempRestaurant = null;
                            }
                            break;
                        case "BeginOrderList":
                            if(tempOrderList == null){
                                tempOrderList = new OrderList();
                                System.out.println("BeginOrderList executed successfully");
                            }else{
                                System.out.println("Please use 'EndOrderList' command before beginning a new Order List");
                            }
                            break;
                        case "BeginOrder":
                            if(tempOrder != null){
                                System.out.println("Please use 'EndOrder' command before beginning a new Order");
                            }else if(strtok.countTokens() != 2){
                                System.out.println("Invalid 'BeginOrder' command format");
                            }else{
                                parameter1 = strtok.nextToken();
                                parameter2 = strtok.nextToken();
                                if(parameter2.equals("delivery") || parameter2.equals("takeaway")){
                                    tempOrderRestaurant = getRestaurantByName(parameter1, restaurants);
                                    if(tempOrderRestaurant == null){
                                        System.out.println("No restaurant with the given name exists");
                                    }else if(!tempOrderRestaurant.checkOrderType(parameter2)){
                                        System.out.println("That restaurant does not accept " + parameter2 + " orders");
                                    }else{
                                        tempOrder = new Order(tempOrderRestaurant, parameter2);
                                        System.out.println("BeginOrder command executed successfully");
                                    }
                                }else{
                                    System.out.println("Invalid second parameter");
                                }
                            }
                            break;
                        case "OrderItem":
                            if(tempOrder == null){
                                System.out.println("Please begin an order using 'BeginOrder' command before adding an order item");
                            }else if(strtok.countTokens() != 1){
                                System.out.println("Invalid 'OrderItem' command format");
                            }else{
                                parameter1 = strtok.nextToken();
                                if(tempOrder.getRestaurant().getItemByName(parameter1) == null){
                                    System.out.println("There is no item with that name on the selected restaurant's menu");
                                }else{
                                    tempOrder.addItem(tempOrder.getRestaurant().getItemByName(parameter1));
                                    System.out.println("Item added to order successfully");
                                }
                            }
                            break;
                        case "EndOrder":
                            if(tempOrder == null){
                                System.out.println("Please use 'BeginOrder' command before beggining a new order");
                            }else if(tempOrder.checkEmpty()){
                                System.out.println("Please add an item to the order before closing it");
                            }else if(tempOrderList == null){
                                System.out.println("Please begin an order list to add the order to");
                            }else{
                                tempOrderList.addOrder(tempOrder);
                                System.out.println("Order added successfully");
                                tempOrder = null;
                            }
                            break;
                        case "EndOrderList":
                            if(tempOrderList == null){
                                System.out.println("Please use 'BeginOrderList' command before using EndOrderList");
                            }else if(tempOrderList.isEmpty()){
                                System.out.println("Please add an order to the order list before closing it");
                            }else{
                                orderLists.add(tempOrderList);
                                System.out.println("OrderList total price: " + tempOrderList.getTotal());
                                tempOrderList = null;
                            }
                            break;
                        default:
                            System.out.println("Invalid command");
                            break;
                    }
                }
            }
        } catch (IOException | IndexOutOfBoundsException ex) {//catch exceptions when reading from file or when getting substrings (for parameters)
            System.out.println("Exception caught");
        }
        
        System.out.println("Total price of all Order Lists: " + getTotalPrice(orderLists));
        tempRestaurant = getHighestRevenue(restaurants);
        System.out.println("The restaurant with the highest revenue is: " + tempRestaurant.getName() + " with " + tempRestaurant.getTotalRevenue() + " in revenue.");
    }
    
    static double getTotalPrice(ArrayList<OrderList> orderLists){
        int total = 0;
        for(OrderList orderList : orderLists){
            total += orderList.getTotal();
        }
        return total;
    }
    
    static Restaurant getHighestRevenue(ArrayList<Restaurant> restaurants){
        Restaurant tempRestaurant = null;
        for(Restaurant restaurant : restaurants){
            if(tempRestaurant == null || restaurant.getTotalRevenue() > tempRestaurant.getTotalRevenue()){
                tempRestaurant = restaurant;
            }
        }
        return tempRestaurant;
    }
    
    static Restaurant getRestaurantByName(String restaurantName, ArrayList<Restaurant> restaurants){
        for(Restaurant restaurant : restaurants){
            if(restaurant.getName().equals(restaurantName)){
                return restaurant;
            }
        }
        return null;
    }
}
