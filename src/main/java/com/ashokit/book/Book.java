package com.ashokit.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="BOOK")
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="B_ID")
	private Integer id;
    @Column(name="B_NAME")
	private String name;
    @Column(name="B_PRICE")
	private Integer price;
	
	
	
}
