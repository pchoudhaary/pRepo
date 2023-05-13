package com.ashokit.mysqllrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.book.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
