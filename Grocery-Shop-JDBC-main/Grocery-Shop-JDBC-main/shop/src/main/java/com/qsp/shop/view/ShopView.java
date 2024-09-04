package com.qsp.shop.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.qsp.shop.controller.ShopController;
import com.qsp.shop.model.Product;

public class ShopView {

	static Scanner myInput = new Scanner(System.in);
	static Product product = new Product();
	static ShopController shopController = new ShopController();

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		do {
			System.out.println("Select operation to perform:");
			System.out.println("1.Add product\n2.Remove product\n3.Update Product\n4.Fetch product\n0.Exit");
			System.out.print("Enter values of desired option : ");
			int userInput = myInput.nextInt();
			myInput.nextLine();
			switch (userInput) {
			case 0:
				myInput.close();
				System.out.println("----Exited----");
				System.exit(0);
				break;
			case 1:
				System.out.println("For single product:1 for multiple products: any number");
				int productInput = myInput.nextInt();
				myInput.nextLine();
				if(productInput == 1) {
					System.out.println("Enter product id : ");
					int i_p_id = myInput.nextInt();
					myInput.nextLine();
					System.out.println("Enter product name : ");
					String i_p_name = myInput.nextLine();
					System.out.println("Enter product price : ");
					int i_p_price = myInput.nextInt();
					myInput.nextLine();
					System.out.println("Enter product quantity : ");
					int i_p_quantity = myInput.nextInt();
					myInput.nextLine();
					boolean i_p_availability = false;
					if (i_p_quantity>0) {
						i_p_availability = true;
					}
					
					if ((shopController.addProduct(i_p_id, i_p_name, i_p_price, i_p_quantity, i_p_availability)) != 0) {
						System.out.println("Product Added");
					} else {
						System.out.println("Product Not Added");
					}
				} else {
					boolean toContinue =true;
					ArrayList<Product> products = new ArrayList<Product>();
					do {
						Product product = new Product();
						System.out.println("Enter id: ");
						product.setP_id(myInput.nextInt());
						myInput.nextLine();
						System.out.println("Enter name: ");
						product.setP_name(myInput.nextLine());
						myInput.nextLine();
						System.out.println("Enter price: ");
						product.setP_price(myInput.nextInt());
						myInput.nextLine();
						System.out.println("Enter quantity: ");
						int quantity = myInput.nextInt();
						product.setP_quantity(quantity);
						myInput.nextLine();
						boolean i_p_availability = false;
						if (quantity >0) {
							i_p_availability = true;
						}
						product.setP_availability(i_p_availability);
						products.add(product);
						System.out.println("Press 1 to continue adding products, Press 0 to stop adding products: ");
						int toAdd = myInput.nextInt();
						if (toAdd == 0) {
							toContinue = false;
						}
					} while (toContinue);
					shopController.addMultipleProducts(products);
				} 
				break;
			case 2:

				System.out.println("Enter product id to remove: ");
				int productidtoRemove = myInput.nextInt();
				myInput.nextLine();
				if (shopController.removeProduct(productidtoRemove) != 0) {
					System.out.println("Product Is Deleted.");
				} else {
					System.out.println("Product Does Not Exist.");
				}
				break;
			case 3:
				System.out.println("Enter product id to be updated: ");
				int productidupdate = myInput.nextInt();
				myInput.nextLine();
				
				ResultSet product = shopController.fetchProduct(productidupdate);
				if (product.next()) {
					System.out.println("What do you want to update?");
					System.out.println("1.Name\n2.Price\n3.Quantity");
					System.out.println("Enter respective number to desired option: ");
					byte updateOption = myInput.nextByte();
					myInput.nextLine();
					switch (updateOption) {
					case 1:
						System.out.println("Enter name to update: ");
						String updateName = myInput.nextLine();
						if ((shopController.updateProductName(productidupdate, updateName)) != 0) {
							System.out.println("Name updated.");
						} else {
							System.out.println("Name not updated");
						}
						break;

					case 2:
						System.out.println("Enter Price to be updated: ");
						int updatePrice = myInput.nextInt();
						myInput.nextLine();
						if (shopController.updateProductPrice(productidupdate, updatePrice) != 0) {
							System.out.println("Price Updated");
						} else {
							System.out.println("Product Price Not Updated");
						}
						break;

					case 3:
						System.out.println("Enter Quantity to be Updated: ");
						int updateQuantity = myInput.nextInt();
						myInput.nextLine();
						boolean updateavailability = false;
						if (updateQuantity>0) {
							updateavailability = true;
						}
						if (shopController.updateProductQuantity(productidupdate, updateQuantity, updateavailability) != 0) {
							System.out.println("Quantity Updated");
						} else {
							System.out.println("Product Quantity Not Updated");
						}
						break;

					default:
						break;
					}
				} else {
					System.out.println("Product id does not exist.");
				}
				
				
				break;
			case 4:
				//handle product fetching
				System.out.println("Enter product id to fetch: ");
				int productid = myInput.nextInt();
				myInput.nextLine();
				ResultSet fetchProduct = shopController.fetchProduct(productid);
//				System.out.println(fetchProduct);
				boolean next = fetchProduct.next();
				
				if (next) {
					System.out.println("PRODUCT DETAILS");
					System.out.println("ID: "+fetchProduct.getInt(1));
					System.out.println("Name: "+fetchProduct.getString(2));
					System.out.println("Price: "+fetchProduct.getInt(3));
					System.out.println("Quantity: "+fetchProduct.getInt(4));
					if (fetchProduct.getBoolean(5)) {
						System.out.println("Availability: Available");
					} else {
						System.out.println("Availability: Not Availabe");
					}
				} else {
					System.out.println("Product with id: "+productid+" does not exists.");
				}
				
				break;

			default:
				System.out.println("- - - - -INVALID SELECTION- - - - -");
				break;
			}
		} while (true);

	}
}
