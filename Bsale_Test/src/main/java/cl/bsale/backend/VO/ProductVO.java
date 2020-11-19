package cl.bsale.backend.VO;

import java.util.List;

import cl.bsale.backend.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductVO {
	
	private String codigo;
	private String mensaje;
	private List<Product> productos;

}
