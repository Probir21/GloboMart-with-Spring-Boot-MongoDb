package org.globomart.productcatalogue.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="productcatalogue")
public class Product {
	@Id
	private int productId;
	private String name;
	private double price;
	private String productType;
	
	public Product(){
		
	}
	public Product(int productId,String name,double price,String productType){
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.productType = productType;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}

}
