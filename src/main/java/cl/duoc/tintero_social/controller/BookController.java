package cl.duoc.tintero_social.controller;

import cl.duoc.tintero_social.model.Book;
import cl.duoc.tintero_social.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    //METODO DE LECTURA, SI ENCUENTRA EL FILTRO POR TITULO, LO MUESTRA
    //SI NO SE COLOCAN PARAMETROS, SE MUESTRA LA LISTA DE LIBROS COMPLETA
    @GetMapping
    public ResponseEntity<List<Book>> listAll(@RequestParam(required = false)String title) {
        if (title != null) {
            return ResponseEntity.ok(bookService.findByTitle(title));
        }
        return ResponseEntity.ok(bookService.listAll());
    }
    //METODO PARA BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    // POST /api/books → CREA UN NUEVO LIBRO
    // @Valid ACTIVA LAS VALIDACIONES DEL MODELO (@NotBlank, ETC.)
    // @RequestBody CONVIERTE EL JSON DEL REQUEST EN UN OBJETO Book
    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
        Book creado = bookService.save(book);
        // HTTP 201 Created es más correcto que 200 OK para creaciones
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

}
