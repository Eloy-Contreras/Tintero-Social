package cl.duoc.tintero_social.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//ENTITY LE DICE A JPA QUE ES ESTA CLASE REPRESENTA UNA TABLA EN LA BASE DE DATOS
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    //ID INDICA QUE ESTE CAMPO ES LA PK
    @Id

    //GENERATEDVALUE HACE QUE EL ID SE GENERE AUTOMATICAMENTE
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //NOTBLANK VALIDA QUE EL CAMPO NO LLEGUE VACIO DESDE EL REQUEST
    @NotBlank(message = "El título es obligatorio")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "El autor es obligatorio")
    @Column(nullable = false)
    private String author;

    //EL ISBN ES UNICO, NO PUEDEN EXISTIR DOS LIBROS CON EL MISMO VALOR
    @Column(unique = true)
    private String isbn;

    private String genre;

    //ACA PERMITIMOS TEXTOS MÁS LARGOS QUE EL DEFAULT (255)
    @Column(length = 2000)
    private String synopsis;

    private Integer publicationYear;
}
