package org.globomart.productcatalogue.controller;

import java.util.List;

import org.globomart.productcatalogue.model.Product;
import org.globomart.productcatalogue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//Add a product
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String addProduct(@RequestBody Product product) {
		int id = productService.addNewProduct(product);
		return "Product added with id : "+ id ;
	}
	
	//Delete a product based on Product Id
	@RequestMapping(value="/product/{productId}", method=RequestMethod.DELETE)
	public String removeProduct(@PathVariable("productId") int productId){
		int id = productService.removeProduct(productId);
		return "Product deleted with id : "+ id ;
	}
	
	//Retrieve all products
	@RequestMapping(value="/product")
	public List<Product> getAllProducts(){
		return productService.getProducts();
	}
	
	//Retrieve all products of given type
	@RequestMapping(value="/productType/{productType}", method=RequestMethod.GET)
	public List<Product> getProductByType(@PathVariable("productType") String productType){
		return productService.getProductByType(productType);
	}
	
	//Retrieve price of given product id
	@RequestMapping(value="/product/{productId}", method=RequestMethod.GET)
	public String getPriceById(@PathVariable("productId") int productId){
		Double price = productService.getPriceById(productId);
		return "Price of Product Item : "+ productId + " is : "+ price;
	}
}
