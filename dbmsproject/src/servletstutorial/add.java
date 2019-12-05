package servletstutorial;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class add extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse resp)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","aravind");
		PreparedStatement st = con 
                .prepareStatement("insert into users values(?,?,?,?)"); 
         st.setString(1,req.getParameter("fullname")); 
         st.setString(2,req.getParameter("address")); 
         st.setString(3,req.getParameter("email")); 
         st.setString(4,req.getParameter("mobileno")); 
         st.executeUpdate();
         st.close();
         con.close();
		}
		catch (ClassNotFoundException e) {
		}
		catch(SQLException e)
		{
			
		}
	
			}

}
