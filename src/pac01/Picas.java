package pac01;

import java.util.LinkedList;

public class Picas {
	private String id;
	private String name;
	private String size;
	private String price;
	private String description;
	LinkedList<Picas> picas = new LinkedList<Picas>();
    
	public Picas(String id, String name, String size, String price, String description)
    {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.description = description;
    }
	
	public void printPica() {
		System.out.println(this.id + "  " + this.name + "   " + this.price);  
	}
	
	public String getPicaID() {
		return this.id;
	}
	
	public String getPicaName() {
		return this.name;
	}
	
	public String getPicaSize() {
		return this.size;
	}
	
	public String getPicaPrice() {
		return this.price;
	}
	
	public String getPicaDescription() {
		return this.description;
	}
}
