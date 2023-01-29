package jdbc;
import java.util.*;
import java.sql.*;

public class RegisterTask1 {

	public static void Login(String u,int p) {
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sameer","root","");
			if(con!=null) {
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from Register");
				int pass=0,user=0;
				while(rs.next()) {
					//System.out.println(rs.getString(1)+" "+rs.getInt(2));
					if(u.equals(rs.getString(1))) {
						user=1;
					}
					if(p==rs.getInt(2)) {
						pass=1;
					}
				}
				if(user==1 && pass==1) {
					System.out.println("Login SucessFully");
				}
				else  if(user==1 && pass==0){
					System.out.println("PASSword is Wrong");
				}
				else if(user==0 && pass==1 ) {
					
					System.out.println("UserName is wrong");
				}
				else {
					System.out.println("Incorect Username & Passwod  ");
				}
				
			}
			else {
				System.out.println("Connection Not Establish");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("\nEnter USERNAME :");
		String u=sc.next();
		
		System.out.println("Enter Password");
		int p=sc.nextInt();
		
		Login(u,p);
		}
	}

}
