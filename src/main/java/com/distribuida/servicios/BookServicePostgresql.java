package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;
//@RegisterBeanMapper(Book.class)
public interface BookServicePostgresql {
    //Listar todos los libros
    List<Book> findAll();
    //añadir un nuevo libro
    void addBook(Book book);
    //buscar libro por id
    Book searchBook(Integer id);
    //eliminar libro por id
    void deleteBook(Integer id);
    //editar o actualizar por id
    void updateBook(Integer id,Book book);
}
