package pac01;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class Order {
	private String id;
	private String picaName;
	private String size;
	private String price;
	private LinkedList<Order> clientOrder;

    public Order(String id, String picaName, String size, String price)
    {
        this.id = id;
        this.picaName = picaName;
        this.size = size;
        this.price = price;
    }
    
    public static void printClientOrder(LinkedList<Order> clientOrder) {
    	for(Order i:clientOrder)
    		System.out.println(i.id + "  " + i.picaName + "  " + i.size + "  " + i.price);  
	}
    
    public static String clientOrderToStringForLabel(LinkedList<Order> clientOrder) {
    	String orderString = "";
    	for(Order i:clientOrder)
    		orderString += ("<html>" + i.id + ". " + i.picaName + " " + i.size + "cm " + i.price + "eur<br>");  
    	
    	orderString += ("<br><br>Kopā: "); 
    	orderString += clientOrderTotal(clientOrder) + " eur";
    	return orderString;
	}
    
    public static String clientOrderToString(LinkedList<Order> clientOrder) {
    	String orderString = "";
    	for(Order i:clientOrder)
    		orderString += (i.picaName + " " + i.size + "cm   ");    	
    	return orderString;
	}
    
    public static Double clientOrderTotal(LinkedList<Order> clientOrder) {
    	Double total = 0.0;
    	for(Order i:clientOrder)
    		total += Double.valueOf(i.price);  	
    	return Math.round(total * 100.0) / 100.0;
	}
}
