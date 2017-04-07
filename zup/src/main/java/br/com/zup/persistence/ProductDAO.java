package br.com.zup.persistence;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.config.MongoConfiguration;
import br.com.zup.entity.Product;

/**
 * Classe responsavel pela comunicação com o banco de dados
 * @author douglasm
 *
 */
@Repository
@Transactional
public class ProductDAO {

	@Autowired
	private MongoConfiguration mongo;
	
	public List<Product> getTodosProdutos() {
		MongoOperations mongoOperations = mongo.getMongoOperations();
		List<Product> lista = mongoOperations.findAll(Product.class);
	    return lista;
	}

	public Product getProduto(String id) {
		MongoOperations mongoOperations = mongo.getMongoOperations();
		return mongoOperations.findById(id, Product.class);
	}

	public void insere(Product product) {
		MongoOperations mongoOperations = mongo.getMongoOperations();
		mongoOperations.insert(product);
	}

	public void edita(Product product) {
		MongoOperations mongoOperations = mongo.getMongoOperations();
		mongoOperations.save(product);
	}

	public void delete(Product product) {
		MongoOperations mongoOperations = mongo.getMongoOperations();
		mongoOperations.remove(product);
	}
	
}
