package servletstutorial;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.*;
public class buyer extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","aravind");
		PrintWriter out = resp.getWriter();
		/*PreparedStatement st = con 
                .prepareStatement("insert into buyers values(?,?,?,?)"); 
         st.setString(1,req.getParameter("name")); 
         st.setString(2,req.getParameter("address")); 
         st.setString(3,req.getParameter("email")); 
         st.setString(4,req.getParameter("phoneno")); 
         st.executeUpdate();*/
        PreparedStatement s = con 
                 .prepareStatement("select fullname,address,emailid,sellers.mobileno,price from sellers,book where sellers.mobileno=book.mobileno and isbn=?");           
          s.setString(1,req.getParameter("isbn"));
          ResultSet rs=s.executeQuery();
          if(rs.next()!=false)
          {
        	  ResultSet r=s.executeQuery();
        	  out.println("<table border=1 width=50% height=50%>");  
              out.println("<tr><th>name</th><th>address</th><th>emailid</th><th>mobileno</th></tr>"); 
              while(r.next())
              {
              out.println("<tr><td>"+r.getString(1)+"</td><td>"+r.getString(2)+"</td><td>"+r.getString(3)+"</td><td>"+r.getString(4)+"</td></tr>");
     
              }
     
		}
          else
          {
        	  PreparedStatement stm = con 
                      .prepareStatement("insert into waiting values(?,?)"); 
            
               stm.setString(2,req.getParameter("isbn")); 
       
             stm.setString(1,req.getParameter("phoneno")); 
               int r=stm.executeUpdate();
               out.println("<h1>inserted"+r+"rows in waiting list</h1>");        	  
 
        	  
          }
		}
          		catch (ClassNotFoundException e) {
			System.out.println(1);
		}
          		
		catch(SQLException e)
		{
			System.out.println(2);
		}
	

	}

}


