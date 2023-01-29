package jdbc;
import java.sql.*;
import java.io.*;
public class FetchStoredImage {

	public static void main(String[] args) throws Exception{
		

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sameer","root","");
		
		PreparedStatement ps=con.prepareStatement("select * from StoreImage");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1));
			Blob b=rs.getBlob(2);
			byte[] arr=b.getBytes(1,(int)b.length());
			
			FileOutputStream fo=new FileOutputStream("D:\\image.jpg");
			fo.write(arr);
			fo.close();
			}
		rs.close();
		ps.close();
		con.close();
		
	}

}
