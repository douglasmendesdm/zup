package com.zup.app.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zup.app.entity.Product;
import com.zup.app.facade.IAppFacade;

@Controller
public class ProductRest {

	@Autowired
	private IAppFacade facade;
	
    @RequestMapping(value="listaprodutos", method = RequestMethod.GET)
    public @ResponseBody List<Product> getTodosProdutos() {
    	List<Product> todosProdutos = facade.getTodosProdutos();
        return todosProdutos;
    }
    
    @RequestMapping(value="recupera/{id}", method = RequestMethod.GET)
	public @ResponseBody Object getProduto(@PathVariable Long id) {
		Product produto = facade.getProduto(id);
		if (produto!=null){
			return produto;
		}
		return "Registro não encontrado!";
	}
    
	@RequestMapping(value="/insere/{name}/{description}/{price}/{category}", method = RequestMethod.POST)
	public @ResponseBody Product insere(@PathVariable String name, @PathVariable String description,
			@PathVariable BigDecimal price, @PathVariable String category) {
		Product product = montaProduto(name, description, price, category);
		return facade.insere(product);
	}

	private Product montaProduto(String name, String description, BigDecimal price, String category) {
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setCategory(category);
		return product;
	}
	
	@RequestMapping(value="/edita/{id}/{name}/{description}/{price}/{category}", method = RequestMethod.PUT)
	public @ResponseBody Product edita(@PathVariable Long id, @PathVariable String name, @PathVariable String description,
			@PathVariable BigDecimal price, @PathVariable String category) {
		Product product = montaProduto(name, description, price, category);
		Product edita = facade.edita(product, id);
		return edita;
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean delete(@PathVariable Long id) {
		return facade.delete(id);
	}
	
}
