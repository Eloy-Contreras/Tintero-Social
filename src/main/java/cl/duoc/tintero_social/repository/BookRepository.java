package cl.duoc.tintero_social.repository;

import cl.duoc.tintero_social.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Al extender JpaRepository, Spring genera automáticamente:
// findAll(), findById(), save(), deleteById(), count(), etc.
// No necesitamos escribir ninguna query de SQL básico.
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    //BUSCA UN LIBRO POR SU TITULO
    List<Book> findByTitleContainingIgnoreCase(String tittle);

    //BUSCA UN LIBRO POR SI AUTOR
    List<Book> findByAuthorContainingIgnoreCase(String author);

    //BUSCA UN LIBRO POR SU GENERO
    List<Book> findByGenre(String genre);

    //BUSCA UN LIBRO POR SU ISBN, COMO PUEDE QUE NO EXISTA ES OPTIONAL
    Optional<Book> findByIsbn(String isbn);
}


