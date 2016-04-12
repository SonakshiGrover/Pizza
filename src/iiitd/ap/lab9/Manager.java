/** 
 * @authors : SONAKSHI GROVER  2014106 , DIVAM GUPTA 2014038
 */


package com.iiitd.ap.lab9;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

/**
 * Servlet implementation class Manager
 */
@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
           response.setContentType("text/html");

		   PrintWriter out = response.getWriter();
		   String title = "Restaurant Managerial View";
		   
		   String docType =
		   "<!doctype html public \"-//w3c//dtd html 4.0 " +
		   "transitional//en\">\n";
		   out.println(docType +
		     "<html>\n" +
		     "<head><title>" + title + "</title></head>\n" +
		     "<body bgcolor=\"#f0f0f0\">\n" +
		     "<h1 align=\"center\">" + title + "</h1>\n" +
		     "<form method='post'><table width=\"100%\" border=\"1\" align=\"center\">\n" +
		     "<tr bgcolor=\"#949494\">\n" +
		     "<th>Order Id</th><th>Status</th><th>Update</th>\n"+
		     "</tr>\n");

		   TableOrders tbo = new TableOrders();
		   
		   if(tbo.getorders()!=null)
		   {for(String Id: tbo.getorders().keySet()) 
		     {   
//		         out.print("<tr><td>" + Id + "</td>\n<td>"+tbo.getorders().get(Id).status+"</td><td><input type='submit' name=\"+str+"\ value=\"Update\"></input></td>\n");
//		         str="Update2"; 
//		         out.print("<tr><td>" + Id + "</td>\n<td>"+tbo.getorders().get(Id).status+"</td><td><input type='submit' name=\"Update\" value=\"Update\"></input></td>\n");
		     out.print("<tr><td>" + Id + "</td>\n<td>"+tbo.getorders().get(Id).status+"</td><td><input type='submit' name="+Id+" value=\"Update\"></input></td></tr>\n");
	         
		         
		      }
		   }
		   		  
		   
		   out.println("</table>\n</body></html>");
		     
		   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		
		
		   TableOrders tbo = new TableOrders();
		   String a;
		   if(tbo.getorders()!=null)
		   {for(String Id: tbo.getorders().keySet()) 
		     {   
			    a= request.getParameter(Id);

			   if (a == null)
			   {
			       System.out.println("no button selected");//no button has been selected
			   } else {
				   System.out.println(Id+ "button selected!!!!!");//no button has been selected
				   tbo.getorders().get(Id).changestatus();
			   } 	     
		         
		      }
		   }
		
		
			
		   doGet(request, response);
		
	
	}


}












