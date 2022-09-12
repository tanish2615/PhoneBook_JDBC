package phonebook_JDBC;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("****Welcome to my Phonebook Application*************");
		int choice;
		Pbook p=new Pbook();
		p.Showmenu();
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("Enter your choice : ");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1: p.Create();
		break;
		
		case 2: p.Edit();
		break;
		
		case 3: p.Delete();
		break;
		
		case 4: p.View();
		break;
		
		case 5: System.exit(0);
		break;
		
		default: System.out.println("Enter a valid input");
		
		}
		}

	}

}
