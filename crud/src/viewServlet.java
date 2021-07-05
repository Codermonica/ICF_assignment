import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet. http.HttpServlet;
import javax.servlet. http.HttpServletRequest;
import javax.servlet. http.HttpServletResponse;

import org.apache.catalina.connector.Response;
@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>Add New Employeee,/a>");
		out.println("<h1>Employees list,/h1>");
		List<Emp> list=EmpDao.getAllEmployees();
		
		out.print("table border='1' width='100%'");;
		out.print("<tr><th>FirstNmae</th><th>LastName</th><th><th>Startdate</th><th>designation</th>,\\\"\\r\\n\" \r\n" + 
		"+ \"<th>department</th><th>enddate</th>,<th>status</th><th>dob</th><th>reportingmanager</th>\"+ \"<th>Gender</th><th>bloodgroup</th><th>address</th></tr>");
		for(Emp e:list) {
			out.print("<tr><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+"</td><td>"+e.Startdate()+"</td><td>"+e.getdesignation()+"</td><td>"+e.getdepartment()+"</td><td>"+e.enddate()+"</td><td>"+e.getstatus()+"=</td><td>"+e.getdob()+"</td><td>"+e.getreportingmanager()+"</td><td>"+e.getgender()+"</td>"
					+ "<td>"+e.getbloodgroup()+"</td><td>"+e.getAddress()+"</td><td></tr>");
		}
		out.print("</table>");
		
		out.close();
		
		
	}
}
