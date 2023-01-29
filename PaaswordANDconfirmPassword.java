package jdbc;

import java.util.*;
import java.sql.*;

public class PaaswordANDconfirmPassword {
	
	public static void insert(String u,String p,String cp) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sameer","root","");
			
			if(con!=null) {
				PreparedStatement ps=con.prepareStatement("insert into PassInfo values('"+u+"','"+p+"','"+cp+"')");
				ps.executeUpdate();
				System.out.println("You Have SucessFully create UsreName & Password");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		while(true) 
		{
			System.out.println("ENter UserName");
			String u=sc.next();
			System.out.println("ENter Password");
			String p=sc.next();
			System.out.println("Confirm Password");
			String cp=sc.next();
		
			if(p.equals(cp)) {
				insert(u,p,cp);
			}
			else {
				System.out.println("PassWord & ConfirmPassword Not Match\n");
			}
	    }
	}

}
