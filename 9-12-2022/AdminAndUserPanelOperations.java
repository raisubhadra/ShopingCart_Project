package shoppingCartusingarray;
import java.util.Scanner;
//this class is for all Admin and User panel operations 
public class AdminAndUserPanelOperations 
{
	static Scanner sc=new Scanner(System.in);

	//all adminPanel operations listed here
	static void adminPanel()
	{
		while(true)
		{
		int choice;
		System.out.println("Enter 1.For Add Product\n"
				+ "Enter 2.For Update Product Details\n"
				+ "Enter 3.For Delete Product Details by id\n"
				+ "Enter 4.For Show All Product Details\n"
				+ "Enter 5.For Show Product by Id\n"
				+ "Enter 6.For Show All Orders\n"
				+ "Enter 7.For Go Back to the Main menu");
		System.out.println("=========================================");
		System.out.println("Enter Your Choice");	
		choice=sc.nextInt();
		System.out.println("=========================================");
		switch(choice)
		{
		case 1:
			ProductService.createProduct();
		    System.out.println("=====================================");
		    break;
		    
		case 2:
			ProductService.updateProductById();
			System.out.println("====================================");
		    break;
		    
		case 3:
			ProductService.deleteProductById();
			System.out.println("====================================");
		    break;
		    
		case 4:
			ProductService.getAllProduct();
		    System.out.println("====================================");
		    break;
		    
		case 5:
			ProductService.getProductById();	
		    System.out.println("====================================");
		    break;
		    
		case 6:
			ProductService.showAllOrder();	
		    System.out.println("====================================");
		    break;
		    
		case 7:
			AdminAndUserPanel.AllOPerations();
		}
	}
	}

	//all userPanel operation listed here
	static void userPanel()
	{
		while(true)
		{
		int choice;
		System.out.println("Enter 1.For Search Products\n"
				+ "Enter 2.For Book Product\n"
				+ "Enter 3.For Cancel Product\n"
				+ "Enter 4.For Go Back to the Main menu\n");
		System.out.println("=====================================");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			ProductService.getAllProduct();	
		    System.out.println("====================================");
		    break;
		    
		case 2:
			ProductService.bookProduct();
			System.out.println("====================================");
		    break;
		    
		case 3:
			ProductService.cancelOrder();
			System.out.println("====================================");
		    break;
		    
		case 4:
			AdminAndUserPanel.AllOPerations();	
		}
	}
	}
	}

