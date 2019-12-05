package servletstutorial;

import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class sellerdelete extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse resp)
	{
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","aravind");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	PreparedStatement ps=con.prepareStatement("delete from book where mobileno=? and isbn=?");
    ps.setString(1, req.getParameter("mobileno"));
    ps.setString(2,req.getParameter("isbn"));
    int r=ps.executeUpdate();
    System.out.println(r);
    out.println("deleted");
	} catch (ClassNotFoundException e) {
		
	} catch (SQLException e) {
		
	} catch (IOException e) {
			}
	finally
	{
		
	}

}

}
