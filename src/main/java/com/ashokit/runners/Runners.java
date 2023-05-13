package com.ashokit.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashokit.book.Book;
import com.ashokit.mysqllrepo.BookRepo;
import com.ashokit.oraclrepo.ProductRepo;
import com.ashokit.product.Product;

@Component
public class Runners implements CommandLineRunner {

	@Autowired
	private ProductRepo prod;
	
	@Autowired
	private BookRepo book;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Runners is started");
		Book b = new Book(1, "novel", 800);

		book.save(b);

		prod.save(new Product(1, "chair", 300));

		System.out.println("product saved");

		System.out.println(book.findById(1));
		System.out.println(prod.findById(1));
	}

}
