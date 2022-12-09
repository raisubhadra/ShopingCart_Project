package shoppingCartusingarray;
import java.util.Scanner;

public class ShoppingKartOperations 
{
	static Scanner sc=new Scanner(System.in);

	//this method listed all menus
	static void AllMenus()
	{
		int choice;
		System.out.println("\t~~Welcome To Shopping Kart~~");
		do
		{	
		    System.out.println("------------------------------------------");
		    System.out.println("Enter 1. for Add Product\n"
		    		+ "Enter 2. for Display All Product Details\n"
		    		+ "Enter 3. for Display Product Details By Id\n"
		    		+ "Enter 4. for Update Product Details By Id\n"
		    		+ "Enter 5. for Delete Product Details\n"
		    		+ "Enter 6. for Book Product\n"
		    		+ "Enter 7. for Cancel Booking Product\n"
		    		+ "Enter 8. for Show All Order\n"
		    		+ "Enter 9. for Quit");
		    
		System.out.println("-----------------------------------------");    
		choice=sc.nextInt();
		System.out.println("=========================================");    
		switch(choice)
		{
		case 1:
			ProductService.createProduct();
		    System.out.println("=====================================");
		    break;
		
		case 2:	
			ProductService.getAllProduct();
		    System.out.println("====================================");
		    break;
		    
		case 3: 
			ProductService.getProductById();	
		    System.out.println("====================================");
		    break;
		

		case 4:
			ProductService.updateProductById();
			System.out.println("====================================");
		    break;
		    
		case 5:
			ProductService.deleteProductById();
			System.out.println("====================================");
		    break;
		    
		case 6:
			ProductService.bookProduct();
			System.out.println("====================================");
		    break;
		    
		case 7:
			ProductService.cancelOrder();
			System.out.println("====================================");
		    break;
		    
		case 8:
			ProductService.showAllOrder();	
		    System.out.println("====================================");
		    break;
		    
		case 9:break;
		default:System.out.println("Please enter correct choice from menu!!");
	   }
	   }//do
		while(choice!=9);
	}
	}

