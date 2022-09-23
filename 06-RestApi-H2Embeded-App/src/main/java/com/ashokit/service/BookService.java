package com.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashokit.entity.Book;

public interface BookService {

	public String upsert(Book book);
	public List<Book> getAll();
	public String delet(Long id);
	
	
}
