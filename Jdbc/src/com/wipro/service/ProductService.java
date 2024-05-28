package com.wipro.service;
import com.wipro.model.*;
import java.sql.*;
import java.util.*;

public interface ProductService {
   void insertProduct(Product product)throws SQLException, ClassNotFoundException;
   void deleteProduct(Integer id) throws SQLException,ClassNotFoundException;
   List<Product> getAllProducts() throws SQLException,ClassNotFoundException;
   Product getProduct(Integer id) throws SQLException,ClassNotFoundException;

   
}
