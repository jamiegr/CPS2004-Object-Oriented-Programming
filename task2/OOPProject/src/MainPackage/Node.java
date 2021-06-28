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
public class Node {
    
    private Order order;
    private Node next;
    
    
    public Node(){//default constructor
        this.order = null;
        this.next = null;
    }
    public Node(Order order){//constructor 1
        this.order = order;
        this.next = null;
    }
    
    public Node(Order order, Node next){//constructor 2
        this.order = order;
        this.next = next;
    }
    
    public Node getNext(){
        return this.next;
    }
    
    public Order getOrder(){
        return this.order;
    }
    
    public void setNext(Node node){
        this.next = node;
    }
    
    public void setOrder(Order order){
        this.order = order;
    }
}
