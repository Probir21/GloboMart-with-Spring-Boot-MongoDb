package org.globomart.productcatalogue.service;


import java.util.List;


import org.globomart.productcatalogue.database.ProductDatabase;
import org.globomart.productcatalogue.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductDatabase productDatabase;
	
	//Add a product
	public Integer addNewProduct(Product product){
		return productDatabase.createProduct(product);
	}
	
	//Remove a product
	public Integer removeProduct(int id){
		return productDatabase.deleteProduct(id);
	}
	
	//Show all products
	public List<Product> getProducts(){
		return productDatabase.retrieveProducts();
	}

	//Show all products of given type
	public List<Product> getProductByType(String type){
		return productDatabase.retrieveProductByType(type);
	}
	
	//Show price of a given product
	public Double getPriceById(int id) {
		return productDatabase.retrievePriceById(id);
	}

}
