package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 
@WebServlet("/servlett")
public class Servlett extends HttpServlet
{
     int i;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    	
        try {
            i++;
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.print("<link rel=\"stylesheet\" href=\"css/bootstrap.css\"></link>");
    		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
    		out.print("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
    		out.print("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>");
    		out.print("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
    		out.print("<style>\r\n" + 
    				"body {\r\n" + 
    				"  margin: 0;\r\n" + 
    				"}\r\n" + 
    				"\r\n" + 
    				"ul {\r\n" + 
    				"  list-style-type: none;\r\n" + 
    				"  margin: 0;\r\n" + 
    				"  padding: 0;\r\n" + 
    				"  width: 13%;\r\n" + 
    				"  background-color: #0f0707;\r\n" + 
    				"  position: fixed;\r\n" + 
    				"  height: 100%;\r\n" + 
    				"  overflow: auto;\r\n" + 
    				"}\r\n" + 
    				"\r\n" + 
    				"li a {\r\n" + 
    				"  display: block;\r\n" + 
    				"  color: rgb(247, 244, 244);\r\n" + 
    				"  padding: 8px 16px;\r\n" + 
    				"  text-decoration: none;\r\n" + 
    				"}\r\n" + 
    				"\r\n" + 
    				"li a.active {\r\n" + 
    				"  background-color: #04AA6D;\r\n" + 
    				"  color: white;\r\n" + 
    				"}\r\n" + 
    				"\r\n" + 
    				"li a:hover:not(.active) {\r\n" + 
    				"  background-color: #555;\r\n" + 
    				"  color: white;\r\n" + 
    				"}\r\n" + 
    				"\r\n" + 
    				"</style>");
    		out.print("<div>\r\n" + 
    				"<ul>\r\n" + 
    				"    <li><a href=\"#home\">Home Page</a></li>\r\n" + 
    				"    <li><a href=\"#news\">Employee</a></li>\r\n" + 
    				"    <li><a href=\"#contact\">Stock</a></li>\r\n" + 
    				"    <li><a href=\"#about\">Supply</a></li>\r\n" + 
    				"    <li><a href=\"#news\">Customer</a></li>\r\n" + 
    				"    <li><a href=\"#contact\">Prescription</a></li>\r\n" + 
    				"    <li><a href=\"#about\">Order</a></li>\r\n" + 
    				"    <li><a class=\"active\" href=\"#news\">Delivery</a></li>\r\n" + 
    				"    <li><a href=\"#contact\">Finance</a></li>   \r\n" + 
    				"  </ul>\r\n" + 
    				"</div> ");
    		out.print("<body bgcolor = \"white\">");
    		out.print("<div class='container' style='margin-left:15%;padding:10px 16px;height:1000px;'>");
    		
            String empname= request.getParameter("ename");
 
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/oop","root","");
            pst = con.prepareStatement("select id,vno,email,type from delivery where name=?");
            pst.setString(1, empname);
            rs = pst.executeQuery();
            
             out.println("<table class='table' style=\"background-color:white\">");
             out.println("<tr><td colspan=4 " );
             out.println("<center><h1><font color = \"red\">Result of Search Page</font></h1>");
             
             
             out.println("</td></tr>");
             out.println("<tr>");
             out.println("<th>Employee id</th>");
             out.println("<th>Vno</th>");
             out.println("<th>email</th>");
             out.println("<th>type</th>");
             out.println("</tr>");
              
              while(rs.next())
              {
                  out.println("<tr>");
                  out.println("<td>" + rs.getString("id") + "</td> ");
                  out.println("<td>" + rs.getString("vno") + "</td> ");
                  out.println("<td>" + rs.getString("email") + "</td> ");
                  out.println("<td>" + rs.getString("type") + "</td> ");
                  out.println("</tr>");
 
                  
              }
              out.println("</table></center></div>");
        
               }
            catch (ClassNotFoundException ex) {
          
        }catch (Exception e)
        { throw new ServletException("error", e); }
    }
    
    public void destory()
    {
        i = 0;
    }
 
    
}