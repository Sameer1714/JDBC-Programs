package jdbc;

import java.sql.*;
import java.util.Scanner;
public class ConnDemo {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sameer","root","");
		System.out.println("connection sucessfully ");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id : ");
		int id=sc.nextInt();
		System.out.println("Enter Name :");
		String name=sc.next();
		System.out.println("Enter Email :");
		String email=sc.next();
		
		PreparedStatement ps=con.prepareStatement("insert into first values('"+id+"','"+name+"','"+email+"')");
		ps.executeUpdate();
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("Select * from first");
		System.out.println();
		System.out.println("\nID"+"\tNAME"+"\tEmail"+"\n");
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.println();
		}
		con.close();
		sc.close();
		
	}

}
