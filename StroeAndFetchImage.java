package jdbc;
import java.io.FileInputStream;
import java.sql.*;
public class StroeAndFetchImage {

	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sameer","root","");
		
		if(con!=null) {
			
			PreparedStatement ps=con.prepareStatement("insert into StoreImage values(?,?)");
		    ps.setString(1,"Sameer" );
		    
		    FileInputStream fi=new FileInputStream("C:\\Users\\NCS NO1\\Downloads\\Sameer Photo.jpg");
		    ps.setBinaryStream(2, fi,fi.available());
		    ps.executeUpdate();
		    fi.close();
		    ps.close();
		    con.close();
		    System.out.println("Seccessfully image saved");
		}
		else {
			System.out.println("Connection Not Establish....");
		}
	}

}
