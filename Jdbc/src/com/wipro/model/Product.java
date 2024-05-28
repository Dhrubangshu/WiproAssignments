package com.wipro.model;

public class Product {
   private int id;
   private String pname;
   private String brand;
   
   public Product() {}
   public Product(int id, String pname, String brand) {
	   this.id = id;
	   this.pname = pname;
	   this.brand = brand;
   }
@Override
public String toString() {
	return "Product [id=" + id + ", pname=" + pname + ", brand=" + brand + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
   
}
