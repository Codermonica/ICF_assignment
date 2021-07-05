import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet. http.HttpServlet;
import javax.servlet. http.HttpServletRequest;
import javax.servlet. http.HttpServletResponse;

public class EditServlet2 extends HttpServlet {
/**
 * 
 */
	private static final long serialVersionUID=1L;
	 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String Firstname=request.getParameter("Firstname");
		String Lastname=request.getParameter("Lastname");
		String Startdate=request.getParameter("Startdate");
		String designation=request.getParameter("designation");
		String department=request.getParameter("department");
		String enddate=request.getParameter("enddate");
		String status=request.getParameter("status");
		String dob=request.getParameter("dob");
		String reportingmanager=request.getParameter("reportingmanager");
		String Gender=request.getParameter("Gender");
		String bloodgroup=request.getParameter("bloodgroup");
		String Startaddressdate=request.getParameter("address");
		
		Emp e=new Emp();
		e.SetFirsttName(Firstname);
		e.setLastname(Lastname);
		e.setStartdate(Startdate);
		e.setdesignation(designation);
		e.setdepartment(department);
		e.setenddate(enddate);
		e.setstatus(status);
		e.setdob(dob);
		e.setreportingmanager(reportingmanager);
		e.setGender(Gender);
		e.setbloodgroup(bloodgroup);
		e.setaddress(address);
		
		int status1=EmpDao.update1(e);
		if(status1>0) {
			response.sendRedirect("viewServlet");
			
		}else {
			out.println("sorry unable to update record");
		
		}
		out.close();
	}
}




