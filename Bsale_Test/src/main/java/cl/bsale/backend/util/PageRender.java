package cl.bsale.backend.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;



public class PageRender<T> {
	
	private String url;
	
	private Page<T> page;
	
	private int totalPaginas;
	
	private int elementosxPagina;
	
	private int paginaActual;
	
	private List<PageItem> paginas;
	
	public PageRender(String url, Page<T> page) {

		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();
		
		elementosxPagina = page.getSize();
		totalPaginas = page.getTotalPages();
		paginaActual = page.getNumber()+1;
		
		int desde, hasta;
		
		if (totalPaginas <= elementosxPagina) {
			desde = 1;
			hasta = totalPaginas;
		}else {
			if(paginaActual <= elementosxPagina/2) {
				desde =1;
				hasta = elementosxPagina;
				
			} else if(paginaActual >= totalPaginas - elementosxPagina/2) {
				
				desde = totalPaginas - elementosxPagina +1;
				hasta = elementosxPagina;
				
			}else {
				desde = paginaActual - elementosxPagina/2;
				hasta = elementosxPagina;
				 
			}
		}
		
		for (int i=0; i < hasta; i++) {
			 paginas.add(new PageItem(desde + i, paginaActual == desde +i ));
		}
	}

	public String getUrl() {
		return url;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	public boolean isHasPrevious() {
		return page.hasPrevious();
		
	}

}
