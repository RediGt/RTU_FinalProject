package pac01;

import java.util.LinkedList;
import java.sql.*;

public class Connections {
	private Connection connection;
    private String server = "jdbc:mysql://localhost:3306/";
    private String database= "pizzashop";
    private String uid = "root";
    private String password = "Mazda636";

    public Boolean Open() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(server + database, uid, password);
			//System.out.println("Connection succeeded!");
        }
        catch (Exception e1) {
    			System.out.println("Connection failed!");
        	return false;
        }
        return true;
    }

    public Boolean Close() {
        try {
        	this.connection.close();
        }
        catch (Exception e1) {
			System.out.println("Connection closure failed!");
            return false;
        }
        return true;
    }
    
	public LinkedList<Picas> LoadSqlPicas() {
        LinkedList<Picas> picas = new LinkedList<Picas>();
        String query = "SELECT * FROM pizzashop.pizzas";       

        if (this.Open() == true) {
        	try {
	        	Statement stmt = connection.createStatement();
	        	ResultSet rs = stmt.executeQuery(query);
	        	
	            while (rs.next()){
	                picas.add(new Picas(String.valueOf(rs.getInt("id")), 
	                					rs.getString("pizzaName"), 
	                					String.valueOf(rs.getInt("size")),
	                					String.valueOf(rs.getDouble("price")), 
	                					rs.getString("picaDescription")));
	            }
	            rs.close();
				stmt.close();
				this.Close();
            }
        	catch (Exception e1) {
    			System.out.println("Connection failed!");
            }
        }
        else {
            picas = null;
        }
        return picas;
    }
	
	public void AddNewOrder(LinkedList<Orders> ordersList)
    {
        String query = "INSERT INTO orders (orderDescription, totalPrice, orderStatus, " +
        									"clName, clPhone, clAddress, clDateTime) " +
            "VALUES ('" + ordersList.getLast().getOrder() + "', " +
            			  Double.valueOf(ordersList.getLast().getOrderTotalPrice()) + ", '" +
            			  ordersList.getLast().getOrderStatus() + "', '" +
            			  ordersList.getLast().getOrderClientName() + "', '" +
            			  ordersList.getLast().getOrderClientPhone() + "', '" +
            			  ordersList.getLast().getOrderClientAddress() + "', '" +
            			  ordersList.getLast().getOrderClientDataTime() + "');";                        
		
        if (this.Open() == true) {
        	try {
        		Statement stmt = connection.createStatement();
        		stmt.execute(query);
        		stmt.close();
        		this.Close();
        		System.out.println("Connection is made!");
        	}
        	catch (Exception e1) {
    			System.out.println("Connection failed!");
    		}
        }
       
            /*label.Text = "Data Stored Successfully";
        }
        else
        {
            label.Text = "Error";
        }*/
    }
}
