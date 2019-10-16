package com.bntn.smartstore.service;

import com.bntn.smartstore.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findOne(Long id);

    Book save(Book book);

    void removeOne(Long id);

    List<Book> findByCategory(String category);

    List<Book> blurrySearch(String title);
}
