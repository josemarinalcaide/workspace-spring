package es.jama.myapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.jama.myapp.dao.ProductDao;
import es.jama.myapp.dao.exception.ProductDaoException;
import es.jama.myapp.dao.exception.RowsNotFoundException;
import es.jama.myapp.model.Product;
import es.jama.myapp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Transactional
	public void increasePrice(Integer percentaje) {
		List<Product> productList = null;
		
		try {
			productList = productDao.getProductList();
		} 
		catch (ProductDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (RowsNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(productList != null) {
			for(Product product : productList) {
				product.setPrice(product.getPrice() * (100 + percentaje)/100);
				productDao.saveProduct(product);
			}
		}
	}

	public List<Product> getProductList() {
		try {
			return productDao.getProductList();
		} 
		catch (ProductDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (RowsNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public void saveProduct(Product product) {
		productDao.saveProduct(product);
	}

}
