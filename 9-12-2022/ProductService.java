package shoppingCartusingarray;
import java.util.Scanner;
//this class is responsible for all operation
public class ProductService 
{
	//this is product array of type Product class,will store product details	
	static Product product[]=new Product[10];

	//this is order details array of type OrderDetails class,will store order details
	static OrderDetails order[]=new OrderDetails[10];

	static Scanner sc=new Scanner(System.in);
	static int index=0;
	static int orderIndex=0;
	static int orderId=1;

	//this method is responsible to add product in the array
	static void createProduct()
	{
		System.out.println("Enter Product Id");
		int id=sc.nextInt();
		
		sc.nextLine();   //it will consume the \n character

		System.out.println("Enter Product Name:");
		String name=sc.nextLine();
		System.out.println("Enter Product Brand:");
		String brand=sc.nextLine();
	    System.out.println("Enter Product Price:");
		double price=sc.nextDouble();
		System.out.println("Enter Stock:");
		int quantity=sc.nextInt();
		
		//will insert in an array
		product[index]=new Product(id,name,brand,price,quantity);
		index++; 
		System.out.println("\nProduct added successfully!!");
	}

	//this method is responsible to retrieve product details
	static void getAllProduct()
	{
		for(int i=0;i<index;i++)
		{
			System.out.println("Product Id:"+product[i].getId());
			System.out.println("Product Name:"+product[i].getName());
			System.out.println("Product Brand:"+product[i].getBrand());
			System.out.println("Product Price:"+product[i].getPrice());
			System.out.println("Product Stock:"+product[i].getQuantity());
			System.out.println("=========================================");
		}
	}

	//this method is responsible to retrieve product details by id 
	static void getProductById()
	{
		boolean status=false;
		System.out.println("Enter Id to Search Product:");
		int id=sc.nextInt();
		System.out.println("=========================================");
		for(int i=0;i<index;i++)
		{
			if(product[i].getId()==id)
			{
				System.out.println("Product Id:"+product[i].getId());
				System.out.println("Product Name:"+product[i].getName());
				System.out.println("Product Brand:"+product[i].getBrand());
				System.out.println("Product Price:"+product[i].getPrice());
				System.out.println("Product Stock:"+product[i].getQuantity());
				System.out.println("=========================================");
				status=true;
				break;
			}
		}
		if(status==false)
		{
			System.out.println("Product Id not Found.");
			System.out.println("=========================================");
		}
	}

	//this method is responsible to order product 
	static void bookProduct()
	{
		boolean status=false;
		sc.nextLine();
		System.out.println("Enter Product Name:");
		String name=sc.nextLine();
		System.out.println("=========================================");
		
		//display product for booking
		for(int i=0;i<index;i++)
		{
			if(product[i].getName().equalsIgnoreCase(name)) 
			{
				System.out.println("Product Id:"+product[i].getId());
				System.out.println("Product Name:"+product[i].getName());
				System.out.println("Product Brand:"+product[i].getBrand());
				System.out.println("Product Price: "+product[i].getPrice());			
				if(product[i].getQuantity()<=0)
				{
					System.out.println("Currently Unavialable");
				}
				else
				{
				System.out.println("Product Stock:"+product[i].getQuantity());
				}
				System.out.println("=========================================");
				status=true;
			}
		}
		
		//if searched product is available,then proceed for booking
		if(status==true)
		{
			int confirmation;
			//sc.nextLine();
			System.out.println("Want to book product? if Yes then press 1 else press 2:");
			confirmation=sc.nextInt();
			if(confirmation==1)
			{
			System.out.println("For Booking, Enter Id");
			int id=sc.nextInt();
			
			for(int i=0;i<index;i++)
			{
				if(product[i].getId()==id)
				{
					System.out.println("Enter quantity:");
					int quantity=sc.nextInt();
					
					//checking stock is available or not
					if(product[i].getQuantity()>quantity)  
					{
						System.out.println("Your Booking has done successfully!!");
						double totalAmount=quantity*product[i].getPrice();
						System.out.println("~~Booking Details:~~");
						System.out.println("Product Name:"+product[i].getName());
						System.out.println("Product Brand:"+product[i].getBrand());
						System.out.println("Product Quantity:"+quantity);
						System.out.println("Total Amount:"+totalAmount);
						
						//updating stock after booking product
						product[i].setQuantity(product[i].getQuantity()-quantity);
						order[orderIndex]=new OrderDetails(orderId,product[i].getId(),name,product[i].getBrand(),quantity,totalAmount);
						orderIndex++;
						orderId++;
						break;			
					}
				}
			}		
		}//confirmation if closed
			else
			{
				AdminAndUserPanel.AllOPerations();
			}
		}
		else
			System.out.println("No such product available in shopping kart!!");
	}
	//this method is responsible to show all order
	static void showAllOrder()
	{
		System.out.println("~~Ordered History~~");
		for(int i=0;i<orderIndex;i++)
		{
			System.out.println("Order Id:"+order[i].getOrderId());
			System.out.println("Product Name:"+order[i].getProductName());
			System.out.println("Product Brand:"+order[i].getBrand());
			System.out.println("Order Quantity:"+order[i].getQuantity());
			System.out.println("Order Amount:"+order[i].getTotalAmount());
			System.out.println("=========================================");
		}
		
	}

