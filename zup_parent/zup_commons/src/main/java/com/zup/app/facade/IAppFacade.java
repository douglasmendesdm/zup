package com.zup.app.facade;

import java.util.List;

import com.zup.app.entity.Product;

public interface IAppFacade {

	public List<Product> getTodosProdutos();

	public Product getProduto(Long id);

	public Product insere(Product product);

	public Product edita(Product product, Long id);

	public boolean delete(Long id);

}
