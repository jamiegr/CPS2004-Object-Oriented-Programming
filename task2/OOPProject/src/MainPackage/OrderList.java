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
public class OrderList {
    
    private Node head;
    private double totalPrice;
    
    public OrderList(){
        this.head = null;
        this.totalPrice = 0;
    }
    
    public void addOrder(Order order){
        Node temp = new Node(order);
        
        if(head == null){//checking if list is empty
            totalPrice = 0;
            head = temp;//if list is empty, add order to beginning of list
        }else{
            Node runnerNode = head;//creating node to run through linked list till last node is found
            while(runnerNode.getNext() != null){
                runnerNode = runnerNode.getNext();
            }
            runnerNode.setNext(temp);
        }
        totalPrice += order.getPrice();//updating total price for this order list
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    public double getTotal(){
        return totalPrice;
    }
    
    public Node getHead(){
        return head;
    }
}
