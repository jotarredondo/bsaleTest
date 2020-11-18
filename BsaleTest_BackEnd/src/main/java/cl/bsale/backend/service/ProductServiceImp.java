package cl.bsale.backend.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.bsale.backend.model.Product;
import cl.bsale.backend.repository.ProductRepository;

@Service
public class ProductServiceImp implements IProductService {
	
	@Autowired
	private ProductRepository productoRepository;
	
	private List<Product> productos = new ArrayList<Product>();
	private static Logger logger = LoggerFactory.getLogger(ProductServiceImp.class);
	

	@Override
	public List<Product> findAll() {
		try {
			productos = productoRepository.findAll();
		} catch (Exception e) {
			logger.error("ClubServicioImp findAll()" + e);
		}
		return productos;
	}
	

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByCategory(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByNombre(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
