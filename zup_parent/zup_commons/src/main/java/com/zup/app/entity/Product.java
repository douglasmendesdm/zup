package com.zup.app.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Product {

//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Type(type = "objectid")
//	@Id @GeneratedValue(generator = "uuid")
//	   @GenericGenerator(name="uuid", strategy="uuid2")
	@Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSequenceGenerator")
  @SequenceGenerator(
      name = "productSequenceGenerator",
      sequenceName = "product_seq",
      initialValue = 1,
      allocationSize = 20
  )
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="category")
	private String category;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
