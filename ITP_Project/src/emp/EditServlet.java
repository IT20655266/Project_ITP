package emp;

//update page
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
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
		out.println("<center><h1><font color = \"red\">Update Delivery</font></h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Emp e=EmpDao.getDeliveryById(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table class='table' style=\"background-color:white\">");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		out.print("<tr><td>Vno:</td><td><input type='text' name='vno' value='"+e.getVno()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Type:</td><td>");
		out.print("<select name='type' style='width:150px'>");
		out.print("<option>Pending</option>");
		out.print("<option>Complete</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'></br><input type='submit' class='btn btn-success' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form></center></div>");
		
		out.close();
	}
}
