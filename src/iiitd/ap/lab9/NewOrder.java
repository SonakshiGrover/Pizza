
/** 
 * @authors : SONAKSHI GROVER  2014106 , DIVAM GUPTA 2014038
 */


package com.iiitd.ap.lab9;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewOrder
 */
@WebServlet("/NewOrder")
public class NewOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("db orders"+OrdersDB.orders);
		Order o = new Order();
		OrdersDB.orders.put(o.id, o);
		
		
		response.getWriter().append("<html><body>");
		
		response.getWriter().append("<h3> ID - "+o.id+"</h3>");
		
		
		
		response.getWriter().append("<form action=\"\"  method='POST'  > ");
		response.getWriter().append(" <input type=\"hidden\" name='id'  value='"+o.id+"' > ");
		response.getWriter().append(" <input type=\"hidden\" name='level'  value='0' > ");
		
		
		int i = 0;
		
		for(String item : Menucard.items)
		{
			i++;
			response.getWriter().append(" <img src=\"http://www.dominos.co.in/blog/wp-content/uploads/2011/08/Dish7-country-specialA.jpg\" alt=\"jhfsd\" style=\"width:100px;height:100px;\">");
			//<img src="pic_mountain.jpg" alt="Mountain View" ">
			response.getWriter().append(" <input type='checkbox' name='"+ "c" + i +"'> " + item);
			response.getWriter().append(" <input type='text' name='"+ "q" + i +"'> <br><br> "  );
		}
		
		response.getWriter().append(" <input type=\"submit\" value=\"Submit\">  </form>");
		response.getWriter().append("</body></html>");
			
		//System.out.println("db orders"+OrdersDB.orders);	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Order o = OrdersDB.orders.get(request.getParameter("id"));
		
		
		switch( request.getParameter("level") )
		{
			case "0":
				int i = 0,flag=0;
				for(String item : Menucard.items)
				{
					i++;
					
					if( request.getParameter("c"+i) != null )
					{   flag=1;
						Integer q = 1;
						if(!(request.getParameter("q"+i).trim().equals("")))
							q = Integer.parseInt(request.getParameter("q"+i).trim());				
						o.items.put(""+i, q );
					}
			       
				}
				if(flag==0)
			       {
			    	   response.getWriter().append("Please select an item");
			    	   break;
			       }
				
				response.getWriter().append("<html><body>");
				response.getWriter().append("<h3> ID - "+o.id+"</h3>");
				response.getWriter().append("<form action=\"\"  method='POST'  > ");
				response.getWriter().append(" <input type=\"hidden\" name='id'  value='"+o.id+"' > ");
				response.getWriter().append(" <input type=\"hidden\" name='level'  value='1' > ");
				
				response.getWriter().append(" Name: <input type=\"text\" name='name'  > <br> ");
				response.getWriter().append(" Number : <input type=\"text\" name='number'  > <br>");
				response.getWriter().append(" Address: <input type=\"text\" name='address'  > <br>");
				
				response.getWriter().append(" <input type=\"submit\" value=\"Submit\">  </form>");
				response.getWriter().append("</body></html>");
				
				
				
				
				break;
			
			case "1":
				
				o.personName = request.getParameter("name");
				o.personAdress = request.getParameter("address");
				o.personNumber = request.getParameter("number");
				
				//System.out.println("b "+o.personAdress.equals(""));
				if((!(o.personName.equals(""))&&!(o.personAdress.equals(""))&&!(o.personNumber.equals("")))==false)
					response.getWriter().append("Please fill all the details!!!!");
				    
				else
			     	response.sendRedirect("./Track?id="+o.id);
				
				//response.getWriter().append("Thank You done ");
				
				
				
				break;
		
		}
		
		
		
		
		
		
		
		
		
	}

}


