package jdbc;

import java.sql.*;
public class fetchSetTotal {

	public static void main(String[] args)throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sameer","root","");
		if(con!=null) {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Addition");
			//System.out.println("Id\t"+"A\t"+"B\t"+"Total");
			int i=1;
			while(rs.next()) {
				int add=rs.getInt(2)+rs.getInt(3);
			    PreparedStatement ps=con.prepareStatement("update Addition set total=? where id=? ");
			    ps.setInt(1, add);
			    ps.setInt(2, i);
			    ps.executeUpdate();
			    i++; 
			}
		
		}
	}

}
