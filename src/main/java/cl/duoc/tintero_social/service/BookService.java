package cl.duoc.tintero_social.service;

import cl.duoc.tintero_social.model.Book;
import cl.duoc.tintero_social.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    //INYECCION DE DEPENDENCIAS
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //METODO PARA RETORNAR TODOS LOS LIBROS
    public List<Book> listAll(){
        return bookRepository.findAll();
    }

    //METODO PARA BUSCAR POR ID
    public Book findById(Long id){
        return bookRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Libro no encontrado con ID: "+id));
    }

    //METODO PARA GUARDAR UN LIBRO NUEVO, VERIFICAMOS QUE EL ISBN NO ESTÉ DUPLICADO
    public Book save(Book book){
        if (book.getIsbn() != null && bookRepository.findByIsbn(book.getIsbn()).isPresent()){
            throw new RuntimeException("Ya existe un libro con el ISBN: "+book.getIsbn());
        }
        return bookRepository.save(book);
    }

    //METODO PARA ELIMINAR UN LIBRO POR ID
    public void delete(Long id){
        findById(id); //ACÁ SI NO EXISTE, LANZA EXCEPCION ANTES DE INTENTAR BORRAR
        bookRepository.deleteById(id);
    }

    //METODO PARA BUSCAR LIBROS POR TITULO
    public List<Book> findByTitle(String title){
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
}
