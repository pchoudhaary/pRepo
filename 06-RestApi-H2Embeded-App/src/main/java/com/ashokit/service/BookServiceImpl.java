package com.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Book;
import com.ashokit.repo.BookRepository;


@Service
public class BookServiceImpl implements BookService {

	   @Autowired
	  private BookRepository repository;
	
	 
	  
	
	@Override
	public String upsert(Book book) {
          Long id = book.getId();
          System.out.println(book);
          repository.save(book);
          System.out.println(book);
          
          //this is for if id null then record is inserted 
		if(id==0)
		return "Record Inserted";
		else 
		return "Record Updated";
		}

	@Override
	public List<Book> getAll() {
         
		return  repository.findAll();   
		 
	}

	@Override
	public String delet(Long id) {
		 
		
		 repository.deleteById(id);  
		return "Record is deleted..";
	}

}
