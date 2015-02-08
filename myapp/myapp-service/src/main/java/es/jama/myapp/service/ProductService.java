package es.jama.myapp.service;

import java.util.List;

import es.jama.myapp.model.Product;


public interface ProductService {

	public void increasePrice(Integer percentaje);
	
	public List<Product> getProductList();
	
	public void saveProduct(Product product);
}
