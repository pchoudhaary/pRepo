package com.ashokit.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="PRODUCT_ORCLE")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="P_ID")
	private Integer id;
    @Column(name="P_NAME")
	private String name;
    @Column(name="P_PRICE")
	private Integer price;
	
	
}



