package com.wipro;
import java.sql.*;
public class Jdbc1 {
	private Connection connection;
	public Jdbc1(Connection connection) {
		this.connection = connection;
	}

	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:9501/XE","system","rps@123")
;        
        System.out.println("Successful Connection");
        
        Jdbc1 prod = new Jdbc1(con);
        prod.addProduct(1, "Iphone", "Apple");
        prod.updateProduct(1, "iphone", "Apple");
        prod.addProduct(2, "15s", "HP");
        prod.addProduct(3, "Mac", "Apple");
        prod.deleteProduct(1);
        prod.listproducts();
        
        con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
        
       
        
	}
	
	public void addProduct(int id, String pname,String brand ) throws SQLException{
		try(PreparedStatement statement = connection.prepareStatement("Insert into product (id, pname,brand) Values(?,?,?)")){
			statement.setInt(1, id);
			statement.setString(2, pname);
			statement.setString(3,brand);
			statement.executeUpdate();
			System.out.println("Product added");
		}
		
	}
	public void updateProduct(int id, String pname,String brand ) throws SQLException{
		try(PreparedStatement statement = connection.prepareStatement("Update product set pname = ?,brand = ? where id = ?")){
			statement.setString(1, pname);
			statement.setString(2, brand);
			statement.setInt(3,id);
			statement.executeUpdate();
			System.out.println("Product updated");
		}
		
	}
	public void deleteProduct(int id) throws SQLException{
		try(PreparedStatement statement = connection.prepareStatement("Delete from  product where id = ?")){
			statement.setInt(1, id);
			statement.executeUpdate();
			System.out.println("Product deleted");
		}
		
	}
	public void listproducts()throws SQLException{
		try(Statement statement = connection.createStatement(); 
			ResultSet resultset = statement.executeQuery("Select * from product")){
			while(resultset.next()) {
				System.out.println(resultset.getInt("id") + "|" + resultset.getString("pname") + "|" + resultset.getString("brand"));
			}
		}
	}

}
