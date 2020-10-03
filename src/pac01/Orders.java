package pac01;

import java.util.LinkedList;

public class Orders {
	private String id;
	//private LinkedList<Picas> order;
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
}
