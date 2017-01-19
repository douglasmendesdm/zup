package com.zup.app.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.zup.app.entity.Product;

@Component
public class ProductDAO {

	public List<Product> getTodosProdutos() {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("SELECT product FROM Product product");
		List<Product> lista = query.getResultList();
        entityManager.close();
	    return lista;
	}

	public Product getProduto(Long id) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		try {
			return entityManager.find(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			entityManager.close();
		}
	}

	public Product insere(Product product) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();
		return product;
	}

	public Product edita(Product product, Long id) {
		Product produtoNoBanco = getProduto(id);
		if (produtoNoBanco!=null){
			produtoNoBanco.setCategory(product.getCategory());
			produtoNoBanco.setDescription(product.getDescription());
			produtoNoBanco.setName(product.getName());
			produtoNoBanco.setPrice(product.getPrice());
			EntityManager entityManager = getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(produtoNoBanco);
			entityManager.getTransaction().commit();
	        entityManager.close();
			return produtoNoBanco;
		}
		return null;
	}

	public boolean delete(Long id) {
		Product produtoNoBanco = getProduto(id);
		if (produtoNoBanco!=null){
			EntityManager entityManager = getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.merge(produtoNoBanco));
			entityManager.getTransaction().commit();
	        entityManager.close();
	        return true;
		}
		return false;
	}
	
	private EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zupPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
}
