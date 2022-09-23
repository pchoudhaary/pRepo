package com.ashokit.repo;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.entity.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, Serializable> {

	
	
	
}