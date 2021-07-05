import java.util.*;
import java.sql.*;

public class EmpDao {

	public static Connection getConnection() { 
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empuser","root","");//database connection
			
			System.out.println("database connected");
		
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Emp e){
		int status=0;
		try {
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into empjava(FirstName,LastName,Startdate,designation,"
					+ "department,enddate,status,dob,reportingmanager,"
					+ "Gender,bloodgroup,address)values(?,?,?,?,?,?,?,?,?,?,?,?)");//insert
			ps.setString(1,e.getFirstName());
			ps.setString(2,e.getLastName());
			ps.setString(3,e.Startdate());
			ps.setString(4,e.getdesignation());
			ps.setString(5,e.getdepartment());
			ps.setString(6,e.enddate());
			ps.setString(7,e.getstatus());
			ps.setString(8,e.getdob());
			ps.setString(9,e.getreportingmanager());
			ps.setString(10,e.getgender());
			ps.setString(11,e.getbloodgroup());	
			ps.setString(12,e.getAddress());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex) {ex.printStackTrace();}
		
		return status;
			
	}
	public static int update(Emp e) {
		int status=0;
				try {
					Connection con=EmpDao.getConnection();
					PreparedStatement ps=con.prepareStatement("update empjava set FirstName=?,LastName=?,Startdate=?,designation=?,"
							+ "department=?,enddate=?,status=?,dob=?,reportingmanager=?,"
							+ "Gender=?,bloodgroup=?,address=?)where id=?");   //update
					ps.setString(1, e.getFirstName());
					ps.setString(2, e.getLastName());
					ps.setString(3, e.Startdate());
					ps.setString(4,e.getdesignation());
					ps.setString(5,e.getdepartment());
					ps.setString(6,e.enddate());
					ps.setString(7,e.getstatus());
					ps.setString(8,e.getdob());
					ps.setString(9,e.getreportingmanager());
					ps.setString(10,e.getgender());
					ps.setString(11,e.getbloodgroup());	
					ps.setString(12,e.getAddress());
					
					status=ps.executeUpdate();
					
					con.close();
				}catch(Exception ex) {ex.printStackTrace();}
				return status;
	}
	public static int delete(int id) {
		int status=0;
				try {
					Connection con=EmpDao.getConnection();
					PreparedStatement ps=con.prepareStatement("deleted from empjava FirstName=?,LastName=?,Startdate=?,designation=?,\"\r\n" 
					+ "department=?,enddate=?,status=?,dob=?,reportingmanager=?,"+ "Gender=?,bloodgroup=?,address=?)where id=?"); //delete
					ps.setInt(1, id);;
					status=ps.executeUpdate();
					
					con.close();
				}catch(Exception e) {e.printStackTrace();}
				
				return status;
										
		}
			
	public static Emp getEmployeeById(int id) {
		Emp e=new Emp();
		
				try {
					Connection con=EmpDao.getConnection();
					PreparedStatement ps=con.prepareStatement("select * from empjava where id=?"); //select using id
					ps.setInt(1,id);
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
						e.setId(rs.getInt(1));
						e.setFirstName(rs.getString(2));
						e.setLastName(rs.getString(3));
						e.setStartdate(rs.getString(4));
						e.setdestination(rs.getString(5)); 
						e.setdepartment(rs.getString(6));
						e.setenddate(rs.getString(7));
						e.setstatus(rs.getString(8));
						e.setdob(rs.getString(9));
						e.setreportmanagaer(rs.getString(10));
						e.setGender(rs.getString(11));
						e.setbloodgroup(rs.getString(12));
						e.setaddress(rs.getString(13));
						
					}					
						
					con.close();
				}catch(Exception ex) {ex.printStackTrace();}
				
				return e;
	
	}
		
		
	
public static List<Emp> getAllEmployees(){ {
	List<Emp> list=new ArrayList<Emp>();
			try {
				Connection con=EmpDao.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from empjava"); //select all record
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Emp e=new Emp();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setLastName(rs.getString(3));
					e.setStartdate(rs.getString(4));
					e.setdestination(rs.getString(5)); 
					e.setdepartment(rs.getString(6));
					e.setenddate(rs.getString(7));
					e.setstatus(rs.getString(8));
					e.setdob(rs.getString(9));
					e.setreportmanagaer(rs.getString(10));
					e.setGender(rs.getString(11));
					e.setbloodgroup(rs.getString(12));
					e.setaddress(rs.getString(13);
					list.add(e);
				}
				
				
				con.close();
			}catch(Exception e) {e.printStackTrace();}
			
			return list;
	}
	
}
} 
