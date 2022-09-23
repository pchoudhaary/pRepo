package com.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


//@Entity represent this class is mapped with database table

@Entity
@Data
@Table(name="BOOK_DTLS")
public class Book {

	@Id	
	@Column(name="BOOK_ID") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="BOOK_NAME")
	private String name;
	
	@Column(name="BOOK_PRICE")
	private Double price;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	

	
}