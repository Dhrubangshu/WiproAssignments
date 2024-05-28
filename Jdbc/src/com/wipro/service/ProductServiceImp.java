package com.wipro.service;
import com.wipro.jdbc.util.*;
import com.wipro.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImp implements ProductService{

	@Override
	public void insertProduct(Product product) throws SQLException,ClassNotFoundException{
		PreparedStatement pst = Dbcon.getconnection().prepareStatement("Insert into product Values(?,?,?)");
		pst.setInt(1, product.getId());
		pst.setString(2, product.getPname());
		pst.setString(3, product.getBrand());
        pst.execute();
        System.out.println("Product inserted");
		}
	@Override
	public void deleteProduct(Integer id) throws SQLException,ClassNotFoundException{
		PreparedStatement pst = Dbcon.getconnection().prepareStatement("Delete from product where id = ?");
		pst.setInt(1,id);
		pst.execute();
		System.out.println("Product Deletd");
	}
	
	@Override
	public  List<Product> getAllProducts() throws SQLException,ClassNotFoundException{
		Statement st = Dbcon.getconnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("Select * from product");
		List<Product> productList = new ArrayList<>();
		while(rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt(1));
			product.setPname(rs.getString(2));
			product.setBrand(rs.getString(3));
			productList.add(product);
		}
        return productList;
		}
	@Override
	public  Product getProduct(Integer id) throws SQLException,ClassNotFoundException{
		
		PreparedStatement pst = Dbcon.getconnection().prepareStatement("Select * from product where id =?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		Product product = new Product();

		while(rs.next()) {
			product.setId(rs.getInt(1));
			product.setPname(rs.getString(2));
			product.setBrand(rs.getString(3));
		}
        return product;
		}
}
