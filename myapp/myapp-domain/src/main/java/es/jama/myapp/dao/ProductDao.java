package es.jama.myapp.dao;

import java.util.List;

import es.jama.myapp.dao.exception.ProductDaoException;
import es.jama.myapp.dao.exception.RowsNotFoundException;
import es.jama.myapp.model.Product;

public interface ProductDao {

	/**
	 * This method make a query to product table in order to get every stored products.
	 * @return Return a product list.
	 * @throws ProductDaoException When there is an error related to data base access or malformed sql statement
	 * @throws RowsNotFoundException When there is no rows found
	 */
	public List<Product> getProductList() throws ProductDaoException, RowsNotFoundException;
	
	/**
	 * Method to save a product in product table.
	 * @param product Product to persist
	 */
	public void saveProduct(Product product);
}
