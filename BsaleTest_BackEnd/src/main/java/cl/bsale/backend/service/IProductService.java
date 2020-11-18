package cl.bsale.backend.service;

import cl.bsale.backend.VO.ProductVO;

public interface IProductService {
	
	public ProductVO findAll();
	
	public ProductVO findById(Integer id);
	
	public ProductVO findByCategory(Integer id);
	
	public ProductVO findByNombre(String name);
		

}
