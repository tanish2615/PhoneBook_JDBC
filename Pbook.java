package phonebook_JDBC;

import java.sql.*;
import java.util.Scanner;

public class Pbook implements PhoneDAO{

	@Override
	public void Showmenu() {
		System.out.println("****************************************************");
		System.out.println("1. Create Contact");
		System.out.println("2. Edit Contact");
		System.out.println("3. Delete Contact");
		System.out.println("4. View Contact");
		System.out.println("5. Exit");
		System.out.println();
		
	}

	@Override
	public void Create() {
		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			PreparedStatement ps=con.prepareStatement("insert into pbook values (?,?,?,?)");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Serial Number : ");
			int sno=sc.nextInt();
			System.out.println("Enter Name : ");
			String name=sc.next();
			System.out.println("Enter Phone Number : ");
			String pno=sc.next();
			System.out.println("Enter Address : ");
			String add=sc.next();
			
			ps.setInt(1, sno);
			ps.setString(2, name);
			ps.setString(3, pno);
			ps.setString(4, add);
			int i=ps.executeUpdate();
			System.out.println("Contact created successfully......");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	@Override
	public void Edit() {
		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			PreparedStatement ps=con.prepareStatement("update pbook set name=?, contact=?, address=? where sr_no=?");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Serial Number : ");
			int sr=sc.nextInt();
			System.out.println("Change Name : ");
			String name=sc.next();
			System.out.println("Change Contact : ");
			String contact=sc.next();
			System.out.println("Change Address : ");
			String add=sc.next();
			
			ps.setString(1, name);
			ps.setString(2, contact);
			ps.setString(3, add);
			ps.setInt(4, sr);
			int k=ps.executeUpdate();
			System.out.println("Contact updated successfully....");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	@Override
	public void View() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from pbook");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	}

	@Override
	public void Delete() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			PreparedStatement ps=con.prepareStatement("delete from pbook where name=?");
			System.out.println("Enter Name of the Contact : ");
			Scanner sc=new Scanner(System.in);
			String name=sc.next();
			ps.setString(1, name);
			int y=ps.executeUpdate();
			System.out.println("Contact deleted successfully....");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
