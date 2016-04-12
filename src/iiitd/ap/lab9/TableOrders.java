/** 
 * @authors : SONAKSHI GROVER  2014106 , DIVAM GUPTA 2014038
 */


package com.iiitd.ap.lab9;

import java.util.HashMap;

public class TableOrders {
	 
	//OrdersDB odb=new OrdersDB();
	public HashMap<String , Order> ans;
	public HashMap<String , Order> getorders()
	   {     System.out.println("Inside getorders ");
		   for( String Id : OrdersDB.orders.keySet()  )
			{
			   System.out.println("Inside for of getorders , Id ="+Id);
			    if((OrdersDB.orders.get(Id).status!=null)&&(!(OrdersDB.orders.get(Id).status.equals("Delivered"))))
			    		{
			    	        
			    	         ans.put(Id,OrdersDB.orders.get(Id)); 
			    	          System.out.println("Id= "+Id);
			    		}
				
			}
			return ans;
	   }
	public TableOrders()
	{
		ans=new HashMap<String , Order>();
		  
//		Order o = new Order();
//		o.status="Placed Order";
//		o.items.put("Pizza veg",2);		
//		
//		
//		o.id="ORD1";
//		
//		
//		
//		o.personName="abc";
//		o.personAdress="sdf";
//		o.personNumber="1424";
//		
//		ans.put(o.id, o);
//		
//		
//		Order o1 = new Order();
//		o1.status="Placed Order";
//		o1.items.put("Pizza veg",2);		
//		
//		
//		o1.id="ORD2";
//		
//		
//		
//		o1.personName="sadf";
//		o1.personAdress="sdf";
//		o1.personNumber="1234";
//		
//		ans.put(o1.id, o1);

		
	}
	
	
	
	
}
