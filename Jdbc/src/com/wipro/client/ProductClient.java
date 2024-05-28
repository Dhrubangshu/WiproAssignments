package com.wipro.client;
import com.wipro.service.*;
import com.wipro.model.*;

import java.sql.*;

public class ProductClient {
	public static void main(String[] args) throws SQLException,ClassNotFoundException{
		ProductService p = new ProductServiceImp();
		
		p.insertProduct(new Product(1,"Laptop","HP"));
		p.insertProduct(new Product(2,"Laptop","Apple"));
		p.insertProduct(new Product(3,"SmartPhone","Motorola"));
     	p.insertProduct(new Product(4,"Speaker","JBL"));
		p.insertProduct(new Product(5,"Earphones","Boat"));

		
		p.deleteProduct(4);
		p.getAllProducts().forEach(System.out::println);
		
		Product product = p.getProduct(5);
		System.out.println(product);


		
	}

}
