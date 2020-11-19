package cl.bsale.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import cl.bsale.backend.service.IProductService;

@Controller
@RequestMapping("/home")
public class ProductController {
	
	@Autowired
	IProductService productoServicio;
	
	@GetMapping
	public String inicio(Model modelo){
		
		modelo.addAttribute("lista", productoServicio.findAll());
		return "index";
	}
	


}
