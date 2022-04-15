package emp;

//view employee page
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
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
		out.print("<div class='container' style='margin-left:15%;padding:10px 16px;height:10px;'>");
		out.println("<font color = \"yellow\"><a href='index.html'>Add New Delivery</a></font>");
		out.print("</div>");
		out.println("<tr>");
		out.println("<form method=\"get\" action=\"servlett\"> ");
		out.println("<center><td><h1><font color = \"red\">Delivery List</font></h1></td>");
		out.println("<td><input type=\"text\" name=\"ename\" placeholder=\"Enter Employee Name\" required/></td>");
		 out.println("</tr><td colspan=2 align=center><input type=submit  value=Retrieve></td></tr>");
		 out.println("</form>");
		
		List<Emp> list=EmpDao.getAllDelivery();
		
		out.print("<div class='container' style='margin-left:15%;padding:10px 16px;height:1000px;'>");
		out.print("<table class='table table-hover table-striped'>");
		out.print("<tr><th>Id</th><th>Name</th><th>Vno</th><th>Email</th><th>Type</th><th>Edit</th><th>Delete</th></tr>");
		for(Emp e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getVno()+"</td><td>"+e.getEmail()+"</td><td>"+e.getType()+"</td><td><a class=\"btn btn-primary\" href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a class=\"btn btn-danger\" href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table></center></body>");
		
		out.close();
	}
}