	//this method is responsible to update product by id
	static void updateProductById()
	{
		boolean status=false;
		System.out.println("Enter product id to update product details");
		int id=sc.nextInt();
		for(int i=0;i<index;i++)
		{
			if(id==product[i].getId())
			{
				System.out.println("Enter new Product Id");
				int pid=sc.nextInt();
				
				sc.nextLine();   //it will consume the \n character

				System.out.println("Enter new Product Name:");
				String name=sc.nextLine();
				System.out.println("Enter new Product Brand:");
				String brand=sc.nextLine();
			    System.out.println("Enter new Product Price:");
				double price=sc.nextDouble();
				System.out.println("Enter new Stock:");
				int quantity=sc.nextInt();
				product[i]=new Product(pid,name,brand,price,quantity);
				System.out.println("Product has been updated Successfully!!");
				status=true;
			}		
		}
		if(status==false)
		{
			System.out.println("Product Id not found");
			System.out.println("=====================================");
		}
	}

	//this method is responsible to delete product
	static void deleteProductById()
	{
		boolean status=false;
		System.out.println("Enter product id to delete product details");
		int id=sc.nextInt();
		for(int i=0;i<index;i++)
		{
			if(id==product[i].getId());
			{
				for(int j=i;j<index-1;j++)
				{
					product[j]=product[j+1];
				}
				index--;
				System.out.println("Product Item has been Deleted Successfully!!");
				status=true;
				break;
			}
		}
		if(status==false)
		{
			System.out.println("Product Id not found");
			System.out.println("=====================================");
		}
	}

	//this method is responsible to cancel order
	static void cancelOrder()
	{
		boolean status=false;
		System.out.println("Enter Order id to Cancel booked product");
		int OId=sc.nextInt();  //1
		for(int i=0;i<orderIndex;i++)
		{
			if(OId==order[i].getOrderId())  //1==order[0]1
			{
				//this code will be increasing product stock after cancel
				for(int k=0;k<index;k++)  //loop for product
				{
					//checking ordered product id id matching with product id
					if(product[k].getId()==order[i].getProductId())
					{
						//increasing the stock in product array during cancellation
						product[k].setQuantity(product[k].getQuantity()+
								order[i].getQuantity());
					}
				}
				//this code id for delete order details from an array
				for(int j=i;j<orderIndex-1;j++)
				{
					order[j]=order[j+1];
				}
				orderIndex--;
				System.out.println("Order has been Cancelled Successfully!!");
				status=true;
				break;
			}
		}
		if(status==false)
		{
			System.out.println("Product Id not found");
			System.out.println("=====================================");
		}
	}
	}

	 	