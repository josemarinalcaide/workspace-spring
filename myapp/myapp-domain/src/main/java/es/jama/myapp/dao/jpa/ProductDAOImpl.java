package es.jama.myapp.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.jama.myapp.dao.ProductDao;
import es.jama.myapp.dao.exception.ProductDaoException;
import es.jama.myapp.dao.exception.RowsNotFoundException;
import es.jama.myapp.model.Product;

@Repository(value="productDAOJPA")
public class ProductDAOImpl implements ProductDao {

	private EntityManager entityManager;
	
	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getProductList() throws ProductDaoException, RowsNotFoundException {
		List<Product> retorno = null;
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t ")
		.append("FROM Product t ")
		.append("ORDER BY t.id");
		
		try {
			Query q = null;
			q = entityManager.createQuery("SELECT t FROM Product t");
			retorno = q.getResultList();
		}
		catch(Exception e) {
			//Register error in log
			
			
			//Throw exception
			throw new ProductDaoException();
		}
		
		//If list is empty, throw RowsNotFoundException
		if(retorno.size() <= 0)
			throw new RowsNotFoundException();
			
		return retorno;
	}

	
	public void saveProduct(Product product) {
		entityManager.merge(product);
	}

}
