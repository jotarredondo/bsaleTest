package cl.bsale.backend.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cl.bsale.backend.VO.ProductVO;
import cl.bsale.backend.model.Product;
import cl.bsale.backend.repository.ProductRepository;

@Service
public class ProductServiceImp implements IProductService {
	
	@Autowired
	private ProductRepository productoRepository;
	
	ProductVO producto;
	
	private static Logger logger = LoggerFactory.getLogger(ProductRepository.class);
	

	@Override
	@Transactional(readOnly = true)
	public ProductVO findAll() {
		producto = new ProductVO("101","error" ,new ArrayList<Product>());
		
		try {
			producto.setProductos(productoRepository.findAll());
			producto.setCodigo("0");
			producto.setMensaje(String.format("Se obtuvieron %d registros", producto.getProductos().size()));
			
		} catch (Exception e) {
			logger.error("UsuarioServicioImp : findAll : " + e);
		}
		 return producto;
	}
	

	@Override
	@Transactional(readOnly = true)
	public ProductVO findById(Integer id) {
		producto = new ProductVO("102","error" ,new ArrayList<Product>());
		
		try {
			producto.getProductos().add(productoRepository.findById(id).get());
			producto.setCodigo("0");
			producto.setMensaje(String.format("Se ha encontrado el usuario %s", producto.getProductos().get(0).getName()));
			
		} catch (Exception e) {
			logger.error("UsuarioServicioImp : findById : " + e);
		}
		 return producto;

	}

	@Override
	public ProductVO findByCategory(Integer id) {
		producto = new ProductVO("103","error" ,new ArrayList<Product>());
		
		try {
			producto.setProductos(productoRepository.findByCategory(id));
			producto.setCodigo("0");
			producto.setMensaje(String.format("Se obtuvieron %d registros", producto.getProductos().size()));
			
		} catch (Exception e) {
			logger.error("UsuarioServicioImp : findById : " + e);
		}
		 return producto;
	}

	@Override
	public ProductVO findByNombre(String name) {
		producto = new ProductVO("104","error" ,new ArrayList<Product>());
		
		try {
			producto.setProductos(productoRepository.findByNombre(name));
			producto.setCodigo("0");
			producto.setMensaje(String.format("Se obtuvieron %d registros", producto.getProductos().size()));
			
		} catch (Exception e) {
			logger.error("UsuarioServicioImp : findById : " + e);
		}
		 return producto;
	}
	
	

}
