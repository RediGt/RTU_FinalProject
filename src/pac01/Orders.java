package pac01;

import java.util.LinkedList;

public class Orders {
	private String id;
	private String order;
	private String totalPrice;
	private String orderStatus;
	private String clientName;
	private String clientPhone;
	private String clientAddress;
	private String supplyDataTime;

    public Orders(String id, String order, String totalPrice, String orderStatus,
    			  String clientName, String clientPhone, String clientAddress, String supplyDataTime)
    {
        this.id = id;
        this.order = order;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientAddress = clientAddress;
        this.supplyDataTime = supplyDataTime;
    }
    
    public void printOrder() {
		System.out.println(this.id + "  " + this.order + "   \n" + this.totalPrice + 
				"  " + this.orderStatus + "  " + this.clientName + "\n" + 
				"  " + this.clientPhone + "  " + this.clientAddress + "\n" +
				this.supplyDataTime);  
	}
    
    public String getOrderID() {
		return this.id;
	}
    
    public String getOrder() {
		return this.order;
	}
    
    public String getOrderTotalPrice() {
		return this.totalPrice;
	}
    
    public String getOrderStatus() {
		return this.orderStatus;
	}
    
    public String getOrderClientName() {
		return this.clientName;
	}
    
    public String getOrderClientPhone() {
		return this.clientPhone;
	}
    
    public String getOrderClientAddress() {
		return this.clientAddress;
	}
    
    public String getOrderClientDataTime() {
		return this.supplyDataTime;
	}
    
    public static Object[][] orderDataForTable(LinkedList<Orders> ordersList) {
    	Object[][] orderData = new Object[ordersList.size()][8];
    	
    	for (int i = 0; i < ordersList.size(); i++) {
    		orderData[i][0] = ordersList.get(i).getOrderID();
    		orderData[i][1] = ordersList.get(i).getOrder();
    		orderData[i][2] = ordersList.get(i).getOrderTotalPrice();
    		orderData[i][3] = ordersList.get(i).getOrderStatus();
    		orderData[i][4] = ordersList.get(i).getOrderClientName();
    		orderData[i][5] = ordersList.get(i).getOrderClientPhone();
    		orderData[i][6] = ordersList.get(i).getOrderClientAddress();
    		orderData[i][7] = ordersList.get(i).getOrderClientDataTime();
    	}
    	return orderData;
	}
}
