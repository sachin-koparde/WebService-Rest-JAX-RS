package com.webservices.restWebServices.Dao;

import com.webservices.restWebServices.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIsbn(Long isbn);

    Response deleteBookByIsbn(Long isbn);

}
