package cl.bsale.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import cl.bsale.backend.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value = "SELECT id, name, url_image, price, discount, category FROM product where category = ?1 ",nativeQuery = true )
	List<Product>findByCategory(Integer id);
	
	@Query (value = "SELECT id, name, url_image, price, discount, category FROM product where name like %?1% ",nativeQuery = true )
	List<Product> findByNombre(String nombre);
	
	

}
