package cl.bsale.backend.service;

import java.util.List;

import cl.bsale.backend.model.Product;

public interface IProductService {
	
	public List<Product> findAll();
	
	public Product findById(Integer id);
	
	public Product findByCategory(Integer id);
	
	public Product findByNombre(String name);
		

}
