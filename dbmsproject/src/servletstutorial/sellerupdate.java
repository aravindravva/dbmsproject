package servletstutorial;

import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class sellerupdate extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse resp)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","aravind");
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			if(req.getParameter("edition")==null || req.getParameter("edition").isEmpty())
			{
			PreparedStatement ps=con.prepareStatement("update book set price=? where mobileno=? and isbn=?");
            ps.setInt(1,Integer.parseInt(req.getParameter("price")));
            ps.setString(2, req.getParameter("phoneno"));
            ps.setString(3,req.getParameter("isbn"));
				
				ps.executeUpdate();
				out.println("succesfully modified"+req.getParameter("name"));
			}
			else if(req.getParameter("price")==null || req.getParameter("price").isEmpty())
			{
				PreparedStatement ps=con.prepareStatement("update book set edition=? where mobileno=? and isbn=?");
	            ps.setString(1,req.getParameter("edition"));
	            ps.setString(2, req.getParameter("phoneno"));
	            ps.setString(3,req.getParameter("isbn"));
					
					ps.executeUpdate();
					out.println("succesfully modified"+req.getParameter("name"));
			}
			else
			{
				System.out.println("hello");
				PreparedStatement ps=con.prepareStatement("update book set edition=?,price=? where mobileno=? and isbn=?");
	            ps.setString(1,req.getParameter("edition"));
	            ps.setInt(2,Integer.parseInt(req.getParameter("price")));
	            ps.setString(3, req.getParameter("phoneno"));
	            ps.setString(4,req.getParameter("isbn"));
					
					ps.executeUpdate();
					out.println("succesfully modified"+req.getParameter("name"));

			}
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
		} catch (IOException e) {
			
		}
		finally
		{
			
		}
	}
}
			
	