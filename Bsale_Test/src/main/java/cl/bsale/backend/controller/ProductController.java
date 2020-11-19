package cl.bsale.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cl.bsale.backend.model.Product;
import cl.bsale.backend.service.IProductService;
import cl.bsale.backend.util.PageRender;


@Controller
@RequestMapping
public class ProductController {
	
	@Autowired
	IProductService productoServicio;
	
	@GetMapping("/")
	public String inicio(Model modelo,  @RequestParam(name = "page", defaultValue = "0") int page){
		
		Pageable pageRequest = PageRequest.of(page, 8);
		Page<Product> lista = productoServicio.findAll(pageRequest);
		PageRender<Product> pageRender = new PageRender<Product>("/", lista);

		modelo.addAttribute("lista", lista);
		modelo.addAttribute("page", pageRender);
		
		return "index";
	}
	
	@PostMapping("/buscar")
	public String buscar(@RequestParam String nombre, Model modelo) {
		
		modelo.addAttribute("lista", productoServicio.findByNombre(nombre));
		return "listar";
		
	}
	
	@GetMapping("/energeticas")
	public String energeticas(Model modelo) {
		
		modelo.addAttribute("lista", productoServicio.findByCategory(1));
		return "listar";
	}
	
	@GetMapping("/fantasia")
	public String fantasia(Model modelo) {		
		
		modelo.addAttribute("lista", productoServicio.findByCategory(4));
		return "listar";
	}
	
	@GetMapping("/snack")
	public String snack(Model modelo) {		
		
		modelo.addAttribute("lista", productoServicio.findByCategory(5));
		return "listar";
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
		return "listar";
	}
	

}
