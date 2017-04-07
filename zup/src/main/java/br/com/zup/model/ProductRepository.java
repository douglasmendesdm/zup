package br.com.zup.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.zup.entity.Product;
import br.com.zup.persistence.ProductDAO;

/**
 * Regras de negocio devem ser feitas aqui
 * @author douglasm
 *
 */
@Repository
public class ProductRepository {

	@Autowired
	private ProductDAO productDAO;
	
	public List<Product> getTodosProdutos() {
		return productDAO.getTodosProdutos();
	}

	public Product getProduto(String id) {
		return productDAO.getProduto(id);
	}

	public void insere(Product product) {
		productDAO.insere(product);
	}

	public void edita(Product product) {
		productDAO.edita(product);
	}

	public void delete(Product product) {
		productDAO.delete(product);
	}
	
}
