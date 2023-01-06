package com.distribuida.servicios;

import com.distribuida.config.DbConfig;
import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jdbi.v3.core.Jdbi;
import java.util.List;

@ApplicationScoped
public class BookServiceImplPostgresql implements BookServicePostgresql{
    @Inject
    private DbConfig dbConfig;

    @Override
    public List<Book> findAll() {
       Jdbi jdbi=dbConfig.conf();
       return jdbi.withHandle(handle ->handle.createQuery("SELECT * FROM \"books\"")
               .mapToBean(Book.class)
               .list());
    }
    @Override
    public void addBook(Book book) {
        Jdbi jdbi=dbConfig.conf();
        jdbi.withHandle(handle ->handle.execute("INSERT INTO books (isbn,title,author,price) VALUES(?,?,?,?)", book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPrice()));
    }
    @Override
    public Book searchBook(Integer id) {
        Jdbi jdbi=dbConfig.conf();
        Book book=jdbi.withHandle(handle ->handle.createQuery("SELECT * FROM books WHERE id = :id")
                .bind("id",id)
                .mapToBean(Book.class)
                .findOnly());
        return book;
    }
    @Override
    public void deleteBook(Integer id) {
        Jdbi jdbi=dbConfig.conf();
        jdbi.withHandle(handle ->handle.createUpdate("DELETE FROM books WHERE id=:id").bind("id",id).execute());
    }
    @Override
    public void updateBook(Integer id, Book book) {
        Jdbi jdbi=dbConfig.conf();
        jdbi.withHandle(handle ->handle.createUpdate("UPDATE books SET isbn = :isbn,title = :title, author = :author,price = :price WHERE id = :id")
                .bindBean(book)
                .bind("id",id)
                .executeAndReturnGeneratedKeys()
                .mapToBean(Book.class)
                .findOnly());
    }
}
