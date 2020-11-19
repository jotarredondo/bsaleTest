package cl.bsale.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	


}
