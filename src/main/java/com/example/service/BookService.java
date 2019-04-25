package com.example.service;

import com.example.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2019/4/25 10:52
 * description:
 */
public interface BookService {

    Book save(Book book);

    void delete(Book book);

    Book findOne(String id) throws Exception;

    Iterable<Book> findAll();

    Page<Book> findByAuthor(String author, Pageable pageable);

    Page<Book> findByTitle(String title, Pageable pageable);
}
