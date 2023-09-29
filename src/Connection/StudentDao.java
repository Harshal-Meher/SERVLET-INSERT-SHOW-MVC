package Connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.xdevapi.Result;

import Model.Student;

public class StudentDao 
{
	//Connection
	
public static Connection getConnection() throws ClassNotFoundException, SQLException
{
	

	String url="jdbc:mysql://localhost:3306/servlet";
	String uname="root";
	String pass="abc123";
	String Driver="com.mysql.cj.jdbc.Driver";
	
	Class.forName(Driver);
	Connection con=DriverManager.getConnection(url,uname,pass);
		

	return con;
}

//Insert

public static int Save(Student e) throws ClassNotFoundException, SQLException
{
	Connection con=StudentDao.getConnection();
	PreparedStatement ps=con.prepareStatement("insert into servlet.ser2(name,address,email)Values(?,?,?)");
	
	ps.setString(1,e.getName());
	ps.setString(2,e.getAddress());
	ps.setString(3,e.getEmail());
	
	int s=ps.executeUpdate();
	
	return 0;
	
}

public static List<Student> getAllEmployees()
{  
      List<Student> list=new ArrayList<Student>();  
        
      try{  
          Connection con=StudentDao.getConnection();  
          PreparedStatement ps=con.prepareStatement("select * from servlet.ser2");  
         
          ResultSet rs=ps.executeQuery();  
          while(rs.next())
          {  
        	  Student e=new Student(); 
             
              e.setId(rs.getInt(1));  
              e.setName(rs.getString(2));  
              e.setAddress(rs.getString(3));  
              e.setEmail(rs.getString(4));  
              
              list.add(e);  
              
          }  
          con.close();  
      }
      catch(Exception e){e.printStackTrace();}  
        
      return list;  
  }  

 





}
