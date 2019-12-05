package servletstutorial;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class book extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse resp)
	{
		ServletContext sc = getServletContext();
		if(req.getParameter("option").equals("seller"))
		{		
			try {
				sc.getRequestDispatcher("/seller.html").forward(req, resp);
			} catch (ServletException e) {
							} catch (IOException e) {
			}
		}
			
		else if(req.getParameter("option").equals("buyer"))
		{
			try
			{
			sc.getRequestDispatcher("/buyer.html").forward(req, resp);
			}
		catch (ServletException e) {
						}
		catch (IOException e) {
		}
			
		}
		else if(req.getParameter("option").equals("sellerupdate"))
		{
			try
			{
			sc.getRequestDispatcher("/sellerupdate.html").forward(req, resp);
			}
		catch (ServletException e) {
						}
		catch (IOException e) {
		}
		}
		
		else if (req.getParameter("option").equals("sellerdelete"))
		{
			try
			{
			sc.getRequestDispatcher("/sellerdelete.html").forward(req, resp);
			}
		catch (ServletException e) {
						}
		catch (IOException e) {
		}
		}
		else if (req.getParameter("option").equals("buyerupdate"))
		{
			try
			{
			sc.getRequestDispatcher("/buyerupdate.html").forward(req, resp);
			}
		catch (ServletException e) {
						}
		catch (IOException e) {
		}
		}
		else
		{
			try
			{
			sc.getRequestDispatcher("/buyerdelete.html").forward(req, resp);
			}
		catch (ServletException e) {
						}
		catch (IOException e) {
		}
		}
			
			
		
							
	}
}