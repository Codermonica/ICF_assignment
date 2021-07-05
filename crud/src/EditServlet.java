import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet. http.HttpServlet;
import javax.servlet. http.HttpServletRequest;
import javax.servlet. http.HttpServletResponse;

public class EditServlet extends HttpServlet {
/**
 * 
 */
	private static final long serialVersionUID=1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Employees</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		Emp e=EmpDao.getEmployeeById(id);
		
		out.print("<form action='EditServelet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td><FirstName:</td><td><input type='text' name='FirstName value='"+e.getFirstName()+"/></td></tr>");
		out.print("<tr><td><LastName:</td><td><input type='text' name='LastName value='"+e.getLastName()+"/></td></tr>");
		out.print("<tr><td>:<Startdate</td><td><input type='text' name='Startdate value='"+e.Startdate()+"/></td></tr>");
		out.print("<tr><td>:<designation</td><td><input type='text' name='designation value='"+e.getdesignation()+"/></td></tr>");
		out.print("<tr><td>:<department</td><td><input type='text' name='department value='"+e.getdepartment()+"/></td></tr>");
		out.print("<tr><td>:<enddate</td><td><input type='text' name='enddate value='"+e.enddate()+"/></td></tr>");
		out.print("<tr><td>:<status</td><td><input type='text' name='status value='"+e.getstatus()+"/></td></tr>");
		out.print("<tr><td>:<dob</td><td><input type='text' name='dob value='"+e.getdob()+"/></td></tr>");
		out.print("<tr><td>:<reportingmanager</td><td><input type='text' name='reportingmanager value='"+e.getreportingmanager()+"/></td></tr>");
		out.print("<tr><td>:<Gender</td><td><input type='text' name='Gender value='"+e.getgender()+"/></td></tr>");
		out.print("<tr><td>:<bloodgroup</td><td><input type='text' name='bloodgroup value='"+e.getbloodgroup()+"/></td></tr>");
		out.print("<tr><td>:<address</td><td><input type='text' name='address value='"+e.getAddress()+"/></td></tr>");
		out.print("</table>");
		out.print("/form>");
		
		out.close();
	}
}
		
		
		

