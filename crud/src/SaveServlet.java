import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet. http.HttpServlet;
import javax.servlet. http.HttpServletRequest;
import javax.servlet. http.HttpServletResponse;


@WebServlet("/SaveServlet")

public class SaveServlet extends HttpServlet{
	/**
	 * 
	 */
	 private static final long serialVersionUID=1L;
	 

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			.+-
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
			e.SetFirsttname(Firstname);
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
			
			int status=EmpDao.save(e);
			if(status>0) {
				out.print("Record saved successfully");
				request.getRequestDispatcher("index.html").include(request,response);
			}else {
				out.println("sorry unable to save record");
			
			}
			out.close();
		}
}
