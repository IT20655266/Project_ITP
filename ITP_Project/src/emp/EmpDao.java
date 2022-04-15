package emp;
import java.util.*;
import java.sql.*;

public class EmpDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oop");
			con = DriverManager.getConnection("jdbc:mysql://localhost/oop","root","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into delivery(name,vno,email,type) values (?,?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getVno());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getType());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update delivery set name=?,vno=?,email=?,type=? where id=?");
			ps.setString(1,e.getName());
			ps.setString(2,e.getVno());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getType());
			ps.setInt(5,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps1=con.prepareStatement("insert backup select * from delivery where id=?");
			ps1.setInt(1,id);
			status=ps1.executeUpdate();
			PreparedStatement ps=con.prepareStatement("delete from delivery where id=?");			
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Emp getDeliveryById(int id){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from delivery where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setVno(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setType(rs.getString(5));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Emp> getAllDelivery(){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from delivery");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setVno(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setType(rs.getString(5));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
