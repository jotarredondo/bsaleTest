package cl.bsale.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.bsale.backend.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	

}
