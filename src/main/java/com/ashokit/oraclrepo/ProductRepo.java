package com.ashokit.oraclrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.product.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
