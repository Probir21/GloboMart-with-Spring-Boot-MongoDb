package org.globomart.productcatalogue.database;

import java.util.List;


import org.globomart.productcatalogue.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;



@Repository
public class ProductDatabase{
	
	final String COLLECTION = "productcatalogue";
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	//Add a product
	public Integer createProduct(Product product){
		mongoTemplate.insert(product);
		return product.getProductId();
	}
	
	//Remove a product
	public Integer deleteProduct(int id){
		mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), Product.class);
		return id;
	}
	
	//Show all products
	public List<Product> retrieveProducts(){
		return (List<Product>)mongoTemplate.findAll(Product.class, COLLECTION);
	}
	
	//Show all products of given type
	public List<Product>retrieveProductByType(String type){
		return (List<Product>)mongoTemplate.find(new Query(Criteria.where("productType").is(type)), Product.class);
	}
	
	//Show price of a given product
	public Double retrievePriceById(int id) {
		Product product = mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), Product.class);
		return product.getPrice();
	}
}
