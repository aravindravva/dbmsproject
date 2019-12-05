package servletstutorial;

import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class seller extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","aravind");
		PreparedStatement st = con 
                .prepareStatement("insert into sellers values(?,?,?,?)"); 
         st.setString(1,req.getParameter("name")); 
         st.setString(2,req.getParameter("address")); 
         st.setString(3,req.getParameter("email")); 
         st.setString(4,req.getParameter("phoneno")); 
         st.executeUpdate();
         PreparedStatement s = con 
                 .prepareStatement("insert into book values(?,?,?,?,?,?)");
          s.setString(1,req.getParameter("phoneno"));
          s.setString(2,req.getParameter("isbn")); 
          s.setString(3,req.getParameter("bookname")); 
          s.setString(4,req.getParameter("author")); 
          s.setString(5,req.getParameter("edition"));
          s.setString(6,req.getParameter("price"));
          s.executeUpdate();
          PrintWriter out = resp.getWriter();
          out.println("your details submitted");
          s.close();
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
