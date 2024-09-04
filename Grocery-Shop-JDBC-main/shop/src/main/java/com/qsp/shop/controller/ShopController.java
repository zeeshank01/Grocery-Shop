package com.qsp.shop.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.postgresql.Driver;

import com.qsp.shop.model.Product;

public class ShopController {

	public int addProduct(int id, String name, int price, int quantity, boolean avaliability) {
		Connection connection = null;
		int rowsAffected = 0;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			FileInputStream fileInputStream = new FileInputStream("db.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_jdbc", properties);
			PreparedStatement prepareStatement = connection.prepareStatement("Insert into product Values(?,?,?,?,?);");
			prepareStatement.setInt(1, id);
			prepareStatement.setString(2, name);
			prepareStatement.setInt(3, price);
			prepareStatement.setInt(4, quantity);
			prepareStatement.setBoolean(5, avaliability);
			rowsAffected = prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rowsAffected;

	}
	
	public void addMultipleProducts(ArrayList<Product> products) {

		Connection connection = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			FileInputStream fileInputStream = new FileInputStream("db.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_jdbc", properties);
			PreparedStatement prepareStatement = connection.prepareStatement("Insert into product Values(?,?,?,?,?);");
			for (Product product : products) {
				prepareStatement.setInt(1, product.getP_id());
				prepareStatement.setString(2, product.getP_name());
				prepareStatement.setInt(3, product.getP_price());
				prepareStatement.setInt(4, product.getP_quantity());
				prepareStatement.setBoolean(5, product.isP_availability());
				prepareStatement.addBatch();
			}
			prepareStatement.executeBatch();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public ResultSet fetchProduct(int id) {
		
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("db.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_jdbc", properties);
			
			PreparedStatement prepareStatement = connection.prepareStatement("Select * From product where id=?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resultSet;
		
	}
	
	public int removeProduct(int id) {
		Connection connection = null;
		int executeUpdate = 0;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("db.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_jdbc", properties);
			
			PreparedStatement prepareStatement = connection.prepareStatement("Delete From product where id=?");
			prepareStatement.setInt(1, id);
			
			executeUpdate = prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return executeUpdate;
	}
	
	public int updateProductName(int id, String name) {
		Connection connection = null;
		int UpdateName = 0;
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("db.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_jdbc", properties);
			
			PreparedStatement prepareStatement = connection.prepareStatement("Update product set name=? where id=?");
			prepareStatement.setString(1, name);
			prepareStatement.setInt(2, id);
			
			
			UpdateName = prepareStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return UpdateName;
	}
	
	public int updateProductPrice(int id, int price) {
		Connection connection = null;
		int UpdatePrice = 0;
		
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("db.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_jdbc", properties);
			
			PreparedStatement prepareStatement = connection.prepareStatement("Update product set price=? where id=?");
			prepareStatement.setInt(1, price);
			prepareStatement.setInt(2, id);
			
			
			UpdatePrice = prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return UpdatePrice;
		
	}
	
	public int updateProductQuantity(int id, int quantity, boolean available) {
		Connection connection = null;
		int UpdateQuantity = 0;
		
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			FileInputStream fileInputStream = new FileInputStream("db.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_jdbc", properties);
			
			PreparedStatement prepareStatement = connection.prepareStatement("Update product set quantity=?, availability=? where id=?");
			prepareStatement.setInt(1, quantity);
			prepareStatement.setBoolean(2, available);
			prepareStatement.setInt(3, id);
			
			
			UpdateQuantity = prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UpdateQuantity;

	}
}
