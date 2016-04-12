package com.iiitd.ap.lab9;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/MainPage")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<html><body>");
		response.getWriter().append("<h3> CUSTOMER VIEW </h3>");
		response.getWriter().append("<form action=\"\"  method='POST'  > ");
		response.getWriter().append("Want to place a new order? <input type='submit' name=\"NewOrder\" value=\"New Order\"></input><br>");
	        
		response.getWriter().append("\nWant to track an order?  Order ID: <input type=\"text\" name='id'  >");
		response.getWriter().append(" <input type=\"submit\" name=\"Track\" value=\"Submit\"> <br> </form>");
		response.getWriter().append("</body></html>");
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 
	    String a= request.getParameter("NewOrder");

	   if (a == null)
	   {
	       System.out.println("new order not selected");//no button has been selected
	   } else {
		   System.out.println("new order selected!!!!!");//no button has been selected
		   response.sendRedirect("./NewOrder");
		   
		   //tbo.getorders().get(Id).changestatus();
	   } 	     
         
	   a= request.getParameter("Track");

	   if (a == null)
	   {
	       System.out.println("Track not selected");//no button has been selected
	   } else {
		   System.out.println("Track selected!!!!!");//no button has been selected
		   if(request.getParameter("id").equals(""))
				response.getWriter().append("Please give the order id!!!");
		   else	 
		   response.sendRedirect("./Track?id="+request.getParameter("id"));

		   //tbo.getorders().get(Id).changestatus();
	   } 	     
         
		
		
		
		//doGet(request, response);
	}

}
