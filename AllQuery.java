package jdbc;

import java.sql.*;
import java.util.Scanner;
public class AllQuery {

	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sameer","root","");
		System.out.println("connection Sucessfully Happen");
		PreparedStatement ps;
		while(true) {
		System.out.println("\nSelect Option:\n"+"\n1.show table Data :"+"\n2.Insert value into table"+"\n3.update table row"+"\n4.delete record"+"\n5.EXIST");
		
		int ch=sc.nextInt();
		
		switch(ch) {
		case 1:
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from info");
			System.out.println("\nID"+"\tNAME"+"\tEmail");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			break;
		case 2:
			System.out.println("How many record you want insert : ");
			int n=sc.nextInt();
			for(int i=1;i<=n;i++) {
				System.out.println("\nEnter name : ");
				String name=sc.next();
				System.out.println("Enter Email :");
				String email=sc.next();
			    ps=con.prepareStatement("insert into info (name,email)values(?,?)");
				ps.setString(1, name);
				ps.setString(2, email);
				ps.executeUpdate();
				System.out.println("\n"+i+" Record Inserted SucessFully...!");
			}
			break;
		case 3:
			System.out.println("\nSelect Option : \n"+"\n1.Update name"+"\n2.Upadate Email"+"\n3.Upadate Both name And Email ");
			int ch1=sc.nextInt();
			switch(ch1) {
			case 1:
				System.out.println("Enter Id");
				int id=sc.nextInt();
				System.out.println("Enter New Name");
				String NewName=sc.next();
			    ps=con.prepareStatement("update info set name=? where id=?");
			    ps.setString(1, NewName);
				ps.setInt(2, id);
				ps.executeUpdate();
				System.out.println("\nRecord Upadate Sucessfully");
				break;
			case 2:
				System.out.println("\nEnter Id");
				int id1=sc.nextInt();
				System.out.println("\nEnter New Email");
				String NewEmail=sc.next();
				ps=con.prepareStatement("update info set email=? where id=?");
				ps.setString(1, NewEmail);
				ps.setInt(2, id1);
				ps.executeUpdate();
				System.out.println("\nRecord Upadate Sucessfully");
				break;
			case 3:
				System.out.println("\nEnter Id");
				int id11=sc.nextInt();
				System.out.println("\nEnter New Name");
				String NewName1=sc.next();
				System.out.println("\nEnter New Email");
				String NewEmail1=sc.next();
				ps=con.prepareStatement("update info set name=?, email=? where id=?");
				ps.setString(1, NewName1);
				ps.setString(2, NewEmail1);
				ps.setInt(3, id11);
				ps.executeUpdate();
				System.out.println("\nRecord Upadate Sucessfully");
				break;
			}
			break;
		case 4:
			System.out.println("\nEnter id that you want delete Record");
			int id2=sc.nextInt();
			ps=con.prepareStatement("delete from info where id=?");
			ps.setInt(1, id2);
			ps.executeUpdate();
			System.out.println("\nRecord delete Sucessfully");
			break;
		case 5:
			con.close();
			sc.close();
			System.exit(0);
			break;
		}
		}
	}

}
