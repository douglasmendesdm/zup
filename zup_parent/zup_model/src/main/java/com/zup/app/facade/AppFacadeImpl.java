package com.zup.app.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zup.app.entity.Product;
import com.zup.app.model.ProductRepository;

@Component
public class AppFacadeImpl implements IAppFacade {

	@Autowired
	private ProductRepository productModel;
	
	public List<Product> getTodosProdutos() {
		return productModel.getTodosProdutos();
	}

	public Product getProduto(Long id) {
		return productModel.getProduto(id);
	}

	public Product insere(Product product) {
		return productModel.insere(product);
	}

	public Product edita(Product product, Long id) {
		return productModel.edita(product, id);
	}

	public boolean delete(Long id) {
		return productModel.delete(id);
	}

	

}
