package shoppingCartusingarray;
import java.util.Scanner;
//this class is for all admin and user panel
public class AdminAndUserPanel
{
	static Scanner sc=new Scanner(System.in);

	//this method responsible for All Operations
	static void AllOPerations()
	{
		int choice;
		do	
		{
			System.out.println("------------------------------------------");
			System.out.println("Press 1.For Admin Panel\n"
					+ "Press 2.For User Panel\n"
					+ "Press 3.For Quit");
			System.out.println("------------------------------------------"); 
			System.out.println("Enter Your Choice");			
			choice=sc.nextInt();
			System.out.println("=========================================");    
			switch(choice)
			{
			case 1:
				AdminAndUserPanelOperations.adminPanel();
				break;
				
			case 2:
				AdminAndUserPanelOperations.userPanel();
				break;
				
			case 3:System.exit(0);
			default:System.out.println("Please enter correct choice from operations!!");
		   }
		   }//do
			while(choice!=3);
	}	
	}

