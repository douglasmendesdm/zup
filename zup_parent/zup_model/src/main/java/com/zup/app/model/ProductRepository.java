package com.zup.app.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zup.app.entity.Product;
import com.zup.app.persistence.ProductDAO;

@Component
public class ProductRepository {

	@Autowired
	private ProductDAO productDAO;
	
	public List<Product> getTodosProdutos() {
		return productDAO.getTodosProdutos();
	}

	public Product getProduto(Long id) {
		return productDAO.getProduto(id);
	}

	public Product insere(Product product) {
		return productDAO.insere(product);
	}

	public Product edita(Product product, Long id) {
		return productDAO.edita(product, id);
	}

	public boolean delete(Long id) {
		return productDAO.delete(id);
	}
	
}
