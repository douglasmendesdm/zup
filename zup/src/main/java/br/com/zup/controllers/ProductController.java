package br.com.zup.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.entity.Product;
import br.com.zup.model.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="listaprodutos", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getTodosProdutos() {
    	List<Product> todosProdutos = productRepository.getTodosProdutos();
    	return new ResponseEntity<List<Product>>(todosProdutos, HttpStatus.OK);
    }
    
    @RequestMapping(value="recupera/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduto(Product product) {
		Product produto = productRepository.getProduto(product.getId());
		return new ResponseEntity<Product>(produto, HttpStatus.OK);
	}
    
    @RequestMapping(value="/insere", method = RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<Product> insere(Product product) {
		productRepository.insere(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(value="/edita", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Product> edita(Product product) {
		productRepository.edita(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Product> delete(Product product) {	
		productRepository.delete(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
}
