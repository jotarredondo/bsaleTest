package cl.bsale.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cl.bsale.backend.service.IProductService;

@SpringBootApplication
public class BsaleTestBackEndApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BsaleTestBackEndApplication.class, args);
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
		IProductService producto = acac.getBean(IProductService.class);
		
		System.out.println(producto.findByNombre("energ").size());
	}

}
