package cl.bsale.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import cl.bsale.backend.model.Product;
import cl.bsale.backend.service.IProductService;

@Controller
@RestController
@RequestMapping("/api/v1/producto")
public class ProductController {
	
	@Autowired
	IProductService productoServicio;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> findAll(){
		
		return productoServicio.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product findById(@PathVariable Integer id){
		
		return productoServicio.findById(id);
	}
	
	@GetMapping("/category/{category}")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> findByCategory(@PathVariable Integer category){
		
		return productoServicio.findByCategory(category);
	}
	
	@GetMapping("/name/{name}")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> findByCategory(@PathVariable String name){
		
		return productoServicio.findByNombre(name);
	}
	

}
