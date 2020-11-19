package cl.bsale.backend.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cl.bsale.backend.model.Product;


public interface IProductService {
	
	public List<Product> findAll();
	
	public Page<Product> findAll(Pageable pageable);
	
	public Product findById(Integer id);
	
	public List<Product> findByCategory(Integer id);
	
	public List<Product> findByNombre(String name);
	
		

}
