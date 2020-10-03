package pac01;

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
}
