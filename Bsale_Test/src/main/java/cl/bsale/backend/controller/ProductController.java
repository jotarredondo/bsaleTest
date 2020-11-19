package cl.bsale.backend.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.bsale.backend.model.Product;
import cl.bsale.backend.service.IProductService;

@Controller
@RequestMapping
public class ProductController {
	
	@Autowired
	IProductService productoServicio;
	
	@GetMapping({"/","/home"})
	public String inicio(Model modelo){
		
		modelo.addAttribute("lista", productoServicio.findAll());
		return "index";
	}
	
	@PostMapping("/buscar")
	public String buscar(@RequestParam String nombre, Model modelo) {
		
		modelo.addAttribute("lista", productoServicio.findByNombre(nombre));
		return "index";
		
	}
	
	@GetMapping("/energeticas")
	public String energeticas(Model modelo) {
		
		modelo.addAttribute("lista", productoServicio.findByCategory(1));
		return "index";
	}
	
	@GetMapping("/fantasia")
	public String fantasia(Model modelo) {		
		
		modelo.addAttribute("lista", productoServicio.findByCategory(4));
		return "index";
	}
	
	@GetMapping("/snack")
	public String snack(Model modelo) {		
		
		modelo.addAttribute("lista", productoServicio.findByCategory(5));
		return "index";
	}
	
	@GetMapping("/alcoholicas")
	public String alcoholicas(Model modelo) {
		
		List<Product> lista = productoServicio.findByCategory(2);
			
			for (Product product : productoServicio.findByCategory(3)) {
				lista.add(product);
			}
			
			for (Product product : productoServicio.findByCategory(6)) {
				lista.add(product);
				
			}
			for (Product product : productoServicio.findByCategory(7)) {
				lista.add(product);
				
			}
		
			modelo.addAttribute("lista", lista);
		return "index";
	}
	

}
