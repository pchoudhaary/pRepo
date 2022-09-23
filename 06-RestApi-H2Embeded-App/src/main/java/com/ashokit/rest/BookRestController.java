package com.ashokit.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Book;
import com.ashokit.service.BookService;

@RestController
public class BookRestController {
   
     @Autowired
	private BookService service;
    
    @PostMapping("/book")
	public ResponseEntity<String> insertRest(@RequestBody Book book){
		String msg= service.upsert(book);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
    
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getRest(){
       List<Book> allbooks=service.getAll();
    	return new ResponseEntity<>(allbooks,HttpStatus.OK);
    }
    
    @PutMapping("/book")
    public ResponseEntity<String> updateRest(@RequestBody Book book){
    	String msg=service.upsert(book);
    	return new ResponseEntity<>(msg,HttpStatus.OK);
    }
    @DeleteMapping("/book/{bookid}")
    public ResponseEntity<String> deleteRest(@PathVariable Long id){
    	 String msg = service.delet(id);
    	 return new ResponseEntity<>(msg,HttpStatus.OK);
    }
    
}
   