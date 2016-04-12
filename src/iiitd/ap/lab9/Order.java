/** 
 * @authors : SONAKSHI GROVER  2014106 , DIVAM GUPTA 2014038
 */



package com.iiitd.ap.lab9;

import java.util.HashMap;

public class Order {
	public HashMap<String , Integer> items = new  HashMap<String , Integer> ();
	
	static Integer  count;
	
	String id;
	String status;
	
	
	String personName;
	String personAdress;
	String personNumber;
	
	static{
		count =0 ;
	}
	
	
	Order(){
		count ++;
		this.id = "ORD" + count.toString() ;
		this.status="Order Placed";
		//this.status="Order PLaced";
	}
	
	public void changestatus()
	{
		 if((this.status).equals("Order Placed"))
	     {
			 this.status="Preparation"; 
         }
		 else if((this.status).equals("Preparation"))
		 {
	         this.status="Bake"; 
		 }
		 else if((this.status).equals("Bake"))
		 {
	         this.status="Quality Check"; 
		 }
		 else if((this.status).equals("Quality Check"))
		 {
	         this.status="Out for delivery"; 
		 }
		 if((this.status).equals("Out for delivery"))
		 {
	         this.status="Delivered"; 
		 }
   
		 
	}
	
}
