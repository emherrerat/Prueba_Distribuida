package com.distribuida.rest;

import com.distribuida.config.DbConfig;
import com.distribuida.db.Book;
import com.distribuida.servicios.BookServiceImplPostgresql;
import com.distribuida.servicios.BookServicePostgresql;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
@Path("/books")
public class BookRestPostgresql {
    @Inject
    private BookServicePostgresql bookServicePostgresql;
    //listar todos los libros
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> findAll(){
        return bookServicePostgresql.findAll();
    }
    //añadir un nuevo libro
    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBook(Book book){
        bookServicePostgresql.addBook(book);

    }
    //eliminar un libro por id
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteBook (@PathParam("id") Integer id){
        bookServicePostgresql.deleteBook(id);
    }
    //modificar un libro por id
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Update (@PathParam("id") Integer id,Book book){
        bookServicePostgresql.updateBook(id,book);
    }
    //buscar un libro por id
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book searchBook (@PathParam("id") Integer id){
        return bookServicePostgresql.searchBook(id);
    }
}
