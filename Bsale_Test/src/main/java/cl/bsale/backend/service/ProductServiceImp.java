package cl.bsale.backend.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cl.bsale.backend.model.Product;
import cl.bsale.backend.repository.ProductRepository;

@Service
public class ProductServiceImp implements IProductService {
	
	@Autowired
	private ProductRepository productoRepository;
	
	private List<Product> productos;
	private Product producto;
	
	private static Logger logger = LoggerFactory.getLogger(ProductRepository.class);
	

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		productos = new ArrayList<Product>();
		
		try {
			productos = productoRepository.findAll();
			
		} catch (Exception e) {
			logger.error("UsuarioServicioImp : findAll : " + e);
		}
		 return productos;
	}


	@Override
	@Transactional(readOnly = true)
	public Product findById(Integer id) {
		producto = new Product();
		
		try {
			producto = productoRepository.findById(id).get();
			
		} catch (Exception e) {
			logger.error("UsuarioServicioImp : findById : " + e);
		}
		 return producto;
	}


	@Override
	@Transactional(readOnly = true)
	public List<Product> findByCategory(Integer id) {
		productos = new ArrayList<Product>();
		
		try {
			productos = productoRepository.findByCategory(id);
			
		} catch (Exception e) {
			logger.error("UsuarioServicioImp : findByCategory : " + e);
		}
		 return productos;
	}


	@Override
	@Transactional(readOnly = true)
	public List<Product> findByNombre(String name) {
		productos = new ArrayList<Product>();
		
		try {
			productos = productoRepository.findByNombre(name);
			
		} catch (Exception e) {
			logger.error("UsuarioServicioImp : findByNombre : " + e);
		}
		 return productos;
	}
	

}
