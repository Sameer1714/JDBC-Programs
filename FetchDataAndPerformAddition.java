package jdbc;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class FetchDataAndPerformAddition {

	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sameer","root","");
			if(con!=null) {
				for(int i=0;i<3;i++)
				{
					System.out.println("Eneter 1 :");
					int x=sc.nextInt();
					System.out.println("ENter 2 :");
					int y=sc.nextInt();
					PreparedStatement ps=con.prepareStatement("insert into Second values('"+x+"','"+y+"')");
					ps.executeUpdate();
					
				}
				
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from Second");
				
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getInt(2));
				}
				
				con.close();
				sc.close();
			}
		
		

	
	}

}
